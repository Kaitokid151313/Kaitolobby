package commands;

import de.kaitokid1513.lobby.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class plugins implements CommandExecutor {
    private final main plugin;

    public plugins(main main) {
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

      /*
        Player p = (Player) commandSender;

        if(p.hasPermission("lobby.plugins")) {

        } else {
            p.sendMessage(main.prefix + "Meinst du ehrlich, wir hätten daran nicht gedacht ;)");
            p.sendMessage(main.prefix + "Aber wenn du Bock hast was über unsere Arbeitsweise zu erfahren, meld dich gerne! Wir suchen immer neue Leute :)");
        }

        */


        return true;
    }
}
