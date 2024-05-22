package events;

import de.kaitokid1513.lobby.main;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import util.Loc;

public class join implements Listener {
    private final main plugin;

    public join(main main) {
        this.plugin = main;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(main.prefix + "§eWillkommen " + p.getDisplayName() + " §e!");

        if(Loc.spawn() !=null) {
            Joinrun(p,Loc.spawn());
        }

        p.setHealth(20);
        p.setFoodLevel(20);

        main.build.put(p, false);



    }


    public void Joinrun(Player p, Location loc) {
        BukkitRunnable task = new BukkitRunnable() {

            @Override
            public void run() {
                p.teleport(loc);


            }
        };

        task.runTaskLater(plugin, 15);


    }
}





