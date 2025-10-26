package zerog.plugin.nenplugin.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CompareArmor {
    public static double compareArmor(Player p){
        double i = 0;
        ItemStack [] armor = p.getInventory().getArmorContents();
        for(ItemStack stack : armor) {
            if (stack != null) {
                if (String.valueOf(stack.getType()).contains("IRON")) {
                    i += 0.02;
                }
                if (String.valueOf(stack.getType()).contains("GOLDEN")) {
                    i += 0.04;
                }
                if (String.valueOf(stack.getType()).contains("NETHERITE")) {
                    i += 0.08;
                }
                if (stack.getItemMeta().hasCustomModelData() && stack.getItemMeta().getCustomModelData() >= 46 && stack.getItemMeta().getCustomModelData() <= 49) {
                    i -= 0.015;
                }
            }
        }
        if (p.getInventory().getChestplate() != null && p.getInventory().getChestplate().hasItemMeta() && p.getInventory().getChestplate().getItemMeta().hasCustomModelData() && p.getInventory().getChestplate().getItemMeta().getCustomModelData() == 50 && i <= 0.09) {
            i = 0;
        }
        if (p.getInventory().getChestplate() != null && p.getInventory().getChestplate().hasItemMeta() && p.getInventory().getChestplate().getItemMeta().hasCustomModelData() && p.getInventory().getChestplate().getItemMeta().getCustomModelData() == 51 && i <= 0.33) {
            i = 0;
        }
        return i;
    }
}
