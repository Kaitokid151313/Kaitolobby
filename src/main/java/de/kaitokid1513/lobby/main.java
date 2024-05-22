package de.kaitokid1513.lobby;

import commands.setspawn;
import commands.spawn;
import commands.build;
import events.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class main extends JavaPlugin implements Listener {

    public static String prefix = "§7[§bCreatorwave§7] ";
    public static HashMap<Player, Boolean> build = new HashMap<>();




    @Override
    public void onEnable() {
        registercommands();
       registerevents();





        System.out.println("Lobby has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerevents() {
        getServer().getPluginManager().registerEvents(this,this);
        new join(this);
        new Damage(this);
        new food(this);
        new blockplacebreak(this);
        new move(this);
    }
    public void registercommands() {
        getCommand("setspawn").setExecutor(new setspawn(this));
        getCommand("spawn").setExecutor(new spawn(this));
        getCommand("build").setExecutor(new build(this));
    }



}
