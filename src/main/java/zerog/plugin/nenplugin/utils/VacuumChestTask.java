package zerog.plugin.nenplugin.utils;

import org.bukkit.Particle;
import org.bukkit.block.Chest;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class VacuumChestTask extends BukkitRunnable {

    private int counter;
    private Chest chest;
    private Item item;

    public VacuumChestTask(int counter, Chest chest, Item item){
        this.counter = counter;
        this.chest = chest;
        this.item = item;
        //item.getWorld().dropItem(item.getLocation(), item.getItemStack());
    }

    private int k = 0;

    @Override
    public void run() {
        double distance = chest.getLocation().toVector().subtract(item.getLocation().toVector()).length();
        Inventory inv = chest.getInventory();
        item.setGravity(false);
        if(counter > 0){
            if(distance>=2) {
                item.setVelocity(chest.getLocation().toVector().subtract(item.getLocation().toVector()).normalize().multiply(new Vector(0.8, 1.4, 0.8)));
            }else {
                counter = 0;
                inv.addItem(item.getItemStack());
                item.remove();
                item.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, item.getLocation(), 2);
            }
            counter--;
        }else {
            item.setGravity(true);
            this.cancel();
        }
    }
}