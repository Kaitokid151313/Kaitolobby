package commands;

import de.kaitokid1513.lobby.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import util.Loc;

public class spawn implements CommandExecutor {
    private final main plugin;

    public spawn(main main) {
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;

        if(Loc.spawn() !=null) {
            p.teleport(Loc.spawn());
        } else {
            p.sendMessage("§cKein Spawn gesetzt!");
        }



        return true;
    }
}
