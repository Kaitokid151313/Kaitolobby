package teleporterfunction;

import de.kaitokid1513.lobby.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class setwarp implements CommandExecutor {
    private final main plugin;

    public setwarp(main main) {
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;


        if(p.hasPermission("teleporterfunction.settp")) {
            //settp {Name} {Position(0-26} {Material/SIEHE ERKLÄRUNG KAITO} {Colorcode}
            if(args.length == 4) {
                File tpfile = new File("plugins/Kaitolobby", "tp.yml");
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(tpfile);
                if(tpfile.exists()) {
                    if(!cfg.contains("Warps." + args[0])) {
                        if(!cfg.contains("Nummer."+args[1]) && args[1] != "26") {
                            cfg.set("Warps." + args[0] + ".world", p.getWorld().getName());
                            cfg.set("Warps." + args[0] + ".x", p.getLocation().getBlockX());
                            cfg.set("Warps." + args[0] + ".y", p.getLocation().getBlockY());
                            cfg.set("Warps." + args[0] + ".z", p.getLocation().getBlockZ());
                            cfg.set("Warps." + args[0]+ ".yaw", p.getLocation().getYaw());
                            cfg.set("Warps." + args[0] + ".pitch", p.getLocation().getPitch());
                            cfg.set("Warps." + args[0]+ ".Platziminv", Integer.valueOf(args[1]));
                            cfg.set("Warps." + args[0] + ".Material",args[2]);
                            cfg.set("Warps." + args[0] + ".color", args[3]);
                            cfg.set("Nummer." +args[1], args[0]);

                            try {
                                cfg.save(tpfile);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            p.sendMessage(main.prefix + "§bDer Tppunkt wurde gesetzt!");

                        } else {
                            p.sendMessage(main.prefix + "§bDiese Nummer im System wurde bereits von " + cfg.get("Nummer."+args[1]) + "verwendet! Bitte benutze eine andere Nummer");
                        }



                    } else {
                        p.sendMessage(main.prefix +"§bDieser TPPunkt wurde bereits gesetzt, bitte nutze einen anderen Namen oder lösche diesn!");
                    }
                } else {
                    cfg.set("Warps." + args[0] + ".world", p.getWorld().getName());
                    cfg.set("Warps." + args[0] + ".x", p.getLocation().getBlockX());
                    cfg.set("Warps." + args[0] + ".y", p.getLocation().getBlockY());
                    cfg.set("Warps." + args[0] + ".z", p.getLocation().getBlockZ());
                    cfg.set("Warps." + args[0]+ ".yaw", p.getLocation().getYaw());
                    cfg.set("Warps." + args[0] + ".pitch", p.getLocation().getPitch());
                    cfg.set("Warps." + args[0]+ ".Platziminv", Integer.valueOf(args[1]));
                    cfg.set("Warps." + args[0] + ".Material",args[2]);
                    cfg.set("Warps." + args[0] + ".color", args[3]);
                    cfg.set("Nummer." +args[1], args[0]);


                    try {
                        cfg.save(tpfile);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    p.sendMessage(main.prefix + "§bDer Tppunkt wurde gesetzt!");
                }


            } else {
                p.sendMessage(main.prefix + "/settp {Name} {Position(0-26} {Material/SIEHE ERKLÄRUNG KAITO} {Colorcode mit §}");
            }


        } else {
            p.sendMessage(main.prefix +"§cYou don't have permission to use this command!");
        }






        return true;
    }
}
