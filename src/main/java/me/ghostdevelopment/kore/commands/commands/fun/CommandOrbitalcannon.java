package me.ghostdevelopment.kore.commands.commands.fun;

import me.ghostdevelopment.kore.Kore;
import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import javax.rmi.CORBA.Util;

@CommandInfo(name = "orbitalcannon", permission = "kore.orbitalcannon")
public class CommandOrbitalcannon extends Command {

    private Kore plugin;
    private static Location location;

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("orbitalcannon.enabled"))) {
            sender.sendMessage(Utils.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }


        if (args.length == 1||args.length == 3) {
            if(args.length==1) {
                try {
                    Player target = sender.getServer().getPlayer(args[0]);
                    location = target.getLocation();
                    if (SettingsFile.getFile().getBoolean("orbitalcannon.tell-to-victim")) {
                        target.sendMessage(Utils.Color(LangFile.getFile().getString("orbitalcannon.tell")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }
                } catch (Exception e) {
                    sender.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                }
            }else {
                int x = Integer.parseInt(args[0]);
                int y = Integer.parseInt(args[1]);
                int z = Integer.parseInt(args[2]);
                location = new Location(sender.getServer().getWorlds().get(0), x, y, z);
            }

            location.getWorld().strikeLightningEffect(location);
            location.getWorld().createExplosion(location, 50f, false);
        } else {
            sender.sendMessage(Utils.Color(LangFile.getFile().getString("orbitalcannon.usage")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
        }

    }
}
