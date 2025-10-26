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

public class ClassesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("classes") && sender instanceof Player p) {
            openMenu(p);
        }
        return true;
    }

    public static void openMenu(Player p){

        Inventory inv = Bukkit.createInventory(p, 54, ChatColor.DARK_GRAY + "Классы");

        ItemStack gray_glass = MetaCreator(Material.GRAY_STAINED_GLASS_PANE, (byte) 1, "⠀");

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, gray_glass);
        }

        ItemStack anvil = MetaCreator.MetaCreator(Material.ANVIL, (byte) 1, "Назад", ChatColor.WHITE, "Вернуться в меню", "", inv, (byte) 45);
        ItemStack arrow = MetaCreator.MetaCreator(Material.ARROW, (byte) 1, "Вперёд", ChatColor.WHITE, "Вторая страница", "", inv, (byte) 53);
        ItemStack book = MetaCreator.MetaCreator(Material.BOOK, (byte) 1, "Заметки", ChatColor.YELLOW, "Мазохист не выпадает в рулетке", "Характеристики роллера сбрасываются при дубле", inv, (byte) 49);

        ItemStack warrior = MetaCreator.ClassesMetaCreator(Material.IRON_HELMET, (byte) 1, "Воин", ChatColor.AQUA, "У вас больше урон и хп", "Вы заметно медлительнее остальных", inv, (byte) 10);
        ItemStack berserk = MetaCreator.ClassesMetaCreator(Material.IRON_AXE, (byte) 1, "Берсерк", ChatColor.GOLD, "Эволюция воина", "Больше урона первыми ударами", inv, (byte) 28);
        ItemStack ironclad = MetaCreator.ClassesMetaCreator(Material.IRON_CHESTPLATE, (byte) 1, "Броненосец", ChatColor.GOLD, "Эволюция воина", "Больше защита от первых ударов", inv, (byte) 37);

        ItemStack paladin = MetaCreator.ClassesMetaCreator(Material.GOLD_INGOT, (byte) 1, "Паладин", ChatColor.AQUA, "Вы наносите больше урона нежити", "Вы восприимчивее к зельям", inv, (byte) 15);
        ItemStack bomber = MetaCreator.ClassesMetaCreator(Material.TNT, (byte) 1, "Подрывник", ChatColor.AQUA, "Вы можете кидать, ставить и поджигать динамит", "у вас меньше хп и урона", inv, (byte) 16);
        ItemStack builder = MetaCreator.ClassesMetaCreator(Material.BRICK, (byte) 1, "Строитель", ChatColor.AQUA, "У вас есть доступ к treeCapitator", "У вас меньше хп и урона", inv, (byte) 24);
        ItemStack parasite = MetaCreator.ClassesMetaCreator(Material.ROTTEN_FLESH, (byte) 1, "Паразит", ChatColor.AQUA, "Вы повышаете статы убивая игроков", "у вас очень низкие начальные статы", inv, (byte) 25);
        ItemStack politic = MetaCreator.ClassesMetaCreator(Material.PAPER, (byte) 1, "Политик", ChatColor.AQUA, "У вас больше скорость и есть двойной прыжок", "У вас меньше хп и брони", inv, (byte) 33);
        ItemStack detective = MetaCreator.ClassesMetaCreator(Material.SPYGLASS, (byte) 1, "Детектив", ChatColor.AQUA, "Вы можете использовать /co i", "У вас меньше хп", inv, (byte) 34);
        ItemStack mazohist = MetaCreator.ClassesMetaCreator(Material.POINTED_DRIPSTONE, (byte) 1, "Мазохист", ChatColor.AQUA, "У вас больше места в эндер-сундуке", "У вас 1 хп и 0 урона", inv, (byte) 42);
        ItemStack vampire = MetaCreator.ClassesMetaCreator(Material.RED_CANDLE, (byte) 1, "Вампир", ChatColor.AQUA, "У вас есть вампиризм и любовь к тьме", "У вас меньше хп и солнцебоязнь", inv, (byte) 43);

        ItemStack roller = MetaCreator.ClassesMetaCreator(Material.CONDUIT, (byte) 1, "Роллер", ChatColor.AQUA, "Поднимает свои характеристики броском куба", "У вас меньше места в эндер-сундуке", inv, (byte) 12);
        ItemStack reroller = MetaCreator.ClassesMetaCreator(Material.BEACON, (byte) 1, "Рероллер", ChatColor.GOLD, "Эволюция роллера", "Характеристики повышаются в два раза больше", inv, (byte) 30);


        p.openInventory(inv);
    }
}
