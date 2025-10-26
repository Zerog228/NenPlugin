package zerog.plugin.nenplugin.utils;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import zerog.plugin.nenplugin.NenPlugin;

import java.util.UUID;

public class PersistentData {

    public static boolean checkPlayerData(Player p, String data_name){
        boolean b = false;
        NamespacedKey key = new NamespacedKey(NenPlugin.getPlugin(), data_name);
        if (p.getPersistentDataContainer().has(key)) {
            b = true;
        }
        return b;
    }

    public static boolean checkEntityData(Entity entity, String data_name){
        boolean b = false;
        NamespacedKey key = new NamespacedKey(NenPlugin.getPlugin(), data_name);
        if (entity.getPersistentDataContainer().has(key)) {
            b = true;
        }
        return b;
    }

    public static void setPlayerData(Player p, String data_name, PersistentDataType datatype, double data_double, String data_string){
        PersistentDataContainer container = p.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(NenPlugin.getPlugin(), data_name);
        if(datatype.equals(PersistentDataType.INTEGER)){
            container.set(key, datatype, (int) data_double);
        }else if(datatype.equals(PersistentDataType.DOUBLE)){
            container.set(key, datatype, data_double);
        } else if(datatype.equals(PersistentDataType.STRING)){
            container.set(key, datatype, data_string);
        }
    }

    public static void setEntityData(Entity entity, String data_name, PersistentDataType datatype, double data_double, String data_string){
        PersistentDataContainer container = entity.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(NenPlugin.getPlugin(), data_name);
        if(datatype.equals(PersistentDataType.INTEGER)){
            container.set(key, datatype, (int) data_double);
        }else if(datatype.equals(PersistentDataType.DOUBLE)){
            container.set(key, datatype, data_double);
        } else if(datatype.equals(PersistentDataType.STRING)){
            container.set(key, datatype, data_string);
        }
    }

    public static Object getPlayerData(Player p, String data_name, PersistentDataType datatype){
        PersistentDataContainer container = p.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(NenPlugin.getPlugin(), data_name);
        return container.get(key, datatype);
    }

    public static Object getEntityData(Entity entity, String data_name, PersistentDataType datatype){
        PersistentDataContainer container = entity.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(NenPlugin.getPlugin(), data_name);
        return container.get(key, datatype);
    }


    public static void removePlayerData(Player p, String data_name){
        PersistentDataContainer container = p.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(NenPlugin.getPlugin(), data_name);
        container.remove(key);
    }

    public static void removeEntityData(Entity entity, String data_name){
        PersistentDataContainer container = entity.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(NenPlugin.getPlugin(), data_name);
        container.remove(key);
    }
}
