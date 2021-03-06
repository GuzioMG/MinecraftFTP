package hub.guzio.MinecraftFTP.commands;

//Move command. Usage: /cp <filename> <newFilename> OR /cp <filename> <dirname> OR /cp <dirname> %newdir%

//Copyright (C) Guzio 2020. All rights reserved.
//License still apply, though, I just wanted to type "All rights reserved".
//*UNLESS OTHERWISE NOTED!!!
//(i.e. if you changed something, don't hesitate to add your name)

import hub.guzio.MinecraftFTP.abstracts.CommandAbs;
import javax.annotation.Nullable;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static hub.guzio.MinecraftFTP.controllers.LocationController.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Copy extends CommandAbs {

    public Copy() {
        super("cp", "mcftp.filesystem");
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

        //Parse args
        String source = args[0];
        String target = args[1];
        if(source.contains("/") || source.contains("\\") || target.contains("/") || target.contains("\\")){
            sender.sendMessage(ChatColor.RED+"Both paths must be placed right in the forlder you're in.");
            return true;
        }

        //Do SOMETHING with them...
        return MVcommand(sender, player, source, target);
    }

    //WELL..... OK, BEYOND THIS POINT... I HAVE NO CLUE, WHAT'S GOING ON. I'VE BEEN LITERALLY FALLING ASLEEP ON MY DESK (bad netflix), WHILE CODING THIS AND I NOW HAVE NO IDEA, WHAT'S GOING ON. LET'S JUST HOPE, IT WORKS!
    //Ok, I technically DO know, what's going on - I simply copied MV.java and slightly changed it, that's going on.

    public static boolean MVcommand(CommandSender sender, Player player, String source, String target) {
        
        try{
            Path pathS = where_ACTUALLY_is(player).resolve(source);
            if(!(pathS.toFile().exists())){
                sender.sendMessage("Source does not exist.");
                return true;
            }
            else if(target.equalsIgnoreCase("%newdir%")) return new_dir(player, pathS);
            Path pathT = where_ACTUALLY_is(player).resolve(target);
            
            if(!(pathT.toFile().exists())){
                if(pathT.toFile().isDirectory()){
                    //COPY (to a diffrent DIR)
                    Files.copy(where_ACTUALLY_is(player).resolve(source), where_ACTUALLY_is(player).resolve(target));
                }
                else{
                    //WHAT
                    sender.sendMessage("Ye, bro, u seeeeee... You're kinda tryin' to put something into a file, you know? And, u know... that's... That ani't gonna fit there, ya' know?"); //I really wanted to crate an impression of a drugged (is this even a word?) person. Visit MV.java for more info. 
                }
            }
            else{
                //COPY (to file)
                Files.copy(where_ACTUALLY_is(player).resolve(source), where_ACTUALLY_is(player).resolve(target));
            }
        }
        catch(Exception e){
            sender.sendMessage(ChatColor.RED+"Well... Something went HORRIBLY wrong! Please try again.");
        }
        return true;
    }

    public static boolean new_dir(Player player, Path newDirectory) throws Exception{
        Files.createDirectories(newDirectory);
        return true;
    }
}