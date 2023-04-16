package me.ghostdevelopment.kore.commands.commands;

import me.ghostdevelopment.kore.Kore;
import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("ALL")
@CommandInfo(name = "teleport", permission = "kore.teleport", permission2 = "kore.tp")
public class CommandTeleport extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("teleport.enabled"))){
            sender.sendMessage(Utils.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player){

            Player player = (Player) sender;

            if (args.length==0){
                player.sendMessage(Utils.Color(LangFile.getFile().getString("teleport.usage.player")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            } else if (args.length==1) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);
                    player.teleport(target);
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("teleport.teleported")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%player%", target.getName())
                    ));
                }catch (Exception e){
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            } else if (args.length==2) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);
                    Player target2 = Bukkit.getPlayer(args[1]);
                    target.teleport(target2);
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("teleport.teleported-other")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%player%", target.getName())
                            .replaceAll("%target%", target2.getName())
                    ));
                }catch (Exception e){
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            }else{
                player.sendMessage(Utils.Color(LangFile.getFile().getString("teleport.usage.player")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }
        }else{
            if (args.length==2) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);
                    Player target2 = Bukkit.getPlayer(args[1]);
                    target.teleport(target2);
                    sender.sendMessage(Utils.Color(LangFile.getFile().getString("teleport.teleported-other")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%player%", target.getName())
                            .replaceAll("%target%", target2.getName())
                    ));
                }catch (Exception e){
                    sender.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            }else{
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("teleport.usage.console")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }
        }
    }
}
