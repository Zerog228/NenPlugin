package zerog.plugin.nenplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import zerog.plugin.nenplugin.inventories.craftsMenuComponents.CraftsStatic;
import zerog.plugin.nenplugin.inventories.craftsMenuComponents.CraftsVariant;
import zerog.plugin.nenplugin.inventories.menuComponents.MenuChooseItems;
import zerog.plugin.nenplugin.inventories.menuComponents.MenuStaticItems;
import zerog.plugin.nenplugin.inventories.menuComponents.MenuVariantItems;

public class CraftsCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("crafts") && sender instanceof Player p) {

            openMenu(p);
        }
        return true;
    }

    public static void openMenu(Player p){

        Inventory inv = Bukkit.createInventory(p, 54, ChatColor.DARK_GRAY + "Меню крафтов");

        CraftsStatic.staticItems(p, inv);
        CraftsVariant.variantItems(p, inv);

        p.openInventory(inv);
    }
}
