package zerog.plugin.nenplugin.utils;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentMaps {

    public static void allPut(){
        UndeadPut();
        MobsWithExpPut();
        ButcherMobsPut();
        OresPut();
        vegetablesPut();
        CraftsVariantsPut();
    }

    public static List<EntityType> undead = new ArrayList<>();
    public static List<EntityType> exp_mobs = new ArrayList<>();
    public static List<EntityType> butcher_mobs = new ArrayList<>();
    public static List<Material> Ores = new ArrayList<>();
    public static List<Material> vegetables = new ArrayList<>();

    private static String [] decor_1 = new String [7];
    private static String [] decor_2 = new String [2];
    private static String [] decor_3 = new String [13];
    private static String [] decor_4 = new String [3];
    private static String [] decor_5 = new String [5];
    private static String [] decor_6 = new String [7];

    private static String [] redstone_1 = new String [4];
    private static String [] redstone_2 = new String [4];
    private static String [] redstone_3 = new String [4];
    private static String [] redstone_4 = new String [3];
    private static String [] redstone_5 = new String [4];
    private static String [] redstone_6 = new String [3];

    private static String [] smithing_1 = new String [8];
    private static String [] smithing_2 = new String [7];
    private static String [] smithing_3 = new String [6];
    private static String [] smithing_4 = new String [7];
    private static String [] smithing_5 = new String [7];
    private static String [] smithing_6 = new String [8];

    private static String [] carpentry_1 = new String [4];
    private static String [] carpentry_2 = new String [5];
    private static String [] carpentry_3 = new String [3];
    private static String [] carpentry_4 = new String [3];
    private static String [] carpentry_5 = new String [2];
    private static String [] carpentry_6 = new String [1];

    public static HashMap<Integer, String []> decor_map = new HashMap<>();
    public static HashMap<Integer, String []> redstone_map = new HashMap<>();
    public static HashMap<Integer, String []> smithing_map = new HashMap<>();
    public static HashMap<Integer, String []> carpentry_map = new HashMap<>();

    public static void UndeadPut(){
        undead.add(EntityType.ZOMBIE);
        undead.add(EntityType.ZOMBIE_HORSE);
        undead.add(EntityType.ZOMBIE_VILLAGER);
        undead.add(EntityType.ZOMBIFIED_PIGLIN);
        undead.add(EntityType.HUSK);
        undead.add(EntityType.DROWNED);
        undead.add(EntityType.GIANT);
        undead.add(EntityType.SKELETON);
        undead.add(EntityType.WITHER_SKELETON);
        undead.add(EntityType.SKELETON_HORSE);
        undead.add(EntityType.STRAY);
        undead.add(EntityType.WITHER);
        undead.add(EntityType.VEX);
    }

    public static void MobsWithExpPut(){
        exp_mobs.add(EntityType.ALLAY);
        exp_mobs.add(EntityType.AXOLOTL);
        exp_mobs.add(EntityType.BAT);
        exp_mobs.add(EntityType.ELDER_GUARDIAN);
        exp_mobs.add(EntityType.GLOW_SQUID);
        exp_mobs.add(EntityType.GHAST);
        exp_mobs.add(EntityType.PHANTOM);
        exp_mobs.add(EntityType.PILLAGER);
        exp_mobs.add(EntityType.RAVAGER);
        exp_mobs.add(EntityType.RABBIT);
        exp_mobs.add(EntityType.STRAY);
        exp_mobs.add(EntityType.VEX);
        exp_mobs.add(EntityType.VINDICATOR);
        exp_mobs.add(EntityType.VILLAGER);
        exp_mobs.add(EntityType.WITCH);
        exp_mobs.add(EntityType.WITHER);
        exp_mobs.add(EntityType.ZOMBIE_VILLAGER);
        exp_mobs.add(EntityType.WARDEN);
    }

    public static void ButcherMobsPut(){
        butcher_mobs.add(EntityType.COW);
        butcher_mobs.add(EntityType.SHEEP);
        butcher_mobs.add(EntityType.CHICKEN);
        butcher_mobs.add(EntityType.PIG);
        butcher_mobs.add(EntityType.HORSE);
    }

    public static void OresPut(){
        Ores.add(Material.COAL_ORE);
        Ores.add(Material.DEEPSLATE_COAL_ORE);
        Ores.add(Material.COPPER_ORE);
        Ores.add(Material.DEEPSLATE_COPPER_ORE);
        Ores.add(Material.IRON_ORE);
        Ores.add(Material.DEEPSLATE_IRON_ORE);
        Ores.add(Material.GOLD_ORE);
        Ores.add(Material.DEEPSLATE_GOLD_ORE);
        Ores.add(Material.DIAMOND_ORE);
        Ores.add(Material.DEEPSLATE_DIAMOND_ORE);
        Ores.add(Material.EMERALD_ORE);
        Ores.add(Material.DEEPSLATE_EMERALD_ORE);
        Ores.add(Material.REDSTONE_ORE);
        Ores.add(Material.DEEPSLATE_REDSTONE_ORE);
        Ores.add(Material.LAPIS_ORE);
        Ores.add(Material.DEEPSLATE_LAPIS_ORE);
    }

    public static void vegetablesPut(){
        vegetables.add(Material.CARROT);
        vegetables.add(Material.POTATO);
        vegetables.add(Material.BAKED_POTATO);
        vegetables.add(Material.GOLDEN_CARROT);
        vegetables.add(Material.APPLE);
        vegetables.add(Material.DRIED_KELP);
        vegetables.add(Material.SWEET_BERRIES);
        vegetables.add(Material.PUMPKIN_PIE);
        vegetables.add(Material.HONEY_BOTTLE);
        vegetables.add(Material.BEETROOT);
        vegetables.add(Material.BEETROOT_SOUP);
        vegetables.add(Material.GLOW_BERRIES);
        vegetables.add(Material.MUSHROOM_STEW);
        vegetables.add(Material.MELON_SLICE);
        vegetables.add(Material.COOKIE);
    }

    public static void CraftsVariantsPut(){
        decor_1 [0] = "ANDESITE";
        decor_1 [1] = "DIORITE";
        decor_1 [2] = "GRANITE";
        decor_1 [3] = "FURNACE";
        decor_1 [4] = "MOSSY_COBBLESTONE";
        decor_1 [5] = "COBBLESTONE_WALL";
        decor_1 [6] = "COBBLESTONE_STAIRS";

        decor_2 [0] = "BRICK";
        decor_2 [1] = "TORCH";

        decor_3 [0] = "LANTERN";
        decor_3 [1] = "BOOKSHELF";
        decor_3 [2] = "GLOWSTONE";
        decor_3 [3] = "POT";
        decor_3 [4] = "PAINTING";
        decor_3 [5] = "CANDLE";
        decor_3 [6] = "BANNER";
        decor_3 [7] = "CARPET";
        decor_3 [8] = "GLASS";
        decor_3 [9] = "FRAME";
        decor_3 [10] = "TERRACOTTA";
        decor_3 [11] = "CAMPFIRE";
        decor_3 [12] = "SMOKER";

        decor_4 [0] = "DEEPSLATE";
        decor_4 [1] = "CONCRETE";
        decor_4 [2] = "COPPER";

        decor_5 [0] = "END";
        decor_5 [1] = "NETHER";
        decor_5 [2] = "QUARTZ";
        decor_5 [3] = "PRISMARINE";
        decor_5 [4] = "BLACKSTONE";

        decor_6 [0] = "STONECUTTER";
        decor_6 [1] = "ENCHANTING_TABLE";
        decor_6 [2] = "ENDER_CHEST";
        decor_6 [3] = "LOOM";
        decor_6 [4] = "CARTOGRAPHY_TABLE";
        decor_6 [5] = "ARMOR_STAND";
        decor_6 [6] = "FLETCHING_TABLE";

        redstone_1 [0] = "REDSTONE_BLOCK";
        redstone_1 [1] = "TRIPWIRE_HOOK";
        redstone_1 [3] = "REDSTONE_LAMP";
        redstone_1 [2] = "REDSTONE_TORCH";

        redstone_2 [0] = "STONE_BUTTON";
        redstone_2 [1] = "IRON_DOOR";
        redstone_2 [2] = "IRON_TRAPDOOR";
        redstone_2 [3] = "TRAPPED_CHEST";

        redstone_3 [0] = "WEIGHTED_PRESSURE_PLATE";
        redstone_3 [1] = "MINECART";
        redstone_3 [2] = "LIGHTNING_ROD";
        redstone_3 [3] = "TARGET";

        redstone_4 [0] = "PISTON";
        redstone_4 [1] = "COMPARATOR";
        redstone_4 [2] = "NOTE_BLOCK";

        redstone_5 [0] = "DISPENSER";
        redstone_5 [1] = "DROPPER";
        redstone_5 [2] = "OBSERVER";
        redstone_5 [3] = "HOPPER";

        redstone_6 [0] = "ANCHOR";
        redstone_6 [1] = "DETECTOR";
        redstone_6 [2] = "LODESTONE";

        smithing_1 [0] = "STEEL";
        smithing_1 [1] = "IRON_P";
        smithing_1 [2] = "IRON_HOE";
        smithing_1 [3] = "IRON_SH";
        smithing_1 [4] = "IRON_A";
        smithing_1 [5] = "BOTTLE";
        smithing_1 [6] = "BUCKET";
        smithing_1 [7] = "SHEARS";

        smithing_2 [0] = "GRINDSTONE";
        smithing_2 [1] = "ANVIL";
        smithing_2 [2] = "CHAIN";
        smithing_2 [3] = "BARS";
        smithing_2 [4] = "BLAST";
        smithing_2 [5] = "SMITHING";
        smithing_2 [6] = "LEATHER";

        smithing_3 [0] = "CHAINMAIL";
        smithing_3 [1] = "TAG";
        smithing_3 [2] = "COMPASS";
        smithing_3 [3] = "SHIELD";
        smithing_3 [4] = "CLOCK";
        smithing_3 [5] = "EYE";

        smithing_4 [0] = "IRON_H";
        smithing_4 [1] = "IRON_C";
        smithing_4 [2] = "IRON_L";
        smithing_4 [3] = "IRON_BO";
        smithing_4 [4] = "IRON_SW";
        smithing_4 [5] = "IRON_HORSE";
        smithing_4 [6] = "CROSSBOW";

        smithing_5 [0] = "GOLDEN";
        smithing_5 [1] = "DIAMOND_S";
        smithing_5 [2] = "DIAMOND_H";
        smithing_5 [3] = "DIAMOND_P";
        smithing_5 [4] = "DIAMOND_A";
        smithing_5 [5] = "BEACON";
        smithing_5 [6] = "CONDUIT";

        smithing_6 [0] = "NETHERITE_BO";
        smithing_6 [1] = "NETHERITE_H";
        smithing_6 [2] = "NETHERITE_C";
        smithing_6 [3] = "NETHERITE_L";
        smithing_6 [4] = "NETHERITE_S";
        smithing_6 [5] = "NETHERITE_A";
        smithing_6 [6] = "NETHERITE_P";
        smithing_6 [7] = "RECOVERY";

        carpentry_1 [0] = "OAK_DOOR";
        carpentry_1 [1] = "OAK_FENCE";
        carpentry_1 [2] = "OAK_STAIRS";
        carpentry_1 [3] = "OAK_TRAPDOOR";

        carpentry_2 [0] = "ACACIA";
        carpentry_2 [1] = "JUNGLE";
        carpentry_2 [2] = "SPRUCE";
        carpentry_2 [3] = "BIRCH";
        carpentry_2 [4] = "MANGROVE";

        carpentry_3 [0] = "BEEHIVE";
        carpentry_3 [1] = "COMPOSTER";
        carpentry_3 [2] = "BARREL";

        carpentry_4 [0] = "RAIL";
        carpentry_4 [1] = "SCAFFOLDING";
        carpentry_4 [2] = "LADDER";

        carpentry_5 [0] = "CRIMSON";
        carpentry_5 [1] = "WARPED";

        carpentry_6 [0] = "ABRA_KADABRA";

        decor_map.put(0, decor_1);
        decor_map.put(1, decor_2);
        decor_map.put(2, decor_3);
        decor_map.put(3, decor_4);
        decor_map.put(4, decor_5);
        decor_map.put(5, decor_6);

        redstone_map.put(0, redstone_1);
        redstone_map.put(1, redstone_2);
        redstone_map.put(2, redstone_3);
        redstone_map.put(3, redstone_4);
        redstone_map.put(4, redstone_5);
        redstone_map.put(5, redstone_6);

        smithing_map.put(0, smithing_1);
        smithing_map.put(1, smithing_2);
        smithing_map.put(2, smithing_3);
        smithing_map.put(3, smithing_4);
        smithing_map.put(4, smithing_5);
        smithing_map.put(5, smithing_6);

        carpentry_map.put(0, carpentry_1);
        carpentry_map.put(1, carpentry_2);
        carpentry_map.put(2, carpentry_3);
        carpentry_map.put(3, carpentry_4);
        carpentry_map.put(4, carpentry_5);
        carpentry_map.put(5, carpentry_6);
    }
}
