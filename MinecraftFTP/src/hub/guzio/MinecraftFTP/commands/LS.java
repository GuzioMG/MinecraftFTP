package hub.guzio.MinecraftFTP.commands;

//List command. Usage: /ls

//Copyright (C) Guzio 2020. All rights reserved.
//License still apply, though, I just wanted to type "All rights reserved".
//*UNLESS OTHERWISE NOTED!!!
//(i.e. if you changed something, don't hesitate to add your name)

import hub.guzio.MinecraftFTP.abstracts.CommandAbs;
import javax.annotation.Nullable;
import org.bukkit.ChatColor;
import static hub.guzio.MinecraftFTP.controllers.LocationController.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LS extends CommandAbs{
    
    public LS() {
        super("pwd", "mcftp.filesystem");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //Break/exit, if sender don't have perms
        if(super.onCommand(sender, command, label, args)){return true;}
        
        //Create player
        @Nullable
        Player player = null;
        if(sender instanceof Player) player = (Player)sender;

        //Setup varibles
        File[] fileArray = where_ACTUALLY_is(player).toFile().listFiles();
        List<String> files = new ArrayList<String>();
        List<String> folders = new ArrayList<String>();
        
        //Assign files
        for (File file : fileArray) {
            if(file.isFile()){
                files.add(file.getName());
            }
        }

        //Assign folders
        for (File file : fileArray) {
            if(file.isFile()){
                folders.add(file.getName());
            }
        }

        //Gotta list 'em all!
        sender.sendMessage(ChatColor.AQUA+"Listing of "+ChatColor.YELLOW+where_is(player)+ChatColor.AQUA+": ");
        for (String folder : folders) sender.sendMessage(ChatColor.GREEN+folder);
        for (String file : files) sender.sendMessage(ChatColor.DARK_BLUE+file);
        sender.sendMessage(ChatColor.ITALIC+"Color codes: "+ChatColor.GREEN+"folders "+ChatColor.DARK_BLUE+"files");

        //Exit
        return true;
    }
}