package me.ghostdevelopment.kore.commands.commands.admin;

import me.ghostdevelopment.kore.Kore;
import me.ghostdevelopment.kore.utils.Color;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandInfo(name = "killmobs", permission = "kore.killmobs")
public class CommandKillMobs extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("killmobs.enabled"))){
            sender.sendMessage(Color.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(args.length!=0){
            sender.sendMessage(Color.Color(LangFile.getFile().getString("killmobs.usage")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }


        if(SettingsFile.getFile().getBoolean("killmobs.async")) {
            BukkitRunnable task = new BukkitRunnable() {
                @Override
                public void run() {
                    for (World world : Bukkit.getWorlds()) {
                        for (Entity entity : world.getEntities()) {
                            if (!(entity instanceof Player)) {
                                entity.remove();
                            }
                        }
                    }
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("killmobs.killed")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            };
            task.runTaskAsynchronously(Kore.getInstance());
        }else{
            for (World world : Bukkit.getWorlds()) {
                for (Entity entity : world.getEntities()) {
                    if (!(entity instanceof Player)) {
                        entity.remove();
                    }
                }
            }
            sender.sendMessage(Color.Color(LangFile.getFile().getString("killmobs.killed")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
        }
    }
}
