package me.ghostdevelopment.kore.commands.commands.admin;

import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

@SuppressWarnings("ALL")
@CommandInfo(name = "god", permission = "kore.god")
public class CommandGod extends Command {

    private static ArrayList<Player> god = new ArrayList<>();

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!(SettingsFile.getFile().getBoolean("godmode.enabled"))){
            sender.sendMessage(Utils.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length==0) {
                if (god.contains(player)) {
                    god.remove(player);
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("god.disabled")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                } else {
                    god.add(player);
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("god.enabled")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            } else if (args.length==1) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (god.contains(target)) {
                        god.remove(target);
                        target.sendMessage(Utils.Color(LangFile.getFile().getString("god.disabled")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("god.disabled-other")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%player%", target.getName())
                        ));
                    } else {
                        god.add(target);
                        target.sendMessage(Utils.Color(LangFile.getFile().getString("god.enabled")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("god.enabled-other")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%player%", target.getName())
                        ));
                    }
                }catch (Exception e){
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                    return;
                }
            }else{
                player.sendMessage(Utils.Color(LangFile.getFile().getString("god.usage.player")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }
        }else {
            if (args.length==1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (god.contains(target)) {
                    god.remove(target);
                    target.sendMessage(Utils.Color(LangFile.getFile().getString("god.disabled")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                    sender.sendMessage(Utils.Color(LangFile.getFile().getString("god.disabled-other")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%player%", target.getName())
                    ));
                } else {
                    god.add(target);
                    target.sendMessage(Utils.Color(LangFile.getFile().getString("god.enabled")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                    sender.sendMessage(Utils.Color(LangFile.getFile().getString("god.enabled-other")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%player%", target.getName())
                    ));
                }
            }else{
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("god.usage.console")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }
        }
    }

    public static ArrayList<Player> getGod() {
        return god;
    }
}
