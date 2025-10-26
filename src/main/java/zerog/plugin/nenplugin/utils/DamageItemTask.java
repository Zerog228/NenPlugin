package zerog.plugin.nenplugin.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Dispenser;
import org.bukkit.block.data.Directional;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;

public class DamageItemTask extends BukkitRunnable {

    Location location;
    ItemStack stack;
    int number;

    public DamageItemTask(Location loc, ItemStack stack, int number){
        this.location = loc;
        this.stack = stack;
        this.number = number;
    }

    @Override
    public void run() {
        int i = 0;
        Dispenser dispenser = (Dispenser) location.getBlock().getState();
        for(ItemStack disp_stack : dispenser.getInventory().getContents()){
            Directional facing = (Directional) dispenser.getBlockData();
            Collection<Entity> entities = dispenser.getLocation().add(facing.getFacing().getDirection().toLocation(dispenser.getWorld())).add(0.5, 0, 0).getNearbyEntities(1, 1, 1);
            if(disp_stack != null && disp_stack.equals(stack) && disp_stack.getItemMeta() instanceof Damageable d && !entities.isEmpty()){
                d.setDamage(d.getDamage() + entities.toArray().length);
                disp_stack.setItemMeta(d);
                if(d.getDamage() >= disp_stack.getType().getMaxDurability()){
                    dispenser.getInventory().setItem(i, new ItemStack(Material.AIR));
                    dispenser.getWorld().playSound(dispenser.getLocation(), Sound.ENTITY_ITEM_BREAK, 0.5F, 1);
                }
                Map<Enchantment, Integer> enchants = disp_stack.getEnchantments();
                if(number != 9) {
                    for (Entity en : entities) {
                        if (en instanceof LivingEntity living) {
                            double damage = number;
                            if(enchants.get(Enchantment.DAMAGE_ALL) != null){
                               damage += enchants.get(Enchantment.DAMAGE_ALL) * 0.5;
                            }
                            living.damage(damage);
                        }
                    }
                } else {
                    if (enchants.containsKey(Enchantment.CHANNELING) && dispenser.getWorld().isThundering()){
                        dispenser.getWorld().strikeLightning(dispenser.getLocation().add(facing.getFacing().getDirection().toLocation(dispenser.getWorld())));
                    } else {
                        Trident tr = (Trident) dispenser.getWorld().spawnEntity(dispenser.getLocation().add(facing.getFacing().getDirection().toLocation(dispenser.getWorld()).add(0.5, 0, 0)), EntityType.TRIDENT);
                        tr.setVelocity(facing.getFacing().getDirection().multiply(new Vector(3, 3, 3)));
                    }
                }
                return;
            }
            i++;
        }
    }
}
