package me.ghostdevelopment.kore.commands.commands.player;

import me.ghostdevelopment.kore.Functions;
import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import me.ghostdevelopment.kore.files.StorageFile;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("ALL")

@CommandInfo(name = "spawn", permission = "kore.spawn")
public class CommandSpawn extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("spawn.enabled"))){
            sender.sendMessage(Utils.Color(LangFile.getFile().getString("command-disabled")
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
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("spawn.teleported")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }else{
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("spawn.nonexistent")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }
                }catch (Exception e){
                    player.sendMessage(Utils.Color("&cAn error has occurred."));
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
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("spawn.teleported")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }else{
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("spawn.nonexistent")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }
                }catch (Exception e){
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
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
                        sender.sendMessage(Utils.Color(LangFile.getFile().getString("spawn.teleported")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }else{
                        sender.sendMessage(Utils.Color(LangFile.getFile().getString("spawn.nonexistent")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }
                }catch (Exception e){
                    sender.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            }else{
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("spawn.usage.console")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
            }
        }
    }
}
