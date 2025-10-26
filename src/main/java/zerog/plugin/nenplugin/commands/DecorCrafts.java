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

public class DecorCrafts implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("d_crafts") && sender instanceof Player p) {

            openMenu(p);
        }
        return true;
    }

    public static void openMenu(Player p){

        Inventory inv = Bukkit.createInventory(p, 54, ChatColor.DARK_GRAY + "Блоки и декор");

        ItemStack gray_glass = MetaCreator(Material.GRAY_STAINED_GLASS_PANE, (byte) 1, "⠀");

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, gray_glass);
        }

        ItemStack cobb_slab = MetaCreator.MetaCreator(Material.COBBLESTONE_SLAB, (byte) 1, "Булыжниковые блоки");
        ItemStack furnace = MetaCreator.MetaCreator(Material.FURNACE, (byte) 1, "Печь");
        ItemStack andesite = MetaCreator.MetaCreator(Material.ANDESITE_WALL, (byte) 1, "Блоки из цветного камня");
        inv.setItem(1, cobb_slab);
        inv.setItem(2, furnace);
        inv.setItem(3, andesite);

        ItemStack stone_slab = MetaCreator.MetaCreator(Material.STONE_SLAB, (byte) 1, "Каменные блоки");
        ItemStack brick_stairs = MetaCreator.MetaCreator(Material.BRICK_STAIRS, (byte) 1, "Различные кирпичи");
        ItemStack mud_bricks = MetaCreator.MetaCreator(Material.MUD_BRICKS, (byte) 1, "Блоки из Грязи");
        inv.setItem(19, stone_slab);
        inv.setItem(20, brick_stairs);
        inv.setItem(21, mud_bricks);

        ItemStack glass = MetaCreator.MetaCreator(Material.ORANGE_STAINED_GLASS, (byte) 1, "Разноцветные блоки");
        ItemStack torch = MetaCreator.MetaCreator(Material.TORCH, (byte) 1, "Осветительные блоки");
        ItemStack painting = MetaCreator.MetaCreator(Material.PAINTING, (byte) 1, "Картины, рамки, книжные полки");
        inv.setItem(37, glass);
        inv.setItem(38, torch);
        inv.setItem(39, painting);

        ItemStack cop_stairs = MetaCreator.MetaCreator(Material.CUT_COPPER_STAIRS, (byte) 1, "Медные блоки");
        ItemStack deepslate = MetaCreator.MetaCreator(Material.DEEPSLATE_TILE_WALL, (byte) 1, "Глубинокаменные блоки");
        ItemStack concrete = MetaCreator.MetaCreator(Material.BLACK_CONCRETE_POWDER, (byte) 1, "Цемент");
        inv.setItem(15, cop_stairs);
        inv.setItem(16, deepslate);
        inv.setItem(17, concrete);

        ItemStack end_stairs = MetaCreator.MetaCreator(Material.END_STONE_BRICK_STAIRS, (byte) 1, "Блоки энда");
        ItemStack nether_fence = MetaCreator.MetaCreator(Material.NETHER_BRICK_FENCE, (byte) 1, "Адские блоки");
        ItemStack prismarine_slab = MetaCreator.MetaCreator(Material.PRISMARINE_SLAB, (byte) 1, "Призмариновые блоки");
        inv.setItem(33, end_stairs);
        inv.setItem(34, nether_fence);
        inv.setItem(35, prismarine_slab);

        ItemStack loom = MetaCreator.MetaCreator(Material.LOOM, (byte) 1, "Блоки профессий");
        ItemStack armor_stand = MetaCreator.MetaCreator(Material.ARMOR_STAND, (byte) 1, "Стойка для брони");
        ItemStack ench_table = MetaCreator.MetaCreator(Material.ENCHANTING_TABLE, (byte) 1, "Стол зачарований и сундук края");
        inv.setItem(51, loom);
        inv.setItem(52, armor_stand);
        inv.setItem(53, ench_table);

        ItemStack bricks1 = MetaCreator.MetaCreator(Material.BRICKS, (byte) 1, ChatColor.YELLOW+"1 уровень");
        ItemStack bricks2 = MetaCreator.MetaCreator(Material.BRICKS, (byte) 2, ChatColor.YELLOW+"2 уровень");
        ItemStack bricks3 = MetaCreator.MetaCreator(Material.BRICKS, (byte) 3, ChatColor.YELLOW+"3 уровень");
        ItemStack bricks4 = MetaCreator.MetaCreator(Material.BRICKS, (byte) 4, ChatColor.YELLOW+"4 уровень");
        ItemStack bricks5 = MetaCreator.MetaCreator(Material.BRICKS, (byte) 5, ChatColor.YELLOW+"5 уровень");
        ItemStack bricks6 = MetaCreator.MetaCreator(Material.BRICKS, (byte) 6, ChatColor.YELLOW+"6 уровень");
        inv.setItem(0, bricks1);
        inv.setItem(18, bricks2);
        inv.setItem(36, bricks3);
        inv.setItem(14, bricks4);
        inv.setItem(32, bricks5);
        inv.setItem(50, bricks6);

        p.openInventory(inv);
    }
}
