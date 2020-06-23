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

        //????
        List<String> folders = new File(where_ACTUALLY_is(player)).list

        //Exit
        return true;
    }
}