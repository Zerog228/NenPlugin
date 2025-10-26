package zerog.plugin.nenplugin.utils;

import net.coreprotect.CoreProtect;
import net.coreprotect.CoreProtectAPI;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockPlaceEvent;
import zerog.plugin.nenplugin.NenPlugin;

import java.util.List;

public class CheckForCoal {

    public static boolean checkCoal(BlockPlaceEvent e){

        boolean bool = false;
        Block b1 = e.getBlockPlaced().getRelative(0, -1, 0);
        Block b2 = e.getBlockPlaced().getRelative(0, 1, 0);
        Block b3 = e.getBlockPlaced().getRelative(1, 0, 0);
        Block b4 = e.getBlockPlaced().getRelative(-1, 0, 0);
        Block b5 = e.getBlockPlaced().getRelative(0, 0, -1);
        Block b6 = e.getBlockPlaced().getRelative(0, 0, 1);

        Block [] mat = new Block[6];
        mat [0] = b1;
        mat [1] = b2;
        mat [2] = b3;
        mat [3] = b4;
        mat [4] = b5;
        mat [5] = b6;
        CoreProtectAPI api = NenPlugin.getCoreProtectAPI();

        for(Block b : mat){
            List<String[]> lookup = api.blockLookup(b, 100000);
            if((b.getType() == Material.COAL_ORE || b.getType() == Material.DEEPSLATE_COAL_ORE) && lookup.isEmpty()){
                return true;
            }
        }

        return bool;
    }
}
