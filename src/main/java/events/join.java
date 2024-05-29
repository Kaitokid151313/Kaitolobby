package events;

import de.kaitokid1513.lobby.main;
import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import util.Loc;
import util.createprofilefile;

import java.io.File;
import java.io.IOException;

public class join implements Listener {
    private final main plugin;

    public join(main main) {
        this.plugin = main;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();


        if(Loc.spawn() !=null) {
            Joinrun(p,Loc.spawn());
        }

        p.setHealth(20);
        p.setFoodLevel(20);

        main.build.put(p, false);


        Pinvclearandreset(p);

        createprofilefile.profilecreate(p);
        onflytest(p);

        e.setJoinMessage(main.prefix + "§eWillkommen §b" + p.getDisplayName() + "§e!");
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


    public static void Pinvclearandreset(Player p) {
        p.getInventory().clear();

        ItemStack Kompass = new ItemStack(Material.COMPASS);
        ItemMeta meta = Kompass.getItemMeta();
        meta.setDisplayName("§5Creatorporter");
        Kompass.setItemMeta(meta);
        p.getInventory().setItem(0, Kompass);



        HeadDatabaseAPI api = new HeadDatabaseAPI();
        ItemStack pocket = api.getItemHead("45830");
        ItemMeta pmeta = pocket.getItemMeta();
        pmeta.setDisplayName("§4A§6R§eC§2A§1D§9E§d!");
        pocket.setItemMeta(pmeta);
        p.getInventory().setItem(8, pocket);
    }

    public void onflytest(Player p) {
        File pfile = new File("plugins/Kaitolobby/profiles",p.getUniqueId()+".yml");
        YamlConfiguration pcfg = YamlConfiguration.loadConfiguration(pfile);
        if(!p.hasPermission("lobby.fly")) {
           if(pcfg.get("Settings.autofly").equals("true")) {
               pcfg.set("Settings.autofly", false);
               try {
                   pcfg.save(pfile);
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
           }



        }
    }




}





