package zerog.plugin.nenplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import zerog.plugin.nenplugin.inventories.PublicChestInventory;

public class PublicChestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("publicchest") && sender instanceof Player p) {
            PublicChestInventory.openPublicChest(p);
        }
        return true;
    }
}
