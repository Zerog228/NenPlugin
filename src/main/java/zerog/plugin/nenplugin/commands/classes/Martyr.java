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

public class Martyr implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("set_martyr") && sender instanceof Player p) {
            if(args.length > 0){
                p = Bukkit.getPlayerExact(args[0]);
            }
            setMartyr(p);
        }
        return true;
    }
    public static void setMartyr(Player p){

        SetVillagerData.setAttributes(p);
        Monke.resetClassesPermissions(p);

        NenPlugin.addPermission(p.getUniqueId(), "nen.martyr");
        NenPlugin.addPermission(p.getUniqueId(), "nen.rebirth");
        PersistentData.setPlayerData(p, "data0", PersistentDataType.DOUBLE, 8.0, "");
        SetAttributes.SetAttributes(p, (byte) 0, 8.0);
        SetAttributes.SetAttributes(p, (byte) 1, 0.1);
        SetAttributes.SetAttributes(p, (byte) 2, 0.0);
        SetAttributes.SetAttributes(p, (byte) 3, 0.0);
        SetAttributes.SetAttributes(p, (byte) 4, 1.0);
        SetAttributes.SetAttributes(p, (byte) 5, 4.0);
        SetAttributes.SetAttributes(p, (byte) 6, 0.0);
        PersistentData.setPlayerData(p, "class_number", PersistentDataType.INTEGER, 40, "");
    }
}
