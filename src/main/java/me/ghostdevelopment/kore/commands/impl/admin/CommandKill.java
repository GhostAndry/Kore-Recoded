package me.ghostdevelopment.kore.commands.impl.admin;

import me.ghostdevelopment.kore.utils.Color;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("ALL")
@CommandInfo(name = "kill", permission = "kore.kill", tabCompleter = true)
public class CommandKill extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("kill.enabled"))){
            sender.sendMessage(LangFile.getString("command-disabled"));
            return;
        }

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length==0){

                player.setHealth(0);
                player.sendMessage(LangFile.getString("kill.killed")
                        .replaceAll("%player%", player.getName()));

            } else if (args.length==1) {

                try{

                    Player target = Bukkit.getPlayer(args[0]);

                    target.setHealth(0);

                    player.sendMessage(LangFile.getString("kill.killed")
                            .replaceAll("%player%", target.getName()));

                }catch (Exception e){
                    player.sendMessage(LangFile.getString("invalid-target"));
                }

            }else{
                player.sendMessage(LangFile.getString("kill.usage.player"));
            }

        }else{

            if(args.length==1){

                try{

                    Player target = Bukkit.getPlayer(args[0]);

                    target.setHealth(0);

                    sender.sendMessage(LangFile.getString("kill.killed")
                            .replaceAll("%player%", target.getName()));

                }catch (Exception e){
                    sender.sendMessage(LangFile.getString("invalid-target"));
                }

            }else {
                sender.sendMessage(LangFile.getString("kill.usage.console"));
            }
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length==1){
            String partialName = args[0].toLowerCase();
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                String playerName = onlinePlayer.getName();
                if (playerName.toLowerCase().startsWith(partialName)) {
                    completions.add(playerName);
                }
            }
        }

        return completions;
    }
}
