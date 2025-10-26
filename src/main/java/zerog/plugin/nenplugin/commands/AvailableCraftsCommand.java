package zerog.plugin.nenplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import zerog.plugin.nenplugin.utils.MetaCreator;

import static zerog.plugin.nenplugin.utils.MetaCreator.MetaCreator;

public class AvailableCraftsCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("a_crafts") && sender instanceof Player p) {

            openMenu(p);
        }
        return true;
    }

    public static void openMenu(Player p){

        Inventory inv = Bukkit.createInventory(p, 27, ChatColor.DARK_GRAY + "Список возможных крафтов");

        ItemStack gray_glass = MetaCreator(Material.GRAY_STAINED_GLASS_PANE, (byte) 1, "⠀");

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, gray_glass);
        }
        ItemStack anvil = MetaCreator.MetaCreator(Material.ANVIL, (byte) 1, "Назад");
        inv.setItem(26, anvil);

        ItemStack bricks = MetaCreator.MetaCreator(Material.BRICKS, (byte) 1, "Блоки и декорации", ChatColor.YELLOW, "Нажми на меня", "Для просмотра всех крафтов", inv, (byte) 10);
        ItemStack lamp = MetaCreator.MetaCreator(Material.REDSTONE_LAMP, (byte) 1, "Механизмы", ChatColor.YELLOW, "Нажми на меня", "Для просмотра всех крафтов", inv, (byte) 12);
        ItemStack i_pickaxe = MetaCreator.MetaCreator(Material.IRON_PICKAXE, (byte) 1, "Кузнечное дело", ChatColor.YELLOW, "Нажми на меня", "Для просмотра всех крафтов", inv, (byte) 14);
        ItemStack i_axe = MetaCreator.MetaCreator(Material.IRON_AXE, (byte) 1, "Плотничество", ChatColor.YELLOW, "Нажми на меня", "Для просмотра всех крафтов", inv, (byte) 16);



        p.openInventory(inv);
    }
}
