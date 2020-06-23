package hub.guzio.MinecraftFTP.controllers;

//Location controller for MinecraftFTP

//Copyright (C) Guzio 2020. All rights reserved.
//License still apply, though, I just wanted to type "All rights reserved".
//*UNLESS OTHERWISE NOTED!!!
//(i.e. if you changed something, don't hesitate to add your name)

import hub.guzio.MinecraftFTP.abstracts.Controller;
import static hub.guzio.MinecraftFTP.controllers.ConfigController.*;
import java.nio.file.Path;
import java.util.List;

import javax.annotation.Nullable;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LocationController extends Controller{

    private static JavaPlugin plugin;

    public LocationController(JavaPlugin plugin) {
        super("Location");
        LocationController.plugin = plugin;
        new ConfigController(plugin);
    }

    public static Path where_is(@Nullable Player player){
        List<String> players = getCf().getStringList("mcftp.loadedPlayers");
        String playerID = getPID(player);

        if(players.contains(playerID)){
            return Path.of(getCf().getString(buildPath(playerID)));
        }
        else{
            players.add(playerID);
            setCf(players, "mcftp.loadedPlayers");
            setCf(".", buildPath(playerID));
            return Path.of(".");
        }
    }

    public static Path where_ACTUALLY_is(@Nullable Player player){
        return simplifyPaths(startLocation(), where_is(player));
    }

    public static void updatePath(String change, @Nullable Player player) {
        Path path = where_is(player).resolve(Path.of(change)).normalize();
        setCf(path.toString(), buildPath(getPID(player)));
    }

    public static String buildPath(String playerID) {
        return "mcftp.locations."+playerID;
    }

    public static Path startLocation() {
        return plugin.getDataFolder().toPath();
    }

    public static Path simplifyPaths(Path home, Path merge){
        Path output = home.resolve(merge);
        return output.toAbsolutePath().normalize();
    }

    public static String getPID(@Nullable Player player){
        if(player == null){
            return "consoleBasedTypeOfMinecraftUser";
        }
        else{
            return player.getName(); //It turned out, that PIDs don't work very well and I had to change that back to PlayerName. Anyway, the name PID still exist, because I'm too lazy to update everything.
        }
    }
}