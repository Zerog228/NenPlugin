package zerog.plugin.nenplugin.inventories;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataType;
import zerog.plugin.nenplugin.NenPlugin;
import zerog.plugin.nenplugin.commands.*;
import zerog.plugin.nenplugin.commands.classes.Berserk;
import zerog.plugin.nenplugin.commands.classes.Ironclad;
import zerog.plugin.nenplugin.utils.ClassRoulette;
import zerog.plugin.nenplugin.utils.MazohistChoose;
import zerog.plugin.nenplugin.utils.PersistentData;

import java.util.Objects;

public class MenuInventory {

    public static void OpenMenu(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        Material item = Objects.requireNonNull(e.getCurrentItem()).getType();
        boolean b = true;

        int level = (int) PersistentData.getPlayerData(p, "nen_level", PersistentDataType.INTEGER);

        switch(item){
            case WRITABLE_BOOK -> {
                HelpCommand.openMenu(p);
                b = false;
            }
            case ENCHANTED_BOOK -> {
                RulesCommand.openMenu(p);
                b = false;
            }
            case EXPERIENCE_BOTTLE -> {
                StatsCommand.openStatsInv(p);
                b = false;
            }
            case IRON_SWORD -> {
                ClassesCommand.openMenu(p);
                b = false;
            }
            case IRON_AXE -> {
                if(!p.hasPermission("nen.ironclad") || !p.hasPermission("nen.berserk") && level>=20){
                    Berserk.setBerserk(p);
                }
            }
            case IRON_CHESTPLATE -> {
                if(!p.hasPermission("nen.ironclad") || !p.hasPermission("nen.berserk") && level>=20){
                    Ironclad.setIronclad(p);
                }
                if(p.hasPermission("nen.paladin") && !p.hasPermission("nen.reinforcement") && !p.hasPermission("nen.water_step")){
                    NenPlugin.addPermission(p.getUniqueId(), "nen.reinforcement");
                    PersistentData.setPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER, 13, "");
                }
            }
            case LIGHT_BLUE_STAINED_GLASS -> {
                if(p.hasPermission("nen.paladin") && !p.hasPermission("nen.reinforcement") && !p.hasPermission("nen.water_step")){
                    NenPlugin.addPermission(p.getUniqueId(), "nen.water_step");
                    PersistentData.setPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER, 9, "");
                }
            }
            case CHEST -> {
                PublicChestInventory.openPublicChest(p);
                b = false;
            }
            case POINTED_DRIPSTONE -> {
                if(!p.hasPermission("nen.mazohist")){
                    MazohistChoose.openMenu(p);
                    b = false;
                }
            }
            case IRON_PICKAXE -> {
                if(!p.hasPermission("nen.miner") && !p.hasPermission("nen.butcher") && !p.hasPermission("nen.miner")){
                    NenPlugin.addPermission(p.getUniqueId(), "nen.miner");
                }
            }
            case BEEF -> {
                if(!p.hasPermission("nen.miner") && !p.hasPermission("nen.butcher") && !p.hasPermission("nen.miner")){
                    NenPlugin.addPermission(p.getUniqueId(), "nen.butcher");
                }
            }
            case IRON_HOE -> {
                if (!p.hasPermission("nen.miner") && !p.hasPermission("nen.butcher") && !p.hasPermission("nen.miner")) {
                    NenPlugin.addPermission(p.getUniqueId(), "nen.farmer");
                }
            }
            case MAGENTA_GLAZED_TERRACOTTA -> {
                if(level >= 10 && p.hasPermission("nen.class_roll") && !p.hasPermission("nen.mazohist")){
                    ClassRoulette.ChooseClass(p);
                }
                else {p.sendMessage(ChatColor.RED+"Вы не можете это сделать");}
            }
            case RED_DYE -> {
                if(p.hasPermission("nen.vampire") && level >= 20 && !p.hasPermission("nen.vampirism2") && p.hasPermission("nen.sunburn")){
                    NenPlugin.addPermission(p.getUniqueId(), "nen.vampirism2");
                    PersistentData.setPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER, 5, "");
                }
                if(p.hasPermission("nen.parasite") && !p.hasPermission("nen.vampirism") && p.hasPermission("nen.potion_reverse") && level >= 20){
                    NenPlugin.addPermission(p.getUniqueId(), "nen.vampirism");
                    PersistentData.setPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER, 7, "");
                }
                if (p.hasPermission("nen.lich")  && p.hasPermission("nen.sunburn") && !p.hasPermission("nen.vampirism")){
                    NenPlugin.addPermission(p.getUniqueId(), "nen.vampirism");
                    PersistentData.setPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER, 7, "");
                }
                if (p.hasPermission("nen.spider")  && !p.hasPermission("nen.vampirism") && !p.hasPermission("nen.venom")){
                    NenPlugin.addPermission(p.getUniqueId(), "nen.vampirism");
                    PersistentData.setPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER, 7, "");
                }
            }
            case WATER_BUCKET -> {
                if(p.hasPermission("nen.vampire") && level >= 20 && !p.hasPermission("nen.vampirism2") && p.hasPermission("nen.sunburn")){
                    NenPlugin.removePermission(p.getUniqueId(), "nen.sunburn");
                    PersistentData.setPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER, 4, "");
                } else if (p.hasPermission("nen.lich")  && p.hasPermission("nen.sunburn") && !p.hasPermission("nen.vampirism")){
                    NenPlugin.removePermission(p.getUniqueId(), "nen.sunburn");
                    PersistentData.setPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER, 4, "");
                }
            }
            case SPIDER_EYE -> {
                if(p.hasPermission("nen.spider") && level >= 20 && !p.hasPermission("nen.vampirism") && !p.hasPermission("nen.venom")){
                    NenPlugin.addPermission(p.getUniqueId(), "nen.venom");
                    PersistentData.setPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER, 12, "");
                }
            }
            case POTION -> {
                if (p.hasPermission("nen.parasite") && level >= 20 && !p.hasPermission("nen.vampirism") && p.hasPermission("nen.potion_reverse")) {
                    NenPlugin.removePermission(p.getUniqueId(), "nen.potion_reverse");
                    PersistentData.setPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER, 6, "");
                }
            }
            case STRING -> {
                if (p.hasPermission("nen.archer") && level >= 20 && !p.hasPermission("nen.multiply") && !p.hasPermission("nen.bowstring")) {
                    NenPlugin.addPermission(p.getUniqueId(), "nen.bowstring");
                    PersistentData.setPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER, 14, "");
                }
            }
            case ARROW -> {
                if (p.hasPermission("nen.archer") && level >= 20 && !p.hasPermission("nen.multiply") && !p.hasPermission("nen.bowstring")) {
                    NenPlugin.addPermission(p.getUniqueId(), "nen.multiply");
                    PersistentData.setPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER, 15, "");
                }
            }

            case CRAFTING_TABLE -> {
                CraftsCommand.openMenu(p);
                b = false;
            }
        }


        if(b){
            MenuCommand.openMenu(p);
        }
    }
}
