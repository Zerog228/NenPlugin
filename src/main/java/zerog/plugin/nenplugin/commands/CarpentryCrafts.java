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

public class CarpentryCrafts implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("c_crafts") && sender instanceof Player p) {

            openMenu(p);
        }
        return true;
    }

    public static void openMenu(Player p){

        Inventory inv = Bukkit.createInventory(p, 54, ChatColor.DARK_GRAY + "Плотничество");

        ItemStack gray_glass = MetaCreator(Material.GRAY_STAINED_GLASS_PANE, (byte) 1, "⠀");

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, gray_glass);
        }

        ItemStack o_stairs = MetaCreator.MetaCreator(Material.OAK_STAIRS, (byte) 1, "Дубовые доски");
        ItemStack o_sign = MetaCreator.MetaCreator(Material.OAK_SIGN, (byte) 1, "Блоки из дубовых досок");
        ItemStack o_door = MetaCreator.MetaCreator(Material.OAK_DOOR, (byte) 1, "Декорации из дубовых досок");
        inv.setItem(1, o_stairs);
        inv.setItem(2, o_sign);
        inv.setItem(3, o_door);

        ItemStack s_stairs = MetaCreator.MetaCreator(Material.SPRUCE_STAIRS, (byte) 1, "Доски из любого дерева");
        ItemStack a_sign = MetaCreator.MetaCreator(Material.ACACIA_SIGN, (byte) 1, "Блоки из любого дерева");
        ItemStack o_fence = MetaCreator.MetaCreator(Material.OAK_FENCE, (byte) 1, "Декорации из любого дерева");
        inv.setItem(19, s_stairs);
        inv.setItem(20, a_sign);
        inv.setItem(21, o_fence);

        ItemStack o_boat = MetaCreator.MetaCreator(Material.OAK_BOAT, (byte) 1, "Лодки");
        ItemStack a_chest_boat = MetaCreator.MetaCreator(Material.ACACIA_CHEST_BOAT, (byte) 1, "Лодки с сундуками");
        ItemStack beeehive = MetaCreator.MetaCreator(Material.BEEHIVE, (byte) 1, "Улей и бочка");
        inv.setItem(37, o_boat);
        inv.setItem(38, a_chest_boat);
        inv.setItem(39, beeehive);

        ItemStack scaffolding = MetaCreator.MetaCreator(Material.SCAFFOLDING, (byte) 1, "Подмостки");
        ItemStack ladder = MetaCreator.MetaCreator(Material.LADDER, (byte) 1, "Лестница");
        ItemStack rails = MetaCreator.MetaCreator(Material.RAIL, (byte) 1, "Рельсы");
        inv.setItem(15, scaffolding);
        inv.setItem(16, ladder);
        inv.setItem(17, rails);

        ItemStack c_stairs = MetaCreator.MetaCreator(Material.CRIMSON_STAIRS, (byte) 1, "Блоки из искажённой древесины");
        ItemStack w_fence = MetaCreator.MetaCreator(Material.WARPED_FENCE, (byte) 1, "Блоки из багровой древесины");

        inv.setItem(33, c_stairs);
        inv.setItem(34, w_fence);


        ItemStack bricks1 = MetaCreator.MetaCreator(Material.WOODEN_AXE, (byte) 1, ChatColor.YELLOW+"1 уровень");
        ItemStack bricks2 = MetaCreator.MetaCreator(Material.STONE_AXE, (byte) 2, ChatColor.YELLOW+"2 уровень");
        ItemStack bricks3 = MetaCreator.MetaCreator(Material.IRON_AXE, (byte) 3, ChatColor.YELLOW+"3 уровень");
        ItemStack bricks4 = MetaCreator.MetaCreator(Material.GOLDEN_AXE, (byte) 4, ChatColor.YELLOW+"4 уровень");
        ItemStack bricks5 = MetaCreator.MetaCreator(Material.DIAMOND_AXE, (byte) 5, ChatColor.YELLOW+"5 уровень");
        inv.setItem(0, bricks1);
        inv.setItem(18, bricks2);
        inv.setItem(36, bricks3);
        inv.setItem(14, bricks4);
        inv.setItem(32, bricks5);

        p.openInventory(inv);
    }
}
