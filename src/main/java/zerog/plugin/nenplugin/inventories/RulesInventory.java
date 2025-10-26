package zerog.plugin.nenplugin.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import zerog.plugin.nenplugin.commands.HelpCommand;
import zerog.plugin.nenplugin.commands.MenuCommand;
import zerog.plugin.nenplugin.commands.RulesCommand;

import java.util.Objects;

public class RulesInventory {

    public static void OpenMenu(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        Material item = Objects.requireNonNull(e.getCurrentItem()).getType();
        boolean b = true;

        switch(item){
            case ANVIL -> {
                MenuCommand.openMenu(p);
                b = false;
            }
            case BLUE_DYE -> {
                p.sendMessage("https://discord.gg/SbRa52AsMn");
                p.sendMessage("https://vk.com/tetscraft");
            }
        }

        if(b){
            RulesCommand.openMenu(p);
        }
    }
}
