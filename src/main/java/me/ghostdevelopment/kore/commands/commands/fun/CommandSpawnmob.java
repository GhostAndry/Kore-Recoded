package me.ghostdevelopment.kore.commands.commands.fun;


import me.ghostdevelopment.kore.Kore;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import me.ghostdevelopment.kore.utils.Color;
import me.ghostdevelopment.kore.utils.Console;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

@CommandInfo(name = "spawnmob", permission = "kore.spawnmob")
public class CommandSpawnmob extends KoreCommand {

    private static ArrayList<EntityType> entities = new ArrayList<>();

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("spawnmob.enabled"))) {
            sender.sendMessage(Color.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 1) {
                try {
                    String entityString = args[0].toUpperCase();
                    EntityType entityType = EntityType.valueOf(entityString);

                    Entity entity = player.getWorld().spawn(player.getLocation(), entityType.getEntityClass());

                    player.sendMessage(Color.Color(LangFile.getFile().getString("spawnmob.spawned")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%num%", String.valueOf(1))
                    ));
                    return;
                }catch (Exception e){
                    player.sendMessage(Color.Color(LangFile.getFile().getString("spawnmob.invalid")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                    return;
                }

            } else if (args.length == 2) {

                try {
                    String entityString = args[0].toUpperCase();
                    EntityType entityType = EntityType.valueOf(entityString);
                    Integer entityNum = Integer.valueOf(args[1]);

                    try {
                        if(SettingsFile.getFile().getBoolean("spawnmob.async")){
                            BukkitRunnable task = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    for(int i = 1; i <= entityNum; i++) {
                                        Bukkit.getScheduler().runTask(Kore.getInstance(), new Runnable() {
                                            @Override
                                            public void run() {
                                                Entity entity = player.getWorld().spawn(player.getLocation(), entityType.getEntityClass());
                                            }
                                        });
                                    }
                                    player.sendMessage(Color.Color(LangFile.getFile().getString("spawnmob.spawned")
                                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                            .replaceAll("%num%", String.valueOf(entityNum))
                                    ));
                                }
                            };
                            task.runTaskAsynchronously(Kore.getInstance());
                            return;
                        } else {
                            for(int i = 1; i <= entityNum; i++) {
                                Entity entity = player.getWorld().spawn(player.getLocation(), entityType.getEntityClass());
                            }
                            player.sendMessage(Color.Color(LangFile.getFile().getString("spawnmob.spawned")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                    .replaceAll("%num%", String.valueOf(entityNum))
                            ));
                            return;
                        }
                    } catch (Exception e) {
                        Console.warning(e + "\n\nUnable to spawn entity");
                    }
                }catch (Exception e){
                    player.sendMessage(Color.Color(LangFile.getFile().getString("spawnmob.invalid")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                    return;
                }

            } else {
                player.sendMessage(Color.Color(LangFile.getFile().getString("spawnmob.usage")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }
        } else {
            sender.sendMessage(Color.Color(LangFile.getFile().getString("only-players")));
            return;
        }
    }

    public static ArrayList<EntityType> getEntities() {
        return entities;
    }
}