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
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LocationController extends Controller{

    private static JavaPlugin plugin;

    protected LocationController(JavaPlugin plugin) {
        super("Location");
        LocationController.plugin = plugin;
        new ConfigController(plugin);
    }

    public static Path where_is(Player player){
        List<String> players = getCf().getStringList("mcftp.loadedPlayers");
        String playerID = player.getUniqueId().toString();

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

    public static Path where_ACTUALLY_is(Player player){
        return simplifyPaths(startLocation(), where_is(player));
    }

    public static void updatePath(String change, Player player) {
        Path path = simplifyPaths(where_is(player), Path.of(change));
        setCf(path.toString(), buildPath(player.getUniqueId().toString()));
    }

    public static String buildPath(String playerID) {
        return "mcftp.locations."+playerID;
    }

    public static Path startLocation() {
        return plugin.getDataFolder().toPath();
    }

    public static Path simplifyPaths(Path home, Path merge){
        Path output = home.resolve(merge);
        return output.toAbsolutePath();
    }
}