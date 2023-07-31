package me.ghostdevelopment.kore.commands.commands.admin;

import me.ghostdevelopment.kore.utils.Color;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


@SuppressWarnings("ALL")
@CommandInfo(name = "kill", permission = "kore.kill")
public class CommandKill extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("kill.enabled"))){
            sender.sendMessage(Color.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length==0){

                player.setHealth(0);
                player.sendMessage(Color.Color(LangFile.getFile().getString("kill.killed")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        .replaceAll("%player%", player.getName())
                ));

            } else if (args.length==1) {

                try{

                    Player target = Bukkit.getPlayer(args[0]);

                    target.setHealth(0);

                    player.sendMessage(Color.Color(LangFile.getFile().getString("kill.killed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%player%", target.getName())
                    ));

                }catch (Exception e){
                    player.sendMessage(Color.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }

            }else{
                player.sendMessage(Color.Color(LangFile.getFile().getString("kill.usage.player")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
            }

        }else{

            if(args.length==1){

                try{

                    Player target = Bukkit.getPlayer(args[0]);

                    target.setHealth(0);

                    sender.sendMessage(Color.Color(LangFile.getFile().getString("kill.killed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%player%", target.getName())
                    ));

                }catch (Exception e){
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }

            }else{
                sender.sendMessage(Color.Color(LangFile.getFile().getString("kill.usage.console")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
            }

        }

    }

}
