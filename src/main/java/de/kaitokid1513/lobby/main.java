package de.kaitokid1513.lobby;

import commands.*;
import events.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import teleporterfunction.delwarp;
import teleporterfunction.setwarp;
import teleporterfunction.warp;
import util.Createsocialfile;

import java.util.HashMap;

public final class main extends JavaPlugin implements Listener {
    //TODO Shift rechts klick eins gegen eins prügeln mit stick und stick im normalen inv um Anfragen auszuschalten/settings
    //TODO Cosmetics
    //TODO Auto fly enable mit Settings


    public static String prefix = "§7[§bMineDynasty§7] ";
    public static HashMap<Player, Boolean> build = new HashMap<>();
    public static HashMap<Player, Boolean> lobbyjnr = new HashMap<>();



    @Override
    public void onEnable() {
        registercommands();
        registerevents();
        Createsocialfile.onsocial();




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
        new inventoryclick(this);
        new interact(this);
        new dropev(this);
        new commandpreprocess(this);
    }
    public void registercommands() {
        getCommand("setspawn").setExecutor(new setspawn(this));
        getCommand("spawn").setExecutor(new spawn(this));
        getCommand("build").setExecutor(new build(this));
        getCommand("setwarp").setExecutor(new setwarp(this));
        getCommand("warp").setExecutor(new warp(this));
        getCommand("delwarp").setExecutor(new delwarp(this));
        getCommand("fly").setExecutor(new fly(this));
       // getCommand("plugins").setExecutor(new plugins(this));
        getCommand("social").setExecutor(new social(this));
       // getCommand("settings").setExecutor(new settings(this));
    }



}
