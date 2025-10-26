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

public class HelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("help") && sender instanceof Player p) {

            openMenu(p);
        }
        return true;
    }

    public static void openMenu(Player p){

        Inventory inv = Bukkit.createInventory(p, 54, ChatColor.DARK_GRAY + "Помощь");

        ItemStack gray_glass = MetaCreator(Material.GRAY_STAINED_GLASS_PANE, (byte) 1, "⠀");

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, gray_glass);
        }

        ItemStack anvil = MetaCreator.MetaCreator(Material.ANVIL, (byte) 1, "Назад", ChatColor.WHITE, "", "", inv, (byte) 53);

        ItemStack help1 = MetaCreator.MetaCreator(Material.PAPER, (byte) 1, "Почему я не могу скрафтить вагонетку и некоторые другие предметы?", ChatColor.AQUA, "Их крафт был изменён", "Теперь их можно скрафтить в верстаке или столе судьбы", inv, (byte) 12);
        ItemStack help2 = MetaCreator.MetaCreator(Material.PAPER, (byte) 2, "Что такое стол судьбы?", ChatColor.AQUA, "Это расширенный верстак для расширенных крафтов", "Его можно скрафтить на обычном верстаке", inv, (byte) 13);
        ItemStack help3 = MetaCreator.MetaCreator(Material.PAPER, (byte) 3, "Где я могу увидеть изменённые крафты?", ChatColor.AQUA, "Все изменённые крафты можно просмотреть в книге рецептов", "Она создаётся из верстака и бумажки", inv, (byte) 14);
        ItemStack help4 = MetaCreator.MetaCreator(Material.PAPER, (byte) 4, "Что такое \"Класс\"?", ChatColor.AQUA, "Это набор особенностей и возможностей", "Его можно получить случайным образом достигнув 20 уровня", inv, (byte) 21);
        ItemStack help5 = MetaCreator.MetaCreator(Material.PAPER, (byte) 5, "Что такое очки опыта?", ChatColor.AQUA, "Это очки, выдаваемые за повышение уровня", "Их можно потратить во вкладке \"Прокачка статов\"", inv, (byte) 22);

        ItemStack help_crafts1 = MetaCreator.MetaCreator(Material.CRAFTING_TABLE, (byte) 1, "\"У вас недостаточно уровня чтобы скрафтить...\"", ChatColor.AQUA, "Чтобы открыть многие рецепты", "Вам нужно прокачать соответствующие ветви крафтов", inv, (byte) 16);
        ItemStack help_crafts2 = MetaCreator.MetaCreator(Material.CRAFTING_TABLE, (byte) 2, "Где прокачать ветви крафтов?", ChatColor.AQUA, "Ветви крафтов можно прокачать", "В меню \"Прокачка крафтов\"", inv, (byte) 25);
        ItemStack help_crafts3 = MetaCreator.MetaCreator(Material.CRAFTING_TABLE, (byte) 3, "Где добыть очки крафтов?", ChatColor.AQUA, "Крафтите доступные на вашем уровне предметы", "Так же вам доступно 1 очко прокачки со старта", inv, (byte) 34);
        ItemStack help_crafts4 = MetaCreator.MetaCreator(Material.CRAFTING_TABLE, (byte) 4, "Где посмотреть доступные предметы?", ChatColor.AQUA, "Все доступные предметы со всех уровней", "можно посмотреть в меню \"Список крафтов\"", inv, (byte) 43);

        ItemStack help_yamipa = MetaCreator.MetaCreator(Material.PAINTING, (byte) 1, "На сервере установлен плагин Yamipa", ChatColor.AQUA, "Это плагин на добавление кастомных картин", "За участие в ивентах вы можете выиграть одну из таких", inv, (byte) 19);

        ItemStack help_potions1 = MetaCreator.MetaCreator(Material.POTION, (byte) 1, "Почему я не могу сварить зелья?", ChatColor.AQUA, "На сервере установлен плагин Brewery", "С помощью него и можно варить зелья", inv, (byte) 39);
        ItemStack help_potions2 = MetaCreator.MetaCreator(Material.POTION, (byte) 2, "Где посмотреть рецепты зелий?", ChatColor.AQUA, "Рецепты зелий можно посмотреть в ведьминой книге", "она крафтится на обычном верстаке", inv, (byte) 40);
        ItemStack help_potions3 = MetaCreator.MetaCreator(Material.POTION, (byte) 3, "Как скрафтить взрывные зелья?", ChatColor.AQUA, "Они крафтятся на столе кузнеца", "Нужно соеденить обычное зелье с порохом", inv, (byte) 41);

        ItemStack end = MetaCreator.MetaCreator(Material.END_PORTAL_FRAME, (byte) 1, "Почему не работает энд?", ChatColor.AQUA, "Измерение энда временно недоступно", "но в ближайшее время будет разблокировано", inv, (byte) 37);

        ItemStack donate = MetaCreator.MetaCreator(Material.GOLD_INGOT, (byte) 1, "Донат", ChatColor.GOLD, "На данный момент на сервере нет доната", "но вы можете сделать добровольное пожертвование", inv, (byte) 49);

        ItemStack communicate = MetaCreator.MetaCreator(Material.BLUE_DYE, (byte) 1, "Как мне связаться напрямую или задать вопрос?", ChatColor.AQUA, "Связаться с администрацией можно в дискорде или вк", "Кликните на меня чтобы получить ссылку!", inv, (byte) 4);
        p.openInventory(inv);
    }
}
