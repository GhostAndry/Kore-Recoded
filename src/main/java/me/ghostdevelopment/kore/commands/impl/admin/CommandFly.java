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
@CommandInfo(name = "fly", permission = "kore.fly", tabCompleter = true)
public class CommandFly extends KoreCommand {

    private static ArrayList<Player> flying = new ArrayList<>();

    public static ArrayList<Player> getFlying() {
        return flying;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("fly.enabled"))) {
            sender.sendMessage(LangFile.getString("command-disabled"));
            return;
        }

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {
                if (flying.contains(player)) {
                    flying.remove(player);
                    player.setAllowFlight(false);
                    player.sendMessage(LangFile.getString("fly.disabled"));
                } else {
                    flying.add(player);
                    player.setAllowFlight(true);
                    player.sendMessage(LangFile.getString("fly.enabled"));
                }
            } else if (args.length == 1) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);

                    if (flying.contains(target)) {
                        flying.remove(target);
                        target.setAllowFlight(false);
                        player.sendMessage(LangFile.getString("fly.disabled-other")
                                .replaceAll("%player%", target.getName()));
                        target.sendMessage(LangFile.getString("fly.disabled"));
                    } else {
                        flying.add(target);
                        target.setAllowFlight(true);
                        player.sendMessage(LangFile.getString("fly.enabled-other")
                                .replaceAll("%player%", target.getName()));
                        target.sendMessage(LangFile.getString("fly.enabled"));
                    }
                } catch (Exception e) {
                    player.sendMessage(LangFile.getString("invalid-target"));
                }
            } else {
                player.sendMessage(LangFile.getString("fly.usage.player"));
            }
        } else {
            if (args.length == 1) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);

                    if (flying.contains(target)) {
                        flying.remove(target);
                        target.setAllowFlight(false);
                        sender.sendMessage(LangFile.getString("fly.disabled-other")
                                .replaceAll("%player%", target.getName()));
                        target.sendMessage(LangFile.getString("fly.disabled"));
                    } else {
                        flying.add(target);
                        target.setAllowFlight(true);
                        sender.sendMessage(LangFile.getString("fly.enabled-other")
                                .replaceAll("%player%", target.getName()));
                        target.sendMessage(LangFile.getString("fly.enabled"));
                    }
                } catch (Exception e) {
                    sender.sendMessage(LangFile.getString("invalid-target"));
                }
            } else {
                sender.sendMessage(LangFile.getString("fly.usage.console"));
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
