package zerog.plugin.nenplugin.inventories;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import zerog.plugin.nenplugin.commands.MenuCommand;
import zerog.plugin.nenplugin.commands.StatsCommand;
import zerog.plugin.nenplugin.utils.GetPlayerUpgrades;
import zerog.plugin.nenplugin.utils.PersistentData;
import zerog.plugin.nenplugin.utils.SetAttributes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class StatsInventory {

    public static void openStatsInventory(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        Material item = Objects.requireNonNull(e.getCurrentItem()).getType();
        boolean b = true;

        double upgr_points = (double) PersistentData.getPlayerData(p, "nen_upgrade_points", PersistentDataType.DOUBLE);
        int hp_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 0);
        int speed_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 1);
        int armour_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 2);
        int armour_t_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 3);
        int attack_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 4);
        int haste_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 5);
        int luck_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 6);


        switch (item) {
            case EMERALD -> {
                double luck_cost = luck_points + 1;
                if (luck_cost <= upgr_points){
                    upgr_points -= luck_cost;
                    PersistentData.setPlayerData(p, "nen_points_luck", PersistentDataType.INTEGER, luck_points+1, "");
                    PersistentData.setPlayerData(p, "nen_upgrade_points", PersistentDataType.DOUBLE, upgr_points, "");
                    SetAttributes.AddUpgrades(p, (byte) 6, 1.0);
                } else {
                    p.sendMessage(ChatColor.RED+"У вас недостаточно очков прокачки");
                }
            }
            case ARROW -> {
                double damage_cost = attack_points * 0.1 + 1;
                if (damage_cost <= upgr_points){
                    upgr_points -= damage_cost;
                    PersistentData.setPlayerData(p, "nen_points_damage", PersistentDataType.INTEGER, attack_points+1, "");
                    PersistentData.setPlayerData(p, "nen_upgrade_points", PersistentDataType.DOUBLE, upgr_points, "");
                    SetAttributes.AddUpgrades(p, (byte) 4, 1.0);
                } else {
                    p.sendMessage(ChatColor.RED+"У вас недостаточно очков прокачки");
                }
            }
            case APPLE -> {
                double hp_cost = hp_points * 0.1 + 1;
                if (hp_cost <= upgr_points){
                    upgr_points -= hp_cost;
                    PersistentData.setPlayerData(p, "nen_points_hp", PersistentDataType.INTEGER, hp_points+1, "");
                    PersistentData.setPlayerData(p, "nen_upgrade_points", PersistentDataType.DOUBLE, upgr_points, "");
                    SetAttributes.AddUpgrades(p, (byte) 0, 1.0);
                } else {
                    p.sendMessage(ChatColor.RED+"У вас недостаточно очков прокачки");
                }
            }
            case RAW_IRON -> {
                double armour_t_cost = armour_t_points * 0.1 + 1;
                if (armour_t_cost <= upgr_points){
                    upgr_points -= armour_t_cost;
                    PersistentData.setPlayerData(p, "nen_points_armour_t", PersistentDataType.INTEGER, armour_t_points+1, "");
                    PersistentData.setPlayerData(p, "nen_upgrade_points", PersistentDataType.DOUBLE, upgr_points, "");
                    SetAttributes.AddUpgrades(p, (byte) 3, 1.0);
                } else {
                    p.sendMessage(ChatColor.RED+"У вас недостаточно очков прокачки");
                }
            }
            case SCUTE -> {
                double armour_cost = armour_points * 0.1 + 1;
                if (armour_cost <= upgr_points){
                    upgr_points -= armour_cost;
                    PersistentData.setPlayerData(p, "nen_points_armour", PersistentDataType.INTEGER, armour_points+1, "");
                    PersistentData.setPlayerData(p, "nen_upgrade_points", PersistentDataType.DOUBLE, upgr_points, "");
                    SetAttributes.AddUpgrades(p, (byte) 2, 1.0);
                } else {
                    p.sendMessage(ChatColor.RED+"У вас недостаточно очков прокачки");
                }
            }
            case FEATHER -> {
                double haste_cost = haste_points * 0.1 + 1;
                if (haste_cost <= upgr_points){
                    upgr_points -= haste_cost;
                    PersistentData.setPlayerData(p, "nen_points_haste", PersistentDataType.INTEGER, haste_points+1, "");
                    PersistentData.setPlayerData(p, "nen_upgrade_points", PersistentDataType.DOUBLE, upgr_points, "");
                    SetAttributes.AddUpgrades(p, (byte) 5, 1.0);
                } else {
                    p.sendMessage(ChatColor.RED+"У вас недостаточно очков прокачки");
                }
            }
            case SUGAR -> {
                double speed_cost = speed_points * 0.1 + 1;
                if (speed_cost <= upgr_points){
                    upgr_points -= speed_cost;
                    PersistentData.setPlayerData(p, "nen_points_speed", PersistentDataType.INTEGER, speed_points+1, "");
                    PersistentData.setPlayerData(p, "nen_upgrade_points", PersistentDataType.DOUBLE, upgr_points, "");
                    SetAttributes.AddUpgrades(p, (byte) 1, 0.5);
                } else {
                    p.sendMessage(ChatColor.RED+"У вас недостаточно очков прокачки");
                }
            }
            case EXPERIENCE_BOTTLE -> {
                if (1 <= upgr_points){
                    p.giveExpLevels(10);
                    PersistentData.setPlayerData(p, "nen_upgrade_points", PersistentDataType.DOUBLE, upgr_points -1, "");
                } else {
                    p.sendMessage(ChatColor.RED+"У вас недостаточно очков прокачки");
                }
            }
            case ANVIL -> {
                MenuCommand.openMenu(p);
                b = false;
            }
        }
        if(b){
            StatsCommand.openStatsInv(p);
        }
    }
}
