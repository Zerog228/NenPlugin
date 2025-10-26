package zerog.plugin.nenplugin;

import net.coreprotect.CoreProtect;
import net.coreprotect.CoreProtectAPI;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.node.Node;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import zerog.plugin.nenplugin.commands.*;
import zerog.plugin.nenplugin.commands.classes.*;
import zerog.plugin.nenplugin.listeners.Listeners;
import zerog.plugin.nenplugin.utils.DifferentMaps;
import zerog.plugin.nenplugin.utils.SetAttributes;

import java.util.UUID;

public final class NenPlugin extends JavaPlugin implements Listener {

    private static NenPlugin plugin;
    public static CoreProtectAPI coreApi;

    public static LuckPerms getLuckPerms(){
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        LuckPerms ap = null;
        if (provider != null) {
            ap = provider.getProvider();
        }
        return ap;
    }

    private CoreProtectAPI getCoreProtect() {
        Plugin plugin = getServer().getPluginManager().getPlugin("CoreProtect");

        if (plugin == null || !(plugin instanceof CoreProtect)) {
            return null;
        }

        CoreProtectAPI CoreProtect = ((CoreProtect) plugin).getAPI();
        if (CoreProtect.isEnabled() == false) {
            return null;
        }

        if (CoreProtect.APIVersion() < 9) {
            return null;
        }

        return CoreProtect;
    }

    public static CoreProtectAPI getCoreProtectAPI(){
        return coreApi;
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        getCommand("testo").setExecutor(new testCommand());
        getCommand("dc").setExecutor(new DcCommand());
        getCommand("vote").setExecutor(new VoteCommand());
        getCommand("remove_attributes").setExecutor(new RemoveAttributes());
        getCommand("stats").setExecutor(new StatsCommand());
        getCommand("classes").setExecutor(new ClassesCommand());
        getCommand("classes2").setExecutor(new Classes2Command());
        getCommand("menu").setExecutor(new MenuCommand());
        getCommand("openmenu").setExecutor(new AnotherMenuCommand());
        getCommand("help").setExecutor(new HelpCommand());
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("upgrades").setExecutor(new UpgradesCommand());
        getCommand("monke").setExecutor(new Monke());
        getCommand("publicchest").setExecutor(new PublicChestCommand());
        getCommand("crafts").setExecutor(new CraftsCommand());
        getCommand("roll").setExecutor(new Roll());
        getCommand("set_bomber").setExecutor(new Bomber());
        getCommand("set_parasite").setExecutor(new Parasite());
        getCommand("set_mazohist").setExecutor(new Mazohist());
        getCommand("set_politic").setExecutor(new Politic());
        getCommand("set_warrior").setExecutor(new Warrior());
        getCommand("set_builder").setExecutor(new Builder());
        getCommand("set_ironclad").setExecutor(new Ironclad());
        getCommand("set_berserk").setExecutor(new Berserk());
        getCommand("set_paladin").setExecutor(new Paladin());
        getCommand("set_detective").setExecutor(new Detective());
        getCommand("set_roller").setExecutor(new Roller());
        getCommand("set_vampire").setExecutor(new Vampire());
        getCommand("set_werewolf").setExecutor(new Werewolf());
        getCommand("set_archer").setExecutor(new Archer());
        getCommand("set_mermaid").setExecutor(new Mermaid());
        getCommand("set_lich").setExecutor(new Lich());
        getCommand("set_spider").setExecutor(new Spider());
        getCommand("set_hellboy").setExecutor(new HellBoy());
        getCommand("set_assassin").setExecutor(new Assassin());
        getCommand("set_martyr").setExecutor(new Martyr());
        getCommand("set_jesus").setExecutor(new Jesus());
        getCommand("setnenexp").setExecutor(new PlayerSetExp());
        getCommand("setnenpoints").setExecutor(new PlayerSetPoints());
        getCommand("a_crafts").setExecutor(new AvailableCraftsCommand());
        getCommand("d_crafts").setExecutor(new DecorCrafts());
        getCommand("r_crafts").setExecutor(new RedstoneCrafts());
        getCommand("s_crafts").setExecutor(new SmithingCrafts());
        getCommand("c_crafts").setExecutor(new CarpentryCrafts());
        getCommand("addperms").setExecutor(new AddPerms());
        SetAttributes.putter();
        DifferentMaps.allPut();
        plugin = this;
        getLuckPerms();
        CoreProtectAPI api = getCoreProtect();
        coreApi = api;
        if (api != null){ // Ensure we have access to the API
            api.testAPI(); // Will print out "[CoreProtect] API test successful." in the console.
        }
    }

    public static Plugin getPlugin(){
        return plugin;
    }

    public static void addPermission(UUID userUuid, String permission) {
        // Load, modify, then save
        LuckPerms luckPerms = getLuckPerms();
        luckPerms.getUserManager().modifyUser(userUuid, user -> {
            // Add the permission
            user.data().add(Node.builder(permission).build());
        });
    }

    public static void removePermission(UUID userUuid, String permission) {
        LuckPerms luckPerms = getLuckPerms();
        // Load, modify, then save
        luckPerms.getUserManager().modifyUser(userUuid, user -> {
            // Add the permission
            user.data().remove(Node.builder(permission).build());
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
