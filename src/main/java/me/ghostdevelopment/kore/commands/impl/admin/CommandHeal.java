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

@SuppressWarnings("all")
@CommandInfo(name = "heal", permission = "kore.heal", tabCompleter = true)
public class CommandHeal extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("heal.enabled"))) {
            sender.sendMessage(LangFile.getString("command-disabled"));
            return;
        }

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length > 1) {
                player.sendMessage(LangFile.getString("heal.usage.player"));
                return;
            }
            if (args.length == 0) {
                player.setHealth(20);
                player.setFoodLevel(40);
                player.sendMessage(LangFile.getString("heal.healed"));
            } else if (args.length == 1) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);

                    target.setHealth(20);
                    target.setFoodLevel(40);
                    player.sendMessage(LangFile.getString("heal.healed-other")
                            .replaceAll("%player%", target.getName()));
                } catch (Exception e) {
                    player.sendMessage(LangFile.getString("invalid-target"));
                    return;
                }
            }
        } else {
            if (!(args.length == 1)) {
                sender.sendMessage(LangFile.getString("heal.usage.console"));
                return;
            }

            try {
                Player target = Bukkit.getPlayer(args[0]);

                target.setFoodLevel(40);
                target.setHealth(20);
                sender.sendMessage(LangFile.getString("heal.healed-other")
                        .replaceAll("%player%", target.getName()));
            } catch (Exception e) {
                sender.sendMessage(LangFile.getString("invalid-target"));
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