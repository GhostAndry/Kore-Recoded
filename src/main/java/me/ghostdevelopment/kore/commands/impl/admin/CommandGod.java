package me.ghostdevelopment.kore.commands.impl.admin;

import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@CommandInfo(name = "god", permission = "kore.god", tabCompleter = true)
public class CommandGod extends KoreCommand {

    private static ArrayList<Player> god = new ArrayList<>();

    public static ArrayList<Player> getGod() {
        return god;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(SettingsFile.getFile().getBoolean("godmode.enabled"))) {
            sender.sendMessage(LangFile.getString("command-disabled"));
            return;
        }

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (god.contains(player)) {
                    god.remove(player);
                    player.sendMessage(LangFile.getString("god.disabled"));
                } else {
                    god.add(player);
                    player.sendMessage(LangFile.getString("god.enabled"));
                }
            } else if (args.length == 1) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (god.contains(target)) {
                        god.remove(target);
                        target.sendMessage(LangFile.getString("god.disabled"));
                        player.sendMessage(LangFile.getString("god.disabled-other")
                                .replaceAll("%player%", target.getName()));
                    } else {
                        god.add(target);
                        target.sendMessage(LangFile.getString("god.enabled"));
                        player.sendMessage(LangFile.getString("god.enabled-other")
                                .replaceAll("%player%", target.getName()));
                    }
                } catch (Exception e) {
                    player.sendMessage(LangFile.getString("invalid-target"));
                    return;
                }
            } else {
                player.sendMessage(LangFile.getString("god.usage.player"));
                return;
            }
        } else {
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (god.contains(target)) {
                    god.remove(target);
                    target.sendMessage(LangFile.getString("god.disabled"));
                    sender.sendMessage(LangFile.getString("god.disabled-other")
                            .replaceAll("%player%", target.getName()));
                } else {
                    god.add(target);
                    target.sendMessage(LangFile.getString("god.enabled"));
                    sender.sendMessage(LangFile.getString("god.enabled-other")
                            .replaceAll("%player%", target.getName()));
                }
            } else {
                sender.sendMessage(LangFile.getString("god.usage.console"));
                return;
            }
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
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
