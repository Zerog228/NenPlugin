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

public class Classes2Command implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("classes2") && sender instanceof Player p) {
            openMenu(p);
        }
        return true;
    }

    public static void openMenu(Player p){

        Inventory inv = Bukkit.createInventory(p, 54, ChatColor.DARK_GRAY + "Классы 2");

        ItemStack gray_glass = MetaCreator(Material.GRAY_STAINED_GLASS_PANE, (byte) 1, "⠀");

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, gray_glass);
        }

        ItemStack anvil = MetaCreator.MetaCreator(Material.ANVIL, (byte) 1, "Назад", ChatColor.WHITE, "", "", inv, (byte) 45);
        ItemStack book = MetaCreator.MetaCreator(Material.BOOK, (byte) 1, "Заметки", ChatColor.YELLOW, "Мученик - эволюция мазохиста", "Его нельзя получить случайным образом", inv, (byte) 49);

        ItemStack werewolf = MetaCreator.ClassesMetaCreator(Material.GRAY_WOOL, (byte) 1, "Оборотень", ChatColor.AQUA, "Вы сильны и кровожадны", "Вы слабеете при наступлении дня", inv, (byte) 10);
        ItemStack archer = MetaCreator.ClassesMetaCreator(Material.BOW, (byte) 1, "Лучник", ChatColor.AQUA, "Ваши стрелы летят дальше", "Вы плохо владеете всем кроме лука", inv, (byte) 19);
        ItemStack mermaid = MetaCreator.ClassesMetaCreator(Material.PRISMARINE_SHARD, (byte) 1, "Мерлин", ChatColor.AQUA, "Вы сильны под водой", "Вы умираете на суше", inv, (byte) 28);
        ItemStack lich = MetaCreator.ClassesMetaCreator(Material.SKELETON_SKULL, (byte) 1, "Лич", ChatColor.AQUA, "Вы можете призвать подмогу на поле битвы", "Вы не переносите дневной свет", inv, (byte) 37);
        ItemStack spider = MetaCreator.ClassesMetaCreator(Material.SPIDER_SPAWN_EGG, (byte) 1, "Паук", ChatColor.AQUA, "Вы больно кусаете", "У вас меньше хп", inv, (byte) 11);
        ItemStack hellboy = MetaCreator.ClassesMetaCreator(Material.LAVA_BUCKET, (byte) 1, "Хеллбой", ChatColor.AQUA, "Вы сильны и огонь вам нипочём", "Вы медлительны", inv, (byte) 20);
        ItemStack assassin = MetaCreator.ClassesMetaCreator(Material.STONE_SWORD, (byte) 1, "Ассасин", ChatColor.AQUA, "Вы быстры и скрытны", "У вас меньше хп и скорость атаки", inv, (byte) 29);
        ItemStack martyr = MetaCreator.ClassesMetaCreator(Material.GOLDEN_APPLE, (byte) 1, "Мученик", ChatColor.AQUA, "Вы отбыли своё наказание", "Теперь вы мученик", inv, (byte) 38);
        ItemStack jesus = MetaCreator.ClassesMetaCreator(Material.ENCHANTED_GOLDEN_APPLE, (byte) 1, "Иисус", ChatColor.AQUA, "Вы Иисус", "", inv, (byte) 12);
        p.openInventory(inv);
    }
}
