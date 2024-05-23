package commands;

import de.kaitokid1513.lobby.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class setspawn implements CommandExecutor {
    private final main plugin;

    public setspawn(main main) {
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;

        if(p.hasPermission("lobby.setspawn")) {
            if(args.length == 0) {
                File file = new File("plugins/Kaitolobby","spawn.yml");
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                cfg.set("Spawn.X", p.getLocation().getX());
                cfg.set("Spawn.Y", p.getLocation().getY());
                cfg.set("Spawn.Z", p.getLocation().getZ());
                cfg.set("Spawn.Yaw", p.getLocation().getYaw());
                cfg.set("Spawn.Pitch", p.getLocation().getPitch());
                cfg.set("Spawn.World", p.getLocation().getWorld().getName());
                try {
                    cfg.save(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                p.sendMessage(main.prefix +"§bSpawn wurde gesetzt!");

            } else {
                p.sendMessage(main.prefix +"/setspawn");
            }





        } else {
            p.sendMessage(main.prefix +"§cYou don't have permission to use this command!");
        }


        return true;
    }
}
