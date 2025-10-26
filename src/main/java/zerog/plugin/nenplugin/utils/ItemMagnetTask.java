package zerog.plugin.nenplugin.utils;

import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ItemMagnetTask extends BukkitRunnable {

    private int counter;
    private Entity target;
    private Bee bee;

    public ItemMagnetTask(int counter, Entity target, Bee bee){
        this.counter = counter;
        this.target = target;
        this.bee = bee;
    }

    @Override
    public void run() {
        if(counter > 0){
            bee.getPathfinder().moveTo(target.getLocation(), 1);
            if(target.getLocation().toVector().subtract(bee.getLocation().toVector()).length() < 1){
                ItemStack stack = bee.getEquipment().getChestplate();
                ItemMeta meta = stack.getItemMeta();
                meta.setCustomModelData(999);
                stack.setItemMeta(meta);
                bee.getWorld().dropItem(bee.getLocation(), stack);
                bee.remove();
                this.cancel();
            }
        } else {
            ItemStack stack = bee.getEquipment().getChestplate();
            ItemMeta meta = stack.getItemMeta();
            meta.setCustomModelData(999);
            stack.setItemMeta(meta);
            bee.getWorld().dropItem(bee.getLocation(), stack);
            bee.remove();
            this.cancel();
        }
        counter--;
    }
}