package me.ghostdevelopment.kore.commands.commands;

import me.ghostdevelopment.kore.Kore;
import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

@CommandInfo(name = "fly", permission = "kore.fly")
public class CommandFly extends Command {

    private Kore plugin;

    private static ArrayList<UUID> flying = new ArrayList<>();

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(!(SettingsFile.getFile().getBoolean("fly.enabled"))){

            return;
        }

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length==0){



            }

        }
    }
}
