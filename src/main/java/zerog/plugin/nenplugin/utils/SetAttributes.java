package zerog.plugin.nenplugin.utils;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.javatuples.Triplet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SetAttributes {

    private static final Map<Byte, Triplet<Attribute, Double, Double>> byteToAttribute = new HashMap<>();

    static Triplet<Attribute, Double, Double> health = new Triplet<>(Attribute.GENERIC_MAX_HEALTH, 20.0, 0.5);
    static Triplet<Attribute, Double, Double> speed = new Triplet<>(Attribute.GENERIC_MOVEMENT_SPEED, 0.1, 0.006);
    static Triplet<Attribute, Double, Double> armor = new Triplet<>(Attribute.GENERIC_ARMOR, 0.0, 0.15);
    static Triplet<Attribute, Double, Double> armor_t = new Triplet<>(Attribute.GENERIC_ARMOR_TOUGHNESS, 0.0, 0.5);
    static Triplet<Attribute, Double, Double> damage = new Triplet<>(Attribute.GENERIC_ATTACK_DAMAGE, 1.0, 0.1);
    static Triplet<Attribute, Double, Double> haste = new Triplet<>(Attribute.GENERIC_ATTACK_SPEED, 4.0, 0.01);
    static Triplet<Attribute, Double, Double> luck = new Triplet<>(Attribute.GENERIC_LUCK, 0.0, 0.1);
    static Triplet<Attribute, Double, Double> knock_res = new Triplet<>(Attribute.GENERIC_KNOCKBACK_RESISTANCE, 0.0, 0.1);

    public static void putter(){
        byteToAttribute.put((byte) 0, health);
        byteToAttribute.put((byte) 1, speed);
        byteToAttribute.put((byte) 2, armor);
        byteToAttribute.put((byte) 3, armor_t);
        byteToAttribute.put((byte) 4, damage);
        byteToAttribute.put((byte) 5, haste);
        byteToAttribute.put((byte) 6, luck);
        byteToAttribute.put((byte) 7, knock_res);
    }

    public static Double luck (Player p){
        double base_value = 0;
        if(PersistentData.checkPlayerData(p, "data6")){
            base_value = (Double) PersistentData.getPlayerData(p, "data6", PersistentDataType.DOUBLE);
        }
        Integer upgr_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 6);
        return base_value+upgr_points*0.1;
    }

    public static Double multiplier (Triplet<Attribute, Double, Double> data){
        return data.getValue2();
    }

    public static void SetStandardAttributes(Player p){
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(20);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).setBaseValue(0.1);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ARMOR)).setBaseValue(0);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS)).setBaseValue(0);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)).setBaseValue(1);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ATTACK_SPEED)).setBaseValue(4);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_LUCK)).setBaseValue(0);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE)).setBaseValue(0);
    }

    public static void setRollerAttributes(Player p){
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(20 + luck(p) * 1 + (int) PersistentData.getPlayerData(p, "nen_points_hp", PersistentDataType.INTEGER) * luck(p));
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).setBaseValue(0.1 + luck(p) * 0.003 + (int) PersistentData.getPlayerData(p, "nen_points_speed", PersistentDataType.INTEGER)  * luck(p));
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ARMOR)).setBaseValue(0 + luck(p) * 0.1 + (int) PersistentData.getPlayerData(p, "nen_points_armour", PersistentDataType.INTEGER)  * luck(p));
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS)).setBaseValue(0 + luck(p) * 0.1 + (int) PersistentData.getPlayerData(p, "nen_points_armour_t", PersistentDataType.INTEGER)  * luck(p));
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)).setBaseValue(1 + luck(p) * 0.1 + (int) PersistentData.getPlayerData(p, "nen_points_damage", PersistentDataType.INTEGER)  * luck(p));
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ATTACK_SPEED)).setBaseValue(4 + luck(p) * 0.05 + (int) PersistentData.getPlayerData(p, "nen_points_haste", PersistentDataType.INTEGER)  * luck(p));
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_LUCK)).setBaseValue((Double) PersistentData.getPlayerData(p, "nen_points_luck", PersistentDataType.INTEGER));
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE)).setBaseValue(0);
    }

    public static void removeAttributes(Player p){
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(20);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).setBaseValue(0.1);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ARMOR)).setBaseValue(0);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS)).setBaseValue(0);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)).setBaseValue(1);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ATTACK_SPEED)).setBaseValue(4);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_LUCK)).setBaseValue(0);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE)).setBaseValue(0);
    }

    public static void AddAttributes(Player p, Byte attribute_number, Double value){
        Double base_value = (Double) PersistentData.getPlayerData(p, "data"+attribute_number, PersistentDataType.DOUBLE);
        Integer upgr_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 6);
        Triplet<Attribute, Double, Double> at_do = byteToAttribute.get(attribute_number);
        Attribute attr = at_do.getValue0();

        if(attribute_number !=6) {
            Objects.requireNonNull(p.getAttribute(attr))
                    .setBaseValue(base_value + value * multiplier(at_do) + luck(p) * multiplier(at_do) + upgr_points * multiplier(at_do) + luck(p) * upgr_points * multiplier(at_do));
        } else {
            Objects.requireNonNull(p.getAttribute(attr))
                    .setBaseValue(base_value + upgr_points * multiplier(at_do) + value * multiplier(at_do));
        }

    }

    public static void SetAttributes(Player p, Byte attribute_number, Double value){

        Double base_value = (Double) PersistentData.getPlayerData(p, "data"+attribute_number, PersistentDataType.DOUBLE);

        Triplet<Attribute, Double, Double> at_do = byteToAttribute.get(attribute_number);
        Attribute attr = at_do.getValue0();
        Integer upgr_points = GetPlayerUpgrades.getUpgrades(p).get(attribute_number);

        if(attribute_number !=6) {
            Objects.requireNonNull(p.getAttribute(attr)).setBaseValue(base_value + upgr_points * multiplier(at_do) + luck(p) * multiplier(at_do) + upgr_points * luck(p) * multiplier(at_do));
        } else {
            Objects.requireNonNull(p.getAttribute(attr)).setBaseValue(base_value + upgr_points * multiplier(at_do));
        }
    }

    public static void ParasiteDeathAttributes(Player p, Byte attribute_number){
        Double base_value = (Double) PersistentData.getPlayerData(p, "data"+attribute_number, PersistentDataType.DOUBLE);

        Triplet<Attribute, Double, Double> at_do = byteToAttribute.get(attribute_number);
        Attribute attr = at_do.getValue0();
        Integer upgr_points = GetPlayerUpgrades.getUpgrades(p).get(attribute_number);

        switch (attribute_number){
            case 0 -> Objects.requireNonNull(p.getAttribute(attr)).setBaseValue(((base_value + 12 - luck(p) * multiplier(at_do)) /2 + upgr_points * multiplier(at_do) + luck(p) * multiplier(at_do)));
            case 1 -> Objects.requireNonNull(p.getAttribute(attr)).setBaseValue(((base_value + 0.06 - luck(p) * multiplier(at_do)) /2 + upgr_points * multiplier(at_do) + luck(p) * multiplier(at_do)));
            case 2, 3 -> Objects.requireNonNull(p.getAttribute(attr)).setBaseValue(((base_value -3 - luck(p) * multiplier(at_do)) /2 + upgr_points * multiplier(at_do) + luck(p) * multiplier(at_do)));
            case 4 -> Objects.requireNonNull(p.getAttribute(attr)).setBaseValue(((base_value -1 - luck(p) * multiplier(at_do)) /2 + upgr_points * multiplier(at_do) + luck(p) * multiplier(at_do)));
            case 5 -> Objects.requireNonNull(p.getAttribute(attr)).setBaseValue(((base_value + 3.5 - luck(p) * multiplier(at_do)) /2 + upgr_points * multiplier(at_do) + luck(p) * multiplier(at_do)));
            case 6 -> Objects.requireNonNull(p.getAttribute(attr)).setBaseValue((base_value - 0.1));
        }
    }

    public static void AddUpgrades(Player p, Byte attribute_number, Double value){
        Double base_value = (Double) PersistentData.getPlayerData(p, "data"+attribute_number, PersistentDataType.DOUBLE);
        Integer upgr_points = GetPlayerUpgrades.getUpgrades(p).get(attribute_number);
        Triplet<Attribute, Double, Double> at_do = byteToAttribute.get(attribute_number);
        Attribute attr = at_do.getValue0();

        if(attribute_number != 6) {
            Objects.requireNonNull(p.getAttribute(attr)).setBaseValue(base_value + value * multiplier(at_do) + luck(p) * multiplier(at_do) + upgr_points * multiplier(at_do) + luck(p) * upgr_points * multiplier(at_do));
        } else {
            Objects.requireNonNull(p.getAttribute(attr)).setBaseValue(base_value + value * multiplier(at_do) + upgr_points * multiplier(at_do));
        }
    }
}