package zerog.plugin.nenplugin.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import zerog.plugin.nenplugin.commands.classes.Martyr;
import zerog.plugin.nenplugin.commands.classes.Roller;

public class NenExp {

    public static void addExp(Player p, double amount){
        double exp = (double) PersistentData.getPlayerData(p, "nen_exp", PersistentDataType.DOUBLE);
        PersistentData.setPlayerData(p, "nen_exp", PersistentDataType.DOUBLE, exp+amount, "");
        p.sendActionBar(Component.newline().content(ChatColor.YELLOW+"Вы получили "+ChatColor.GREEN+amount+ChatColor.YELLOW+" опыта!"));
        levelCheck(p);
    }

    public static void addExp(Player p, double amount, boolean silent){
        double exp = (double) PersistentData.getPlayerData(p, "nen_exp", PersistentDataType.DOUBLE);
        PersistentData.setPlayerData(p, "nen_exp", PersistentDataType.DOUBLE, exp+amount, "");
        if(!silent) {
            p.sendActionBar(Component.newline().content(ChatColor.YELLOW + "Вы получили " + ChatColor.GREEN + amount + ChatColor.YELLOW + " опыта!"));
        }
        levelCheck(p);
    }

    public static void levelCheck(Player p){
        double exp = (double) PersistentData.getPlayerData(p, "nen_exp", PersistentDataType.DOUBLE);
        double points = (double) PersistentData.getPlayerData(p, "nen_upgrade_points", PersistentDataType.DOUBLE);
        if(PersistentData.checkPlayerData(p, "nen.max_level")){
            return;
        }
        int level = (int) PersistentData.getPlayerData(p, "nen_level", PersistentDataType.INTEGER);
        if(level >= 100){
            p.showTitle(Title.title(Component.newline().content(ChatColor.GREEN + "Поздравляю!"), Component.newline().content(ChatColor.YELLOW + "Вы достигли Максимального уровня!"), Title.DEFAULT_TIMES));
            PersistentData.setPlayerData(p, "nen.max_level", PersistentDataType.STRING, 0.0, "true");
        }
        int i = 0;
        while (exp>(level+3+i)*(level+i)){
            i++;
        }
        PersistentData.setPlayerData(p, "nen_level", PersistentDataType.INTEGER, i+level, "");
        PersistentData.setPlayerData(p, "nen_upgrade_points", PersistentDataType.DOUBLE, (double) i+points, "");
        if(i!=0){
            p.sendMessage(ChatColor.GREEN+"Вы получили "+ChatColor.RED+(level+i)+ChatColor.GREEN+" уровень!");
        }

        if(level >= 20 && p.hasPermission("nen.roller") && !p.hasPermission("nen.reroller")){
            Roller.setReRoller(p);
        }
        if(level >= 30 && p.hasPermission("nen.mazohist") && !p.hasPermission("nen.martyr")){
            Martyr.setMartyr(p);
        }
    }

    public static void removeLevels(Player p){
        PersistentData.setPlayerData(p, "nen_level", PersistentDataType.INTEGER, 1, "");
        PersistentData.setPlayerData(p, "nen_upgrade_points", PersistentDataType.DOUBLE, 0, "");
    }
}
