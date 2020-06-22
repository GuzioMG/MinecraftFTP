package hub.guzio.MinecraftFTP.controllers;

import java.io.ObjectInputFilter.Config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

//Config controller for MinecraftFTP

//Copyright (C) Guzio 2020. All rights reserved.
//License still apply, though, I just wanted to type "All rights reserved".
//*UNLESS OTHERWISE NOTED!!!
//(i.e. if you changed something, don't hesitate to add your name)

import hub.guzio.MinecraftFTP.abstracts.Controller;

public class ConfigController extends Controller{
    
    public static ConfigController instance;

    private FileConfiguration config;
    private JavaPlugin plugin;
    
    public ConfigController(JavaPlugin plugin){
        instance = this;
        this.plugin = plugin;
        config = plugin.getConfig();
        config.options().copyDefaults(true);
        plugin.saveConfig();
    }

    public static FileConfiguration get() {
        return instance.config;
    }

    public static void set(Object object, Player player) {
        
    }
}