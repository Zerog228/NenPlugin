package zerog.plugin.nenplugin.commands.classes;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import zerog.plugin.nenplugin.NenPlugin;
import zerog.plugin.nenplugin.commands.Monke;
import zerog.plugin.nenplugin.utils.PersistentData;
import zerog.plugin.nenplugin.utils.SetAttributes;
import zerog.plugin.nenplugin.utils.SetVillagerData;

import java.util.UUID;

public class Mazohist implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("set_mazohist") && sender instanceof Player p) {
            if(args.length > 0){
                p = Bukkit.getPlayerExact(args[0]);
            }
            setMazohist(p);
        }
        return true;
    }

    public static void setMazohist(Player p){

        SetVillagerData.setAttributes(p);
        Monke.resetClassesPermissions(p);

        NenPlugin.addPermission(p.getUniqueId(), "nen.mazohist");
        PersistentData.setPlayerData(p, "data0", PersistentDataType.DOUBLE, 1.0, "");
        SetAttributes.SetAttributes(p, (byte) 0,1.0);
        SetAttributes.SetAttributes(p, (byte) 1,0.1);
        PersistentData.setPlayerData(p, "data2", PersistentDataType.DOUBLE, -10.0, "");
        SetAttributes.SetAttributes(p, (byte) 2,-10.0);
        PersistentData.setPlayerData(p, "data3", PersistentDataType.DOUBLE, 5.0, "");
        SetAttributes.SetAttributes(p, (byte) 3,5.0);
        PersistentData.setPlayerData(p, "data4", PersistentDataType.DOUBLE, 0.0, "");
        SetAttributes.SetAttributes(p, (byte) 4,0.0);
        SetAttributes.SetAttributes(p, (byte) 5,4.0);
        PersistentData.setPlayerData(p, "data6", PersistentDataType.DOUBLE, 1.0, "");
        SetAttributes.SetAttributes(p, (byte) 6,1.0);
        UUID uuid = p.getUniqueId();
        NenPlugin.addPermission(uuid, "purpur.enderchest.rows.three");
        PersistentData.setPlayerData(p, "class_number", PersistentDataType.INTEGER, 39, "");
    }
}
