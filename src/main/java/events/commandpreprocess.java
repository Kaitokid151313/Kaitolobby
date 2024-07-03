package events;

import de.kaitokid1513.lobby.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Arrays;
import java.util.List;

public class commandpreprocess implements Listener {


    private final main plugin;

    public commandpreprocess(main main) {
        this.plugin = main;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        List<String> commands = Arrays.asList("?", "pl", "about", "version", "ver", "plugins", "bukkit:?", "bukkit:pl", "bukkit:about", "bukkit:version", "bukkit:ver", "bukkit:plugins", "minecraft:pl", "minecraft:plugins", "minecraft:about", "minecraft:version", "minecraft:ver");
        commands.forEach(all -> {
            String[] arrCommand = e.getMessage().toLowerCase().split(" ", 2);
            if (arrCommand[0].equalsIgnoreCase("/" + all.toLowerCase())) {
                if(p.hasPermission("lobby.plugins")) {
                } else {
                    p.sendMessage(main.prefix + "Meinst du ehrlich, wir hätten daran nicht gedacht ;)");
                    p.sendMessage(main.prefix + "Aber wenn du Bock hast was über unsere Arbeitsweise zu erfahren, meld dich gerne! Wir suchen immer neue Leute :)");
                    e.setCancelled(true);
                }
            }



        });


    }



}
