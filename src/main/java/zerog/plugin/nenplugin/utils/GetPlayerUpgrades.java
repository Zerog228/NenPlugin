package zerog.plugin.nenplugin.utils;

import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.Map;

public class GetPlayerUpgrades {

    public static Map<Byte, Integer> getUpgrades (Player p){

        int hp_points = (int) PersistentData.getPlayerData(p, "nen_points_hp", PersistentDataType.INTEGER);
        int speed_points = (int) PersistentData.getPlayerData(p, "nen_points_speed", PersistentDataType.INTEGER);
        int armour_points = (int) PersistentData.getPlayerData(p, "nen_points_armour", PersistentDataType.INTEGER);
        int armour_t_points = (int) PersistentData.getPlayerData(p, "nen_points_armour_t", PersistentDataType.INTEGER);
        int damage_points = (int) PersistentData.getPlayerData(p, "nen_points_damage", PersistentDataType.INTEGER);
        int haste_points = (int) PersistentData.getPlayerData(p, "nen_points_haste", PersistentDataType.INTEGER);
        int luck_points = (int) PersistentData.getPlayerData(p, "nen_points_luck", PersistentDataType.INTEGER);

        int upgr_p = hp_points + speed_points + armour_points + armour_t_points + damage_points + haste_points + luck_points;

        Map<Byte, Integer> upgr_map = new HashMap<>();

        upgr_map.put((byte) 0, hp_points);
        upgr_map.put((byte) 1, speed_points);
        upgr_map.put((byte) 2, armour_points);
        upgr_map.put((byte) 3, armour_t_points);
        upgr_map.put((byte) 4, damage_points);
        upgr_map.put((byte) 5, haste_points);
        upgr_map.put((byte) 6, luck_points);
        upgr_map.put((byte) 7, upgr_p);

        return upgr_map;
    }
}
