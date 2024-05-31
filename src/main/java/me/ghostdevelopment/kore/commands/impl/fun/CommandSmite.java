package me.ghostdevelopment.kore.commands.impl.fun;

import me.ghostdevelopment.kore.utils.Color;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@CommandInfo(name = "smite", permission = "kore.smite", tabCompleter = true)
public class CommandSmite extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("smite.enabled"))){
            sender.sendMessage(LangFile.getString("command-disabled"));
            return;
        }

        if(args.length==1){

            try{

                Player target = Bukkit.getPlayer(args[0]);

                Location location = target.getLocation();
                World world = location.getWorld();

                world.strikeLightning(location);

                sender.sendMessage(LangFile.getString("smite.smited-player")
                        .replaceAll("%player%", target.getName()));

            }catch (Exception e){
                sender.sendMessage(LangFile.getString("invalid-target"));
            }

        }else{
            sender.sendMessage(LangFile.getString("smite.usage"));
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
