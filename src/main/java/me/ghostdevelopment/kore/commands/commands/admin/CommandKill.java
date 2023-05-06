package me.ghostdevelopment.kore.commands.commands.admin;

import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


@SuppressWarnings("ALL")
@CommandInfo(name = "kill", permission = "kore.kill")
public class CommandKill extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length==0){

                player.setHealth(0);
                player.sendMessage(Utils.Color(LangFile.getFile().getString("kill.killed")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        .replaceAll("%player%", player.getName())
                ));

            } else if (args.length==1) {

                try{

                    Player target = Bukkit.getPlayer(args[0]);

                    target.setHealth(0);

                    player.sendMessage(Utils.Color(LangFile.getFile().getString("kill.killed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%player%", target.getName())
                    ));

                }catch (Exception e){
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }

            }else{
                player.sendMessage(Utils.Color(LangFile.getFile().getString("kill.usage.player")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
            }

        }else{

            if(args.length==1){

                try{

                    Player target = Bukkit.getPlayer(args[0]);

                    target.setHealth(0);

                    sender.sendMessage(Utils.Color(LangFile.getFile().getString("kill.killed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%player%", target.getName())
                    ));

                }catch (Exception e){
                    sender.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }

            }else{
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("kill.usage.console")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
            }

        }

    }

}
