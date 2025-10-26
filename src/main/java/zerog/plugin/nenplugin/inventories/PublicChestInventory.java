package zerog.plugin.nenplugin.inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PublicChestInventory {

    public static Inventory inv = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Общественный сундук");

    public static void openPublicChest(Player p){

        p.openInventory(inv);

    }
}
