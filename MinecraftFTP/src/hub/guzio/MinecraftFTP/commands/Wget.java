package hub.guzio.MinecraftFTP.commands;

//Wget command. Usage: /wget <filename> <URL (make sure to add protocol, e.g. "https://")>

//Copyright (C) Guzio 2020. All rights reserved.
//License still apply, though, I just wanted to type "All rights reserved".
//*UNLESS OTHERWISE NOTED!!!
//(i.e. if you changed something, don't hesitate to add your name)

import static hub.guzio.MinecraftFTP.controllers.LocationController.*;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.annotation.Nullable;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import hub.guzio.MinecraftFTP.abstracts.CommandAbs;

public class Wget extends CommandAbs{
    
    public Wget() {
		super("wget", "mcftp.filesystem");
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
        if(args.length != 2){
            sender.sendMessage("Wrong arguments.");
            return false;
        }

        //Download
        sender.sendMessage("Downloading file. BEWARE!!! This MAY crash your server, if the file is too big (downloads are synchronus right now - so they lag the server, until they're done).");
        try{
            //Taken from Ben Noland's and Jared Burrows's suggestion on https://stackoverflow.com/questions/921262/how-to-download-and-save-a-file-from-internet-using-java Unlike on MV.java, this time I ABSOLUTLEY woudn't be able to do this on my own. I suck at networking :-(
            URL website = new URL(args[1]);
            try (InputStream in = website.openStream()) {
                Files.copy(in, where_ACTUALLY_is(player).resolve(args[0]), StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch(Exception e){
            sender.sendMessage(ChatColor.RED+"A \""+e.getClass().getName()+"\" error occured: "+ChatColor.DARK_GREEN+e.getMessage());
        }

        return true;
    }
}