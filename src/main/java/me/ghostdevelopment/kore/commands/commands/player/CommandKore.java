package me.ghostdevelopment.kore.commands.commands.player;

import me.ghostdevelopment.kore.Console;
import me.ghostdevelopment.kore.Functions;
import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import org.bukkit.entity.Player;

@CommandInfo(name = "kore", onlyPlayers = true)
public class CommandKore extends Command {
    @Override
    public void execute(Player player, String[] args) {
        if(args.length==0){
            player.sendMessage(Utils.Color("\n&aThis server is running Kore."));
        } else if (args.length==1) {
            if(args[0].equalsIgnoreCase("info")) {
                player.sendMessage(Utils.Color(
                        "&aKore 1.6 RECODED\n" +
                        "&aAuthor: &7GhostAndry\n" +
                        "&aGitHub: &b&nhttps://github.com/GhostAndry/Kore-Recoded\n" +
                        "\n"));
            } else if (args[0].equalsIgnoreCase("reload")) {

                if (!player.hasPermission("kore.reload")) {
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("no-permissions").replaceAll("%prefix%", LangFile.getFile().getString("prefix%"))
                    ));
                    return;
                }
                try {
                    Functions.reloadFiles();
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("reload.success")));
                } catch (Exception e) {
                    Console.warning(e.getMessage());
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("reload.error")));
                }
            }
        }
    }
}
