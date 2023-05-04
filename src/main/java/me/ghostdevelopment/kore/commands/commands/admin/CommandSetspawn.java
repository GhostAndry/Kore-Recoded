package me.ghostdevelopment.kore.commands.commands.admin;

import me.ghostdevelopment.kore.Functions;
import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("ALL")

@CommandInfo(name = "setspawn", permission = "kore.setspawn")
public class CommandSetspawn extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if (args.length==0) {
                Functions.setSpawnLoc(player.getLocation());
                player.sendMessage(Utils.Color(LangFile.getFile().getString("spawn.set")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        .replaceAll("%x%", String.valueOf(player.getLocation().getX()))
                        .replaceAll("%y%", String.valueOf(player.getLocation().getY()))
                        .replaceAll("%z%", String.valueOf(player.getLocation().getZ()))
                ));
                return;
            }
            player.sendMessage(Utils.Color(LangFile.getFile().getString("spawn.usage.player")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
        }else{
            sender.sendMessage(Utils.Color(LangFile.getFile().getString("spawn.usage.console")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
        }
    }
}
