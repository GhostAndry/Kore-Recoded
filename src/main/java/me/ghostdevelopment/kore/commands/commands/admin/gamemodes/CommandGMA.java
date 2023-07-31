package me.ghostdevelopment.kore.commands.commands.admin.gamemodes;

import me.ghostdevelopment.kore.utils.Color;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("ALL")
@CommandInfo(name = "gma", permission = "kore.gamemode.adventure", permission2 =  "kore.gamemode.*", permission3 = "kore.gamemode")
public class CommandGMA extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!(SettingsFile.getFile().getBoolean("gamemode.enabled"))){
            sender.sendMessage(Color.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        .replaceAll("%gamemode%", player.getGameMode().name().toUpperCase())
                ));
            } else if (args.length == 1) {

                try {
                    Player target = Bukkit.getPlayer(args[0]);

                    target.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed-other")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                            .replaceAll("%player%", target.getName())
                    ));
                } catch (Exception e) {
                    player.sendMessage(Color.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            }
        }else{
            if(!(args.length==1)){
                sender.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.usage.console")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }
            try {
                Player target = Bukkit.getPlayer(args[0]);

                target.setGameMode(GameMode.ADVENTURE);
                sender.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed-other")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                        .replaceAll("%player%", target.getName())
                ));
            } catch (Exception e) {
                sender.sendMessage(Color.Color(LangFile.getFile().getString("invalid-target")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
            }
        }
    }
}
