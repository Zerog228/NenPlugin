package zerog.plugin.nenplugin.inventories;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataType;
import zerog.plugin.nenplugin.commands.AvailableCraftsCommand;
import zerog.plugin.nenplugin.commands.CraftsCommand;
import zerog.plugin.nenplugin.commands.MenuCommand;
import zerog.plugin.nenplugin.utils.PersistentData;

import java.util.Objects;

public class CraftsInventory {

    public static void openCraftsInventory(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        Material item = Objects.requireNonNull(e.getCurrentItem()).getType();
        boolean b = true;

        double craft_points = (double) PersistentData.getPlayerData(p, "nen_craft_points", PersistentDataType.DOUBLE);

        int decor_upgrades = (int) PersistentData.getPlayerData(p, "nen_blocks_decor_upgrades", PersistentDataType.INTEGER);
        int redstone_upgrades = (int) PersistentData.getPlayerData(p, "nen_redstone_upgrades", PersistentDataType.INTEGER);
        int smithing_upgrades = (int) PersistentData.getPlayerData(p, "nen_smithing_upgrades", PersistentDataType.INTEGER);
        int carpentry_upgrades = (int) PersistentData.getPlayerData(p, "nen_carpentry_upgrades", PersistentDataType.INTEGER);
        int jewelry_upgrades = (int) PersistentData.getPlayerData(p, "nen_jewelry_upgrades", PersistentDataType.INTEGER);


        switch (Objects.requireNonNull(item)) {
            case BRICKS -> {
                if (decor_upgrades < 6) {
                    double decor_cost = Math.pow(2, decor_upgrades);
                    if (decor_cost < craft_points) {
                        craft_points -= decor_cost;
                        PersistentData.setPlayerData(p, "nen_blocks_decor_upgrades", PersistentDataType.INTEGER, (decor_upgrades + 1), "");
                        PersistentData.setPlayerData(p, "nen_craft_points", PersistentDataType.DOUBLE, craft_points, "");
                    } else {
                        p.sendMessage(ChatColor.RED + "Недостаточно очков крафта");
                    }
                }
            }
            case REDSTONE_LAMP -> {
                if (redstone_upgrades < 6) {
                    double redstone_cost = Math.pow(2, redstone_upgrades);
                    if (redstone_cost < craft_points) {
                        craft_points -= redstone_cost;
                        PersistentData.setPlayerData(p, "nen_redstone_upgrades", PersistentDataType.INTEGER, (redstone_upgrades + 1), "");
                        PersistentData.setPlayerData(p, "nen_craft_points", PersistentDataType.DOUBLE, craft_points, "");
                    } else {
                        p.sendMessage(ChatColor.RED + "Недостаточно очков крафта");
                    }
                }
            }
            case IRON_PICKAXE -> {
                if (smithing_upgrades < 6) {
                    double smithing_cost = Math.pow(2, smithing_upgrades);
                    if (smithing_cost < craft_points) {
                        craft_points -= smithing_cost;
                        PersistentData.setPlayerData(p, "nen_smithing_upgrades", PersistentDataType.INTEGER, (smithing_upgrades + 1), "");
                        PersistentData.setPlayerData(p, "nen_craft_points", PersistentDataType.DOUBLE, craft_points, "");
                    } else {
                        p.sendMessage(ChatColor.RED + "Недостаточно очков крафта");
                    }
                }
            }
            case DIAMOND -> {
                if (jewelry_upgrades < 6) {
                    double jewerly_cost = Math.pow(2, jewelry_upgrades);
                    if (jewerly_cost < craft_points) {
                        craft_points -= jewerly_cost;
                        PersistentData.setPlayerData(p, "nen_jewelry_upgrades", PersistentDataType.INTEGER, (jewelry_upgrades + 1), "");
                        PersistentData.setPlayerData(p, "nen_craft_points", PersistentDataType.DOUBLE, craft_points, "");
                    } else {
                        p.sendMessage(ChatColor.RED + "Недостаточно очков крафта");
                    }
                }
            }
            case IRON_AXE -> {
                if (carpentry_upgrades < 5) {
                    double carpentry_cost = Math.pow(2, carpentry_upgrades);
                    if (carpentry_cost < craft_points) {
                        craft_points -= carpentry_cost;
                        PersistentData.setPlayerData(p, "nen_carpentry_upgrades", PersistentDataType.INTEGER, (carpentry_upgrades + 1), "");
                        PersistentData.setPlayerData(p, "nen_craft_points", PersistentDataType.DOUBLE, craft_points, "");
                    } else {
                        p.sendMessage(ChatColor.RED + "Недостаточно очков крафта");
                    }
                }
            }
            case ANVIL -> {
                MenuCommand.openMenu(p);
                b = false;
            }
            case CRAFTING_TABLE -> {
                AvailableCraftsCommand.openMenu(p);
                b = false;
            }
        }
        if(b){
            CraftsCommand.openMenu(p);
        }
    }
}
