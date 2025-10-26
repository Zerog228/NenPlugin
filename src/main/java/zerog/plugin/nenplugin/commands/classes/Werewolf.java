package zerog.plugin.nenplugin.commands.classes;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import zerog.plugin.nenplugin.NenPlugin;
import zerog.plugin.nenplugin.commands.Monke;
import zerog.plugin.nenplugin.utils.PersistentData;
import zerog.plugin.nenplugin.utils.SetAttributes;
import zerog.plugin.nenplugin.utils.SetVillagerData;

public class Werewolf implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("set_werewolf") && sender instanceof Player p) {
            if(args.length > 0){
                p = Bukkit.getPlayerExact(args[0]);
            }
            setWerewolf(p);
        }
        return true;
    }
    public static void setWerewolf(Player p){

        SetVillagerData.setAttributes(p);
        Monke.resetClassesPermissions(p);

        NenPlugin.addPermission(p.getUniqueId(), "nen.werewolf");
        PersistentData.setPlayerData(p, "data0", PersistentDataType.DOUBLE, 24.0, "");
        SetAttributes.SetAttributes(p, (byte) 0, 24.0);
        PersistentData.setPlayerData(p, "data1", PersistentDataType.DOUBLE, 0.105, "");
        SetAttributes.SetAttributes(p, (byte) 1, 0.105);
        SetAttributes.SetAttributes(p, (byte) 2, 0.0);
        SetAttributes.SetAttributes(p, (byte) 3, 0.0);
        PersistentData.setPlayerData(p, "data4", PersistentDataType.DOUBLE, 1.5, "");
        SetAttributes.SetAttributes(p, (byte) 4, 1.5);
        SetAttributes.SetAttributes(p, (byte) 5, 4.0);
        SetAttributes.SetAttributes(p, (byte) 6, 0.0);
        PersistentData.setPlayerData(p, "class_number", PersistentDataType.INTEGER, 10, "");
    }
}
