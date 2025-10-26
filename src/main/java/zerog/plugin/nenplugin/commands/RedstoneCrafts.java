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

public class RedstoneCrafts implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("r_crafts") && sender instanceof Player p) {

            openMenu(p);
        }
        return true;
    }

    public static void openMenu(Player p){

        Inventory inv = Bukkit.createInventory(p, 54, ChatColor.DARK_GRAY + "Механизмы");

        ItemStack gray_glass = MetaCreator(Material.GRAY_STAINED_GLASS_PANE, (byte) 1, "⠀");

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, gray_glass);
        }

        ItemStack r_block = MetaCreator.MetaCreator(Material.REDSTONE_BLOCK, (byte) 1, "Блок редстоуна");
        ItemStack hook = MetaCreator.MetaCreator(Material.TRIPWIRE_HOOK, (byte) 1, "Крюк и лампа");
        ItemStack torch = MetaCreator.MetaCreator(Material.REDSTONE_TORCH, (byte) 1, "Красный факел");
        inv.setItem(1, r_block);
        inv.setItem(2, hook);
        inv.setItem(3, torch);

        ItemStack chest = MetaCreator.MetaCreator(Material.TRAPPED_CHEST, (byte) 1, "Сундук-ловушка и кнопка");
        ItemStack repeater = MetaCreator.MetaCreator(Material.REPEATER, (byte) 1, "Повторитель");
        ItemStack iron_door = MetaCreator.MetaCreator(Material.IRON_DOOR, (byte) 1, "Железная дверь и люк");
        inv.setItem(19, chest);
        inv.setItem(20, repeater);
        inv.setItem(21, iron_door);

        ItemStack minecart = MetaCreator.MetaCreator(Material.MINECART, (byte) 1, "Вагонетки");
        ItemStack target = MetaCreator.MetaCreator(Material.TARGET, (byte) 1, "Мишень и нажимные плиты");
        ItemStack l_rod = MetaCreator.MetaCreator(Material.LIGHTNING_ROD, (byte) 1, "Громоотвод");
        inv.setItem(37, minecart);
        inv.setItem(38, target);
        inv.setItem(39, l_rod);

        ItemStack piston = MetaCreator.MetaCreator(Material.PISTON, (byte) 1, "Поршни и блоки слизи");
        ItemStack n_block = MetaCreator.MetaCreator(Material.NOTE_BLOCK, (byte) 1, "Нотные блоки");
        ItemStack comparator = MetaCreator.MetaCreator(Material.COMPARATOR, (byte) 1, "Компаратор");
        inv.setItem(15, piston);
        inv.setItem(16, n_block);
        inv.setItem(17, comparator);

        ItemStack hopper = MetaCreator.MetaCreator(Material.HOPPER, (byte) 1, "Воронка");
        ItemStack observer = MetaCreator.MetaCreator(Material.OBSERVER, (byte) 1, "Наблюдатель");
        ItemStack dispenser = MetaCreator.MetaCreator(Material.DISPENSER, (byte) 1, "Раздатчик и выбрасыватель");
        inv.setItem(33, hopper);
        inv.setItem(34, observer);
        inv.setItem(35, dispenser);

        ItemStack lodestone = MetaCreator.MetaCreator(Material.LODESTONE, (byte) 1, "Магнетит");
        ItemStack anchor = MetaCreator.MetaCreator(Material.RESPAWN_ANCHOR, (byte) 1, "Якорь возрождения");
        ItemStack sensor = MetaCreator.MetaCreator(Material.DAYLIGHT_DETECTOR, (byte) 1, "Датчик дневного света");
        inv.setItem(51, lodestone);
        inv.setItem(52, anchor);
        inv.setItem(53, sensor);

        ItemStack bricks1 = MetaCreator.MetaCreator(Material.REDSTONE_LAMP, (byte) 1, ChatColor.YELLOW+"1 уровень");
        ItemStack bricks2 = MetaCreator.MetaCreator(Material.REDSTONE_LAMP, (byte) 2, ChatColor.YELLOW+"2 уровень");
        ItemStack bricks3 = MetaCreator.MetaCreator(Material.REDSTONE_LAMP, (byte) 3, ChatColor.YELLOW+"3 уровень");
        ItemStack bricks4 = MetaCreator.MetaCreator(Material.REDSTONE_LAMP, (byte) 4, ChatColor.YELLOW+"4 уровень");
        ItemStack bricks5 = MetaCreator.MetaCreator(Material.REDSTONE_LAMP, (byte) 5, ChatColor.YELLOW+"5 уровень");
        ItemStack bricks6 = MetaCreator.MetaCreator(Material.REDSTONE_LAMP, (byte) 6, ChatColor.YELLOW+"6 уровень");
        inv.setItem(0, bricks1);
        inv.setItem(18, bricks2);
        inv.setItem(36, bricks3);
        inv.setItem(14, bricks4);
        inv.setItem(32, bricks5);
        inv.setItem(50, bricks6);

        p.openInventory(inv);
    }
}
