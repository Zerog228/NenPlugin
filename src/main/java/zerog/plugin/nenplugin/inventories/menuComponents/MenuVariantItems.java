package zerog.plugin.nenplugin.inventories.menuComponents;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import zerog.plugin.nenplugin.utils.MetaCreator;
import zerog.plugin.nenplugin.utils.PersistentData;

import static zerog.plugin.nenplugin.utils.MetaCreator.MetaCreator;

public class MenuVariantItems {
    public static void variantItems(Player p, Inventory inv) {
        int i = (int) PersistentData.getPlayerData(p, "class_number", PersistentDataType.INTEGER);
        int x = (int) PersistentData.getPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER);

        switch (i) {
            case 0 -> {
                ItemStack villager = MetaCreator.MetaCreator(Material.APPLE, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы обычный житель", "У вас пока нет класса", inv, (byte) 8);
            }
            case 1 -> {
                ItemStack bomber = MetaCreator.MetaCreator(Material.TNT, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы подрывник", "У вашего класса нет дальнейшей прокачки", inv, (byte) 8);
            }
            case 2 -> {
                ItemStack builder = MetaCreator.MetaCreator(Material.BRICK, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы строитель", "У вашего класса нет дальнейшей прокачки", inv, (byte) 8);
            }
            case 3 -> {
                ItemStack detective = MetaCreator.MetaCreator(Material.SPYGLASS, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы детектив", "У вашего класса нет дальнейшей прокачки", inv, (byte) 8);
            }
            case 4 -> {
                ItemStack paladin = MetaCreator.MetaCreator(Material.GOLD_INGOT, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы паладин", "На 20 уровне вы сможете улучшить свой класс", inv, (byte) 8);
            }
            case 5 -> {
                ItemStack parasite = MetaCreator.MetaCreator(Material.ROTTEN_FLESH, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы паразит", "На 20 уровне вы сможете улучшить свой класс", inv, (byte) 8);
            }
            case 6 -> {
                ItemStack politic = MetaCreator.MetaCreator(Material.PAPER, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы политик", "У вашего класса нет дальнейшей прокачки", inv, (byte) 8);
            }
            case 7 -> {
                ItemStack roller = MetaCreator.MetaCreator(Material.CONDUIT, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы роллер", "На 20 уровне вы сможете улучшить класс", inv, (byte) 8);
            }
            case 8 -> {
                ItemStack warrior = MetaCreator.MetaCreator(Material.IRON_HELMET, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы воин", "На 20 уровне вы сможете улучшить класс", inv, (byte) 8);
            }
            case 9 -> {
                ItemStack vampire = MetaCreator.MetaCreator(Material.RED_CANDLE, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы вампир", "На 20 уровне вы сможете улучшить свой класс", inv, (byte) 8);
            }
            case 10 -> {
                ItemStack werewolf = MetaCreator.MetaCreator(Material.GRAY_WOOL, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы оборотень", "У вас нет дальнейшей прокачки", inv, (byte) 8);
            }
            case 11 -> {
                ItemStack archer = MetaCreator.MetaCreator(Material.BOW, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы лучник", "На 20 уровне вы сможете улучшить свой класс", inv, (byte) 8);
            }
            case 12 -> {
                ItemStack mermaid = MetaCreator.MetaCreator(Material.PRISMARINE_SHARD, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы мерлин", "У вас нет дальнейшей прокачки", inv, (byte) 8);
            }
            case 13 -> {
                ItemStack lich = MetaCreator.MetaCreator(Material.SKELETON_SKULL, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы лич", "На 20 уровне вы сможете улучшить свой класс", inv, (byte) 8);
            }
            case 14 -> {
                ItemStack spider = MetaCreator.MetaCreator(Material.SPIDER_SPAWN_EGG, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы паук", "На 20 уровне вы сможете улучшить свой класс", inv, (byte) 8);
            }
            case 15 -> {
                ItemStack hellboy = MetaCreator.MetaCreator(Material.LAVA_BUCKET, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы хеллбой", "У вас нет дальнейшей прокачки", inv, (byte) 8);
            }
            case 16 -> {
                ItemStack assassin = MetaCreator.MetaCreator(Material.STONE_SWORD, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы ассассин", "У вас нет дальнейшей прокачки", inv, (byte) 8);
            }
            case 17 -> {
                ItemStack jesus = MetaCreator.MetaCreator(Material.ENCHANTED_GOLDEN_APPLE, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы Иисус", "У вас нет дальнейшей прокачки", inv, (byte) 8);
            }
            case 39 -> {
                ItemStack mazohist = MetaCreator.MetaCreator(Material.POINTED_DRIPSTONE, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы мазохист", "У вас нет дальнейшей прокачки?", inv, (byte) 8);
            }
            case 40 -> {
                ItemStack martyr = MetaCreator.MetaCreator(Material.GOLDEN_APPLE, (byte) 1, "Ваш класс", ChatColor.YELLOW, "Вы мученик", "У вас нет дальнейшей прокачки", inv, (byte) 8);
            }
        }
        switch(x){
            case 1 -> {ItemStack reroller = MetaCreator.MetaCreator(Material.BEACON, (byte) 1, "Подкласс и способности", ChatColor.YELLOW, "Вы рероллер", "Вы бросаете больше кубов за раз", inv, (byte) 17);}
            case 2 -> {ItemStack berserk = MetaCreator.MetaCreator(Material.DIAMOND_AXE, (byte) 1, "Подкласс и способности", ChatColor.YELLOW, "Вы берсерк", "Вы наносите больше урона", inv, (byte) 17);}
            case 3 -> {ItemStack ironclad = MetaCreator.MetaCreator(Material.DIAMOND_CHESTPLATE, (byte) 1, "Подкласс и способности", ChatColor.YELLOW, "Вы броненосец", "Вы получаете меньше урона", inv, (byte) 17);}
            case 4 -> {ItemStack sun_shield = MetaCreator.MetaCreator(Material.WATER_BUCKET, (byte) 1, "Подкласс и способности", ChatColor.YELLOW, "Вы солнцеупорны", "Вы больше не получаете урон от солнца", inv, (byte) 17);}
            case 5 -> {ItemStack vampirism2 = MetaCreator.MetaCreator(Material.RED_DYE, (byte) 1, "Подкласс и способности", ChatColor.YELLOW, "Вы супер-вампир", "Вампиризм работает в два раза лучше", inv, (byte) 17);}
            case 6 -> {ItemStack potion_res = MetaCreator.MetaCreator(Material.POTION, (byte) 1, "Подкласс и способности", ChatColor.YELLOW, "У вас устойчивость к зельям", "Теперь вы получаете и хорошие эффекты", inv, (byte) 17);}
            case 7 -> {ItemStack vampirism = MetaCreator.MetaCreator(Material.RED_DYE, (byte) 1, "Подкласс и способности", ChatColor.YELLOW, "У вас вампиризм", "Вы восстанавливаете хп нанося урон мобам", inv, (byte) 17);}
            case 8 -> {ItemStack rebirth = MetaCreator.MetaCreator(Material.ENCHANTED_GOLDEN_APPLE, (byte) 1, "Подкласс и способности", ChatColor.YELLOW, "Вы способны переродиться!", "Раз в 10 минут вы воскреснете из мёртвых", inv, (byte) 17);}
            case 9 -> {ItemStack water_step = MetaCreator.MetaCreator(Material.LIGHT_BLUE_STAINED_GLASS, (byte) 1, "Подкласс и способности", ChatColor.YELLOW, "Вы способны ходить по воде и лаве", "Теперь жидкости вам нипочём", inv, (byte) 17);}
            case 10 -> {ItemStack fire_res = MetaCreator.MetaCreator(Material.MAGMA_CREAM, (byte) 1, "Подкласс и способности", ChatColor.YELLOW, "У вас огнеупорность", "Вы не горите в огне и лаве", inv, (byte) 17);}
            case 11 -> {ItemStack climbing = MetaCreator.MetaCreator(Material.VINE, (byte) 1, "Подкласс и способности", ChatColor.YELLOW, "Вы цепкий как паук", "Вы можете лазить по стенам", inv, (byte) 17);}
            case 12 -> {ItemStack venom = MetaCreator.MetaCreator(Material.SPIDER_EYE, (byte) 1, "Подкласс и способности", ChatColor.YELLOW, "У вас есть Venom", "При нанесении удара есть шанс отравить цель", inv, (byte) 17);}
            case 13 -> {ItemStack reinforcement = MetaCreator.MetaCreator(Material.IRON_CHESTPLATE, (byte) 1, "Подкласс и способности", ChatColor.YELLOW, "У вас есть подкрепление", "При получении урона есть шанс призвать подкрепление", inv, (byte) 17);}
            case 14 -> {ItemStack bowstring = MetaCreator.MetaCreator(Material.STRING, (byte) 1, "Подкласс и способности", ChatColor.YELLOW, "У вас прочная тетива", "Ваши стрелы летят дальше и наночят больше урона", inv, (byte) 17);}
            case 15 -> {ItemStack multiply = MetaCreator.MetaCreator(Material.ARROW, (byte) 1, "Подкласс и способности", ChatColor.YELLOW, "Вам повезло", "У вас есть шанс 66% не потратить стрелу", inv, (byte) 17);}
        }

        String st = "";
        String st2 = "";

        if (p.hasPermission("nen.miner")) {
            st = "Вы шахтёр";
            st2 = "Копайте руду для получения опыта";
            ItemStack profession = MetaCreator.MetaCreator(Material.IRON_PICKAXE, (byte) 1, "Ваша профессия", ChatColor.YELLOW, st, st2, inv, (byte) 7);
        } else if (p.hasPermission("nen.butcher")) {
            st = "Вы мясник";
            st2 = "Убивайте мирных животных для получения опыта";
            ItemStack profession = MetaCreator.MetaCreator(Material.BEEF, (byte) 1, "Ваша профессия", ChatColor.YELLOW, st, st2, inv, (byte) 7);
        } else if (p.hasPermission("nen.farmer")) {
            st = "Вы фермер";
            st2 = "Выращивайте растения для получения опыта";
            ItemStack profession = MetaCreator.MetaCreator(Material.IRON_HOE, (byte) 1, "Ваша профессия", ChatColor.YELLOW, st, st2, inv, (byte) 7);
        }
    }
}
