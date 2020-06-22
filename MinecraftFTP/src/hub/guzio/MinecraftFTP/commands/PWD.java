package hub.guzio.MinecraftFTP.commands;

//PWD command. Usage: /pwd

//Copyright (C) Guzio 2020. All rights reserved.
//License still apply, though, I just wanted to type "All rights reserved".
//*UNLESS OTHERWISE NOTED!!!
//(i.e. if you changed something, don't hesitate to add your name)

import hub.guzio.MinecraftFTP.abstracts.CommandAbs;
import javax.annotation.Nullable;
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
        if(super.onCommand(sender, command, label, args)){return true;}
        
        @Nullable
        Player player = null;
        if(sender instanceof Player) player = (Player)sender;
        sender.sendMessage("You're currently at: "+where_is(player)  +"\n"+
        "(which directly translates to \""+ where_ACTUALLY_is(player) +"\").");
        return true;
    }
}