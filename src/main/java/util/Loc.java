package util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Loc {


    public static Location spawn() {
        File file = new File("plugins/Kaitolobby","spawn.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        if(!file.exists()) {
            return null;
        }

        double x = cfg.getDouble("Spawn.X");
        double y = cfg.getDouble("Spawn.Y");
        double z = cfg.getDouble("Spawn.Z");
        double yaw = cfg.getDouble("Spawn.Yaw");
        double pitch = cfg.getDouble("Spawn.Pitch");
        String world = cfg.getString("Spawn.World");
        Location loc = new Location(Bukkit.getWorld(world), x,y,z,(float)yaw,(float)pitch);





        return loc;

    }





}
