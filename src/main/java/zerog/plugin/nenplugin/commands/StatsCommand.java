package zerog.plugin.nenplugin.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import zerog.plugin.nenplugin.utils.GetPlayerUpgrades;
import zerog.plugin.nenplugin.utils.MetaCreator;
import zerog.plugin.nenplugin.utils.PersistentData;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StatsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (command.getName().equalsIgnoreCase("stats") && sender instanceof Player p){
            openStatsInv(p);
        }

        return true;
    }

    public static void openStatsInv(Player p){

        Inventory inv = Bukkit.createInventory(p, 54, ChatColor.DARK_GRAY + "Ваши статы");

        double upgr_points = (double) PersistentData.getPlayerData(p, "nen_upgrade_points", PersistentDataType.DOUBLE);
        DecimalFormat format = new DecimalFormat("0.0#");

        int hp_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 0);
        int speed_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 1);
        int armour_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 2);
        int armour_t_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 3);
        int attack_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 4);
        int haste_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 5);
        int luck_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 6);

        double hp_value = Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue();
        double speed_value = Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).getValue();
        double armour_value = Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ARMOR)).getValue();
        double armour_t_value = Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS)).getValue();
        double attack_value = Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)).getValue();
        double haste_value = Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ATTACK_SPEED)).getValue();
        double luck_value = Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_LUCK)).getValue();


        ItemStack gray_glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemStack stat_glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS, 1);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.newline().content(ChatColor.WHITE+"Хп: "+ ChatColor.DARK_RED +format.format(hp_value)));
        lore.add(Component.newline().content(ChatColor.WHITE+"Скорость: "+ ChatColor.AQUA +format.format(speed_value)));
        lore.add(Component.newline().content(ChatColor.WHITE+"Защита: "+ ChatColor.DARK_AQUA +format.format(armour_value)));
        lore.add(Component.newline().content(ChatColor.WHITE+"Твёрдость брони: "+ ChatColor.DARK_GREEN +format.format(armour_t_value)));
        lore.add(Component.newline().content(ChatColor.WHITE+"Урон: "+ ChatColor.RED +format.format(attack_value)));
        lore.add(Component.newline().content(ChatColor.WHITE+"Скорость атаки: "+ ChatColor.YELLOW +format.format(haste_value)));
        lore.add(Component.newline().content(ChatColor.WHITE+"Удача: "+ ChatColor.GREEN +format.format(luck_value)));
        ItemMeta meta = stat_glass.getItemMeta();
        meta.lore(lore);
        meta.displayName(Component.newline().content(ChatColor.WHITE+"Ваши аттрибуты"));
        stat_glass.setItemMeta(meta);
        MetaCreator.MetaCreator(Material.GRAY_STAINED_GLASS_PANE, (byte) 1, "⠀");

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, gray_glass);
        }
        inv.setItem(53, stat_glass);

        if(upgr_points <= 1){
            ItemStack head = MetaCreator.MetaCreator(Material.PLAYER_HEAD, (byte) 1, "Очки прокачки", ChatColor.YELLOW, "Ваши очки прокачки", "Вы имеете: "+format.format(upgr_points), inv, (byte) 0);
        } else {
            ItemStack head = MetaCreator.MetaCreator(Material.PLAYER_HEAD, (byte) upgr_points, "Очки прокачки", ChatColor.YELLOW, "Ваши очки прокачки", "Вы имеете: "+format.format(upgr_points), inv, (byte) 0);
        }

        ItemStack apple = MetaCreator.MetaCreator(Material.APPLE, (byte) ((byte) 1 + hp_points), "Здоровье", ChatColor.RED, "Добавляет 0.5 хп", "Стоимость: "+format.format(hp_points*0.1+1), inv, (byte) 13);
        ItemStack sugar = MetaCreator.MetaCreator(Material.SUGAR, (byte) ((byte)1 +speed_points), "Скорость", ChatColor.AQUA, "Добавляет 0.006 скорости", "Стоимость: "+format.format(speed_points*0.1+1), inv, (byte) 24);
        ItemStack turtle = MetaCreator.MetaCreator(Material.SCUTE, (byte) ((byte)1 + armour_points), "Броня", ChatColor.DARK_AQUA, "Добавляет 0.15 брони", "Стоимость: "+format.format(armour_points*0.1+1), inv, (byte) 20);
        ItemStack iron = MetaCreator.MetaCreator(Material.RAW_IRON, (byte) ((byte)1 + armour_t_points), "Твёрдость брони", ChatColor.BLUE, "Добавляет 0.5 твёрдости брони", "Стоимость: "+format.format(armour_t_points*0.1+1), inv, (byte) 42);
        ItemStack arrow = MetaCreator.MetaCreator(Material.ARROW, (byte) ((byte)1 + attack_points), "Урон", ChatColor.DARK_RED, "Добавляет 0.1 урона", "Стоимость: "+format.format(attack_points*0.1+1), inv, (byte) 49);
        ItemStack feather = MetaCreator.MetaCreator(Material.FEATHER, (byte) ((byte)1 + haste_points), "Скорость атаки", ChatColor.GOLD, "Добавляет 0.01 скорости атаки", "Стоимость: "+format.format(haste_points*0.1+1), inv, (byte) 38);
        ItemStack emerald = MetaCreator.MetaCreator(Material.EMERALD, (byte) ((byte)1 + luck_points), "Удача", ChatColor.GREEN, "Добавляет 0.1 удачи", "Стоимость: "+format.format(luck_points+1), inv, (byte) 31);
        ItemStack exp = MetaCreator.MetaCreator(Material.EXPERIENCE_BOTTLE, (byte) 1, "Опыт", ChatColor.DARK_GREEN, "Покупка 10 ванильных уровней", "Стоимость: 1", inv, (byte) 8);
        ItemStack anvil = MetaCreator.MetaCreator(Material.ANVIL, (byte) 1, "Назад", ChatColor.WHITE, "", "", inv, (byte) 45);

        p.openInventory(inv);
    }
}
