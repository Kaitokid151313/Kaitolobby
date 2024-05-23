package commands;

import de.kaitokid1513.lobby.main;
import events.join;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class build implements CommandExecutor {
    private final main plugin;

    public build(main main) {
        this.plugin =main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;

        if(p.hasPermission("lobby.build")) {
            if(args.length == 0) {
                if(!main.build.get(p)) {
                    main.build.put(p, true);
                    p.sendMessage(main.prefix +"§bBuild wurde aktiviert.");
                    p.setGameMode(GameMode.CREATIVE);
                } else {
                    main.build.put(p, false);
                    p.sendMessage(main.prefix +"§bBuild wurde deaktiviert.");
                    p.setGameMode(GameMode.ADVENTURE);

                    join.Pinvclearandreset(p);

                }

            } else {
                p.sendMessage(main.prefix +"/build");
            }

        } else {
            p.sendMessage(main.prefix +"§cYou don't have permission to use this command!");
        }




        return true;
    }
}
