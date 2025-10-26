package zerog.plugin.nenplugin.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import zerog.plugin.nenplugin.commands.Classes2Command;
import zerog.plugin.nenplugin.commands.ClassesCommand;
import zerog.plugin.nenplugin.commands.HelpCommand;
import zerog.plugin.nenplugin.commands.MenuCommand;

import java.util.Objects;

public class Classesnventory {

    public static void OpenMenu(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        Material item = Objects.requireNonNull(e.getCurrentItem()).getType();
        boolean b = true;

        if(item == Material.ANVIL){
            MenuCommand.openMenu(p);
            b = false;
        }
        if(item == Material.ARROW){
            Classes2Command.openMenu(p);
            b = false;
        }

        if(b){
            ClassesCommand.openMenu(p);
        }
    }
}
