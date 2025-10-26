package zerog.plugin.nenplugin.inventories.craftsMenuComponents;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import zerog.plugin.nenplugin.utils.MetaCreator;
import zerog.plugin.nenplugin.utils.PersistentData;

import java.text.DecimalFormat;

import static zerog.plugin.nenplugin.utils.MetaCreator.MetaCreator;

public class CraftsVariant {

    public static void variantItems(Player p, Inventory inv){

        int block_points = (int) PersistentData.getPlayerData(p, "nen_blocks_decor_upgrades", PersistentDataType.INTEGER);
        int redstone_points = (int) PersistentData.getPlayerData(p, "nen_redstone_upgrades", PersistentDataType.INTEGER);
        int smithing_points = (int) PersistentData.getPlayerData(p, "nen_smithing_upgrades", PersistentDataType.INTEGER);
        int carpenter_points = (int) PersistentData.getPlayerData(p, "nen_carpentry_upgrades", PersistentDataType.INTEGER);
        int jewerly_points = (int) PersistentData.getPlayerData(p, "nen_jewelry_upgrades", PersistentDataType.INTEGER);

        DecimalFormat format = new DecimalFormat("0.#");


        ItemStack brick = MetaCreator.MetaCreator(Material.BRICKS, (byte) 1, "Блоки и декор", ChatColor.YELLOW, "Ваш уровень: "+ block_points, "Стоимость улучшения: "+(Math.pow(2, block_points)), inv, (byte) 0);
        ItemStack redstone = MetaCreator.MetaCreator(Material.REDSTONE_LAMP, (byte) 1, "Механизмы", ChatColor.YELLOW, "Ваш уровень: "+ redstone_points, "Стоимость улучшения: "+(Math.pow(2, redstone_points)), inv, (byte) 2);
        ItemStack pickaxe = MetaCreator.MetaCreator(Material.IRON_PICKAXE, (byte) 1, "Кузнечное дело", ChatColor.YELLOW, "Ваш уровень: "+ smithing_points, "Стоимость улучшения: "+(Math.pow(2, smithing_points)), inv, (byte) 4);
        ItemStack axe = MetaCreator.MetaCreator(Material.IRON_AXE, (byte) 1, "Плотничество", ChatColor.YELLOW, "Ваш уровень: " + carpenter_points, "Стоимость улучшения: " + (Math.pow(2, carpenter_points)), inv, (byte) 6);
        ItemStack diamond = MetaCreator.MetaCreator(Material.DIAMOND, (byte) 1, "Кладоискательство", ChatColor.YELLOW, "Ваш уровень: " + jewerly_points, "Стоимость улучшения: " + (Math.pow(2, jewerly_points)), inv, (byte) 8);

        if(carpenter_points > 0 && carpenter_points <= 4) {
            ItemStack axe1 = MetaCreator.MetaCreator(Material.IRON_AXE, (byte) carpenter_points, "Плотничество", ChatColor.YELLOW, "Ваш уровень: " + carpenter_points, "Стоимость улучшения: " + (Math.pow(2, carpenter_points)), inv, (byte) 6);
        } else if (carpenter_points == 5){
            ItemStack axe1 = MetaCreator.MetaCreator(Material.IRON_AXE, (byte) 5, "Плотничество", ChatColor.GREEN, "Ваш уровень: " + carpenter_points, "Вы достигли максимального уровня", inv, (byte) 6);
        }

        if(jewerly_points > 0 && jewerly_points <= 5) {
            ItemStack diamond1 = MetaCreator.MetaCreator(Material.DIAMOND, (byte) jewerly_points, "Ювелирное дело", ChatColor.YELLOW, "Ваш уровень: " + jewerly_points, "Стоимость улучшения: " + (Math.pow(2, jewerly_points)), inv, (byte) 8);
        } else if (jewerly_points == 6){
            ItemStack diamond1 = MetaCreator.MetaCreator(Material.DIAMOND, (byte) 6, "Ювелирное дело", ChatColor.GREEN, "Ваш уровень: " + jewerly_points, "Вы достигли максимального уровня", inv, (byte) 8);
        }

        if(smithing_points > 0 && smithing_points <= 5) {
            ItemStack pickaxe1 = MetaCreator.MetaCreator(Material.IRON_PICKAXE, (byte) smithing_points, "Кузнечное дело", ChatColor.YELLOW, "Ваш уровень: "+ smithing_points, "Стоимость улучшения: "+(Math.pow(2, smithing_points)), inv, (byte) 4);
        } else if (smithing_points == 6){
            ItemStack pickaxe1 = MetaCreator.MetaCreator(Material.IRON_PICKAXE, (byte) 6, "Кузнечное дело", ChatColor.GREEN, "Ваш уровень: "+ smithing_points, "Вы достигли максимального уровня", inv, (byte) 4);
        }

        if(redstone_points > 0 && redstone_points <= 5) {
            ItemStack redstone1 = MetaCreator.MetaCreator(Material.REDSTONE_LAMP, (byte) redstone_points, "Механизмы", ChatColor.YELLOW, "Ваш уровень: "+ redstone_points, "Стоимость улучшения: "+(Math.pow(2, redstone_points)), inv, (byte) 2);
        } else if (redstone_points == 6){
            ItemStack redstone1 = MetaCreator.MetaCreator(Material.REDSTONE_LAMP, (byte) 6, "Механизмы", ChatColor.GREEN, "Ваш уровень: "+ redstone_points, "Вы достигли максимального уровня", inv, (byte) 2);
        }

        if(block_points > 0 && block_points <= 5) {
            ItemStack brick1 = MetaCreator.MetaCreator(Material.BRICKS, (byte) block_points, "Блоки и декор", ChatColor.YELLOW, "Ваш уровень: "+ block_points, "Стоимость улучшения: "+(Math.pow(2, block_points)), inv, (byte) 0);
        } else if (block_points == 6){
            ItemStack brick1 = MetaCreator.MetaCreator(Material.BRICKS, (byte) 6, "Блоки и декор", ChatColor.GREEN, "Ваш уровень: "+ block_points, "Вы достигли максимального уровня", inv, (byte) 0);
        }

        switch (block_points){
            case 0 -> {
                ItemStack cobb_slab = MetaCreator.MetaCreator(Material.COBBLESTONE_SLAB, (byte) 1, "Булыжниковые блоки");
                ItemStack furnace = MetaCreator.MetaCreator(Material.FURNACE, (byte) 1, "Печь");
                ItemStack andesite = MetaCreator.MetaCreator(Material.ANDESITE_WALL, (byte) 1, "Блоки из цветного камня");
                inv.setItem(18, cobb_slab);
                inv.setItem(27, furnace);
                inv.setItem(36, andesite);
            }
            case 1 -> {
                ItemStack stone_slab = MetaCreator.MetaCreator(Material.STONE_SLAB, (byte) 1, "Каменные блоки");
                ItemStack brick_stairs = MetaCreator.MetaCreator(Material.BRICK_STAIRS, (byte) 1, "Различные кирпичи");
                ItemStack mud_bricks = MetaCreator.MetaCreator(Material.MUD_BRICKS, (byte) 1, "Блоки из Грязи");
                inv.setItem(18, stone_slab);
                inv.setItem(27, brick_stairs);
                inv.setItem(36, mud_bricks);
            }
            case 2 -> {
                ItemStack glass = MetaCreator.MetaCreator(Material.ORANGE_STAINED_GLASS, (byte) 1, "Разноцветные блоки");
                ItemStack torch = MetaCreator.MetaCreator(Material.TORCH, (byte) 1, "Осветительные блоки");
                ItemStack painting = MetaCreator.MetaCreator(Material.PAINTING, (byte) 1, "Картины, рамки, книжные полки");
                inv.setItem(18, glass);
                inv.setItem(27, torch);
                inv.setItem(36, painting);
            }
            case 3 -> {
                ItemStack cop_stairs = MetaCreator.MetaCreator(Material.CUT_COPPER_STAIRS, (byte) 1, "Медные блоки");
                ItemStack deepslate = MetaCreator.MetaCreator(Material.DEEPSLATE_TILE_WALL, (byte) 1, "Глубинокаменные блоки");
                ItemStack concrete = MetaCreator.MetaCreator(Material.BLACK_CONCRETE_POWDER, (byte) 1, "Цемент");
                inv.setItem(18, cop_stairs);
                inv.setItem(27, deepslate);
                inv.setItem(36, concrete);
            }
            case 4 -> {
                ItemStack end_stairs = MetaCreator.MetaCreator(Material.END_STONE_BRICK_STAIRS, (byte) 1, "Блоки энда");
                ItemStack nether_fence = MetaCreator.MetaCreator(Material.NETHER_BRICK_FENCE, (byte) 1, "Адские блоки");
                ItemStack prismarine_slab = MetaCreator.MetaCreator(Material.PRISMARINE_SLAB, (byte) 1, "Призмариновые блоки");
                inv.setItem(18, end_stairs);
                inv.setItem(27, nether_fence);
                inv.setItem(36, prismarine_slab);
            }
            case 5 -> {
                ItemStack loom = MetaCreator.MetaCreator(Material.LOOM, (byte) 1, "Блоки профессий");
                ItemStack armor_stand = MetaCreator.MetaCreator(Material.ARMOR_STAND, (byte) 1, "Стойка для брони");
                ItemStack ench_table = MetaCreator.MetaCreator(Material.ENCHANTING_TABLE, (byte) 1, "Стол зачарований и сундук края");
                inv.setItem(18, loom);
                inv.setItem(27, armor_stand);
                inv.setItem(36, ench_table);
            }
        }
        switch (redstone_points){
            case 0 -> {
                ItemStack r_block = MetaCreator.MetaCreator(Material.REDSTONE_BLOCK, (byte) 1, "Блок редстоуна");
                ItemStack hook = MetaCreator.MetaCreator(Material.TRIPWIRE_HOOK, (byte) 1, "Крюк и лампа");
                ItemStack torch = MetaCreator.MetaCreator(Material.REDSTONE_TORCH, (byte) 1, "Красный факел");
                inv.setItem(20, r_block);
                inv.setItem(29, hook);
                inv.setItem(38, torch);
            }
            case 1 -> {
                ItemStack chest = MetaCreator.MetaCreator(Material.TRAPPED_CHEST, (byte) 1, "Сундук-ловушка и кнопка");
                ItemStack repeater = MetaCreator.MetaCreator(Material.REPEATER, (byte) 1, "Повторитель");
                ItemStack iron_door = MetaCreator.MetaCreator(Material.IRON_DOOR, (byte) 1, "Железная дверь и люк");
                inv.setItem(20, chest);
                inv.setItem(29, repeater);
                inv.setItem(38, iron_door);
            }
            case 2 -> {
                ItemStack minecart = MetaCreator.MetaCreator(Material.MINECART, (byte) 1, "Вагонетки");
                ItemStack target = MetaCreator.MetaCreator(Material.TARGET, (byte) 1, "Мишень и нажимные плиты");
                ItemStack l_rod = MetaCreator.MetaCreator(Material.LIGHTNING_ROD, (byte) 1, "Громоотвод");
                inv.setItem(20, minecart);
                inv.setItem(29, target);
                inv.setItem(38, l_rod);
            }
            case 3 -> {
                ItemStack piston = MetaCreator.MetaCreator(Material.PISTON, (byte) 1, "Поршни и блоки слизи");
                ItemStack n_block = MetaCreator.MetaCreator(Material.NOTE_BLOCK, (byte) 1, "Нотные блоки");
                ItemStack comparator = MetaCreator.MetaCreator(Material.COMPARATOR, (byte) 1, "Компаратор");
                inv.setItem(20, piston);
                inv.setItem(29, n_block);
                inv.setItem(38, comparator);
            }
            case 4 -> {
                ItemStack hopper = MetaCreator.MetaCreator(Material.HOPPER, (byte) 1, "Воронка");
                ItemStack observer = MetaCreator.MetaCreator(Material.OBSERVER, (byte) 1, "Наблюдатель");
                ItemStack dispenser = MetaCreator.MetaCreator(Material.DISPENSER, (byte) 1, "Раздатчик и выбрасыватель");
                inv.setItem(20, hopper);
                inv.setItem(29, observer);
                inv.setItem(38, dispenser);
            }
            case 5 -> {
                ItemStack lodestone = MetaCreator.MetaCreator(Material.LODESTONE, (byte) 1, "Магнетит");
                ItemStack anchoir = MetaCreator.MetaCreator(Material.RESPAWN_ANCHOR, (byte) 1, "Якорь возрождения");
                ItemStack sensor = MetaCreator.MetaCreator(Material.DAYLIGHT_DETECTOR, (byte) 1, "Датчик дневного света");
                inv.setItem(20, lodestone);
                inv.setItem(29, anchoir);
                inv.setItem(38, sensor);
            }
        }
        switch (smithing_points){
            case 0 -> {
                ItemStack flint = MetaCreator.MetaCreator(Material.FLINT_AND_STEEL, (byte) 1, "Огниво и ведро");
                ItemStack i_axe = MetaCreator.MetaCreator(Material.IRON_AXE, (byte) 1, "Железные инструменты");
                ItemStack shears = MetaCreator.MetaCreator(Material.SHEARS, (byte) 1, "Ножницы и пузырёк");
                inv.setItem(22, flint);
                inv.setItem(31, i_axe);
                inv.setItem(40, shears);
            }
            case 1 -> {
                ItemStack grindstone = MetaCreator.MetaCreator(Material.GRINDSTONE, (byte) 1, "Точило и печь");
                ItemStack anvil = MetaCreator.MetaCreator(Material.ANVIL, (byte) 1, "Наковальня и кузнечный стол");
                ItemStack chain = MetaCreator.MetaCreator(Material.CHAIN, (byte) 1, "Цепи и прутья");
                inv.setItem(22, grindstone);
                inv.setItem(31, anvil);
                inv.setItem(40, chain);
            }
            case 2 -> {
                ItemStack tag = MetaCreator.MetaCreator(Material.NAME_TAG, (byte) 1, "Бирки и око эндера");
                ItemStack chainmail = MetaCreator.MetaCreator(Material.CHAINMAIL_CHESTPLATE, (byte) 1, "Кольчуга");
                ItemStack compass = MetaCreator.MetaCreator(Material.COMPASS, (byte) 1, "Компас, часы и труба");
                inv.setItem(22, tag);
                inv.setItem(31, chainmail);
                inv.setItem(40, compass);
            }
            case 3 -> {
                ItemStack i_chestplate = MetaCreator.MetaCreator(Material.IRON_CHESTPLATE, (byte) 1, "Железная броня");
                ItemStack crossbow = MetaCreator.MetaCreator(Material.CROSSBOW, (byte) 1, "Арбалет");
                ItemStack i_horse = MetaCreator.MetaCreator(Material.IRON_HORSE_ARMOR, (byte) 1, "Железная конская броня");
                inv.setItem(22, i_chestplate);
                inv.setItem(31, crossbow);
                inv.setItem(40, i_horse);
            }
            case 4 -> {
                ItemStack g_apple = MetaCreator.MetaCreator(Material.GOLDEN_APPLE, (byte) 1, "Золотая еда");
                ItemStack g_sword = MetaCreator.MetaCreator(Material.GOLDEN_SWORD, (byte) 1, "Вещи из драгоценностей");
                ItemStack beacon = MetaCreator.MetaCreator(Material.BEACON, (byte) 1, "Маяк и подводный источник");
                inv.setItem(22, g_apple);
                inv.setItem(31, g_sword);
                inv.setItem(40, beacon);
            }
            case 5 -> {
                ItemStack n_armor = MetaCreator.MetaCreator(Material.NETHERITE_CHESTPLATE, (byte) 1, "Незеритовая броня");
                ItemStack n_sword = MetaCreator.MetaCreator(Material.NETHERITE_SWORD, (byte) 1, "Незеритовые инструменты");
                ItemStack r_compass = MetaCreator.MetaCreator(Material.RECOVERY_COMPASS, (byte) 1, "Возвратный компас");
                inv.setItem(22, n_armor);
                inv.setItem(31, n_sword);
                inv.setItem(40, r_compass);
            }
        }
        switch (carpenter_points){
            case 0 -> {
                ItemStack o_stairs = MetaCreator.MetaCreator(Material.OAK_STAIRS, (byte) 1, "Дубовые доски");
                ItemStack o_sign = MetaCreator.MetaCreator(Material.OAK_SIGN, (byte) 1, "Блоки из дубовых досок");
                ItemStack o_door = MetaCreator.MetaCreator(Material.OAK_DOOR, (byte) 1, "Декорации из дубовых досок");
                inv.setItem(24, o_stairs);
                inv.setItem(33, o_sign);
                inv.setItem(42, o_door);
            }
            case 1 -> {
                ItemStack s_stairs = MetaCreator.MetaCreator(Material.SPRUCE_STAIRS, (byte) 1, "Доски из любого дерева");
                ItemStack a_sign = MetaCreator.MetaCreator(Material.ACACIA_SIGN, (byte) 1, "Блоки из любого дерева");
                ItemStack o_fence = MetaCreator.MetaCreator(Material.OAK_FENCE, (byte) 1, "Декорации из любого дерева");
                inv.setItem(24, s_stairs);
                inv.setItem(33, a_sign);
                inv.setItem(42, o_fence);
            }
            case 2 -> {
                ItemStack o_boat = MetaCreator.MetaCreator(Material.OAK_BOAT, (byte) 1, "Лодки");
                ItemStack a_chest_boat = MetaCreator.MetaCreator(Material.ACACIA_CHEST_BOAT, (byte) 1, "Лодки с сундуками");
                ItemStack beeehive = MetaCreator.MetaCreator(Material.BEEHIVE, (byte) 1, "Улей и бочка");
                inv.setItem(24, o_boat);
                inv.setItem(33, a_chest_boat);
                inv.setItem(42, beeehive);
            }
            case 3 -> {
                ItemStack scaffolding = MetaCreator.MetaCreator(Material.SCAFFOLDING, (byte) 1, "Подмостки");
                ItemStack ladder = MetaCreator.MetaCreator(Material.LADDER, (byte) 1, "Лестница");
                ItemStack rails = MetaCreator.MetaCreator(Material.RAIL, (byte) 1, "Рельсы");
                inv.setItem(24, scaffolding);
                inv.setItem(33, ladder);
                inv.setItem(42, rails);
            }
            case 4 -> {
                ItemStack c_stairs = MetaCreator.MetaCreator(Material.CRIMSON_STAIRS, (byte) 1, "Блоки из искажённой древесины");
                ItemStack w_fence = MetaCreator.MetaCreator(Material.WARPED_FENCE, (byte) 1, "Блоки из багровой древесины");
                inv.setItem(24, c_stairs);
                inv.setItem(33, w_fence);
            }
        }
        if(jewerly_points < 6){
            ItemStack j_points1 = MetaCreator.MetaCreator(Material.LAPIS_ORE, (byte) 1, ChatColor.GREEN+"Увеличение шанса");
            ItemStack j_points2 = MetaCreator.MetaCreator(Material.EMERALD_ORE, (byte) 1, ChatColor.GREEN+"Выпадения редких дропов");
            ItemStack j_points3 = MetaCreator.MetaCreator(Material.DIAMOND_ORE, (byte) 1, ChatColor.GREEN+"Из руд и кристаллов");
            inv.setItem(26, j_points1);
            inv.setItem(35, j_points2);
            inv.setItem(44, j_points3);
        }
    }
}
