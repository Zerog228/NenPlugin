package zerog.plugin.nenplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class DcCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("dc")) {
            sender.sendMessage("Дискорд - "+ChatColor.AQUA+"https://discord.gg/SbRa52AsMn");
            sender.sendMessage("ВК - "+ChatColor.BLUE+" https://vk.com/tetscraft");
            sender.sendMessage("Ютуб - "+ChatColor.RED+" https://www.youtube.com/channel/UC3ssUc12zBgSKe8Eq2nIN8A");
        }
        return true;
    }
}
