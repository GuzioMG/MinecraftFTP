package hub.guzio.MinecraftFTP.abstracts;

//Command abstract for MinecraftFTP.

//Copyright (C) Guzio 2020. All rights reserved.
//License still apply, though, I just wanted to type "All rights reserved".
//*UNLESS OTHERWISE NOTED!!!
//(i.e. if you changed something, don't hesitate to add your name)

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.command.Command;
import static hub.guzio.MinecraftFTP.Main.Log;

public abstract class CommandAbs implements CommandExecutor{

    public String CommandText;
    public String perm;

    protected CommandAbs(String commandText, String perm){
        CommandText = commandText;
        this.perm = perm;
        Log("Registred /"+CommandText+" command.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(((sender.hasPermission(new Permission(perm))) || sender.isOp()) && (command.getName().equalsIgnoreCase(CommandText))){
            return false; //A. K. A. Don't break/exit.
        }
        return true; //A. K. A. Break/exit.
    }
}