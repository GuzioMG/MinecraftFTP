package hub.guzio.MinecraftFTP.controllers;


//Config controller for MinecraftFTP. It's ment to be imported statically to give the user direct acces to it's content.

//Copyright (C) Guzio 2020. All rights reserved.
//License still apply, though, I just wanted to type "All rights reserved".
//*UNLESS OTHERWISE NOTED!!!
//(i.e. if you changed something, don't hesitate to add your name)

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import hub.guzio.MinecraftFTP.abstracts.Controller;

public class ConfigController extends Controller{
    
    public static ConfigController ConfigController_Instance;

    private FileConfiguration config;
    private JavaPlugin plugin;
    
    public ConfigController(JavaPlugin plugin){
        ConfigController_Instance = this;
        this.plugin = plugin;
        config = plugin.getConfig();
        getCf().options().copyDefaults(true);
        plugin.saveConfig();
    }

    public static FileConfiguration getCf() {
        return ConfigController_Instance.config;
    }

    public static void setCf(Object object, String path) {
        ConfigController_Instance.config.set(path, object);
        ConfigController_Instance.plugin.saveConfig();
    }
}