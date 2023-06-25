package me.ghostdevelopment.kore.commands.commands.admin;

import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("all")
@CommandInfo(name = "heal", permission = "kore.heal")
public class CommandHeal extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("heal.enabled"))){
            sender.sendMessage(Utils.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(args.length>1){
                player.sendMessage(Utils.Color(LangFile.getFile().getString("heal.usage.player")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }
            if (args.length==0) {
                player.setHealth(20);
                player.setFoodLevel(40);
                player.sendMessage(Utils.Color(LangFile.getFile().getString("heal.healed")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
            } else if (args.length==1) {
                try{
                    Player target = Bukkit.getPlayer(args[0]);

                    target.setHealth(20);
                    target.setFoodLevel(40);
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("heal.healed-other")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%player%", target.getName())
                    ));
                }catch (Exception e){
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                    return;
                }
            }
        }else{
            if(!(args.length==1)){
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("heal.usage.console")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }

            try{
                Player target = Bukkit.getPlayer(args[0]);

                target.setFoodLevel(40);
                target.setHealth(20);
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("heal.healed-other")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        .replaceAll("%player%", target.getName())
                ));
            }catch (Exception e){
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }
        }
    }
}
