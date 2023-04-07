package me.ghostdevelopment.kore.bukkit.commands.commands.player;

import me.ghostdevelopment.kore.bukkit.Utils;
import me.ghostdevelopment.kore.bukkit.commands.Command;
import me.ghostdevelopment.kore.bukkit.commands.CommandInfo;
import org.bukkit.entity.Player;

@CommandInfo(name = "kore", permission = "", onlyPlayers = true)
public class CommandKore extends Command {
    @Override
    public void execute(Player player, String[] args) {
        if(args.length==0){
            player.sendMessage(Utils.Color("\n&aThis server is running Kore."));
        } else if (args.length==1) {

            switch (args[0]){
                case "info":{
                    player.sendMessage(Utils.Color("\n" +
                            "&aKore 1.6 RECODED" +
                            "&aAuthor: &7GhostAndry" +
                            "&aSpigot: &b&nhttps://www.spigotmc.org/resources/kore-1-8-x-1-19-x.107023/" +
                            "&aGitHub: &b&nhttps://github.com/GhostAndry/Kore" +
                            "\n"));
                }
                case "reload":{

                }
            }
        }
    }
}
