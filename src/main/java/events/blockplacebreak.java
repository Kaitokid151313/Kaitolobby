package events;

import de.kaitokid1513.lobby.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class blockplacebreak implements Listener {
    private final main plugin;

    public blockplacebreak(main main) {
        this.plugin = main;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player p = event.getPlayer();
        if(main.build.get(p) == true) {

        } else {
            event.setCancelled(true);
        }
    }
@EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
    Player p = event.getPlayer();
    if(main.build.get(p) == true) {

    } else {
        event.setCancelled(true);
    }
}


}
