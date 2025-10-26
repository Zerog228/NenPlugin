package zerog.plugin.nenplugin.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.persistence.PersistentDataType;
import org.javatuples.Triplet;

public class CheckCraftingLevel {

    public static Triplet<Boolean, Integer, String> checkLevel(CraftItemEvent e){
        Player p = (Player) e.getWhoClicked();

        Triplet<Boolean, Integer, String> triplet = new Triplet(true, 0, "");

        int decor_level = (int) PersistentData.getPlayerData(p, "nen_blocks_decor_upgrades", PersistentDataType.INTEGER);
        int redstone_level = (int) PersistentData.getPlayerData(p, "nen_redstone_upgrades", PersistentDataType.INTEGER);
        int smithing_level = (int) PersistentData.getPlayerData(p, "nen_smithing_upgrades", PersistentDataType.INTEGER);
        int carpentry_level = (int) PersistentData.getPlayerData(p, "nen_carpentry_upgrades", PersistentDataType.INTEGER);

        String result = String.valueOf(e.getRecipe().getResult());

        for (int i = 5; i>=decor_level; i--) {
            String[] words = DifferentMaps.decor_map.get(i);
            for (String word : words) {
                if (result.contains(word)) {
                    triplet = new Triplet<>(false, i, "Блоки и декор");
                    return triplet;
                }
            }
        }
        for (int i = 5; i>=redstone_level; i--) {
            String[] words = DifferentMaps.redstone_map.get(i);
            for(String word : words){
                if(result.contains(word)){
                    triplet = new Triplet<>(false, i, "Редстоун");
                    return triplet;
                }
            }
        }
        for (int i = 5; i>=smithing_level; i--) {
            String[] words = DifferentMaps.smithing_map.get(i);
            for(String word : words){
                if(result.contains(word)){
                    triplet = new Triplet<>(false, i, "Кузнечное дело");
                    return triplet;
                }
            }
        }
        for (int i = 5; i>=carpentry_level; i--) {
            String[] words = DifferentMaps.carpentry_map.get(i);
            for(String word : words){
                if(result.contains(word)){
                    triplet = new Triplet<>(false, i, "Плотничество");
                    return triplet;
                }
            }
        }
        return triplet;
    }
}
