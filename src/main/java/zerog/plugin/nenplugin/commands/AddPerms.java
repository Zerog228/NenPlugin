package zerog.plugin.nenplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import zerog.plugin.nenplugin.NenPlugin;

public class AddPerms implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("AddPerms") && sender instanceof Player p && args.length > 0) {

            if(args.length == 1){
                NenPlugin.addPermission(p.getUniqueId(), args[0]);
            }else if (args.length == 2){
                Player target = Bukkit.getPlayerExact(args[0]);
                assert target != null;
                NenPlugin.addPermission(target.getUniqueId(), args[1]);
            } else {
                sender.sendMessage("Нехватает аргументов");
            }
        }
        return true;
    }
}
