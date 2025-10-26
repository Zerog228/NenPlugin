package zerog.plugin.nenplugin.utils;

import org.bukkit.Chunk;
import org.bukkit.GameMode;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.SpectralArrow;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class AimingArrowsTask extends BukkitRunnable {

    private int counter;
    private SpectralArrow arrow;
    private Entity shooter;

    public AimingArrowsTask(int counter, SpectralArrow arrow, Entity shooter){
        this.counter = counter;
        this.arrow = arrow;
        this.shooter = shooter;
    }

    @Override
    public void run() {
        if(counter > 0){
            Entity [] entities = arrow.getNearbyEntities(20, 80, 20).toArray(new Entity[0]);
            for(Entity en : entities){
                if(en instanceof Player p && !p.getName().equals(shooter.getName()) && p.getGameMode() == GameMode.SURVIVAL){
                    Vector pVec = p.getLocation().toVector().add(new Vector(0, 2, 0));
                    Vector aVec = arrow.getLocation().toVector();
                    arrow.setGravity(false);
                    arrow.setVelocity(pVec.subtract(aVec).normalize());
                }
            }
        }else {
            arrow.remove();
            this.cancel();
        }
        counter--;
    }
}