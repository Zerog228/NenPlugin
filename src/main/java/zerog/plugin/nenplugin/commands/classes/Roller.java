package zerog.plugin.nenplugin.commands.classes;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import zerog.plugin.nenplugin.NenPlugin;
import zerog.plugin.nenplugin.commands.Monke;
import zerog.plugin.nenplugin.utils.PersistentData;
import zerog.plugin.nenplugin.utils.SetAttributes;
import zerog.plugin.nenplugin.utils.SetVillagerData;

import java.util.UUID;

public class Roller implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("set_roller") && sender instanceof Player p) {
            if(args.length > 0){
                p = Bukkit.getPlayerExact(args[0]);
            }
            setRoller(p);
        }
        return true;
    }
    public static void setRoller(Player p){

        SetVillagerData.setAttributes(p);
        Monke.resetClassesPermissions(p);

        SetAttributes.SetAttributes(p, (byte) 0, 20.0);
        SetAttributes.SetAttributes(p, (byte) 1, 0.1);
        SetAttributes.SetAttributes(p, (byte) 2, 0.0);
        SetAttributes.SetAttributes(p, (byte) 3, 0.0);
        SetAttributes.SetAttributes(p, (byte) 4, 1.0);
        SetAttributes.SetAttributes(p, (byte) 5, 4.0);
        SetAttributes.SetAttributes(p, (byte) 6, 0.0);

        PersistentData.setPlayerData(p, "class_number", PersistentDataType.INTEGER, 7, "");
        UUID uuid = p.getUniqueId();
        ItemStack stack = new ItemStack(Material.HEART_OF_THE_SEA);
        ItemMeta meta = stack.getItemMeta();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        meta.displayName(Component.newline().content(ChatColor.AQUA+"Куб роллера"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 1, true);
        container.set(new NamespacedKey(NenPlugin.getPlugin(), "rollers_cube"), PersistentDataType.STRING, "cube");
        stack.setItemMeta(meta);
        p.getWorld().dropItem(p.getLocation(), stack);
        NenPlugin.removePermission(uuid, "purpur.enderchest.rows.two");
        NenPlugin.addPermission(uuid, "purpur.enderchest.rows.one");
        NenPlugin.addPermission(uuid, "nen.roller");
    }

    public static void setReRoller(Player p){
        setRoller(p);
        UUID uuid = p.getUniqueId();
        NenPlugin.addPermission(uuid, "nen.reroller");
        PersistentData.setPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER, 1, "");
    }
}
