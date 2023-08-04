package me.ghostdevelopment.kore.commands.commands.player;

import me.ghostdevelopment.kore.Functions;
import me.ghostdevelopment.kore.utils.Color;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import me.ghostdevelopment.kore.files.StorageFile;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")

@CommandInfo(name = "spawn", permission = "kore.spawn", tabCompleter = true)
public class CommandSpawn extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("spawn.enabled"))){
            sender.sendMessage(Color.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length==0){

                try {
                    if(StorageFile.getFile().contains("spawn.world")
                            ||StorageFile.getFile().contains("spawn.x")
                            ||StorageFile.getFile().contains("spawn.y")
                            ||StorageFile.getFile().contains("spawn.z")
                            ||StorageFile.getFile().contains("spawn.yaw")
                            ||StorageFile.getFile().contains("spawn.pitch")
                    ) {
                        Location spawn = Functions.getSpawnLocation();
                        player.teleport(spawn);
                        player.sendMessage(Color.Color(LangFile.getFile().getString("spawn.teleported")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }else{
                        player.sendMessage(Color.Color(LangFile.getFile().getString("spawn.nonexistent")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }
                }catch (Exception e){
                    player.sendMessage(Color.Color("&cAn error has occurred."));
                }

            } else if (args.length==1) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);

                    if(StorageFile.getFile().contains("spawn.world")
                            ||StorageFile.getFile().contains("spawn.x")
                            ||StorageFile.getFile().contains("spawn.y")
                            ||StorageFile.getFile().contains("spawn.z")
                            ||StorageFile.getFile().contains("spawn.yaw")
                            ||StorageFile.getFile().contains("spawn.pitch")
                    ) {
                        Location spawn = Functions.getSpawnLocation();
                        target.teleport(spawn);
                        player.sendMessage(Color.Color(LangFile.getFile().getString("spawn.teleported")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }else{
                        player.sendMessage(Color.Color(LangFile.getFile().getString("spawn.nonexistent")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }
                }catch (Exception e){
                    player.sendMessage(Color.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            }
        }else{
            if (args.length==1) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);

                    if(StorageFile.getFile().contains("spawn.world")
                            ||StorageFile.getFile().contains("spawn.x")
                            ||StorageFile.getFile().contains("spawn.y")
                            ||StorageFile.getFile().contains("spawn.z")
                            ||StorageFile.getFile().contains("spawn.yaw")
                            ||StorageFile.getFile().contains("spawn.pitch")
                    ) {
                        Location spawn = Functions.getSpawnLocation();
                        target.teleport(spawn);
                        sender.sendMessage(Color.Color(LangFile.getFile().getString("spawn.teleported")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }else{
                        sender.sendMessage(Color.Color(LangFile.getFile().getString("spawn.nonexistent")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }
                }catch (Exception e){
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            }else{
                sender.sendMessage(Color.Color(LangFile.getFile().getString("spawn.usage.console")
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
}
