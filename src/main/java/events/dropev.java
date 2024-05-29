package events;

import de.kaitokid1513.lobby.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class dropev implements Listener {
    private final main plugin;

    public dropev(main main) {
        this.plugin = main;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }


    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        Player p = e.getPlayer();

        if(!main.build.get(p)) {
            e.setCancelled(true);
        }




    }
}
