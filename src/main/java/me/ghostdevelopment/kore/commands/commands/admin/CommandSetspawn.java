package me.ghostdevelopment.kore.commands.commands.admin;

import me.ghostdevelopment.kore.Functions;
import me.ghostdevelopment.kore.utils.Color;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("ALL")

@CommandInfo(name = "setspawn", permission = "kore.setspawn")
public class CommandSetspawn extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("spawn.enabled"))){
            sender.sendMessage(Color.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player){

            Player player = (Player) sender;

            if (args.length==0) {
                Functions.setSpawnLoc(player.getLocation());
                player.sendMessage(Color.Color(LangFile.getFile().getString("spawn.set")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        .replaceAll("%x%", String.valueOf(player.getLocation().getX()))
                        .replaceAll("%y%", String.valueOf(player.getLocation().getY()))
                        .replaceAll("%z%", String.valueOf(player.getLocation().getZ()))
                ));
                return;
            }
            player.sendMessage(Color.Color(LangFile.getFile().getString("spawn.usage.admin")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
        }else{
            sender.sendMessage(Color.Color(LangFile.getFile().getString("only-players")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
        }
    }
}
