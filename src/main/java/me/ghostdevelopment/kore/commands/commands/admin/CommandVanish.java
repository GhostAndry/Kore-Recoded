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
@CommandInfo(name = "vanish", permission = "kore.vanish", tabCompleter = true)
public class CommandVanish extends KoreCommand {

    private static ArrayList<Player> vanished = new ArrayList<>();

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("vanish.enabled"))){
            sender.sendMessage(Color.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(args.length==0){
                if(vanished.contains(player)){
                    vanished.remove(player);
                    for(Player other : Bukkit.getOnlinePlayers()){
                        if(!(other.hasPermission("kore.vanish")||other.hasPermission("kore.*")||other.hasPermission("*")||other.isOp())) {
                            other.showPlayer(player);
                        }
                    }
                    player.sendMessage(Color.Color(LangFile.getFile().getString("vanish.disabled")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }else{
                    vanished.add(player);
                    for(Player other : Bukkit.getOnlinePlayers()){
                        if(!(other.hasPermission("kore.vanish")||other.hasPermission("kore.*")||other.hasPermission("*")||other.isOp())) {
                            other.hidePlayer(player);
                        }
                    }
                    player.sendMessage(Color.Color(LangFile.getFile().getString("vanish.enabled")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            } else if (args.length==1) {
                Player target = Bukkit.getPlayer(args[0]);
                if(vanished.contains(target)){
                    vanished.remove(target);
                    for(Player other : Bukkit.getOnlinePlayers()){
                        if(!(other.hasPermission("kore.vanish")||other.hasPermission("kore.*")||other.hasPermission("*")||other.isOp())) {
                            other.showPlayer(target);
                        }
                    }
                    player.sendMessage(Color.Color(LangFile.getFile().getString("vanish.disabled-other")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%player%", target.getName())
                    ));
                }else{
                    vanished.add(target);
                    for(Player other : Bukkit.getOnlinePlayers()){
                        if(!(other.hasPermission("kore.vanish")||other.hasPermission("kore.*")||other.hasPermission("*")||other.isOp())) {
                            other.hidePlayer(target);
                        }
                    }
                    player.sendMessage(Color.Color(LangFile.getFile().getString("vanish.enabled-other")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%player%", target.getName())
                    ));
                }
            }else{
                player.sendMessage(Color.Color(LangFile.getFile().getString("vanish.usage.player")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }
        }else{
            if(args.length==1){
                Player target = Bukkit.getPlayer(args[0]);

                if(vanished.contains(target)){
                    vanished.remove(target);
                    for(Player other : Bukkit.getOnlinePlayers()){
                        if(!(other.hasPermission("kore.vanish")||other.hasPermission("kore.*")||other.hasPermission("*")||other.isOp())) {
                            other.showPlayer(target);
                        }
                    }
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("vanish.disabled-other")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%player%", target.getName())
                    ));
                }else{
                    vanished.add(target);
                    for(Player other : Bukkit.getOnlinePlayers()){
                        if(!(other.hasPermission("kore.vanish")||other.hasPermission("kore.*")||other.hasPermission("*")||other.isOp())) {
                            other.hidePlayer(target);
                        }
                    }
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("vanish.enabled-other")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%player%", target.getName())
                    ));
                }

            }else{
                sender.sendMessage(Color.Color(LangFile.getFile().getString("vanish.usage.player")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
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

    public static ArrayList<Player> getVanished() {
        return vanished;
    }
}
