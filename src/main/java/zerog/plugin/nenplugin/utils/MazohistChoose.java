package zerog.plugin.nenplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static zerog.plugin.nenplugin.utils.MetaCreator.MetaCreator;

public class MazohistChoose {

    public static void openMenu(Player p){
        Inventory inv = Bukkit.createInventory(p, 9, ChatColor.RED + "Вы точно уверены?");

        ItemStack gray_glass = MetaCreator(Material.GRAY_STAINED_GLASS_PANE, (byte) 1, "⠀");

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, gray_glass);
        }

        ItemStack yes = MetaCreator.MetaCreator(Material.GREEN_DYE, (byte) 1, "Подтвердить", ChatColor.RED, "Стать мазохистом", "", inv, (byte) 6);
        ItemStack no = MetaCreator.MetaCreator(Material.BARRIER, (byte) 1, "Отменить", ChatColor.GREEN, "Вернуться в меню", "", inv, (byte) 2);

        p.openInventory(inv);
    }
}
