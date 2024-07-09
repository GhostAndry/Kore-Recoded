package me.ghostdevelopment.kore.commands.impl.admin;

import me.ghostdevelopment.kore.Functions;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("ALL")

@CommandInfo(name = "setspawn", permission = "kore.setspawn")
public class CommandSetspawn extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("spawn.enabled"))) {
            sender.sendMessage(LangFile.getString("command-disabled"));
            return;
        }

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {
                Functions.setSpawnLoc(player.getLocation());
                player.sendMessage(LangFile.getString("spawn.set")
                        .replaceAll("%x%", String.valueOf(player.getLocation().getX()))
                        .replaceAll("%y%", String.valueOf(player.getLocation().getY()))
                        .replaceAll("%z%", String.valueOf(player.getLocation().getZ()))
                );
                return;
            }
            player.sendMessage(LangFile.getString("spawn.usage.admin"));
        } else {
            sender.sendMessage(LangFile.getString("only-players"));
        }
    }
}
