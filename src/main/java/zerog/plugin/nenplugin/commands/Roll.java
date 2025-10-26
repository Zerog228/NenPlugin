package zerog.plugin.nenplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.javatuples.Pair;
import org.jetbrains.annotations.NotNull;
import zerog.plugin.nenplugin.utils.SetAttributes;
import zerog.plugin.nenplugin.utils.Timer;

import java.util.Random;

public class Roll implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("roll") && sender instanceof Player p) {
            roll(p);
        }
        return true;
    }

    public static void roll(Player p){
        Pair <Boolean, Long> bool_time = (Timer.Timer1(p, 300L));
        if (bool_time.getValue0()) {
            Random rd = new Random();
            int i = rd.nextInt(6);
            int y = rd.nextInt(6);
            if (i == y) {
                p.sendMessage("Вам выпал дубль, не повезло");
                SetAttributes.setRollerAttributes(p);
            } else {
                i++;
                y++;
                p.sendMessage("Вам выпало " + ChatColor.DARK_AQUA + i + ChatColor.WHITE + " и " + ChatColor.DARK_AQUA + y);
                i = rd.nextInt(7);
                y = rd.nextInt(7);
                SetAttributes.AddAttributes(p, (byte) i, 1.2);
                SetAttributes.AddAttributes(p, (byte) y, 1.2);
                if(p.hasPermission(new Permission("nen.reroller"))){
                    i = rd.nextInt(7);
                    y = rd.nextInt(7);
                    SetAttributes.AddAttributes(p, (byte) i, 1.3);
                    SetAttributes.AddAttributes(p, (byte) y, 1.3);
                }
            }
        } else {
            p.sendMessage("Подождиnt ещё "+ ChatColor.DARK_AQUA + bool_time.getValue1()/1000 + ChatColor.WHITE +" прежде чем использовать это снова");
        }
    }
}
