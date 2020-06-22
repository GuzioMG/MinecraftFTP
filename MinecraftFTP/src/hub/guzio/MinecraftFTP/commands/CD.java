package hub.guzio.MinecraftFTP.commands;

//Change directory command. Usage: /cd <location> OR /cd %home% OR /cd %up%

//Copyright (C) Guzio 2020. All rights reserved.
//License still apply, though, I just wanted to type "All rights reserved".
//*UNLESS OTHERWISE NOTED!!!
//(i.e. if you changed something, don't hesitate to add your name)

import static hub.guzio.MinecraftFTP.controllers.LocationController.*;
import java.io.File;
import javax.annotation.Nullable;
import static hub.guzio.MinecraftFTP.controllers.ConfigController.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import hub.guzio.MinecraftFTP.abstracts.CommandAbs;

public class CD extends CommandAbs{

    public CD() {
        super("cd", "mcftp.filesystem");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        //Break/exit, if sender don't have perms
        if(super.onCommand(sender, command, label, args)){return true;}
        
        //Create player
        @Nullable
        Player player = null;
        if(sender instanceof Player) player = (Player)sender;

        //Check args
        if(args.length != 1){
            sender.sendMessage("Wrong arguments.");
            return false;
        }

        //Parse args
        String newPathstring = args[0];
        if(newPathstring == "%up%") newPathstring = "..";
        else if(newPathstring == "%home%"){
            setCf(".", buildPath(getPID(player)));
            return true;
        }
        File fullpath = where_ACTUALLY_is(player).resolve(newPathstring).toFile();

        //Check for existance
        if(!(fullpath.exists()) || newPathstring == "%home%" || newPathstring == "%up%" ){
            sender.sendMessage(ChatColor.RED+"Directory does not exist!");
            return true;
        }
        if(fullpath.isFile()){
            sender.sendMessage(ChatColor.RED+"Directory is a file!");
            return false;
        }

        //Navigate
        updatePath(newPathstring, player);
        
        //Exit
        return true;
    }
}