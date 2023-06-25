package me.ghostdevelopment.kore.commands.commands.admin;

import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("ALL")
@CommandInfo(name = "teleport", permission = "kore.teleport", permission2 = "kore.tp")
public class CommandTeleport extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("teleport.enabled"))){
            sender.sendMessage(Utils.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length!=1||args.length!=2||args.length!=3||args.length!=4){

                try{
                    // tp <player>
                    if(args.length==1){

                        Player target = Bukkit.getPlayer(args[0]);

                        player.teleport(target.getLocation());
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("teleport.teleported")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%loc%", target.getName())
                        ));
                        return;

                    }else if(args.length==2){

                        Player target = Bukkit.getPlayer(args[0]);
                        Player target2 = Bukkit.getPlayer(args[1]);

                        target.teleport(target2.getLocation());
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("teleport.teleported-other")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%player%", target.getName())
                                .replaceAll("%loc%", target2.getName())
                        ));
                        return;

                    } else if (args.length==3) {

                        double x = Double.valueOf(args[0]);
                        double y = Double.valueOf(args[1]);
                        double z = Double.valueOf(args[2]);

                        Location loc = new Location(player.getLocation().getWorld(), x, y, z, player.getLocation().getYaw(), player.getLocation().getPitch());

                        player.teleport(loc);

                        String msgloc = x+" "+y+" "+z;
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("teleport.teleported")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%loc%", msgloc)
                        ));

                        return;

                    } else if (args.length==4) {

                        double x = Double.valueOf(args[1]);
                        double y = Double.valueOf(args[2]);
                        double z = Double.valueOf(args[3]);

                        Player target = Bukkit.getPlayer(args[0]);

                        Location loc = new Location(target.getLocation().getWorld(), x, y, z, target.getLocation().getYaw(), target.getLocation().getPitch());

                        target.teleport(loc);

                        String msgloc = x+" "+y+" "+z;
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("teleport.teleported-other")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%player%", target.getName())
                                .replaceAll("%loc%", msgloc)
                        ));

                        return;

                    }

                }catch (Exception e){
                    player.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                    return;
                }

            }else{
                player.sendMessage(Utils.Color(LangFile.getFile().getString("teleport.usage.player")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }

        }else{
            if (args.length==2) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);
                    Player target2 = Bukkit.getPlayer(args[1]);
                    target.teleport(target2);
                    sender.sendMessage(Utils.Color(LangFile.getFile().getString("teleport.teleported-other")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%player%", target.getName())
                            .replaceAll("%loc%", target2.getName())
                    ));
                    return;
                }catch (Exception e){
                    sender.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                    return;
                }
            }else{
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("teleport.usage.console")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }
        }
    }
}
