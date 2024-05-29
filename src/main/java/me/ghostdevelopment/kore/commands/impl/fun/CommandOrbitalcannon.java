package me.ghostdevelopment.kore.commands.impl.fun;

import me.ghostdevelopment.kore.Kore;
import me.ghostdevelopment.kore.utils.Color;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@CommandInfo(name = "orbitalcannon", permission = "kore.orbitalcannon", tabCompleter = true)
public class CommandOrbitalcannon extends KoreCommand {

    private Kore plugin;
    private static Location location;

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("orbitalcannon.enabled"))) {
            sender.sendMessage(LangFile.getString("command-disabled"));
            return;
        }


        if (args.length == 1||args.length == 3) {
            if(args.length==1) {
                try {
                    Player target = sender.getServer().getPlayer(args[0]);
                    location = target.getLocation();
                    if (SettingsFile.getFile().getBoolean("orbitalcannon.tell-to-victim")) {
                        target.sendMessage(Color.Color(LangFile.getFile().getString("orbitalcannon.tell")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }
                } catch (Exception e) {
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("invalid-target")
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
            location.getWorld().createExplosion(location, 150f, false);
            location.getWorld().createExplosion(location, 150f, false);
            location.getWorld().createExplosion(location, 150f, false);

        } else {
            sender.sendMessage(Color.Color(LangFile.getFile().getString("orbitalcannon.usage")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                String partialName = args[0].toLowerCase();
                if(player.getName().startsWith(partialName)){
                    completions.add(player.getName());
                }else {
                    completions.add("<x>");
                    completions.add("<y>");
                    completions.add("<z>");
                    completions.add(player.getName());
                }
            }
        } else if (args.length == 2 || args.length == 3) {
            completions.add("<x>");
            completions.add("<y>");
            completions.add("<z>");
        }
        return completions;
    }
}
