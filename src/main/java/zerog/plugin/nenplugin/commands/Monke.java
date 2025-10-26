package zerog.plugin.nenplugin.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import zerog.plugin.nenplugin.NenPlugin;
import zerog.plugin.nenplugin.utils.PersistentData;
import zerog.plugin.nenplugin.utils.SetAttributes;
import zerog.plugin.nenplugin.utils.SetVillagerData;

import java.util.UUID;

public class Monke implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player target = Bukkit.getPlayerExact(args[0]);
        if (command.getName().equalsIgnoreCase("monke") && args.length == 1 && target != null) {

            SetVillagerData.setAttributes(target);

            Location l = target.getLocation();
            World w = target.getWorld();

            //w.spawnParticle(Particle.TOTEM, new Location(w, l.getX(), l.getY()+1, l.getZ()), 8000);
            //w.createExplosion(l, 1, false, false);
            //w.strikeLightningEffect(l);
            target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 2));
            target.sendMessage(ChatColor.DARK_AQUA+"Return to monke, "+ ChatColor.RED +target.getName());

            PersistentData.setPlayerData(target, "nen_exp", PersistentDataType.DOUBLE, 0, "");
            PersistentData.setPlayerData(target, "nen_level", PersistentDataType.INTEGER, 1, "");

            PersistentData.removePlayerData(target, "nen_upgrade_points");
            PersistentData.setPlayerData(target, "nen_upgrade_points", PersistentDataType.DOUBLE, 0, "");

            PersistentData.setPlayerData(target, "nen_points_hp", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(target, "nen_points_speed", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(target, "nen_points_armour", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(target, "nen_points_armour_t", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(target, "nen_points_damage", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(target, "nen_points_haste", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(target, "nen_points_luck", PersistentDataType.INTEGER, 0, "");

            PersistentData.setPlayerData(target, "class_number", PersistentDataType.INTEGER, 0, "");

            PersistentData.setPlayerData(target, "additional_upgrades", PersistentDataType.INTEGER, 0, "");

            PersistentData.setPlayerData(target, "nen_blocks_decor_upgrades", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(target, "nen_redstone_upgrades", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(target, "nen_smithing_upgrades", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(target, "nen_carpentry_upgrades", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(target, "nen_jewelry_upgrades", PersistentDataType.INTEGER, 0, "");

            PersistentData.setPlayerData(target, "nen_craft_points", PersistentDataType.DOUBLE, 1.1, "");

            UUID uuid = target.getUniqueId();

            NenPlugin.removePermission(uuid, "nen.farmer");
            NenPlugin.removePermission(uuid, "nen.miner");
            NenPlugin.removePermission(uuid, "nen.butcher");

            resetClassesPermissions(target);

            NenPlugin.addPermission(uuid, "nen.class_roll");

            SetAttributes.removeAttributes(target);
        } else {
            System.out.println("Sum Ting Wong");
        }
        return true;
    }
    public static void resetClassesPermissions(Player p){
        UUID uuid = p.getUniqueId();
        NenPlugin.removePermission(uuid, "nen.berserk");
        NenPlugin.removePermission(uuid, "nen.bomber");
        NenPlugin.removePermission(uuid, "nen.builder");
        NenPlugin.removePermission(uuid, "nen.ironclad");
        NenPlugin.removePermission(uuid, "nen.mazohist");
        NenPlugin.removePermission(uuid, "nen.paladin");
        NenPlugin.removePermission(uuid, "nen.parasite");
        NenPlugin.removePermission(uuid, "nen.politic");
        NenPlugin.removePermission(uuid, "nen.roller");
        NenPlugin.removePermission(uuid, "nen.reroller");
        NenPlugin.removePermission(uuid, "nen.warrior");
        NenPlugin.removePermission(uuid, "nen.detective");
        NenPlugin.removePermission(uuid, "nen.vampire");
        NenPlugin.removePermission(uuid, "nen.archer");
        NenPlugin.removePermission(uuid, "nen.mermaid");
        NenPlugin.removePermission(uuid, "nen.werewolf");
        NenPlugin.removePermission(uuid, "nen.lich");
        NenPlugin.removePermission(uuid, "nen.spider");
        NenPlugin.removePermission(uuid, "nen.jesus");
        NenPlugin.removePermission(uuid, "nen.hellboy");
        NenPlugin.removePermission(uuid, "nen.assassin");
        NenPlugin.removePermission(uuid, "nen.martyr");

        NenPlugin.removePermission(uuid, "nen.roll");
        NenPlugin.removePermission(uuid, "nen.sunburn");
        NenPlugin.removePermission(uuid, "nen.vampirism");
        NenPlugin.removePermission(uuid, "nen.vampirism2");
        NenPlugin.removePermission(uuid, "nen.potion_reverse");
        NenPlugin.removePermission(uuid, "nen.multiply");
        NenPlugin.removePermission(uuid, "nen.bowstring");
        NenPlugin.removePermission(uuid, "nen.water_step");
        NenPlugin.removePermission(uuid, "nen.reinforcement");
        NenPlugin.removePermission(uuid, "nen.venom");
        NenPlugin.removePermission(uuid, "nen.climbing");
        NenPlugin.removePermission(uuid, "nen.rebirth");

        NenPlugin.removePermission(uuid, "purpur.enderchest.rows.one");
        NenPlugin.removePermission(uuid, "purpur.enderchest.rows.two");
        NenPlugin.removePermission(uuid, "purpur.enderchest.rows.three");
        NenPlugin.removePermission(uuid, "smoothtimber.use");
        NenPlugin.removePermission(uuid, "essentials.workbench");
        NenPlugin.removePermission(uuid, "coreprotect.inspect");
        NenPlugin.removePermission(uuid, "infinitejump.use");
        NenPlugin.removePermission(uuid, "infinitejump.3");

        NenPlugin.addPermission(uuid, "purpur.enderchest.rows.two");
        NenPlugin.addPermission(uuid, "nen.default");
    }
}
