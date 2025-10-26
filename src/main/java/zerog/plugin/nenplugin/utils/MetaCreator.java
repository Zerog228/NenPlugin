package zerog.plugin.nenplugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MetaCreator {

    public static ItemStack MetaCreator(Material material, byte amount, String display_name, ChatColor display_color, String lore1, String lore2, Inventory inv, byte slot){

        ItemStack item_stack = new ItemStack(material, amount);
        ItemMeta meta = item_stack.getItemMeta();
        meta.setDisplayName(display_color+display_name);
        ArrayList<String> lore_array = new ArrayList<>();
        lore_array.add(ChatColor.WHITE+lore1);
        lore_array.add(ChatColor.WHITE+lore2);
        meta.setLore(lore_array);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
        item_stack.setItemMeta(meta);
        inv.setItem(slot, item_stack);

        return item_stack;
    }
    public static ItemStack MetaCreator(Material material, byte amount, String display_name, ChatColor display_color, String lore1, String lore2, String lore3, Inventory inv, byte slot){

        ItemStack item_stack = new ItemStack(material, amount);
        ItemMeta meta = item_stack.getItemMeta();
        meta.setDisplayName(display_color+display_name);
        ArrayList<String> lore_array = new ArrayList<>();
        lore_array.add(ChatColor.WHITE+lore1);
        lore_array.add(ChatColor.WHITE+lore2);
        lore_array.add(ChatColor.WHITE+lore3);
        meta.setLore(lore_array);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
        item_stack.setItemMeta(meta);
        inv.setItem(slot, item_stack);

        return item_stack;
    }

    public static ItemStack MetaCreator(Material material, byte amount, String display_name){

        ItemStack item_stack = new ItemStack(material, amount);
        ItemMeta meta = item_stack.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE+display_name);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
        item_stack.setItemMeta(meta);

        return item_stack;
    }

    public static ItemStack ClassesMetaCreator(Material material, byte amount, String display_name, ChatColor display_color, String lore1, String lore2, Inventory inv, byte slot){

        ItemStack item_stack = new ItemStack(material, amount);
        ItemMeta meta = item_stack.getItemMeta();
        meta.setDisplayName(display_color+display_name);
        ArrayList<String> lore_array = new ArrayList<>();
        lore_array.add(ChatColor.GREEN+lore1);
        lore_array.add(ChatColor.RED+lore2);
        meta.setLore(lore_array);
        item_stack.setItemMeta(meta);
        inv.setItem(slot, item_stack);

        return item_stack;
    }
}
