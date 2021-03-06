package hub.guzio.MinecraftFTP;

//Main class for MinecraftFTP

//Copyright (C) Guzio 2020. All rights reserved.
//License still apply, though, I just wanted to type "All rights reserved".
//*UNLESS OTHERWISE NOTED!!!
//(i.e. if you changed something, don't hesitate to add your name)

import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import hub.guzio.MinecraftFTP.commands.*;
import hub.guzio.MinecraftFTP.controllers.*;

public class Main extends JavaPlugin{
    
    public static Logger logger;

    @Override
    public void onEnable() {logger = getLogger();

        Log("[LOADER] Starting MinecraftFTP v1.0.0.0000B1@21-0 transfer server, please wait...");
        //There is no ACTUAL server, it's just a bunch of commands. Sounds cooler like this (instead of usual "loading"), though...

        Log("[LOADER/EXECUTION] [1/3] Processing SUPER...");
        super.onEnable();

        Log("[LOADER/EXECUTION] [2/3] Loading controllers...");
        new LocationController(this);

        Log("[LOADER/EXECUTION] [3/3] Registring commands...");
        this.getCommand("pwd" ).setExecutor(new PWD(true));
        this.getCommand("cd"  ).setExecutor(new CD(     ));
        this.getCommand("ls"  ).setExecutor(new LS(     ));
        this.getCommand("cat" ).setExecutor(new Cat(    ));
        this.getCommand("cp"  ).setExecutor(new Copy(   ));
        this.getCommand("mv"  ).setExecutor(new MV(     ));
        this.getCommand("wget").setExecutor(new Wget(   ));

        Log("[LOADER] MinecraftFTP - READY!!!");

    }

    public static void Log(String msg) {
        logger.log(Level.INFO, msg);
    }
}