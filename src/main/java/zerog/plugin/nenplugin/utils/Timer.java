package zerog.plugin.nenplugin.utils;

import org.bukkit.entity.Player;
import org.javatuples.Pair;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Supplier;

public class Timer {

    public static HashMap<UUID, Long> timer1 = new HashMap<>();
    public static HashMap<UUID, Long> timer2 = new HashMap<>();
    public static Supplier<Long> curr_time = System::currentTimeMillis;

    public static Pair<Boolean, Long> Timer1(Player p, Long cooldown_sec){
        boolean check = true;
        UUID uuid = p.getUniqueId();
        boolean onCooldown = (timer1.containsKey(uuid) && (curr_time.get() - timer1.get(uuid) < cooldown_sec*1000));
        if(onCooldown){
            check = false;
        } else {
            timer1.put(uuid, curr_time.get());
        }
        Long time = cooldown_sec*1000 - (curr_time.get() - timer1.get(uuid));
        if(p.isOp()){check = true;}
        return new Pair<>(check, time);
    }

    public static Pair<Boolean, Long> Timer2(Player p, Long cooldown_sec){
        boolean check = true;
        UUID uuid = p.getUniqueId();
        boolean onCooldown = (timer2.containsKey(uuid) && (curr_time.get() - timer2.get(uuid) < cooldown_sec*1000));
        if(onCooldown){
            check = false;
        } else {
            timer2.put(uuid, curr_time.get());
        }
        Long time = cooldown_sec*1000 - (curr_time.get() - timer2.get(uuid));
        if(p.isOp()){check = true;}
        return new Pair<>(check, time);
    }
    public static Pair<Boolean, Long> Timer2(UUID uuid, Long cooldown_sec){
        boolean check = true;
        boolean onCooldown = (timer2.containsKey(uuid) && (curr_time.get() - timer2.get(uuid) < cooldown_sec*1000));
        if(onCooldown){
            check = false;
        } else {
            timer2.put(uuid, curr_time.get());
        }
        Long time = cooldown_sec*1000 - (curr_time.get() - timer2.get(uuid));
        return new Pair<>(check, time);
    }

}
