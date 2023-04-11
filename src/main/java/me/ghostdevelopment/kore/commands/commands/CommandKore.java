package me.ghostdevelopment.kore.commands.commands;

import me.ghostdevelopment.kore.Console;
import me.ghostdevelopment.kore.Functions;
import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name = "kore")
public class CommandKore extends Command {
    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                player.sendMessage(Utils.Color("\n&aThis server is running Kore."));
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("info")) {
                    player.sendMessage(Utils.Color(
                            "&aKore 1.6 RECODED\n" +
                                    "&aAuthor: &7GhostAndry\n" +
                                    "&aGitHub: &b&nhttps://github.com/GhostAndry/Kore-Recoded\n" +
                                    "\n"));
                } else if (args[0].equalsIgnoreCase("reload")) {

                    if (!player.hasPermission("kore.reload")) {
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("no-permissions").replaceAll("%prefix%", LangFile.getFile().getString("prefix%"))
                        ));
                        return;
                    }
                    try {
                        Functions.reloadFiles();
                        sender.sendMessage(Utils.Color(LangFile.getFile().getString("reload.success")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    } catch (NullPointerException e) {
                        Bukkit.getLogger().warning(e.getMessage());
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("reload.error")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }
                }
            }
        }else{
            if (args.length == 0) {
                sender.sendMessage(Utils.Color("\n&aThis server is running Kore."));
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("info")) {
                    sender.sendMessage(Utils.Color(
                            "&aKore 1.6 RECODED\n" +
                                    "&aAuthor: &7GhostAndry\n" +
                                    "&aGitHub: &b&nhttps://github.com/GhostAndry/Kore-Recoded\n" +
                                    "\n"));
                } else if (args[0].equalsIgnoreCase("reload")) {
                    try {
                        Functions.reloadFiles();
                        sender.sendMessage(Utils.Color(LangFile.getFile().getString("reload.success")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    } catch (NullPointerException e) {
                        Bukkit.getLogger().warning(e.getMessage());
                        sender.sendMessage(Utils.Color(LangFile.getFile().getString("reload.error")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }
                }
            }
        }
    }
}
