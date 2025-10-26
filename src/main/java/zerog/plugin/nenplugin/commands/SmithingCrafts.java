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

public class SmithingCrafts implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("s_crafts") && sender instanceof Player p) {

            openMenu(p);
        }
        return true;
    }

    public static void openMenu(Player p){

        Inventory inv = Bukkit.createInventory(p, 54, ChatColor.DARK_GRAY + "Кузнечное дело");

        ItemStack gray_glass = MetaCreator(Material.GRAY_STAINED_GLASS_PANE, (byte) 1, "⠀");

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, gray_glass);
        }

        ItemStack flint = MetaCreator.MetaCreator(Material.FLINT_AND_STEEL, (byte) 1, "Огниво и ведро");
        ItemStack i_axe = MetaCreator.MetaCreator(Material.IRON_AXE, (byte) 1, "Железные инструменты");
        ItemStack shears = MetaCreator.MetaCreator(Material.SHEARS, (byte) 1, "Ножницы и пузырёк");
        inv.setItem(1, flint);
        inv.setItem(2, i_axe);
        inv.setItem(3, shears);

        ItemStack grindstone = MetaCreator.MetaCreator(Material.GRINDSTONE, (byte) 1, "Точило и печь");
        ItemStack anvil = MetaCreator.MetaCreator(Material.ANVIL, (byte) 1, "Наковальня и кузнечный стол");
        ItemStack chain = MetaCreator.MetaCreator(Material.CHAIN, (byte) 1, "Цепи и прутья");
        inv.setItem(19, grindstone);
        inv.setItem(20, anvil);
        inv.setItem(21, chain);

        ItemStack tag = MetaCreator.MetaCreator(Material.NAME_TAG, (byte) 1, "Бирки и око эндера");
        ItemStack chainmail = MetaCreator.MetaCreator(Material.CHAINMAIL_CHESTPLATE, (byte) 1, "Кольчуга");
        ItemStack compass = MetaCreator.MetaCreator(Material.COMPASS, (byte) 1, "Компас, часы и труба");
        inv.setItem(37, tag);
        inv.setItem(38, chainmail);
        inv.setItem(39, compass);

        ItemStack i_chestplate = MetaCreator.MetaCreator(Material.IRON_CHESTPLATE, (byte) 1, "Железная броня");
        ItemStack crossbow = MetaCreator.MetaCreator(Material.CROSSBOW, (byte) 1, "Арбалет");
        ItemStack i_horse = MetaCreator.MetaCreator(Material.IRON_HORSE_ARMOR, (byte) 1, "Железная конская броня");
        inv.setItem(15, i_chestplate);
        inv.setItem(16, crossbow);
        inv.setItem(17, i_horse);

        ItemStack g_apple = MetaCreator.MetaCreator(Material.GOLDEN_APPLE, (byte) 1, "Золотая еда");
        ItemStack g_sword = MetaCreator.MetaCreator(Material.GOLDEN_SWORD, (byte) 1, "Вещи из драгоценностей");
        ItemStack beacon = MetaCreator.MetaCreator(Material.BEACON, (byte) 1, "Маяк и подводный источник");
        inv.setItem(33, g_apple);
        inv.setItem(34, g_sword);
        inv.setItem(35, beacon);

        ItemStack n_armor = MetaCreator.MetaCreator(Material.NETHERITE_CHESTPLATE, (byte) 1, "Незеритовая броня");
        ItemStack n_sword = MetaCreator.MetaCreator(Material.NETHERITE_SWORD, (byte) 1, "Незеритовые инструменты");
        ItemStack r_compass = MetaCreator.MetaCreator(Material.RECOVERY_COMPASS, (byte) 1, "Возвратный компас");
        inv.setItem(51, n_armor);
        inv.setItem(52, n_sword);
        inv.setItem(53, r_compass);

        ItemStack bricks1 = MetaCreator.MetaCreator(Material.WOODEN_PICKAXE, (byte) 1, ChatColor.YELLOW+"1 уровень");
        ItemStack bricks2 = MetaCreator.MetaCreator(Material.STONE_PICKAXE, (byte) 2, ChatColor.YELLOW+"2 уровень");
        ItemStack bricks3 = MetaCreator.MetaCreator(Material.IRON_PICKAXE, (byte) 3, ChatColor.YELLOW+"3 уровень");
        ItemStack bricks4 = MetaCreator.MetaCreator(Material.GOLDEN_PICKAXE, (byte) 4, ChatColor.YELLOW+"4 уровень");
        ItemStack bricks5 = MetaCreator.MetaCreator(Material.DIAMOND_PICKAXE, (byte) 5, ChatColor.YELLOW+"5 уровень");
        ItemStack bricks6 = MetaCreator.MetaCreator(Material.NETHERITE_PICKAXE, (byte) 6, ChatColor.YELLOW+"6 уровень");
        inv.setItem(0, bricks1);
        inv.setItem(18, bricks2);
        inv.setItem(36, bricks3);
        inv.setItem(14, bricks4);
        inv.setItem(32, bricks5);
        inv.setItem(50, bricks6);

        p.openInventory(inv);
    }
}
