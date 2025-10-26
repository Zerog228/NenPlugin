package zerog.plugin.nenplugin.utils;

import org.bukkit.entity.*;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Objects;

public class AimingCrossbowTask extends BukkitRunnable {

    private int counter;
    private final SpectralArrow arrow;
    private final Entity shooter;
    private Entity target;

    public AimingCrossbowTask(int counter, SpectralArrow arrow, Entity shooter) {
        this.counter = counter;
        this.arrow = arrow;
        this.shooter = shooter;
    }

    @Override
    public void run() {
        if (counter > 0) {
            Entity[] entities = arrow.getNearbyEntities(20, 40, 20).toArray(new Entity[0]);
            if (target == null) {
                for (Entity en : entities) {
                    if (!en.getName().equals(shooter.getName()) && !PersistentData.checkEntityData(en, "arrow_uuid") && !(en instanceof Item) && !(en instanceof SpectralArrow) && !(en instanceof Arrow)) {
                        PersistentData.setEntityData(en, "arrow_uuid", PersistentDataType.STRING, 0, String.valueOf(arrow.getUniqueId()));
                        this.target = en;
                        return;
                    }
                }
            } else if(Objects.equals(PersistentData.getEntityData(target, "arrow_uuid", PersistentDataType.STRING), String.valueOf(arrow.getUniqueId()))){
                Vector pVec = target.getLocation().toVector();
                Vector aVec = arrow.getLocation().toVector();
                arrow.setGravity(false);
                arrow.setVelocity(pVec.subtract(aVec).normalize());
            }
        } else if (target != null){
            Entity en = this.target;
            arrow.remove();
            PersistentData.removeEntityData(en, "arrow_uuid");
            this.cancel();
        }
        counter--;
    }
}