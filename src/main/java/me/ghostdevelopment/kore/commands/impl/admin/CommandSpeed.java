package me.ghostdevelopment.kore.commands.impl.admin;

import me.ghostdevelopment.kore.Functions;
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
@CommandInfo(name = "speed", permission = "kore.speed", tabCompleter = true)
public class CommandSpeed extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(SettingsFile.getFile().getBoolean("speed.enabled"))) {
            sender.sendMessage(LangFile.getString("command-disabled"));
            return;
        }

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 1 || args.length == 2 || args.length == 3) {

                if (args.length == 1) {

                    float speed;

                    try {
                        speed = Float.valueOf(args[0]);
                    } catch (NumberFormatException e) {
                        player.sendMessage(Color.Color(LangFile.getFile().getString("speed.invalid-value")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                        return;
                    }
                    if (speed > 10.0 || speed < 0.0) {
                        player.sendMessage(Color.Color(LangFile.getFile().getString("speed.invalid-value")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                        return;
                    }

                    if (player.isOnGround()) {
                        Functions.setSpeed(player, "walk", speed);
                        player.sendMessage(Color.Color(LangFile.getFile().getString("speed.set")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%speed%", String.valueOf(speed))));
                    } else {
                        Functions.setSpeed(player, "fly", speed);
                        player.sendMessage(Color.Color(LangFile.getFile().getString("speed.set")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%speed%", String.valueOf(speed))));
                    }

                    return;
                } else if (args.length == 2) {

                    Player target = Bukkit.getPlayer(args[1]);
                    float speed;

                    try {

                        try {
                            speed = Float.valueOf(args[0]);
                        } catch (NumberFormatException e) {
                            player.sendMessage(Color.Color(LangFile.getFile().getString("speed.invalid-value")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                            return;
                        }
                        if (speed > 10.0 || speed < 0.0) {
                            player.sendMessage(Color.Color(LangFile.getFile().getString("speed.invalid-value")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                            return;
                        }

                        if (target.isOnGround()) {
                            Functions.setSpeed(target, "walk", speed);
                            target.sendMessage(Color.Color(LangFile.getFile().getString("speed.set")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                    .replaceAll("%speed%", String.valueOf(speed))));
                            player.sendMessage(Color.Color(LangFile.getFile().getString("speed.set-other")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                    .replaceAll("%player%", target.getName())
                                    .replaceAll("%speed%", String.valueOf(speed))));
                        } else {
                            Functions.setSpeed(target, "fly", speed);
                            target.sendMessage(Color.Color(LangFile.getFile().getString("speed.set")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                    .replaceAll("%speed%", String.valueOf(speed))));
                            player.sendMessage(Color.Color(LangFile.getFile().getString("speed.set-other")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                    .replaceAll("%player%", target.getName())
                                    .replaceAll("%speed%", String.valueOf(speed))));
                        }
                        return;
                    }catch (Exception e){
                        sender.sendMessage(Color.Color(LangFile.getFile().getString("speed.invalid-value")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                        return;
                    }

                } else if (args.length == 3) {

                    try {
                        String type = args[2];
                        Player target = Bukkit.getPlayer(args[1]);
                        float speed;

                        try {
                            try {
                                speed = Float.valueOf(args[0]);
                            } catch (NumberFormatException e) {
                                player.sendMessage(Color.Color(LangFile.getFile().getString("speed.invalid-value")
                                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                                return;
                            }
                            if (speed > 10.0 || speed < 0.0) {
                                player.sendMessage(Color.Color(LangFile.getFile().getString("speed.invalid-value")
                                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                                return;
                            }

                            if (type.equalsIgnoreCase("walk") || type.equalsIgnoreCase("walking")) {
                                Functions.setSpeed(target, "walk", speed);
                                target.sendMessage(Color.Color(LangFile.getFile().getString("speed.set")
                                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                        .replaceAll("%speed%", String.valueOf(speed))));
                                player.sendMessage(Color.Color(LangFile.getFile().getString("speed.set-other")
                                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                        .replaceAll("%player%", target.getName())
                                        .replaceAll("%speed%", String.valueOf(speed))));
                            } else if (type.equalsIgnoreCase("fly") || type.equalsIgnoreCase("flight")) {
                                Functions.setSpeed(target, "fly", speed);
                                target.sendMessage(Color.Color(LangFile.getFile().getString("speed.set")
                                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                        .replaceAll("%speed%", String.valueOf(speed))));
                                player.sendMessage(Color.Color(LangFile.getFile().getString("speed.set-other")
                                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                        .replaceAll("%player%", target.getName())
                                        .replaceAll("%speed%", String.valueOf(speed))));
                            } else {
                                player.sendMessage(Color.Color(LangFile.getFile().getString("speed.invalid-type")
                                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                            }
                        }catch (Exception e){
                            sender.sendMessage(Color.Color(LangFile.getFile().getString("speed.invalid-value")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                            return;
                        }
                    } catch (Exception e) {
                        player.sendMessage(Color.Color(LangFile.getFile().getString("invalid-target")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                    }

                    return;

                }

            } else {
                player.sendMessage(Color.Color(LangFile.getFile().getString("speed.usage.player")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                return;
            }

        } else {

            if (args.length == 3) {
                try {
                    String type = args[2];
                    Player target = Bukkit.getPlayer(args[1]);
                    float speed;
                    try {
                        try {
                            speed = Float.valueOf(args[0]);
                        } catch (NumberFormatException e) {
                            sender.sendMessage(Color.Color(LangFile.getFile().getString("speed.invalid-value")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                            return;
                        }
                        if (speed > 10.0 || speed < 0.0) {
                            sender.sendMessage(Color.Color(LangFile.getFile().getString("speed.invalid-value")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                            return;
                        }

                        if (type.equalsIgnoreCase("walk") || type.equalsIgnoreCase("walking")) {
                            Functions.setSpeed(target, "walk", speed);
                            target.sendMessage(Color.Color(LangFile.getFile().getString("speed.set")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                    .replaceAll("%speed%", String.valueOf(speed))));
                            sender.sendMessage(Color.Color(LangFile.getFile().getString("speed.set-other")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                    .replaceAll("%player%", target.getName())
                                    .replaceAll("%speed%", String.valueOf(speed))));
                        } else if (type.equalsIgnoreCase("fly") || type.equalsIgnoreCase("flight")) {
                            Functions.setSpeed(target, "fly", speed);
                            target.sendMessage(Color.Color(LangFile.getFile().getString("speed.set")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                    .replaceAll("%speed%", String.valueOf(speed))));
                            sender.sendMessage(Color.Color(LangFile.getFile().getString("speed.set-other")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                    .replaceAll("%player%", target.getName())
                                    .replaceAll("%speed%", String.valueOf(speed))));
                        } else {
                            sender.sendMessage(Color.Color(LangFile.getFile().getString("speed.invalid-type")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                        }
                    }catch (Exception e){
                        sender.sendMessage(Color.Color(LangFile.getFile().getString("speed.invalid-value")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                        return;
                    }
                } catch (Exception e) {
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                }

                return;

            } else {
                sender.sendMessage(Color.Color(LangFile.getFile().getString("speed.usage.console")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))));
                return;
            }
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            for (float i = 0; i <= 10.0; i += 0.1) {
                completions.add(String.format("%.1f", i));
            }
        } else if (args.length == 2) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                completions.add(player.getName());
            }
        } else if (args.length == 3) {
            completions.add("walk");
            completions.add("fly");
        }

        return completions;
    }
}
