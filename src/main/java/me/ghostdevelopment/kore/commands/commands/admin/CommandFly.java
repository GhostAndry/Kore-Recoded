package me.ghostdevelopment.kore.commands.commands.admin;

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
@CommandInfo(name = "fly", permission = "kore.fly", tabCompleter = true)
public class CommandFly extends KoreCommand {

    private static ArrayList<Player> flying = new ArrayList<>();

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(!(SettingsFile.getFile().getBoolean("fly.enabled"))){
            sender.sendMessage(Color.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length==0){
                if(flying.contains(player)){
                    flying.remove(player);
                    player.setAllowFlight(false);
                    player.sendMessage(Color.Color(LangFile.getFile().getString("fly.disabled")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }else{
                    flying.add(player);
                    player.setAllowFlight(true);
                    player.sendMessage(Color.Color(LangFile.getFile().getString("fly.enabled")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            } else if (args.length==1) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);

                    if (flying.contains(target)) {
                        flying.remove(target);
                        target.setAllowFlight(false);
                        player.sendMessage(Color.Color(LangFile.getFile().getString("fly.disabled-other")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%player%", target.getName())
                        ));
                        target.sendMessage(Color.Color(LangFile.getFile().getString("fly.disabled")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    } else {
                        flying.add(target);
                        target.setAllowFlight(true);
                        player.sendMessage(Color.Color(LangFile.getFile().getString("fly.enabled-other")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%player%", target.getName())
                        ));
                        target.sendMessage(Color.Color(LangFile.getFile().getString("fly.enabled")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }
                }catch (Exception e){
                    player.sendMessage(Color.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            }else{
                player.sendMessage(Color.Color(LangFile.getFile().getString("fly.usage.player")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
            }
        }else{
            if(args.length==1) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);

                    if (flying.contains(target)) {
                        flying.remove(target);
                        target.setAllowFlight(false);
                        sender.sendMessage(Color.Color(LangFile.getFile().getString("fly.disabled-other")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%player%", target.getName())
                        ));
                        target.sendMessage(Color.Color(LangFile.getFile().getString("fly.disabled")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    } else {
                        flying.add(target);
                        target.setAllowFlight(true);
                        sender.sendMessage(Color.Color(LangFile.getFile().getString("fly.enabled-other")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%player%", target.getName())
                        ));
                        target.sendMessage(Color.Color(LangFile.getFile().getString("fly.enabled")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }
                } catch (Exception e) {
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            }else{
                sender.sendMessage(Color.Color(LangFile.getFile().getString("fly.usage.console")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
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

    public static ArrayList<Player> getFlying() {
        return flying;
    }
}
