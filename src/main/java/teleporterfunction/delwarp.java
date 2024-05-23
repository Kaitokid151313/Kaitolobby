package teleporterfunction;

import de.kaitokid1513.lobby.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class delwarp implements CommandExecutor {
    private final main plugin;

    public delwarp(main main) {
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;
        if(p.hasPermission("teleporterfunction.delwarp")) {
            if(args.length == 1) {
                File tpfile = new File(plugin.getDataFolder(), "tp.yml");
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(tpfile);

                if(cfg.contains("Warps." + args[0])) {
                    cfg.set("Nummer." + String.valueOf(cfg.getInt("Warps." +args[0] + ".Platziminv")), null);
                    cfg.set("Warps." + args[0], null);
                    try {
                        cfg.save(tpfile);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    p.sendMessage(main.prefix + "§bDer Warp wurde gelöscht.");

                } else {
                    p.sendMessage(main.prefix + "§bDieser Warp existiert nicht");
                }



            } else {
                p.sendMessage("/delwarp name");
            }
        } else {
            p.sendMessage(main.prefix + "§cYou don't have permission to use this command.");
        }



        return true;
    }
}
