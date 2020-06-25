package hub.guzio.MinecraftFTP.commands;

//Cat command. Usage: /cat <filename>

//Copyright (C) Guzio 2020. All rights reserved.
//License still apply, though, I just wanted to type "All rights reserved".
//*UNLESS OTHERWISE NOTED!!!
//(i.e. if you changed something, don't hesitate to add your name)

import static hub.guzio.MinecraftFTP.controllers.LocationController.*;
import java.io.File;
import java.util.Scanner;
import javax.annotation.Nullable;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import hub.guzio.MinecraftFTP.abstracts.CommandAbs;

public class Cat extends CommandAbs{
    public static void Meow(){} //OK, I just HAD to do this...

    
    public Cat() {
        super("cat", "mcftp.filesystem");
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
        sender.sendMessage("Content of: "+ChatColor.AQUA+newPathstring);
        
        //Check for existance  (And yes, if you haven't realize, it's literally copypaste of CD command with some minor changes to it.)
        File fullpath = where_ACTUALLY_is(player).resolve(newPathstring).toFile();
        if(!(fullpath.exists())){
            sender.sendMessage(ChatColor.RED+"File does not exist!");
            return true;
        }
        if(fullpath.isFile()){
            sender.sendMessage(ChatColor.RED+"File is a directory!");
            return false;
        }

        //Give content
        try{
            Scanner scanner = new Scanner(fullpath);
            String fileContent = "";
            while(scanner.hasNextLine()){
                fileContent = fileContent+"\n"+scanner.nextLine();                     
            }
            sender.sendMessage(fileContent);
            scanner.close();
        }
        catch(Exception ex){
            sender.sendMessage(ChatColor.RED+"Well... Something went HORRIBLY wrong! Please try again.");
        }

        //Exit
        return true;
    }
}