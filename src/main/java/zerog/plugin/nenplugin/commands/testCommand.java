package zerog.plugin.nenplugin.commands;

import com.destroystokyo.paper.ParticleBuilder;
import net.kyori.adventure.audience.MessageType;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.inventory.Book;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapView;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import zerog.plugin.nenplugin.NenPlugin;
import zerog.plugin.nenplugin.commands.classes.Roller;
import zerog.plugin.nenplugin.utils.GetPlayerUpgrades;
import zerog.plugin.nenplugin.utils.PersistentData;
import zerog.plugin.nenplugin.utils.SetAttributes;

import java.util.Random;

public class testCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("testo") && sender instanceof Player p){

            Server server = NenPlugin.getPlugin().getServer();
            Identity id = Identity.identity(((Player) sender).getUniqueId());
            sender.showTitle(Title.title(Component.newline().content(ChatColor.AQUA+"Добро пожаловать"), Component.newline().content(ChatColor.GREEN+"на TetsCraft"), Title.DEFAULT_TIMES));
            for(Player player : Bukkit.getOnlinePlayers()){
                if(player.getName().equalsIgnoreCase("Mcira")){
                    int hp_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 0);
                    int speed_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 1);
                    int armour_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 2);
                    int armour_t_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 3);
                    int attack_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 4);
                    int haste_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 5);
                    int luck_points = GetPlayerUpgrades.getUpgrades(p).get((byte) 6);
                    for (int i = 0; i < 20; i++) {
                        Random rd = new Random();
                        int k = rd.nextInt(7);
                        SetAttributes.AddUpgrades(player, (byte) k, 0.5);
                        switch (k){
                            case 6-> PersistentData.setPlayerData(p, "nen_points_luck", PersistentDataType.INTEGER, luck_points+1, "");
                            case 5-> PersistentData.setPlayerData(p, "nen_points_haste", PersistentDataType.INTEGER, haste_points+1, "");
                            case 4-> PersistentData.setPlayerData(p, "nen_points_damage", PersistentDataType.INTEGER, attack_points+1, "");
                            case 3-> PersistentData.setPlayerData(p, "nen_points_armour_t", PersistentDataType.INTEGER, armour_t_points+1, "");
                            case 2-> PersistentData.setPlayerData(p, "nen_points_armour", PersistentDataType.INTEGER, armour_points+1, "");
                            case 1-> PersistentData.setPlayerData(p, "nen_points_speed", PersistentDataType.INTEGER, speed_points+1, "");
                            case 0-> PersistentData.setPlayerData(p, "nen_points_hp", PersistentDataType.INTEGER, hp_points+1, "");
                        }
                    }
                }
            }
        }
        return true;
    }
}
