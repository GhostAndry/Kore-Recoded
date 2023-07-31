package me.ghostdevelopment.kore.commands.commands.fun;


import me.ghostdevelopment.kore.utils.Color;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name = "spawnmob", permission = "kore.spawnmob")
public class CommandSpawnmob extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("spawnmob.enabled"))) {
            sender.sendMessage(Color.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 1) {

            } else if (args.length == 2) {
                //
            } else {
                player.sendMessage(Color.Color(LangFile.getFile().getString("spawnmob.usage")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
            }
        } else {
            sender.sendMessage(Color.Color(LangFile.getFile().getString("only-players")));
        }
    }

}
