package zerog.plugin.nenplugin.inventories.menuComponents;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import zerog.plugin.nenplugin.utils.MetaCreator;
import zerog.plugin.nenplugin.utils.PersistentData;

public class MenuChooseItems {
    public static void chooseItems(Player p, Inventory inv){
        int i = (int) PersistentData.getPlayerData(p, "class_number", PersistentDataType.INTEGER);
        int level = (int) PersistentData.getPlayerData(p, "nen_level", PersistentDataType.INTEGER);

        if(!p.hasPermission("nen.mazohist")){
            ItemStack dripstone = MetaCreator.MetaCreator(Material.POINTED_DRIPSTONE, (byte) 1, "Стать мазохистом", ChatColor.RED, "Вы больше не сможете поменять класс", "Этот выбор раз и навсегда", inv, (byte) 35);
        } else {
            ItemStack dripstone = MetaCreator.MetaCreator(Material.POINTED_DRIPSTONE, (byte) 1, "Вы мазохист", ChatColor.RED, "Вы больше не сможете поменять класс", "Вы сами это выбрали", inv, (byte) 35);
        }

        if (i==0){
            ItemStack roulette = MetaCreator.MetaCreator(Material.MAGENTA_GLAZED_TERRACOTTA, (byte) 1, "Выбрать класс", ChatColor.GOLD, "Доступно на 10 уровне", "При нажатии вам будет выдан случайный класс", inv, (byte) 31);
        }
        if (p.hasPermission("nen.warrior") && level >= 20 && !p.hasPermission("nen.ironclad") && !p.hasPermission("nen.berserk")){
            ItemStack berserk = MetaCreator.MetaCreator(Material.IRON_AXE, (byte) 1, "Стать берсерком", ChatColor.YELLOW, "У вас достаточно уровня", "чтобы стать берсерком", inv, (byte) 30);
            ItemStack ironclad = MetaCreator.MetaCreator(Material.IRON_CHESTPLATE, (byte) 1, "Стать броненосцем", ChatColor.YELLOW, "У вас достаточно уровня", "чтобы стать броненосцем", inv, (byte) 32);
        }
        if (p.hasPermission("nen.vampire") && level >= 20 && p.hasPermission("nen.sunburn") && !p.hasPermission("nen.vampirism2")){
            ItemStack sunburn = MetaCreator.MetaCreator(Material.WATER_BUCKET, (byte) 1, "Стать солнцеупорным", ChatColor.YELLOW, "Вы больше не будете получать", "урон от солнца", inv, (byte) 30);
            ItemStack vampirism2 = MetaCreator.MetaCreator(Material.RED_DYE, (byte) 1, "Стать супер-вампиром", ChatColor.YELLOW, "Восстановление хп от вампиризма", "будет сильно увеличено", inv, (byte) 32);
        }

        if(!p.hasPermission("nen.miner") && !p.hasPermission("nen.butcher") && !p.hasPermission("nen.farmer")){
            ItemStack pickaxe = MetaCreator.MetaCreator(Material.IRON_PICKAXE, (byte) 1, "Шахтёр", ChatColor.YELLOW, "Стать шахтёром", "Выбрать профессию можно только 1 раз!", inv, (byte) 30);
            ItemStack meat = MetaCreator.MetaCreator(Material.BEEF, (byte) 1, "Мясник", ChatColor.YELLOW, "Стать мясником", "Выбрать профессию можно только 1 раз!", inv, (byte) 31);
            ItemStack hoe = MetaCreator.MetaCreator(Material.IRON_HOE, (byte) 1, "Фермер", ChatColor.YELLOW, "Стать фермером", "Выбрать профессию можно только 1 раз!", inv, (byte) 32);
        }

        if(p.hasPermission("nen.parasite") && !p.hasPermission("nen.vampirism") && p.hasPermission("nen.potion_reverse") && level >= 20){
            ItemStack potion_res = MetaCreator.MetaCreator(Material.POTION, (byte) 1, "Устойчивость к зельям", ChatColor.YELLOW, "Вы больше не будете получать", "негативные эффекты от хороших зелий", inv, (byte) 30);
            ItemStack vampirism = MetaCreator.MetaCreator(Material.RED_DYE, (byte) 1, "Получить вампиризм", ChatColor.YELLOW, "Вы будете восстанавливать хп", "нанося урон мобам", inv, (byte) 32);
        }

        if(p.hasPermission("nen.archer") && !p.hasPermission("nen.bowstring") && !p.hasPermission("nen.multiply") && level >= 20){
            ItemStack bowstring = MetaCreator.MetaCreator(Material.STRING, (byte) 1, "Усиленная тетива", ChatColor.YELLOW, "Ваши стрелы будут лететь дальше", "и наносить больше урона", inv, (byte) 30);
            ItemStack multiply = MetaCreator.MetaCreator(Material.ARROW, (byte) 1, "Сохранение стрел", ChatColor.YELLOW, "Теперь у вас будет шанс", "66% не потратить стрелу", inv, (byte) 32);
        }
        if(p.hasPermission("nen.lich") && !p.hasPermission("nen.vampirism") && p.hasPermission("nen.sunburn") && level >= 20){
            ItemStack sunburn = MetaCreator.MetaCreator(Material.WATER_BUCKET, (byte) 1, "Солнцеупорность", ChatColor.YELLOW, "Вы больше не будете получать", "урон от солнца", inv, (byte) 30);
            ItemStack vampirism = MetaCreator.MetaCreator(Material.RED_DYE, (byte) 1, "Получить вампиризм", ChatColor.YELLOW, "Вы будете восстанавливать хп", "нанося урон мобам", inv, (byte) 32);
        }
        if(p.hasPermission("nen.spider") && !p.hasPermission("nen.venom") && !p.hasPermission("nen.vampirism") && level >= 20){
            ItemStack venom = MetaCreator.MetaCreator(Material.SPIDER_EYE, (byte) 1, "Получить яд", ChatColor.YELLOW, "Вы будете накладывать отравление", "нанося урон мобам", inv, (byte) 30);
            ItemStack vampirism = MetaCreator.MetaCreator(Material.RED_DYE, (byte) 1, "Получить вампиризм", ChatColor.YELLOW, "Вы будете восстанавливать хп", "нанося урон мобам", inv, (byte) 32);
        }
        if(p.hasPermission("nen.paladin") && !p.hasPermission("nen.reinforcement") && !p.hasPermission("nen.water_step") && level >= 20){
            ItemStack reinforcement = MetaCreator.MetaCreator(Material.IRON_CHESTPLATE, (byte) 1, "Получить подкрепление", ChatColor.YELLOW, "При получении урона", "вы мызовете подкрепление", inv, (byte) 30);
            ItemStack water_step = MetaCreator.MetaCreator(Material.LIGHT_BLUE_STAINED_GLASS, (byte) 1, "Ходьба по жидкостям", ChatColor.YELLOW, "Вы сможете ходить", "по воде и лаве", inv, (byte) 32);
        }
    }
}
