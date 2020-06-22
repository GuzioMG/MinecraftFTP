package hub.guzio.MinecraftFTP.commands;

//PWD command. Usage: /pwd

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

public class PWD extends CommandAbs {

    public PWD() {
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
        String Loc = ""+ChatColor.YELLOW+where_is(player);
        String rLoc= ""+ChatColor.AQUA+where_ACTUALLY_is(player)+ChatColor.RESET;

        //Broadcast location
        sender.sendMessage("You're currently at "+ChatColor.GRAY+"(relative to plugin config)"+ChatColor.RESET+": "+Loc
        +"\n\n"+
        "(Which directly translates to \""+rLoc+"\".)");
        
        //Exit
        return true;
    }
}