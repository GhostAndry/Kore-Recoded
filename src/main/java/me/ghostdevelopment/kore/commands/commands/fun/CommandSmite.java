package me.ghostdevelopment.kore.commands.commands.fun;

import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("ALL")
@CommandInfo(name = "smite", permission = "kore.smite", moduleName = "smite")
public class CommandSmite extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("smite.enabled"))){
            sender.sendMessage(Utils.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(args.length==1){

            try{

                Player target = Bukkit.getPlayer(args[0]);

                Location location = target.getLocation();
                World world = location.getWorld();

                world.strikeLightning(location);

                sender.sendMessage(Utils.Color(LangFile.getFile().getString("smite.smited-player")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        .replaceAll("%player%", target.getName())
                ));

            }catch (Exception e){
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
            }

        }else{
            sender.sendMessage(Utils.Color(LangFile.getFile().getString("smite.usage")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
        }

    }

}
