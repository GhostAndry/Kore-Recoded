package me.ghostdevelopment.kore.commands.impl.player;

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

@CommandInfo(name = "spawn", permission = "kore.spawn", permission2 = "kore.spawn.other", tabCompleter = true)
public class CommandSpawn extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("spawn.enabled"))){
            sender.sendMessage(LangFile.getString("command-disabled"));
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
                        player.sendMessage(LangFile.getString("spawn.teleported"));
                    }else{
                        player.sendMessage(LangFile.getString("spawn.nonexistent"));
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
                        if(player.hasPermission("kore.spawn.other")) {
                            Location spawn = Functions.getSpawnLocation();
                            target.teleport(spawn);
                            player.sendMessage(LangFile.getString("spawn.teleported-other"));
                        }else{
                            player.sendMessage(LangFile.getString("no-permissions"));
                            return;
                        }
                    }else{
                        player.sendMessage(LangFile.getString("spawn.nonexistent"));
                    }
                }catch (Exception e){
                    player.sendMessage(LangFile.getString("invalid-target"));
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
                        sender.sendMessage(LangFile.getString("spawn.teleported"));
                    }else{
                        sender.sendMessage(LangFile.getString("spawn.nonexistent"));
                    }
                }catch (Exception e){
                    sender.sendMessage(LangFile.getString("invalid-target"));
                }
            }else{
                sender.sendMessage(LangFile.getString("spawn.usage.console"));
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
