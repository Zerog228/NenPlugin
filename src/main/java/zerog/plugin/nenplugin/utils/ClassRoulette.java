package zerog.plugin.nenplugin.utils;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import zerog.plugin.nenplugin.NenPlugin;
import zerog.plugin.nenplugin.commands.classes.*;

import java.util.Random;

public class ClassRoulette {
    public static void ChooseClass(Player p){
        Random rd = new Random();
        int i = rd.nextInt(17);
        switch (i){
            case 0 -> Bomber.setBomber(p);
            case 1 -> Builder.setBuilder(p);
            case 2 -> Detective.setDetective(p);
            case 3 -> Paladin.setPaladin(p);
            //case 4 -> Parasite.setParasite(p);
            case 5 -> Politic.setPolitic(p);
            case 6 -> Roller.setRoller(p);
            case 7 -> Warrior.setWarrior(p);
            case 8 -> Werewolf.setWerewolf(p);
            case 9 -> Vampire.setVampire(p);
            case 10 -> Archer.setArcher(p);
            case 11 -> Mermaid.setMermaid(p);
            case 12 -> Lich.setLich(p);
            case 13 -> Spider.setSpider(p);
            case 14 -> HellBoy.setHellBoy(p);
            case 15 -> Assassin.setAssassin(p);
            case 16 -> Jesus.setJesus(p);
        }
        World w = p.getWorld();
        Location l = p.getLocation();
        w.playSound(l, Sound.ENTITY_PLAYER_LEVELUP, 1.5F, 1.0F);
        NenPlugin.removePermission(p.getUniqueId(), "nen.class_roll");
    }
}
