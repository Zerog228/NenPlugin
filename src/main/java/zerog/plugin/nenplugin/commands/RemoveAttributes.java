package zerog.plugin.nenplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import zerog.plugin.nenplugin.utils.SetAttributes;

public class RemoveAttributes implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("remove_attributes") && sender instanceof Player p){
            if (args.length > 0){
                p = Bukkit.getPlayerExact(args[0]);
            }
            SetAttributes.removeAttributes(p);
        }

        return true;
    }
}
