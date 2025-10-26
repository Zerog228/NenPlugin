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

public class Archer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("set_archer") && sender instanceof Player p) {
            if(args.length > 0){
                p = Bukkit.getPlayerExact(args[0]);
            }
            setArcher(p);
        }
        return true;
    }
    public static void setArcher(Player p){

        if(!p.hasPermission("nen.archer")){
            Monke.resetClassesPermissions(p);
            NenPlugin.addPermission(p.getUniqueId(), "nen.archer");
        }


        SetVillagerData.setAttributes(p);

        PersistentData.setPlayerData(p, "data0", PersistentDataType.DOUBLE, 18.0, "");
        SetAttributes.SetAttributes(p, (byte) 0, 18.0);

        PersistentData.setPlayerData(p, "data1", PersistentDataType.DOUBLE, 0.11, "");
        SetAttributes.SetAttributes(p, (byte) 1, 0.11);

        SetAttributes.SetAttributes(p, (byte) 2, 0.0);
        SetAttributes.SetAttributes(p, (byte) 3, 0.0);
        SetAttributes.SetAttributes(p, (byte) 4, 1.0);
        PersistentData.setPlayerData(p, "data5", PersistentDataType.DOUBLE, 3.8, "");
        SetAttributes.SetAttributes(p, (byte) 5, 3.8);

        PersistentData.setPlayerData(p, "data6", PersistentDataType.DOUBLE, 0.3, "");
        SetAttributes.SetAttributes(p, (byte) 6, 1.0);

        PersistentData.setPlayerData(p, "class_number", PersistentDataType.INTEGER, 11, "");
    }
}
