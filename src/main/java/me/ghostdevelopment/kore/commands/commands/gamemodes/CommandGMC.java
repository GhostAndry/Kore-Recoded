package me.ghostdevelopment.kore.commands.commands.gamemodes;

import me.ghostdevelopment.kore.Kore;
import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("ALL")
@CommandInfo(name = "gmc", permission = "kore.gamemode.creative", permission2 =  "kore.gamemode.*")
public class CommandGMC extends Command {

    private Kore plugin;

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(Utils.Color(LangFile.getFile().getString("gamemode.changed")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        .replaceAll("%gamemode%", player.getGameMode().name().toUpperCase())
                ));
            } else if (args.length == 1) {

                try {
                    Player target = Bukkit.getPlayer(args[0]);

                    target.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("gamemode.changed-other")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                            .replaceAll("%player%", target.getName())
                    ));
                } catch (Exception e) {
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            }
        }else{
            if(!(args.length==1)){
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("gamemode.usage.console")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }
            try {
                Player target = Bukkit.getPlayer(args[0]);

                target.setGameMode(GameMode.CREATIVE);
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("gamemode.changed-other")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                        .replaceAll("%player%", target.getName())
                ));
            } catch (Exception e) {
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
            }
        }
    }
}
