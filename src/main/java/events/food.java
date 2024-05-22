package events;

import de.kaitokid1513.lobby.main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class food implements Listener {
    private final main plugin;

    public food(main main) {
        this.plugin = main;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);

    }


    @EventHandler
    public void onfood(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onkill(EntitySpawnEvent e) {
        e.setCancelled(true);
    }



}
