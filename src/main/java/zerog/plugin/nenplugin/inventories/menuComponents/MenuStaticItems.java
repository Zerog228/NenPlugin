package zerog.plugin.nenplugin.inventories.menuComponents;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import zerog.plugin.nenplugin.utils.MetaCreator;
import zerog.plugin.nenplugin.utils.PersistentData;

import java.text.DecimalFormat;

import static zerog.plugin.nenplugin.utils.MetaCreator.MetaCreator;

public class MenuStaticItems {
    public static void staticItems(Player p, Inventory inv){

        ItemStack gray_glass = MetaCreator(Material.GRAY_STAINED_GLASS_PANE, (byte) 1, "⠀");

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, gray_glass);
        }

        ItemStack paper = MetaCreator(Material.WRITABLE_BOOK, (byte) 1, "Помощь по серверу");
        inv.setItem(4, paper);

        int level = (int) PersistentData.getPlayerData(p, "nen_level", PersistentDataType.INTEGER);
        double xp = (double) PersistentData.getPlayerData(p, "nen_exp", PersistentDataType.DOUBLE);
        int i = (int) PersistentData.getPlayerData(p, "class_number", PersistentDataType.INTEGER);
        DecimalFormat format = new DecimalFormat("0.#");

        if(level==0){
            ItemStack head = MetaCreator.MetaCreator(Material.PLAYER_HEAD, (byte) 1, "Ваш уровень", ChatColor.YELLOW, "Текущий уровень: "+level, "Текущий опыт: "+format.format(xp), inv, (byte) 0);
        } else {
            ItemStack head = MetaCreator.MetaCreator(Material.PLAYER_HEAD, (byte) level, "Ваш уровень", ChatColor.YELLOW, "Текущий уровень: "+ChatColor.AQUA+level, "Текущий опыт: ("+ChatColor.AQUA+format.format(xp)+ChatColor.WHITE+"/"+ChatColor.AQUA+((level+3)*level)+ChatColor.WHITE+")", inv, (byte) 0);
        }

        ItemStack exp_bottle = MetaCreator.MetaCreator(Material.EXPERIENCE_BOTTLE, (byte) 1, "Прокачка статов", ChatColor.GREEN, "Меню прокачки", "За очки опыта", inv, (byte) 18);
        ItemStack i_sword = MetaCreator.MetaCreator(Material.IRON_SWORD, (byte) 1, "Список классов", ChatColor.RED, "Все классы", "и их особенности", inv, (byte) 3);

        ItemStack workbench = MetaCreator.MetaCreator(Material.CRAFTING_TABLE, (byte) 1, "Прокачка крафтов", ChatColor.GREEN, "Меню открытия крафтов", "За очки крафтинга", inv, (byte) 27);

        ItemStack chest = MetaCreator.MetaCreator(Material.CHEST, (byte) 1, "Общий сундук", ChatColor.GOLD, "Сундук для всех", "В нём можно делиться вещами", inv, (byte) 45);

        ItemStack enchanted_book = MetaCreator.MetaCreator(Material.ENCHANTED_BOOK, (byte) 1, "Правила сервера", ChatColor.GOLD, "Нажмите на меня", "Чтобы узнать правила", inv, (byte) 5);
    }
}
