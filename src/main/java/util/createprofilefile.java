package util;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class createprofilefile {


    public static void profilecreate(Player p) {
        File pfile = new File("plugins/Kaitolobby/profiles",p.getUniqueId()+".yml");
        YamlConfiguration pcfg = YamlConfiguration.loadConfiguration(pfile);





        if(!pfile.exists()) {
            pcfg.set("Settings.autofly", "false");


            try {
                pcfg.save(pfile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }



    }



}
