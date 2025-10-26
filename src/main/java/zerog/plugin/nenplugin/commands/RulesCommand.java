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

public class RulesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("rules") && sender instanceof Player p) {

            openMenu(p);
        }
        return true;
    }

    public static void openMenu(Player p){

        Inventory inv = Bukkit.createInventory(p, 27, ChatColor.DARK_GRAY + "Правила");

        ItemStack gray_glass = MetaCreator(Material.GRAY_STAINED_GLASS_PANE, (byte) 1, "⠀");

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, gray_glass);
        }

        ItemStack anvil = MetaCreator.MetaCreator(Material.ANVIL, (byte) 1, "Назад", ChatColor.WHITE, "", "", inv, (byte) 26);

        ItemStack rule1 = MetaCreator.MetaCreator(Material.BOOK, (byte) 1, "1. На сервере запрещено гриферство", ChatColor.AQUA, "В т.ч. убийство без согласия", "Или обман на ресурсы", inv, (byte) 12);
        ItemStack rule2 = MetaCreator.MetaCreator(Material.BOOK, (byte) 2, "2. Запрещены оскорбления", ChatColor.AQUA, "А так же флуд, спам", "И реклама сторонних серверов", inv, (byte) 13);
        ItemStack rule3 = MetaCreator.MetaCreator(Material.BOOK, (byte) 3, "3. На сервере запрещены читы", ChatColor.AQUA, "Но разрешена миникарта", "", inv, (byte) 14);

        ItemStack communicate = MetaCreator.MetaCreator(Material.BLUE_DYE, (byte) 1, "Как мне связаться напрямую или задать вопрос?", ChatColor.AQUA, "Связаться с администрацией можно в дискорде или вк", "Кликните на меня чтобы получить ссылку!", inv, (byte) 4);
        p.openInventory(inv);
    }
}
