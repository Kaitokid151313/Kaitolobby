package commands;

import de.kaitokid1513.lobby.main;
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
                if(main.build.get(p) == false) {
                    main.build.put(p, true);
                    p.sendMessage("§bBuild wurde aktiviert.");
                } else {
                    main.build.put(p, false);
                    p.sendMessage("§bBuild wurde deaktiviert.");
                }







            } else {
                p.sendMessage("/build");
            }






        } else {
            p.sendMessage("§cYou don't have permission to use this command!");
        }




        return true;
    }
}
