package zerog.plugin.nenplugin.utils;

import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class CheckHoeInteract {

    public static boolean checkHoeInteract(PlayerInteractEvent e){
        if (e.getClickedBlock() != null){
            Material mat = e.getClickedBlock().getRelative(0, 1, 0).getType();
            Material clicked = e.getClickedBlock().getType();
            return clicked == Material.GRASS_BLOCK && e.getAction().isRightClick() && String.valueOf(e.getPlayer().getInventory().getItemInMainHand().getType()).contains("HOE") && mat == Material.AIR;
        }
        return false;
    }
}
