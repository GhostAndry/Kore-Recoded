package me.ghostdevelopment.kore.commands.commands.player;

import me.ghostdevelopment.kore.Functions;
import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("ALL")
@CommandInfo(name = "home", permission = "kore.home")
public class CommandHome extends Command {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("home.enabled"))){
            sender.sendMessage(Utils.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length==0||args.length==1){

                if(args.length==0){

                    if(Functions.checkHome(player)){

                        Location home = Functions.getHomeLoc(player);

                        player.teleport(home);
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("home.teleported")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                        return;
                    }else{
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("home.not-set")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                        return;
                    }

                } else if (args.length==1) {

                    if(args[0].equalsIgnoreCase("set")){

                        if(!Functions.checkHome(player)) {
                            try {
                                Functions.addHome(player);

                                player.sendMessage(Utils.Color(LangFile.getFile().getString("home.set")
                                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                ));
                                return;
                            } catch (Exception e) {
                                throw new NullPointerException(e.getMessage());
                            }
                        }

                    } else if (args[0].equalsIgnoreCase("remove")) {

                        if(Functions.checkHome(player)){
                            try{

                             Functions.delHome(player);

                             player.sendMessage(Utils.Color(LangFile.getFile().getString("home.removed")
                                     .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                             ));
                             return;
                            }catch (Exception e) {
                                throw new NullPointerException(e.getMessage());
                            }
                        }

                    }else{
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("home.usage")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                        return;
                    }

                }

            }else{
                player.sendMessage(Utils.Color(LangFile.getFile().getString("home.usage")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }

        }else{
            sender.sendMessage(Utils.Color(LangFile.getFile().getString("only-players")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
        }

    }

}
