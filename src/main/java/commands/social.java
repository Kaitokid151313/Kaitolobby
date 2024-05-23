package commands;

import de.kaitokid1513.lobby.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class social implements CommandExecutor {
    public social(main main) {
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;
        File file = new File("plugins/Kaitolobby", "social.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        String dc = cfg.getString("social.discord");
        String webseite = cfg.getString("social.webseite");
        String tiktok = cfg.getString("social.tiktok");
        String Instagram = cfg.getString("social.instagram");
        String Twitter = cfg.getString("social.twitter");

        p.sendMessage(main.prefix + "§bHey und cool, dass du dich für unsere Social Media Kanäle interessierst :)");
        p.sendMessage(main.prefix + "§bIm Folgenden findest du unsere Social Media Kanäle und die dazugehörigen Links:");
        p.sendMessage(main.prefix + "§5Discord: §7" + dc);
        p.sendMessage(main.prefix + "§4Webseite: §7" + webseite);
        p.sendMessage(main.prefix + "§dTiktok: §7" + tiktok);
        p.sendMessage(main.prefix + "§9Instagram: §7" + Instagram);
        p.sendMessage(main.prefix + "§3X/Twitter: §7" + Twitter);




        return true;
    }
}
