package zerog.plugin.nenplugin.utils;

import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class SetVillagerData {

    public static void setAttributes(Player p){
        PersistentData.setPlayerData(p, "data0", PersistentDataType.DOUBLE, 20.0, "");
        SetAttributes.SetAttributes(p, (byte) 0, 20.0);
        PersistentData.setPlayerData(p, "data1", PersistentDataType.DOUBLE, 0.1, "");
        SetAttributes.SetAttributes(p, (byte) 1, 0.1);
        PersistentData.setPlayerData(p, "data2", PersistentDataType.DOUBLE, 0.0, "");
        SetAttributes.SetAttributes(p, (byte) 2, 0.0);
        PersistentData.setPlayerData(p, "data3", PersistentDataType.DOUBLE, 0.0, "");
        SetAttributes.SetAttributes(p, (byte) 3, 0.0);
        PersistentData.setPlayerData(p, "data4", PersistentDataType.DOUBLE, 1.0, "");
        SetAttributes.SetAttributes(p, (byte) 4, 1.0);
        PersistentData.setPlayerData(p, "data5", PersistentDataType.DOUBLE, 4.0, "");
        SetAttributes.SetAttributes(p, (byte) 5, 4.0);
        PersistentData.setPlayerData(p, "data6", PersistentDataType.DOUBLE, 0.0, "");
        SetAttributes.SetAttributes(p, (byte) 6, 0.0);
    }
}
