package commands;

import de.kaitokid1513.lobby.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {
    private final main plugin;

    public fly(main main) {
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;

        if(p.hasPermission("lobby.fly")) {
            if(!p.getAllowFlight()) {
                p.setAllowFlight(true);
                p.sendMessage(main.prefix + "§bDu kannst nun fliegen!");
            } else {
                p.setAllowFlight(false);
                p.sendMessage(main.prefix + "§bDu kannst nun nicht mehr fliegen!");
            }



        } else {
            p.sendMessage(main.prefix + "§cYou don't have permission to use this command!");
        }


        return true;
    }
}
