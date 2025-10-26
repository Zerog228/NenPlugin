package zerog.plugin.nenplugin.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import zerog.plugin.nenplugin.NenPlugin;
import zerog.plugin.nenplugin.commands.MenuCommand;
import zerog.plugin.nenplugin.commands.classes.Mazohist;
import zerog.plugin.nenplugin.commands.classes.Parasite;

import java.util.Objects;

public class MazohistChooseInventory {

    public static void chooseInventory(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        Material item = Objects.requireNonNull(e.getCurrentItem()).getType();

        if (item == Material.GREEN_DYE) {
            NenPlugin.removePermission(p.getUniqueId(), "class_roll");
            Mazohist.setMazohist(p);
        }
        MenuCommand.openMenu(p);
    }
}
