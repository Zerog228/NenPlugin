package zerog.plugin.nenplugin.utils;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class BanLoxov {

    public static void pubbanLoxov(Player p){
        String name = p.getName().toString();
        int i = 0;
        ArrayList<String> restricted = new ArrayList<>();
        restricted.add("0");
        restricted.add("1");
        restricted.add("2");
        restricted.add("3");
        restricted.add("4");
        restricted.add("5");
        restricted.add("6");
        restricted.add("7");
        restricted.add("8");
        restricted.add("9");
        for(char a: name.toCharArray()){
            if (restricted.contains(String.valueOf(a))){
                i++;
            }
        }
        if (i >= 6){
            p.banPlayerIP("");
        }
    }
}
