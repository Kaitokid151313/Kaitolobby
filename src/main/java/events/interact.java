package events;

import de.kaitokid1513.lobby.main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class interact implements Listener {
    private final main plugin;

    public interact(main main) {
        this.plugin = main;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if(!main.build.get(p)) {
            e.setCancelled(true);
        }



        if ((((e.getAction() == Action.RIGHT_CLICK_AIR) ? 1 : 0) | ((e.getAction() == Action.RIGHT_CLICK_BLOCK) ? 1 : 0)) != 0 &&
                e.getMaterial().equals(Material.COMPASS)) {
            Bukkit.dispatchCommand(p,"warp");
        }
        if ((((e.getAction() == Action.RIGHT_CLICK_AIR) ? 1 : 0) | ((e.getAction() == Action.RIGHT_CLICK_BLOCK) ? 1 : 0)) != 0 &&
                e.getItem().getItemMeta().getDisplayName().equals("§4A§6R§eC§2A§1D§9E§d!")) {
            Bukkit.dispatchCommand(p,"pocket");
        }

    }


}
