package zerog.plugin.nenplugin.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;

public class AddCraftingExperience {

    private static int getPlayerData(Player p, String data_name){

        return (int) PersistentData.getPlayerData(p, data_name, PersistentDataType.INTEGER);
    }

    public static void CraftExp(CraftItemEvent e){
        Player p = (Player) e.getWhoClicked();
        int decor_level = getPlayerData(p, "nen_blocks_decor_upgrades");
        int redstone_level = getPlayerData(p, "nen_redstone_upgrades");
        int smithing_level = getPlayerData(p, "nen_smithing_upgrades");
        int carpentry_level = getPlayerData(p, "nen_carpentry_upgrades");

        decorMapComparator(e, DifferentMaps.decor_map, 0.001, decor_level, smithing_level);
        MapComparator(e, DifferentMaps.redstone_map, 0.01, redstone_level);
        MapComparator(e, DifferentMaps.smithing_map, 0.01, smithing_level);
        carpentryMapComparator(e, DifferentMaps.carpentry_map, 0.001, carpentry_level, smithing_level);
    }

    private static void GetEveryCraft(CraftItemEvent e, double amount){
        Player p = (Player) e.getWhoClicked();
        ItemStack craftedItem = e.getInventory().getResult();
        Inventory Inventory = e.getInventory();
        ClickType clickType = e.getClick();
        int realAmount = craftedItem.getAmount();
        if(clickType.isShiftClick())
        {
            int lowerAmount = craftedItem.getMaxStackSize() + 1000;
            for(ItemStack actualItem : Inventory.getContents())
            {
                if(!actualItem.getType().isAir() && lowerAmount > actualItem.getAmount() && !actualItem.getType().equals(craftedItem.getType()))
                    lowerAmount = actualItem.getAmount();
            }
            realAmount = lowerAmount * craftedItem.getAmount();
            if(craftedItem.getType() != Material.REDSTONE_BLOCK && craftedItem.getType() != Material.COPPER_BLOCK && craftedItem.getType() != Material.RAW_COPPER_BLOCK && craftedItem.getType() != Material.COPPER_INGOT){
                AddExp(p, amount*realAmount);
            }
        } else {
            if(craftedItem.getType() != Material.REDSTONE_BLOCK && craftedItem.getType() != Material.COPPER_BLOCK && craftedItem.getType() != Material.RAW_COPPER_BLOCK && craftedItem.getType() != Material.COPPER_INGOT){
                AddExp(p, amount);
            }
        }
    }

    public static void AddExp(Player p, double amount){
        double craft_points = (double) PersistentData.getPlayerData(p, "nen_craft_points", PersistentDataType.DOUBLE);
        craft_points += amount;
        PersistentData.setPlayerData(p, "nen_craft_points", PersistentDataType.DOUBLE, craft_points, "");
    }

    private static void MapComparator(CraftItemEvent e, HashMap<Integer, String []> map, double xp_amount, int level){
        for (int i = 0; i < level; i++) {
            String [] str = map.get(i);
            String craftedItem = String.valueOf(e.getInventory().getResult());
            for (String word : str) {
                if (craftedItem.contains(word) && e.getAction() != InventoryAction.NOTHING) {
                    GetEveryCraft(e, xp_amount*(i+1));
                }
            }
        }
    }

    private static void decorMapComparator(CraftItemEvent e, HashMap<Integer, String []> map, double xp_amount, int level, int smithing_level){
        String craftedItem = String.valueOf(e.getInventory().getResult());
        if(craftedItem.contains("COBBLESTONE_SLAB") && e.getAction() != InventoryAction.NOTHING){
            GetEveryCraft(e, 0.001/(0.25*(smithing_level+1)));
        }
        for (int i = 0; i < level; i++) {
            String [] str = map.get(i);
            for (String word : str) {
                if (craftedItem.contains(word) && e.getAction() != InventoryAction.NOTHING) {
                    GetEveryCraft(e, xp_amount*(i+1)/(0.25*(smithing_level+1)));
                }
            }
        }
    }

    private static void carpentryMapComparator(CraftItemEvent e, HashMap<Integer, String []> map, double xp_amount, int level, int smithing_level){
        String craftedItem = String.valueOf(e.getInventory().getResult());
        if(craftedItem.contains("OAK_PLANKS") || craftedItem.contains("OAK_SLAB")  && e.getAction() != InventoryAction.NOTHING){
            GetEveryCraft(e, 0.001/(smithing_level+1));
        }
        for (int i = 0; i < level; i++) {
            String [] str = map.get(i);
            for (String word : str) {
                if (craftedItem.contains(word) && e.getAction() != InventoryAction.NOTHING) {
                    GetEveryCraft(e, xp_amount*(i+1)/((smithing_level+1)));
                }
            }
        }
    }
}
