package events;

import Commands.LobbyJnR;
import de.kaitokid1513.lobby.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import util.Loc;

public class move implements Listener {
    private final main plugin;

    public move(main main) {
        this.plugin = main;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();

        if(main.build.containsKey(p)) {
            if(!main.build.get(p)) {
                if(p.getLocation().getY() < 30) {
                    if(Loc.spawn() != null) {
                        p.teleport(Loc.spawn());
                    }
                }
            }
        } else {
            main.build.put(p, false);
        }
        if(main.lobbyjnr.containsKey(p)) {
            if(main.lobbyjnr.get(p)) {
                if(!Utils.infoapi.infoobjnron(p)) {
                    main.lobbyjnr.put(p, false);
                    join.Pinvclearandreset(p);
                }



            }



        } else {
            main.lobbyjnr.put(p, false);
        }



    }






}
