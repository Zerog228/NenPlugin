package zerog.plugin.nenplugin.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import zerog.plugin.nenplugin.commands.*;

import java.util.Objects;

public class AvailableCraftsInventory {

    public static void chooseInventory(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        Material item = Objects.requireNonNull(e.getCurrentItem()).getType();

        boolean b = true;

        switch (item) {
            case BRICKS -> {
                DecorCrafts.openMenu(p);
                b = false;
            }
            case REDSTONE_LAMP -> {
                RedstoneCrafts.openMenu(p);
                b = false;
            }
            case IRON_PICKAXE -> {
                SmithingCrafts.openMenu(p);
                b = false;
            }
            case IRON_AXE -> {
                CarpentryCrafts.openMenu(p);
                b = false;
            }
            case ANVIL -> {
                CraftsCommand.openMenu(p);
                b = false;
            }
        }

        if (b) {
            AvailableCraftsCommand.openMenu(p);
        }
    }
}
