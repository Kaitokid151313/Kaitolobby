package util;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Createsocialfile {

    public static void onsocial() {
        File file = new File("plugins/Kaitolobby", "social.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);


        if(!file.exists()) {
            cfg.set("social.discord", "tba");
            cfg.set("social.webseite", "tba");
            cfg.set("social.tiktok", "tba");
            cfg.set("social.instagram", "tba");
            cfg.set("social.twitter", "tba");

            try {
                cfg.save(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }




    }






}
