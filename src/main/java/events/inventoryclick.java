package events;

import de.kaitokid1513.lobby.main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;

public class inventoryclick implements Listener {
    private final main plugin;

    public inventoryclick(main main) {
        this.plugin = main;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase("§bWarpmenü")) {
            e.setCancelled(true);
            ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS);
            ItemMeta meta = glass.getItemMeta();
            meta.setDisplayName("");
            glass.setItemMeta(meta);
            if(e.getCurrentItem() != glass) {
                p.closeInventory();


                File tpfile = new File(plugin.getDataFolder(), "tp.yml");
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(tpfile);
                String name = e.getCurrentItem().getItemMeta().getLore().toString().replace("[", "").replaceAll("]","");
                String world = cfg.getString("Warps."+ name + ".world");
                int x = cfg.getInt("Warps."+ name + ".x");
                int y = cfg.getInt("Warps."+ name + ".y");
                int z = cfg.getInt("Warps."+ name + ".z");
                double yaw = cfg.getDouble("Warps."+ name + ".yaw");
                double pitch = cfg.getDouble("Warps."+ name + ".pitch");
                Location loc = new Location(Bukkit.getWorld(world), x, y, z,(float) yaw,(float) pitch);
                p.teleport(loc);






            }





        } else if(e.getClickedInventory() == p.getInventory()) {
            if(!main.build.get(p)) {
                e.setCancelled(true);
            }



        }






    }

}
