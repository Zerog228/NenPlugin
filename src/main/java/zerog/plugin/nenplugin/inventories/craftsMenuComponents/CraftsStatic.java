package zerog.plugin.nenplugin.inventories.craftsMenuComponents;

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

public class CraftsStatic {

    public static void staticItems(Player p, Inventory inv){

        ItemStack gray_glass = MetaCreator(Material.GRAY_STAINED_GLASS_PANE, (byte) 1, "⠀");

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, gray_glass);
        }
        ItemStack anvil = MetaCreator.MetaCreator(Material.ANVIL, (byte) 1, "Назад");
        inv.setItem(53, anvil);

        double craft_points = (double) PersistentData.getPlayerData(p, "nen_craft_points", PersistentDataType.DOUBLE);

        DecimalFormat format = new DecimalFormat("0.#");

        if(craft_points <= 1){
            ItemStack head = MetaCreator.MetaCreator(Material.PLAYER_HEAD, (byte) 1, "Очки крафтов", ChatColor.GREEN, "Ваши очки крафтов", "Вы имеете: "+format.format(craft_points), inv, (byte) 49);
        } else {
            ItemStack head = MetaCreator.MetaCreator(Material.PLAYER_HEAD, (byte) craft_points, "Очки крафтов", ChatColor.GREEN, "Ваши очки крафтов", "Вы имеете: "+format.format(craft_points), inv, (byte) 49);
        }

        ItemStack workbench = MetaCreator.MetaCreator(Material.CRAFTING_TABLE, (byte) 1, "Список крафтов", ChatColor.GREEN, "Нажмите чтобы посмотреть", "Все крафты на каждом уровне", inv, (byte) 45);
    }
}
