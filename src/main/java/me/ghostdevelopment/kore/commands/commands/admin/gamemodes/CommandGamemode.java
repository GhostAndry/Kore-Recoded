package me.ghostdevelopment.kore.commands.commands.admin.gamemodes;

import me.ghostdevelopment.kore.Kore;
import me.ghostdevelopment.kore.utils.Color;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@CommandInfo(name = "gamemode", permission = "kore.gamemode.*", permission2 = "kore.gamemode", tabCompleter = true)
public class CommandGamemode extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!(SettingsFile.getFile().getBoolean("gamemode.enabled"))){
            sender.sendMessage(Color.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length==0){
                player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.usage.player")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
            } else if (args.length==1) {
                String type = args[0];
                if(type.equalsIgnoreCase("0")){
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", player.getGameMode().name().toUpperCase())
                    ));
                } else if (type.equalsIgnoreCase("1")) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", player.getGameMode().name().toUpperCase())
                    ));
                } else if (type.equalsIgnoreCase("2")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", player.getGameMode().name().toUpperCase())
                    ));
                } else if (type.equalsIgnoreCase("3")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", player.getGameMode().name().toUpperCase())
                    ));
                } else if (type.equalsIgnoreCase("survival")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", player.getGameMode().name().toUpperCase())
                    ));
                } else if (type.equalsIgnoreCase("creative")) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", player.getGameMode().name().toUpperCase())
                    ));
                } else if (type.equalsIgnoreCase("adventure")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", player.getGameMode().name().toUpperCase())
                    ));
                } else if (type.equalsIgnoreCase("spectator")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", player.getGameMode().name().toUpperCase())
                    ));
                }
            } else if (args.length==2) {
                String type = args[0];
                Player target = Bukkit.getPlayer(args[1]);

                try{
                    if(type.equalsIgnoreCase("0")){
                        target.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                        ));
                    } else if (type.equalsIgnoreCase("1")) {
                        target.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                        ));
                    } else if (type.equalsIgnoreCase("2")) {
                        target.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                        ));
                    } else if (type.equalsIgnoreCase("3")) {
                        target.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                        ));
                    } else if (type.equalsIgnoreCase("survival")) {
                        target.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                        ));
                    } else if (type.equalsIgnoreCase("creative")) {
                        target.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                        ));
                    } else if (type.equalsIgnoreCase("adventure")) {
                        target.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                        ));
                    } else if (type.equalsIgnoreCase("spectator")) {
                        target.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                        ));
                    }
                }catch (Exception e){
                    player.sendMessage(Color.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            }
        }else{
            try{
                String type = args[0];
                Player target = Bukkit.getPlayer(args[1]);

                if(type.equalsIgnoreCase("0")){
                    target.setGameMode(GameMode.SURVIVAL);
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                    ));
                } else if (type.equalsIgnoreCase("1")) {
                    target.setGameMode(GameMode.CREATIVE);
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                    ));
                } else if (type.equalsIgnoreCase("2")) {
                    target.setGameMode(GameMode.ADVENTURE);
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                    ));
                } else if (type.equalsIgnoreCase("3")) {
                    target.setGameMode(GameMode.SPECTATOR);
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                    ));
                } else if (type.equalsIgnoreCase("survival")) {
                    target.setGameMode(GameMode.SURVIVAL);
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                    ));
                } else if (type.equalsIgnoreCase("creative")) {
                    target.setGameMode(GameMode.CREATIVE);
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                    ));
                } else if (type.equalsIgnoreCase("adventure")) {
                    target.setGameMode(GameMode.ADVENTURE);
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                    ));
                } else if (type.equalsIgnoreCase("spectator")) {
                    target.setGameMode(GameMode.SPECTATOR);
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("gamemode.changed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%gamemode%", target.getGameMode().name().toUpperCase())
                    ));
                }
            }catch (Exception e){
                sender.sendMessage(Color.Color(LangFile.getFile().getString("invalid-target")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
            }
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            String partialName = args[0].toLowerCase();
            String[] gameModes = {"survival", "creative", "adventure", "spectator", "1", "0", "2", "3"};

            for (String gameMode : gameModes) {
                if (gameMode.startsWith(partialName)) {
                    completions.add(gameMode);
                }
            }
        } else if (args.length == 2) {
            String partialName = args[1].toLowerCase();
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

/*
           _
       .__(.)< (MEOW)
        \___)
 ~~~~~~~~~~~~~~~~~~
*/
