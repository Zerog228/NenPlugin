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

public class UpgradesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("upgrades") && sender instanceof Player p) {

            openMenu(p);
        }
        return true;
    }

    public static void openMenu(Player p){

        Inventory inv = Bukkit.createInventory(p, 27, ChatColor.DARK_GRAY + "Улучшения");

        ItemStack gray_glass = MetaCreator(Material.GRAY_STAINED_GLASS_PANE, (byte) 1, "⠀");

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, gray_glass);
        }

        ItemStack anvil = MetaCreator.MetaCreator(Material.ANVIL, (byte) 1, "Назад", ChatColor.WHITE, "", "", inv, (byte) 26);

        ItemStack communicate = MetaCreator.MetaCreator(Material.BLUE_DYE, (byte) 1, "Как мне связаться напрямую или задать вопрос?", ChatColor.AQUA, "Связаться с администрацией можно в дискорде или вк", "Кликните на меня чтобы получить ссылку!", inv, (byte) 4);
        p.openInventory(inv);
    }
}
