package zerog.plugin.nenplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import zerog.plugin.nenplugin.utils.NenExp;
import zerog.plugin.nenplugin.utils.PersistentData;

public class PlayerSetExp implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player p && command.getName().equalsIgnoreCase("setnenexp")){
            Player target = p;
            if (args.length == 2) {
                target = Bukkit.getPlayerExact(args[0]);

                double new_exp = Double.parseDouble((args[1]));
                PersistentData.setPlayerData(target, "nen_exp", PersistentDataType.DOUBLE, new_exp, "");
                p.sendMessage(ChatColor.DARK_AQUA + "Теперь опыт " + ChatColor.WHITE + target.getName() + ChatColor.DARK_AQUA + " = " + ChatColor.RED + new_exp);
                NenExp.removeLevels(target);
                NenExp.levelCheck(target);
            } else if(args.length == 1) {
                target = Bukkit.getPlayerExact(args[0]);
                sender.sendMessage("Его опыт - "+ PersistentData.getPlayerData(target, "nen_exp", PersistentDataType.DOUBLE));
            }
        }
        return true;
    }
}
