package hub.guzio.MinecraftFTP;

//Main class for MinecraftFTP

//Copyright (C) Guzio 2020. All rights reserved.
//License still apply, though, I just wanted to type "All rights reserved".
//*UNLESS OTHERWISE NOTED!!!
//(i.e. if you changed something, don't hesitate to add your name)

import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    
    public static Logger logger;

    @Override
    public void onEnable() {
        logger = getLogger();

        Log("Starting MinecraftFTP transfer server, please wait...");
        //There is no ACTUAL server, it's just a bunch of commands. Sounds cooler like this, though...

        Log("[1/2] Registring commands...");
        //CMDs

        Log("[2/2] Processing SUPER...");
        super.onEnable();

        Log("MinecraftFTP - READY!!!");
    }

    public static void Log(String msg) {
        logger.log(Level.INFO, msg);
    }
}