package zerog.plugin.nenplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class VoteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("vote")) {
            sender.sendMessage("Проголосуй! "+ChatColor.AQUA+"https://minecraftrating.ru/server/tetscraft/");
            sender.sendMessage("и получи! "+ChatColor.AQUA+"https://hotmc.ru/vote-232148");
            sender.sendMessage("радость админа! "+ChatColor.AQUA+"https://tmonitoring.com/server/tetscraft/");
        }
        return true;
    }
}
