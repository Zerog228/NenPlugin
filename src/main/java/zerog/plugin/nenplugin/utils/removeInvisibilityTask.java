package zerog.plugin.nenplugin.utils;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import zerog.plugin.nenplugin.NenPlugin;

public class removeInvisibilityTask extends BukkitRunnable {

    private Player hider;
    private Player seeker;

    public removeInvisibilityTask(Player hider, Player seeker){
        this.hider = hider;
        this.seeker = seeker;
    }

    @Override
    public void run() {
        seeker.showPlayer(NenPlugin.getPlugin(), hider);
    }
}