package zerog.plugin.nenplugin.utils;

import com.destroystokyo.paper.ParticleBuilder;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class MagicCircleTask extends BukkitRunnable {

    private Location location;
    private int count;

    public MagicCircleTask(int count, Location location){
        this.location = location;
        this.count = count;
    }

    @Override
    public void run() {
        if(count > 0){
            location.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, location, 0);
            count--;
            Collection<Entity> entities = location.getNearbyEntities(6, 6, 6);
            for(Entity en : entities){
                if(en instanceof Player p){
                    Color color = Color.fromRGB(173, 255, 47);
                    Particle.DustOptions options = new Particle.DustOptions(color, 40);
                    //player.getWorld().spawnParticle(particle, p.getLocation().add(0, 3, 0), 0, options);
                    Vector vec = p.getLocation().add(0, 1.5, 0).toVector().subtract(location.toVector());
                    Particle particle = new ParticleBuilder(Particle.REDSTONE).offset(vec.getX(), 0, vec.getZ()).particle();
                    location.getWorld().spawnParticle(particle, location, 0, vec.getX(), vec.getY(), vec.getZ(), options);
                }
            }
        }else {
            this.cancel();
        }
    }
}