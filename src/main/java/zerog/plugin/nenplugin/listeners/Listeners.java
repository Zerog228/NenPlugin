package zerog.plugin.nenplugin.listeners;

import io.papermc.paper.world.MoonPhase;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.*;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.*;
import org.bukkit.event.raid.RaidFinishEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import zerog.plugin.nenplugin.NenPlugin;
import zerog.plugin.nenplugin.commands.AvailableCraftsCommand;
import zerog.plugin.nenplugin.commands.Roll;
import zerog.plugin.nenplugin.commands.classes.*;
import zerog.plugin.nenplugin.commands.classes.Spider;
import zerog.plugin.nenplugin.inventories.*;
import zerog.plugin.nenplugin.utils.*;
import zerog.plugin.nenplugin.utils.Timer;

import java.util.*;

import static org.bukkit.potion.PotionEffectType.*;
import static zerog.plugin.nenplugin.utils.Timer.Timer1;

public class Listeners implements Listener {

    public static Map<UUID, Boolean> paladin_effects = new HashMap<>();

    @EventHandler
    public void onPlayerInventoryEvent(InventoryClickEvent e) {

        String title = e.getView().getTitle();
        Player p = (Player) e.getView().getPlayer();

        if (InventoryAction.NOTHING != e.getAction() && title.equals(ChatColor.DARK_GRAY + "Ваши статы")) {
            StatsInventory.openStatsInventory(e);
            e.setCancelled(true);
        } else if (InventoryAction.NOTHING != e.getAction() && title.equals(ChatColor.DARK_GRAY + "Меню")) {
            MenuInventory.OpenMenu(e);
            e.setCancelled(true);
        } else if (InventoryAction.NOTHING != e.getAction() && title.equals(ChatColor.DARK_GRAY + "Помощь")) {
            HelpInventory.OpenMenu(e);
            e.setCancelled(true);
        } else if (InventoryAction.NOTHING != e.getAction() && title.equals(ChatColor.DARK_GRAY + "Классы")) {
            Classesnventory.OpenMenu(e);
            e.setCancelled(true);
        } else if (InventoryAction.NOTHING != e.getAction() && title.equals(ChatColor.RED + "Вы точно уверены?")) {
            MazohistChooseInventory.chooseInventory(e);
            e.setCancelled(true);
        } else if (InventoryAction.NOTHING != e.getAction() && title.equals(ChatColor.DARK_GRAY + "Меню крафтов")) {
            CraftsInventory.openCraftsInventory(e);
            e.setCancelled(true);
        } else if (InventoryAction.NOTHING != e.getAction() && title.equals(ChatColor.DARK_GRAY + "Список возможных крафтов")) {
            AvailableCraftsInventory.chooseInventory(e);
            e.setCancelled(true);
        } else if (InventoryAction.NOTHING != e.getAction() && (title.equals(ChatColor.DARK_GRAY + "Блоки и декор") || title.equals(ChatColor.DARK_GRAY + "Механизмы") || title.equals(ChatColor.DARK_GRAY + "Кузнечное дело") || title.equals(ChatColor.DARK_GRAY + "Плотничество"))) {
            AvailableCraftsCommand.openMenu(p);
            e.setCancelled(true);
        } else if (InventoryAction.NOTHING != e.getAction() && title.equals(ChatColor.DARK_GRAY + "Классы 2")) {
            Classes2nventory.OpenMenu(e);
            e.setCancelled(true);
        } else if ((e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE) && title.equals(ChatColor.RED + "Предметная катапульта")) {
            e.setCancelled(true);
        } else if (InventoryAction.NOTHING != e.getAction() && title.equals(ChatColor.DARK_GRAY + "Правила")) {
            RulesInventory.OpenMenu(e);
            e.setCancelled(true);
        } else if (InventoryAction.NOTHING != e.getAction() && title.equals(ChatColor.DARK_GRAY + "Улучшения")) {
            UpgradesInventory.OpenMenu(e);
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerJoinsEvent(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if (!PersistentData.checkPlayerData(p, "nen_exp")) {
            NenPlugin.addPermission(p.getUniqueId(), "nen.default");
            PersistentData.setPlayerData(p, "nen_exp", PersistentDataType.DOUBLE, 0, "");
            PersistentData.setPlayerData(p, "nen_level", PersistentDataType.INTEGER, 1, "");

            PersistentData.setPlayerData(p, "nen_upgrade_points", PersistentDataType.DOUBLE, 0, "");
            PersistentData.setPlayerData(p, "nen_points_hp", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(p, "nen_points_speed", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(p, "nen_points_armour", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(p, "nen_points_armour_t", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(p, "nen_points_damage", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(p, "nen_points_haste", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(p, "nen_points_luck", PersistentDataType.INTEGER, 0, "");

            PersistentData.setPlayerData(p, "class_number", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER, 0, "");

            PersistentData.setPlayerData(p, "nen_craft_points", PersistentDataType.DOUBLE, 1.1, "");

            PersistentData.setPlayerData(p, "nen_jewelry_upgrades", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(p, "nen_blocks_decor_upgrades", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(p, "nen_redstone_upgrades", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(p, "nen_smithing_upgrades", PersistentDataType.INTEGER, 0, "");
            PersistentData.setPlayerData(p, "nen_carpentry_upgrades", PersistentDataType.INTEGER, 0, "");

            NenPlugin.addPermission(p.getUniqueId(), "purpur.enderchest.rows.two");

            NenPlugin.addPermission(p.getUniqueId(), "nen.default");
            NenPlugin.addPermission(p.getUniqueId(), "nen.class_roll");

            SetVillagerData.setAttributes(p);

            //BanLoxov.pubbanLoxov(p);
            p.showTitle(Title.title(Component.newline().content(ChatColor.AQUA + "Добро пожаловать"), Component.newline().content(ChatColor.GREEN + "на TetsCraft"), Title.DEFAULT_TIMES));
        }
        if (!p.hasPermission("nen.class_roll")) {
            if(p.hasPermission("nen.default")) {
                int upgrade = (int) PersistentData.getPlayerData(p, "additional_upgrades", PersistentDataType.INTEGER);
                int num = (int) PersistentData.getPlayerData(p, "class_number", PersistentDataType.INTEGER);
                switch (num) {
                    case 0 -> SetVillagerData.setAttributes(p);
                    case 1 -> Bomber.setBomber(p);
                    case 2 -> Builder.setBuilder(p);
                    case 3 -> Detective.setDetective(p);
                    case 4 -> Paladin.setPaladin(p);
                    case 5 -> Parasite.setParasite(p);
                    case 6 -> Politic.setPolitic(p);
                    case 7 -> Roller.setRoller(p);
                    case 8 -> Warrior.setWarrior(p);
                    case 9 -> Vampire.setVampire(p);
                    case 10 -> Werewolf.setWerewolf(p);
                    case 11 -> Archer.setArcher(p);
                    case 12 -> Mermaid.setMermaid(p);
                    case 13 -> Lich.setLich(p);
                    case 14 -> Spider.setSpider(p);
                    case 15 -> HellBoy.setHellBoy(p);
                    case 16 -> Assassin.setAssassin(p);
                    case 17 -> Jesus.setJesus(p);
                    case 39 -> Mazohist.setMazohist(p);
                    case 40 -> Martyr.setMartyr(p);
                }
                switch (upgrade) {
                    case 1 -> SetVillagerData.setAttributes(p);
                    case 2 -> Berserk.setBerserk(p);
                    case 3 -> Ironclad.setIronclad(p);
                }
            }
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e){
        if (e.getEntity() instanceof Player p && p.hasPermission("nen.bomber")){
            if(e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION || e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION){
                e.setCancelled(true);
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 2));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 0));
            }
        }
        if (e.getEntity().hasPermission("nen.politic") || e.getEntity().hasPermission("nen.mazohist")){
            e.setDamage(e.getDamage() * 2);
        }
        if(e.getEntity().hasPermission("nen.ironclad")){
            Player p = (Player) e.getEntity();
            Pair<Boolean, Long> pair1 = Timer1(p, 10L);
            if(pair1.getValue1()/1000 > 7){
                Pair<Boolean, Long> pair2 = Timer.Timer2(p, 3L);
                e.setDamage(e.getDamage() / ((double) pair2.getValue1() / 1000));
            } else {
                e.setDamage(e.getDamage());
            }
        }
        if(e.getEntity() instanceof Player p && p.hasPermission("nen.fire_res") && (e.getCause() == EntityDamageEvent.DamageCause.FIRE || e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK || e.getCause() == EntityDamageEvent.DamageCause.LAVA)){
            p.setFireTicks(0);
            p.setVisualFire(false);
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void playerAdvancementDoneEvent(PlayerAdvancementDoneEvent e){
    }

    @EventHandler
    public void onDamageByEntity(EntityDamageByEntityEvent e){
        if(e.getDamager().hasPermission("nen.berserk")){
            Player p = (Player) e.getDamager();
            Pair<Boolean, Long> pair1 = Timer1(p, 8L);
            if(pair1.getValue1()/1000 > 5){
                Pair<Boolean, Long> pair2 = Timer.Timer2(p, 3L);
                e.setDamage(e.getDamage() * ((double) pair2.getValue1() / 1000));
            } else {
                e.setDamage(e.getDamage());
            }
        }
        if (e.getDamager().hasPermission("nen.paladin") && DifferentMaps.undead.contains(e.getEntityType())){
            e.setDamage(e.getDamage()*2);
        }
        if (e.getDamager().hasPermission("nen.vampirism")){
            Player p = (Player) e.getDamager();
            if(p.getHealth() + e.getFinalDamage() > p.getMaxHealth()){
                p.setHealth(p.getMaxHealth());
            } else {
                p.setHealth(p.getHealth() + e.getFinalDamage()/2);
            }
        }
        if(e.getEntity() instanceof Player p && p.hasPermission("nen.reinforcement") && e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK){
            LivingEntity attacker = (LivingEntity) e.getDamager();
            Pair <Boolean, Long> bool_time = (Timer.Timer1(p, 30L));
            if(bool_time.getValue0()) {
                for (int i = 0; i < 3; i++) {
                    PigZombie zombie = (PigZombie) p.getWorld().spawnEntity(p.getLocation().add(new Random().nextInt(3), 0, new Random().nextInt(3)), EntityType.ZOMBIFIED_PIGLIN);
                    zombie.setTarget(attacker);
                    zombie.attack(attacker);
                    zombie.setAngry(true);
                    zombie.setAnger(6);
                    zombie.setCustomName(ChatColor.RED+"Восставший из мёртвых "+p.getName());
                    zombie.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                }
            }
        }
        if(e.getDamager() instanceof Player p && p.hasPermission("nen.assassin") && e.getEntity() instanceof Player target){
            if(Timer.Timer1(p, 20L).getValue0()){
                p.addPotionEffect(new PotionEffect(SPEED, 200, 0, true, false));
                target.hidePlayer(NenPlugin.getPlugin(), p);
                BukkitTask task = new removeInvisibilityTask(p, target).runTaskLater(NenPlugin.getPlugin(), 200);
            }
        }
        if(e.getDamager() instanceof Player p && p.hasPermission("nen.venom") && e.getEntity() instanceof LivingEntity living){
            int i = new Random().nextInt(4);
            if(i == 0){
                living.addPotionEffect(new PotionEffect(POISON, 100, 1));
            }
        }
    }

    @EventHandler
    private void pigZombieAngerEvent(PigZombieAngerEvent e){
        if(e.getTarget() instanceof Player p && p.hasPermission("nen.reinforcement") && e.getEntity().getName().equalsIgnoreCase(ChatColor.RED+"Восставший из мёртвых "+p.getName())){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void BlockPlaceEvent(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(p.hasPermission("nen.bomber") && e.getBlockPlaced().getType() == Material.TNT && p.getInventory().getItemInMainHand().getType() == Material.TNT && e.getPlayer().isSneaking()){
            e.setCancelled(true);
            int amount = p.getInventory().getItemInMainHand().getAmount();
            p.getInventory().getItemInMainHand().setAmount(amount-1);
            Location l = e.getBlockPlaced().getLocation().add(0.5, 0, 0.5);
            e.getPlayer().getWorld().spawnEntity(l, EntityType.PRIMED_TNT);
        }
        if(p.hasPermission("nen.mazohist") && e.getBlockPlaced().getType() == Material.CRAFTING_TABLE){
            e.setCancelled(true);
        }
        if ((e.getBlockPlaced().getType() == Material.TORCH || e.getBlockPlaced().getType() == Material.WALL_TORCH) && CheckForCoal.checkCoal(e)) {
            e.getBlock().getLocation().createExplosion(6);
            e.getBlock().setType(Material.AIR);
        }
        if(p.getInventory().getItemInOffHand().hasItemMeta() && p.getInventory().getItemInOffHand().getItemMeta().hasCustomModelData() && p.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() >= 300 && p.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() <= 303){
            int blockAmount = p.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() - 298;
            if(p.getInventory().getItemInMainHand().getAmount() >= blockAmount){
                p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - blockAmount);
                while(blockAmount > 0){
                    if(e.getBlock().getLocation().add(0, blockAmount-1, 0).getBlock().getType() == Material.AIR){
                        e.getBlock().getLocation().add(0, blockAmount-1, 0).getBlock().setType(p.getInventory().getItemInMainHand().getType());
                    }
                    blockAmount--;
                }
            }

        }
        ItemMeta meta = e.getItemInHand().getItemMeta();
        if(meta != null && meta.getDisplayName().contains(ChatColor.RED+"Предметная катапульта")){
            Dispenser dispenser = (Dispenser) e.getBlockPlaced().getState();
            Directional facing = (Directional) dispenser.getBlockData();
            facing.setFacing(BlockFace.UP);
            ItemStack stack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemStack stack2 = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta meta2 = stack.getItemMeta();
            ItemMeta meta3 = stack2.getItemMeta();
            meta2.displayName(Component.newline().content(ChatColor.RED+"Пусто"));
            meta3.displayName(Component.newline().content(ChatColor.YELLOW+"Посмотрите туториал!"));
            meta2.setCustomModelData(500);
            meta3.setCustomModelData(500);
            stack.setItemMeta(meta2);
            stack2.setItemMeta(meta3);
            dispenser.getInventory().setItem(0, new ItemStack(stack));
            dispenser.getInventory().setItem(2, new ItemStack(stack));
            dispenser.getInventory().setItem(3, new ItemStack(stack));
            dispenser.getInventory().setItem(4, new ItemStack(stack2));
            dispenser.getInventory().setItem(5, new ItemStack(stack));
            dispenser.getInventory().setItem(6, new ItemStack(stack));
            dispenser.getInventory().setItem(8, new ItemStack(stack));
            e.getBlockPlaced().setBlockData(facing);
        }
    }

    @EventHandler
    public void BlockExplode(BlockExplodeEvent e){
        int i = e.blockList().size();
        for (int j = 0; j < i; j++) {
            Block b = e.blockList().get(j);
            Material m = b.getType();

            if (m == Material.COAL_ORE || m == Material.DEEPSLATE_COAL_ORE){
                b.setType(Material.AIR);
                b.getLocation().createExplosion(3);
            }
        }
    }

    @EventHandler
    public void entityExplodeEvent(EntityExplodeEvent e){
        List<Block> blocks = e.blockList();
        for(Block b : blocks){
            if(b.getType() == Material.COAL_BLOCK){
                e.setYield(0);
                int i = new Random().nextInt(4);
                if(i==0) {
                    b.getState().setType(Material.AIR);
                    b.getWorld().dropItem(b.getLocation(), new ItemStack(Material.DIAMOND));
                }
            }
        }
    }

    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(p.hasPermission("nen.bomber") && p.getInventory().getItemInOffHand().getType() == Material.TNT){
            int amount = p.getInventory().getItemInOffHand().getAmount();
            p.getInventory().getItemInOffHand().setAmount(amount-1);
            Location l = e.getPlayer().getLocation().add(0, 0.5, 0);
            Vector vk = p.getVelocity();
            vk.multiply(4);
            e.getPlayer().getWorld().spawnEntity(l, EntityType.PRIMED_TNT).setVelocity(vk);
        }
        if(CheckHoeInteract.checkHoeInteract(e)){
            int jewelry_points = (int) PersistentData.getPlayerData(p, "nen_jewelry_upgrades", PersistentDataType.INTEGER);

            int rand = new Random().nextInt(500-jewelry_points*3);

            if(rand == 0){
                createItemEmpty(Material.EMERALD, 1, Objects.requireNonNull(e.getClickedBlock()));
                e.getClickedBlock().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.4F, 1);
            } else if (rand == 1){
                createItemEmpty(Material.DIAMOND, 1, Objects.requireNonNull(e.getClickedBlock()));
                e.getClickedBlock().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.4F, 1);
            } else if (rand >= 3 && rand <= 5){
                createItemEmpty(Material.IRON_INGOT, 1, Objects.requireNonNull(e.getClickedBlock()));
                e.getClickedBlock().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.4F, 1);
            } else if (rand == 6){
                createItemEmpty(Material.HEART_OF_THE_SEA,1, Objects.requireNonNull(e.getClickedBlock()));
                e.getClickedBlock().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.4F, 1);
            }
        }
        if(p.hasPermission("nen.roller") && p.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(NenPlugin.getPlugin(), "rollers_cube"))){
            Roll.roll(p);
        }
        if(p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData() && p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() >= 300 && p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() <= 303 && e.getAction() == Action.RIGHT_CLICK_AIR && e.getPlayer().isSneaking()){
            int modelData = p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData();
            ItemStack stack = p.getInventory().getItemInMainHand();
            ItemMeta meta = p.getInventory().getItemInMainHand().getItemMeta();
            if(modelData == 303){
                meta.setCustomModelData(300);
            }else {
                meta.setCustomModelData(modelData+1);

            }
            List<Component> lore = new ArrayList<>();
            lore.add(Component.newline().content(ChatColor.AQUA+"Режим: "+ChatColor.GREEN+(meta.getCustomModelData()-298)+ChatColor.AQUA+" блоков"));
            lore.add(Component.newline().content(ChatColor.AQUA+"Нажмите"+ChatColor.GREEN+" Shift+ПКМ "+ChatColor.AQUA+"для смены режима"));
            meta.lore(lore);
            stack.setItemMeta(meta);
            p.sendMessage(ChatColor.AQUA+"Режим: "+ChatColor.GREEN+(meta.getCustomModelData()-298));
        }
    }

    @EventHandler
    public void PotionEffectEvent(EntityPotionEffectEvent e){
        EntityPotionEffectEvent.Action a = e.getAction();
        if (e.getEntity() instanceof Player p && p.hasPermission("nen.potion_reverse") && a == EntityPotionEffectEvent.Action.ADDED){
            PotionEffectType type = Objects.requireNonNull(e.getNewEffect()).getType();
            if (PotionEffectType.REGENERATION.equals(type)) {
                e.setCancelled(true);
                p.addPotionEffect(new PotionEffect(POISON, e.getNewEffect().getDuration(), e.getNewEffect().getAmplifier()));
            } else if (PotionEffectType.INCREASE_DAMAGE.equals(type)) {
                e.setCancelled(true);
                p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, e.getNewEffect().getDuration(), e.getNewEffect().getAmplifier()));
            } else if (PotionEffectType.SPEED.equals(type)) {
                e.setCancelled(true);
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, e.getNewEffect().getDuration(), e.getNewEffect().getAmplifier()));
            } else if (PotionEffectType.DAMAGE_RESISTANCE.equals(type)) {
                e.setCancelled(true);
                p.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, e.getNewEffect().getAmplifier()));
            }
        }
        if(e.getEntity() instanceof Player p && p.hasPermission("nen.paladin") && a == EntityPotionEffectEvent.Action.ADDED) {
            UUID uuid = p.getUniqueId();
            if (!paladin_effects.containsKey(uuid)){
                paladin_effects.put(p.getUniqueId(), true);
            }
            if(paladin_effects.get(uuid)){
                paladin_effects.put(uuid, false);
                e.setCancelled(true);
                p.addPotionEffect(new PotionEffect(Objects.requireNonNull(e.getNewEffect()).getType(), e.getNewEffect().getDuration(), e.getNewEffect().getAmplifier() + 1));
            }
            paladin_effects.put(uuid, true);
        }
        if(e.getEntity() instanceof Player p && p.hasPermission("nen.paladin") && a == EntityPotionEffectEvent.Action.CHANGED) {
            UUID uuid = p.getUniqueId();
            if (!paladin_effects.containsKey(uuid)){
                paladin_effects.put(p.getUniqueId(), true);
            }
            if(paladin_effects.get(uuid)){
                paladin_effects.put(uuid, false);
                e.setCancelled(true);
                p.addPotionEffect(new PotionEffect(Objects.requireNonNull(e.getNewEffect()).getType(), e.getNewEffect().getDuration(), e.getNewEffect().getAmplifier() + 1));
            }
            paladin_effects.put(uuid, true);
        }
    }
    @EventHandler
    public void PlayerDeath(PlayerDeathEvent e){
        Player p = e.getPlayer();
        if(p.hasPermission("nen.parasite")){
            double luck = Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_LUCK)).getValue();
            Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_LUCK)).setBaseValue(0);

            int k = 6;
            while(k!=0){
                SetAttributes.ParasiteDeathAttributes(p, (byte) k);
                k--;
            }

            int kill_count = p.getStatistic(Statistic.PLAYER_KILLS);

            for(int i = 0; i<kill_count; i++){
                Random rd = new Random();
                int r = rd.nextInt(6);
                SetAttributes.AddAttributes(p, (byte) r, 1.0);
            }
            Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_LUCK)).setBaseValue(luck);
        }
        if(p.getKiller() != null && p.getKiller().hasPermission("nen.parasite")){

            Player k = p.getKiller();
            int hp_points = GetPlayerUpgrades.getUpgrades(k).get((byte) 0);
            int speed_points = GetPlayerUpgrades.getUpgrades(k).get((byte) 1);
            int armour_points = GetPlayerUpgrades.getUpgrades(k).get((byte) 2);
            int armour_t_points = GetPlayerUpgrades.getUpgrades(k).get((byte) 3);
            int attack_points = GetPlayerUpgrades.getUpgrades(k).get((byte) 4);
            int haste_points = GetPlayerUpgrades.getUpgrades(k).get((byte) 5);
            int luck_points = GetPlayerUpgrades.getUpgrades(k).get((byte) 6);

            Pair<Boolean, Long> pair = Timer1(k, 120L);
            if (pair.getValue0()) {
                k.sendMessage(ChatColor.RED+"Вы чувствуете прилив сил");
                Random rd = new Random();
                int i = rd.nextInt(7);
                SetAttributes.AddUpgrades(k, (byte) i, 1.0);
                switch (i){
                    case 6-> PersistentData.setPlayerData(k, "nen_points_luck", PersistentDataType.INTEGER, luck_points+1, "");
                    case 5-> PersistentData.setPlayerData(k, "nen_points_haste", PersistentDataType.INTEGER, haste_points+1, "");
                    case 4-> PersistentData.setPlayerData(k, "nen_points_damage", PersistentDataType.INTEGER, attack_points+1, "");
                    case 3-> PersistentData.setPlayerData(k, "nen_points_armour_t", PersistentDataType.INTEGER, armour_t_points+1, "");
                    case 2-> PersistentData.setPlayerData(k, "nen_points_armour", PersistentDataType.INTEGER, armour_points+1, "");
                    case 1-> PersistentData.setPlayerData(k, "nen_points_speed", PersistentDataType.INTEGER, speed_points+1, "");
                    case 0-> PersistentData.setPlayerData(k, "nen_points_hp", PersistentDataType.INTEGER, hp_points+1, "");
                }
            } else {
                k.setStatistic(Statistic.PLAYER_KILLS, k.getStatistic(Statistic.PLAYER_KILLS) - 1);
                k.sendMessage(ChatColor.GRAY+"Вам нужно подождать ещё "+pair.getValue1()/1000);
            }
        }
        if(e.getEntity().hasPermission("nen.rebirth")){
            if(Timer.Timer2(p, 600L).getValue0()){
                p.sendMessage(ChatColor.WHITE+"Всевышние силы сжалились над вашими муками...");
                p.getWorld().spawnParticle(Particle.CLOUD, p.getLocation(), 90);
                p.addPotionEffect(new PotionEffect(LEVITATION, 60, 0));
                p.getInventory().clear();
                e.setCancelled(true);
                return;
            }
        }
        System.out.println(e.getEntity().getLocation()+" - Там умер "+e.getEntity().getName());
        p.sendMessage(ChatColor.RED+"Вы умерли на координатах: "+ChatColor.YELLOW+ e.getEntity().getLocation().getBlock().getX()+" "+e.getEntity().getLocation().getBlock().getY()+" "+e.getEntity().getLocation().getBlock().getZ());
    }

    @EventHandler
    public void OnEntityDeath(EntityDeathEvent e){
        if(e.getEntity().getKiller() != null && DifferentMaps.exp_mobs.contains(e.getEntityType())){
            Player p = e.getEntity().getKiller();
            int vindicator = p.getStatistic(Statistic.KILL_ENTITY, EntityType.VINDICATOR);
            int villager = p.getStatistic(Statistic.KILL_ENTITY, EntityType.VILLAGER);
            int witch = p.getStatistic(Statistic.KILL_ENTITY, EntityType.WITCH);
            int pillager = p.getStatistic(Statistic.KILL_ENTITY, EntityType.PILLAGER);
            int lvlFirstTotal = villager+vindicator+witch+pillager;
            switch (e.getEntityType()){
                case ENDER_DRAGON -> NenExp.addExp(p, 40);
                case WITHER, ELDER_GUARDIAN, WARDEN -> NenExp.addExp(p, 10);
                case ZOMBIE_VILLAGER, AXOLOTL, GLOW_SQUID -> NenExp.addExp(p, 1.5);
                case VEX, PHANTOM, RAVAGER, BAT, RABBIT-> NenExp.addExp(p, 1.2);
                case WITCH, ALLAY, VILLAGER, VINDICATOR, PILLAGER -> {
                    if(lvlFirstTotal < 100){
                        NenExp.addExp(p, 1);
                    }
                }
                case GHAST -> {
                    if(p.getStatistic(Statistic.KILL_ENTITY, EntityType.GHAST) < 150){
                        NenExp.addExp(p, 1.5);
                    }
                }
                case STRAY -> {
                    if(!e.getEntity().fromMobSpawner()){
                        NenExp.addExp(p, 1.2);
                    }
                }
            }
        }
        if(e.getEntity().getKiller() !=null && DifferentMaps.butcher_mobs.contains(e.getEntityType()) && e.getEntity().getKiller().hasPermission("nen.butcher")){
            Player p = e.getEntity().getKiller();
            NenExp.addExp(p, 0.04);
        }
    }

    @EventHandler
    public void OnBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Material mat = e.getBlock().getBlockData().getMaterial();
        ItemStack item = p.getInventory().getItemInMainHand();
        int jewelry_points = (int) PersistentData.getPlayerData(p, "nen_jewelry_upgrades", PersistentDataType.INTEGER);
        if (!item.containsEnchantment(Enchantment.SILK_TOUCH)) {
            int rand = new Random().nextInt(21 - jewelry_points);
            switch (mat){
                case DIAMOND_ORE, DEEPSLATE_DIAMOND_ORE -> {
                    if (mat == Material.DIAMOND_ORE){
                        NenExp.addExp(p, 0.4);
                    }else {
                        NenExp.addExp(p, 0.5);
                    }
                    switch (rand){
                        case 0 -> createItem(Material.LIME_DYE, ChatColor.GREEN + "Зелёный алмаз", 1, e.getBlock(), 1, "dia1");
                        case 1 -> createItem(Material.BLACK_DYE, ChatColor.GRAY + "Чёрный алмаз", 1, e.getBlock(), 2, "dia2");
                        case 2 -> createItem(Material.YELLOW_DYE, ChatColor.YELLOW + "Жёлтый алмаз", 1, e.getBlock(), 3, "dia3");
                        case 3 -> createItem(Material.PINK_DYE, ChatColor.LIGHT_PURPLE + "Розовый алмаз", 1, e.getBlock(), 4, "dia4");
                    }
                }
                case EMERALD_ORE, DEEPSLATE_EMERALD_ORE -> {
                    if (mat == Material.EMERALD_ORE){
                        NenExp.addExp(p, 2.0);
                    } else {
                        NenExp.addExp(p, 5.0);
                    }
                    if(rand == 0){
                        createItem(Material.EMERALD, ChatColor.GREEN + "Редкий изумруд", 1, e.getBlock());
                    }
                }
                case DEEPSLATE_COPPER_ORE, COPPER_ORE -> {
                    if (mat == Material.DEEPSLATE_COPPER_ORE){
                        NenExp.addExp(p, 0.05);
                    } else {
                        NenExp.addExp(p, 0.01);
                    }
                    if(rand == 0){
                        createItem(Material.RAW_COPPER, ChatColor.YELLOW + "Высококачественная медная руда", 1, e.getBlock());
                    }
                }
                case IRON_ORE, DEEPSLATE_IRON_ORE -> {
                    if(mat == Material.IRON_ORE){
                        NenExp.addExp(p, 0.02);
                    }else {
                        NenExp.addExp(p, 0.09);
                    }
                    if(rand == 0){
                        createItem(Material.RAW_IRON, ChatColor.GRAY + "Высококачественная железная руда", 1, e.getBlock());
                    }
                }
                case REDSTONE_ORE, DEEPSLATE_REDSTONE_ORE -> NenExp.addExp(p, 0.02);
                case GOLD_ORE, DEEPSLATE_GOLD_ORE -> {
                    if(mat == Material.GOLD_ORE){
                        NenExp.addExp(p, 0.09);
                    }else {
                        NenExp.addExp(p, 0.15);
                    }
                    if(rand == 0){
                        createItem(Material.RAW_GOLD, ChatColor.GOLD + "Высококачественная золотая руда", 1, e.getBlock());
                    }
                }
                case LAPIS_ORE, DEEPSLATE_LAPIS_ORE -> {
                    NenExp.addExp(p, 0.2);
                    if(rand == 0){
                        createItem(Material.LAPIS_LAZULI, ChatColor.BLUE + "Очаровательный лазурит", 1, e.getBlock());
                    }
                }
                case NETHER_QUARTZ_ORE -> {;
                    if(rand == 0){
                        createItem(Material.QUARTZ, ChatColor.WHITE + "Острый кварц", 1, e.getBlock());
                    }
                }
            }
            if(DifferentMaps.Ores.contains(mat) && p.hasPermission("nen.miner")){
                NenExp.addExp(p, 0.02, true);
            }
        }
        BlockData block_data = e.getBlock().getBlockData();
        if(block_data instanceof Ageable a && p.hasPermission("nen.farmer") && a.getMaximumAge() == a.getAge() && e.getBlock().getType() != Material.BAMBOO){
            NenExp.addExp(p, 0.005);
        }
        if (e.getBlock().getType() == Material.REINFORCED_DEEPSLATE && p.getGameMode() != GameMode.CREATIVE){
            e.getBlock().setType(Material.AIR);
            e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.REINFORCED_DEEPSLATE));
        }
        if (e.getBlock().hasMetadata("generatedChest") && e.getBlock().getState() instanceof Chest chest){
            chest.removeMetadata("generatedChest", NenPlugin.getPlugin());
            Inventory inv = chest.getInventory();
            for (ItemStack stack : inv.getContents()){
                if (stack == null){
                    continue;
                }
                chest.getWorld().dropItem(chest.getLocation(), stack);
                inv.remove(stack);
            }
            chest.getBlock().setType(Material.AIR);
            e.setCancelled(true);
        }
        if(item.hasItemMeta() && item.getItemMeta().hasCustomModelData() && item.getItemMeta().getCustomModelData() == 305){
            float hardness = e.getBlock().getType().getHardness();
            for(int x = 0; x < 3; x++){
                for(int y = 0; y<3; y++){
                    switch (p.getFacing()){
                        case NORTH,SOUTH -> {
                            if(e.getBlock().getLocation().add(x - 1, y - 1, 0).getBlock().getType() != Material.BEDROCK && e.getBlock().getLocation().add(x - 1, y - 1, 0).getBlock().getType() != Material.REINFORCED_DEEPSLATE && e.getBlock().getLocation().add(x - 1, y - 1, 0).getBlock().getType().getHardness() <= hardness){
                                e.getBlock().getWorld().dropItem(e.getBlock().getLocation().add(x - 1, y - 1, 0).getBlock().getLocation(), new ItemStack(e.getBlock().getLocation().add(x - 1, y - 1, 0).getBlock().getType()));
                                e.getBlock().getLocation().add(x - 1, y - 1, 0).getBlock().setType(Material.AIR);
                            }
                        }
                        case WEST,EAST -> {
                            if(e.getBlock().getLocation().add(0, y - 1, x - 1).getBlock().getType() != Material.BEDROCK && e.getBlock().getLocation().add(0, y - 1, x - 1).getBlock().getType() != Material.REINFORCED_DEEPSLATE && e.getBlock().getLocation().add(0, y - 1, x - 1).getBlock().getType().getHardness() <= hardness){
                                e.getPlayer().getWorld().dropItem(e.getBlock().getLocation().add(0, y - 1, x - 1).getBlock().getLocation(), new ItemStack(e.getBlock().getLocation().add(0, y - 1, x - 1).getBlock().getType()));
                                e.getBlock().getLocation().add(0, y - 1, x - 1).getBlock().setType(Material.AIR);
                            }
                        }
                    }
                }
            }
            Damageable damageble = (Damageable) item.getItemMeta();
            damageble.setDamage(damageble.getDamage()+9);
            item.setItemMeta(damageble);
            if (damageble.getDamage()>item.getType().getMaxDurability()){
                item.setAmount(0);
                //p.getInventory().getItemInMainHand().setType(Material.AIR);
                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
            }
            e.setCancelled(true);
        }
        if(e.getBlock().getState() instanceof Dispenser dispenser && dispenser.getCustomName() != null && dispenser.getCustomName().contains("Предметная катапульта")){
            if(dispenser.getInventory().getItem(1) != null){
                dispenser.getWorld().dropItem(dispenser.getLocation(), dispenser.getInventory().getItem(1));
            }
            if(dispenser.getInventory().getItem(7) != null){
                dispenser.getWorld().dropItem(dispenser.getLocation(), dispenser.getInventory().getItem(7));
            }
            dispenser.getInventory().clear();
            dispenser.getInventory().clear();
        }
    }

    @EventHandler
    private void inventoryMoveItemEvent(InventoryMoveItemEvent e){
        ItemStack stack = e.getItem();
        if(stack.hasItemMeta() && stack.getItemMeta().hasCustomModelData() && stack.getItemMeta().getCustomModelData() == 500) {
            e.setCancelled(true);
        }
        if(stack.hasItemMeta() && stack.getItemMeta().hasCustomModelData() && stack.getItemMeta().getCustomModelData() == 220){
            Location loc = e.getDestination().getLocation().add(0.5, 2, 0.5);
            BukkitTask task = new MagicCircleTask(60, loc).runTaskTimer(NenPlugin.getPlugin(), 2, 2);
        }
    }

    @EventHandler
    public void OnCraft(CraftItemEvent e){
        Player p = (Player) e.getWhoClicked();
        if(Objects.requireNonNull(e.getCurrentItem()).getType() == Material.NETHERITE_INGOT){
            ItemStack craftedItem = e.getInventory().getResult(); //Get result of recipe
            Inventory Inventory = e.getInventory(); //Get crafting inventory
            ClickType clickType = e.getClick();
            int realAmount = craftedItem.getAmount();
            if(clickType.isShiftClick())
            {
                int lowerAmount = craftedItem.getMaxStackSize() + 1000; //Set lower at recipe result max stack size + 1000 (or just highter max stacksize of reciped item)
                for(ItemStack actualItem : Inventory.getContents()) //For each item in crafting inventory
                {
                    if(!actualItem.getType().isAir() && lowerAmount > actualItem.getAmount() && !actualItem.getType().equals(craftedItem.getType())) //if slot is not air && lowerAmount is highter than this slot amount && it's not the recipe amount
                        lowerAmount = actualItem.getAmount(); //Set new lower amount
                }
                realAmount = lowerAmount * craftedItem.getAmount();
                NenExp.addExp(p, 5*realAmount);
            } else {
                NenExp.addExp(p, 5);
            }
        }
        Triplet<Boolean, Integer, String> triplet = CheckCraftingLevel.checkLevel(e);
        if(triplet.getValue0() || e.getRecipe().getResult().getType() == Material.OAK_SLAB || e.getRecipe().getResult().getType() == Material.COBBLESTONE_SLAB || e.getRecipe().getResult().getType() == Material.OAK_PLANKS){
            AddCraftingExperience.CraftExp(e);
        }else{
            p.sendMessage(ChatColor.DARK_GRAY+"=====================================================");
            p.sendMessage(ChatColor.RED+"У вас недостаточно уровня для крафта данного предмета!");
            p.sendMessage(ChatColor.RED+"Вам нужен уровень "+ChatColor.YELLOW+(triplet.getValue1()+1)+ChatColor.RED+" рецептов \""+ChatColor.YELLOW+triplet.getValue2()+ChatColor.RED+"\"");
            p.sendMessage(ChatColor.DARK_GRAY+"=====================================================");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void BreedEvent(EntityBreedEvent e){
        if(e.getBreeder() instanceof Player p && p.hasPermission("nen.farmer")){
            NenExp.addExp(p, 0.05);
        }
    }

    @EventHandler
    public void PlayerMoveEvent(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(p.hasPermission("nen.sunburn") && p.getLocation().getBlock().getLightFromSky() > 4 && p.getWorld().getTime() < 12300 && p.getWorld().getTime() >= 0 && !p.getWorld().hasStorm()){
            p.setFireTicks(200);
        } else if(p.hasPermission("nen.vampire") && p.getLocation().getBlock().getLightFromSky() <= 4){
            p.setVisualFire(false);
            p.addPotionEffect(new PotionEffect(NIGHT_VISION, 300, 0));
            p.addPotionEffect(new PotionEffect(SPEED, 40, 0));
        }
        if(p.hasPermission("nen.vampire") && p.getWorld().getMoonPhase().equals(MoonPhase.FULL_MOON)){
            p.addPotionEffect(new PotionEffect(INCREASE_DAMAGE, 40, 0));
            p.addPotionEffect(new PotionEffect(NIGHT_VISION, 300, 0));
        }
        if(p.hasPermission("nen.werewolf") && p.getWorld().getTime() > 12300){
            if(p.getWorld().getMoonPhase() == MoonPhase.FULL_MOON){
                p.addPotionEffect(new PotionEffect(NIGHT_VISION, 300, 0, true, false));
                p.addPotionEffect(new PotionEffect(SPEED, 40, 1, true, false));
                p.addPotionEffect(new PotionEffect(INCREASE_DAMAGE, 40, 1, true, false));
                p.addPotionEffect(new PotionEffect(FAST_DIGGING, 40, 0, true, false));
            }else {
                p.addPotionEffect(new PotionEffect(SPEED, 40, 0, true, false));
                p.addPotionEffect(new PotionEffect(INCREASE_DAMAGE, 40, 0, true, false));
            }
        }
        if(p.hasPermission("nen.werewolf")){
            if(p.getWorld().getTime() >= 0 && p.getWorld().getTime() <=20) {
                p.addPotionEffect(new PotionEffect(WEAKNESS, 1200, 0, true, false));
                p.addPotionEffect(new PotionEffect(SLOW, 1200, 0, true, false));
                p.addPotionEffect(new PotionEffect(HUNGER, 600, 1, true, false));
                p.addPotionEffect(new PotionEffect(SLOW_DIGGING, 600, 0, true, false));
                p.addPotionEffect(new PotionEffect(CONFUSION, 120, 0, true, false));
            } else if(p.getWorld().getTime() >=0 &&p.getWorld().getTime() < 12300){
                p.addPotionEffect(new PotionEffect(WEAKNESS, 120, 0, true, false));
                p.addPotionEffect(new PotionEffect(SLOW, 120, 0, true, false));
            }
        }
        double d = CompareArmor.compareArmor(p);
        if(p.getLocation().getBlock().getType() == Material.WATER || p.getLocation().getBlock().getRelative(0, 1, 0).getType() == Material.ICE) {

            if (d != 0) {
                p.setVelocity(new Vector(p.getVelocity().getX(),p.getVelocity().getY()-d, p.getVelocity().getZ()));
            }
        }
        if(p.getLocation().getBlock().getRelative(0, -1, 0).getType() == Material.ICE && d >= 0.12){
            p.getLocation().getBlock().getRelative(0, -1, 0).setType(Material.AIR);
            p.getLocation().getBlock().getRelative(1, -1, 0).setType(Material.AIR);
            p.getLocation().getBlock().getRelative(-1, -1, 0).setType(Material.AIR);
            p.getLocation().getBlock().getRelative(0, -1, 1).setType(Material.AIR);
            p.getLocation().getBlock().getRelative(0, -1, -1).setType(Material.AIR);
            p.getWorld().playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, 1F, 1.2F);
        }
        if (e.getPlayer().getLocation().getBlockY() < -100){
            p.teleport(new Location(p.getWorld(), p.getLocation().getX(), 400, p.getLocation().getZ()));
            p.addPotionEffect(new PotionEffect(DAMAGE_RESISTANCE, 300, 5));
        }
        if(p.hasPermission("nen.water_step") || p.hasPermission("nen.jesus")){
            BlockData water = Bukkit.createBlockData(Material.LIGHT_BLUE_STAINED_GLASS);
            BlockData lava = Bukkit.createBlockData(Material.ORANGE_STAINED_GLASS);
            for (int x = 0; x < 3; x++) {
                for (int z = 0; z < 3; z++) {
                    if (p.getLocation().getBlock().getRelative(x - 1, -1, z - 1).getType() == Material.WATER && p.getLocation().getBlock().getRelative(x - 1, 0, z - 1).getType() == Material.AIR) {
                        p.sendBlockChange(p.getLocation().getBlock().getRelative(x -1, -1, z - 1).getLocation(), water);
                    }
                    if (p.getLocation().getBlock().getRelative(x - 1, -1, z - 1).getType() == Material.LAVA && p.getLocation().getBlock().getRelative(x - 1, 0, z - 1).getType() == Material.AIR) {
                        p.sendBlockChange(p.getLocation().getBlock().getRelative(x -1, -1, z - 1).getLocation(), lava);
                    }
                }
            }
        }
        if(p.getName().equalsIgnoreCase("Zerog228")){
        }
    }

    @EventHandler
    public void EntityShootEvent(EntityShootBowEvent e) {
        if (e.getEntity() instanceof Player p && e.getEntity().hasPermission("nen.archer")) {
            int mult_chance = 3;
            double arrow_power = 1.5;
            if(p.hasPermission("nen.bowstring")){
                arrow_power = 2.2;
            }
            if(p.hasPermission("nen.multiply")){
                mult_chance = 2;
            }
            int rand = new Random().nextInt(mult_chance);
            if(rand == 0){
                e.setConsumeItem(false);
            }
            e.getProjectile().getWorld().spawnParticle(Particle.SMOKE_NORMAL, e.getEntity().getLocation(), 5);
            e.getProjectile().setVelocity(new Vector(e.getProjectile().getVelocity().getX() * arrow_power, e.getProjectile().getVelocity().getY() * arrow_power, e.getProjectile().getVelocity().getZ() * arrow_power));
        }
        ItemStack bow = e.getBow();
        if((Objects.requireNonNull(e.getConsumable()).getItemMeta().hasCustomModelData() && e.getConsumable().getItemMeta().getCustomModelData() == 101 || e.getEntity() instanceof Stray) && Objects.requireNonNull(bow).hasItemMeta() && bow.getItemMeta().hasCustomModelData() && bow.getItemMeta().getCustomModelData() == 200) {
            int i = new Random().nextInt(2);
            if (i == 0) {
                if (e.getEntity() instanceof Stray) {
                    SpectralArrow a = (SpectralArrow) e.getProjectile().getWorld().spawnEntity(e.getProjectile().getLocation(), EntityType.SPECTRAL_ARROW);
                    a.spawnAt(e.getProjectile().getLocation());
                    a.setVelocity(e.getProjectile().getVelocity());
                    a.setShooter(e.getEntity());
                    e.getProjectile().remove();
                    BukkitTask task = new AimingArrowsTask(20, a, e.getEntity()).runTaskTimer(NenPlugin.getPlugin(), 10, 10);
                } else {
                    SpectralArrow arrow = (SpectralArrow) e.getProjectile();
                    arrow.setShooter(e.getEntity());
                    BukkitTask task = new AimingArrowsTask(20, arrow, e.getEntity()).runTaskTimer(NenPlugin.getPlugin(), 10, 10);
                }
            }
        }
        if(Objects.requireNonNull(bow).hasItemMeta() && bow.getItemMeta().hasCustomModelData() && bow.getItemMeta().getCustomModelData() == 201){
            if((e.getConsumable().hasItemMeta() && e.getConsumable().getItemMeta().hasCustomModelData() && e.getConsumable().getItemMeta().getCustomModelData() == 101) || e.getEntity() instanceof Pillager) {
                for (int i = 0; i < 10; i++) {
                    SpectralArrow a = (SpectralArrow) e.getProjectile().getWorld().spawnEntity(e.getProjectile().getLocation(), EntityType.SPECTRAL_ARROW);
                    a.spawnAt(e.getProjectile().getLocation());
                    a.setShooter(e.getEntity());
                    a.setVelocity(e.getProjectile().getVelocity().normalize().multiply(new Vector(new Random().nextInt(2) + 1.8, new Random().nextInt(2) + 1.8, new Random().nextInt(2) + 1.8)));
                    HashMap<String, Boolean> p_map = new HashMap<>();
                    BukkitTask task = new AimingCrossbowTask(50, a, e.getEntity()).runTaskTimer(NenPlugin.getPlugin(), 3, 3);
                }
            } else {
                e.getEntity().sendMessage("Вам необходима самонаводящаяся стрела для стрельбы");
                e.setCancelled(true);
                return;
            }
        }
        if(Objects.requireNonNull(e.getBow()).containsEnchantment(Enchantment.MULTISHOT)){
            int i = e.getBow().getEnchantmentLevel(Enchantment.MULTISHOT);
            while (i>0){
                i--;
                e.getProjectile().getWorld().spawnArrow(e.getProjectile().getLocation(), e.getProjectile().getVelocity(), e.getForce()*2, 6).setShotFromCrossbow(true);
            }
            e.getProjectile().remove();
        }
    }

    @EventHandler
    private void blockDispenseEvent(BlockDispenseEvent e){
        if((String.valueOf(e.getItem().getType()).contains("SWORD") || (String.valueOf(e.getItem().getType()).contains("TRIDENT"))) && e.getBlock().getState() instanceof Dispenser d){
            int damage = 0;
            switch (e.getItem().getType()){
                case WOODEN_SWORD -> damage = 4;
                case STONE_SWORD -> damage = 5;
                case IRON_SWORD, GOLDEN_SWORD -> damage = 6;
                case DIAMOND_SWORD -> damage = 7;
                case NETHERITE_SWORD -> damage = 8;
                case TRIDENT -> damage = 9;
            }
            BukkitTask task = new DamageItemTask(d.getLocation(), e.getItem(), damage).runTaskLater(NenPlugin.getPlugin(), 1);
            e.setCancelled(true);
        }
        if(e.getBlock().getState() instanceof Dispenser dispenser && dispenser.getCustomName() != null && dispenser.getCustomName().contains(ChatColor.RED+"Предметная катапульта")){
            e.setCancelled(true);
            if(dispenser.getInventory().getItem(7) != null && dispenser.getInventory().getItem(7).getType() == Material.PAPER){
                Scanner sc = new Scanner(dispenser.getInventory().getItem(7).getItemMeta().getDisplayName());
                double x = 0;
                double z = 0;
                try {
                    x = sc.nextDouble();
                    z = sc.nextDouble();
                } catch (NoSuchElementException exception){
                    dispenser.getWorld().dropItem(dispenser.getLocation().add(0, 1, 0), new ItemStack(dispenser.getInventory().getItem(7)));
                    dispenser.getInventory().setItem(7, new ItemStack(Material.AIR));
                }
                Location destination = dispenser.getLocation().add(x, 0, z);
                double length = dispenser.getLocation().toVector().subtract(destination.toVector()).length();
                if(dispenser.getInventory().getItem(1) != null && length < 200){
                    Item throwed = dispenser.getWorld().dropItem(dispenser.getLocation().add(0.5, 1, 0.5), dispenser.getInventory().getItem(1));
                    dispenser.getInventory().setItem(1, new ItemStack(Material.AIR));
                    throwed.setVelocity(new Vector(x/28, 0, z/28).add(new Vector(0, 0.89, 0)));
                }
            }
        }
    }

    @EventHandler
    private void raidFinishEvent(RaidFinishEvent e){
        for(Player p : e.getWinners()) {
            int vindicator = p.getStatistic(Statistic.KILL_ENTITY, EntityType.VINDICATOR);
            int villager = p.getStatistic(Statistic.KILL_ENTITY, EntityType.VILLAGER);
            int witch = p.getStatistic(Statistic.KILL_ENTITY, EntityType.WITCH);
            int pillager = p.getStatistic(Statistic.KILL_ENTITY, EntityType.PILLAGER);
            int lvlFirstTotal = villager + vindicator + witch + pillager;
            if (lvlFirstTotal < 600) {
                NenExp.addExp(p, 2 * (e.getRaid().getBadOmenLevel() + 1));
            }
        }
    }

    @EventHandler
    private void playerItemConsumeEvent(PlayerItemConsumeEvent e){
        if(e.getPlayer().hasPermission("nen.werewolf") && DifferentMaps.vegetables.contains(e.getItem().getType())){
            e.getPlayer().sendMessage(ChatColor.RED+"Вы не можете есть овощи, вы оборотень!");
            e.setCancelled(true);
        }
    }

    @EventHandler
    private static void airChangeEvent(EntityAirChangeEvent e) {
        if (e.getEntity().hasPermission("nen.mermaid")) {
            Player p = (Player) e.getEntity();
            if (e.getEntity().getLocation().getBlock().getType() == Material.WATER || p.getWorld().hasStorm()) {
                e.setAmount(60);
                p.addPotionEffect(new PotionEffect(DOLPHINS_GRACE, 10, 1, true, false));
                p.addPotionEffect(new PotionEffect(NIGHT_VISION, 300, 1, true, false));
            } else if (p.getRemainingAir() > 280) {
                p.damage(2);
                e.setAmount(60);
            }
        }
    }

    @EventHandler
    public void entitySpawnEvent(CreatureSpawnEvent e){
        if (e.getEntity().getWorld().getMoonPhase() == MoonPhase.FULL_MOON){
            Objects.requireNonNull(e.getEntity().getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(Objects.requireNonNull(e.getEntity().getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue() + 5);
            e.getEntity().addPotionEffect(new PotionEffect(SPEED, 9000, 0));
            Objects.requireNonNull(e.getEntity().getAttribute(Attribute.GENERIC_ARMOR)).setBaseValue(Objects.requireNonNull(e.getEntity().getAttribute(Attribute.GENERIC_ARMOR)).getValue() + 4);
            if(e.getEntity() instanceof Creeper){
                e.getEntity().addPotionEffect(new PotionEffect(INVISIBILITY, 1200, 0, true, false));
            }
        }
        if(e.getEntity() instanceof Stray stray && !stray.fromMobSpawner() && e.getSpawnReason() != CreatureSpawnEvent.SpawnReason.FROZEN){
            int i = new Random().nextInt(3);
            ItemStack bow = new ItemStack(Material.BOW);
            ItemMeta meta = bow.getItemMeta();
            PersistentDataContainer container = meta.getPersistentDataContainer();
            container.set(new NamespacedKey("wolfyutilities", "custom_item"), PersistentDataType.STRING, "customcrafting:tool/autobow");
            meta.setCustomModelData(200);
            meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 3, true);
            List<Component> lore = new ArrayList<>();
            lore.add(Component.newline().content(ChatColor.WHITE+"Имеет шанс "+ChatColor.RED+"50% "+ChatColor.WHITE+"навестись на цель"));
            lore.add(Component.newline().content(ChatColor.GRAY+"Необходимы самонаводящиеся стрелы"));
            lore.add(Component.newline().content(ChatColor.GRAY+"для стрельбы!"));
            meta.lore(lore);
            meta.displayName(Component.newline().content(ChatColor.RED+"Самонаводящийся лук"));

            bow.setItemMeta(meta);
            if(i == 0){
                stray.setCanPickupItems(false);
                stray.setLeftHanded(false);
                stray.getEquipment().setItem(EquipmentSlot.HAND, bow);
                stray.getEquipment().setDropChance(EquipmentSlot.HAND, 0.1F);
            }
        }
    }

    @EventHandler
    public void blockBurnEvent(BlockBurnEvent e){
        if(String.valueOf(e.getBlock().getType()).contains("LOG") || String.valueOf(e.getBlock().getType()).contains("WOOD")){
            int i = new Random().nextInt(3);
            e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.CHARCOAL, i));
        }
    }

    @EventHandler
    private void itemSpawnEvent(ItemSpawnEvent e) {
        Location loc = e.getLocation();
        Item item = e.getEntity();
        boolean b = false;

        ArrayList<BlockState> chunks = new ArrayList<>();
        for (int chunkX = -1; chunkX <= 1; chunkX++) {
            for (int chunkZ = -1; chunkZ <= 1; chunkZ++) {
                chunks.addAll(Arrays.stream(loc.getBlock().getRelative(16 * chunkX, 0, 16 * chunkZ).getChunk().getTileEntities()).toList());
            }
        }

        for (BlockState blockState : chunks) {
            if (blockState instanceof Chest chest && chest.getCustomName() != null && chest.getCustomName().equalsIgnoreCase(ChatColor.RED + "Вакуумный сундук")) {
                Inventory inv = ((Chest) blockState).getBlockInventory();
                for (ItemStack stack : inv.getContents()) {
                    if (((stack == null || (Objects.equals(stack.getType(), item.getItemStack().getType())) && stack.getAmount() < item.getItemStack().getMaxStackSize() && 64 - stack.getAmount() >= item.getItemStack().getAmount()))) {
                        BukkitTask task = new VacuumChestTask(16, chest, item).runTaskTimer(NenPlugin.getPlugin(), 20, 20);
                        b = true;
                    }
                    if (b) {
                        return;
                    }
                }
            }
        }

        //TODO magnet
        if (e.getEntity().getItemStack().getType() == Material.STONE_BUTTON) {
            boolean has_data;
            try {
                has_data = e.getEntity().getItemStack().getItemMeta().getCustomModelData() == 999;
            } catch (Exception ignored) {
                has_data = false;
            }
            if (!has_data) {
                List<Entity> entities = e.getEntity().getNearbyEntities(20, 20, 20);
                for (Entity entity : entities) {
                    if (entity instanceof Player p && !p.getName().equalsIgnoreCase("Zerog228")) {
                        Bee bee = (Bee) item.getWorld().spawnEntity(item.getLocation(), EntityType.BEE);
                        bee.getEquipment().setChestplate(item.getItemStack());
                        bee.setBaby();
                        BukkitTask task = new ItemMagnetTask(20, p, bee).runTaskTimer(NenPlugin.getPlugin(), 5, 5);
                        item.remove();
                        return;
                    }
                }
            }
        }
    }

    @EventHandler
    private static void entityPickupItemEvent(EntityPickupItemEvent e){
        boolean has_data;
        try {
            has_data = e.getItem().getItemStack().getItemMeta().getCustomModelData() == 999;
        } catch (Exception ignored) {
            has_data = false;
        }
        if(has_data){
            ItemMeta meta = e.getItem().getItemStack().getItemMeta();
            meta.setCustomModelData(0);
            e.getItem().getItemStack().setItemMeta(meta);
        }
    }

    private static void createItem(Material mat, String name, int amount, Block block, int model_data, String dataname){
        ItemStack itemstack = new ItemStack(mat, amount);
        ItemMeta meta = itemstack.getItemMeta();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(new NamespacedKey("wolfyutilities", "custom_item"), PersistentDataType.STRING, "customcrafting:res/"+dataname);
        meta.displayName(Component.newline().content(name));
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        meta.setCustomModelData(model_data);
        itemstack.setItemMeta(meta);
        block.getWorld().dropItem(block.getLocation(), itemstack);
    }

    private static void createItem(Material mat, String name, int amount, Block block){
        ItemStack itemstack = new ItemStack(mat, amount);
        ItemMeta meta = itemstack.getItemMeta();
        meta.displayName(Component.newline().content(name));
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        itemstack.setItemMeta(meta);
        block.getWorld().dropItem(block.getLocation(), itemstack);
    }

    private static void createItemEmpty(Material mat, int amount, Block block){
        ItemStack itemstack = new ItemStack(mat, amount);
        ItemMeta meta = itemstack.getItemMeta();
        itemstack.setItemMeta(meta);
        block.getWorld().dropItem(block.getLocation(), itemstack);
    }
}
