package me.ghostdevelopment.kore.commands.commands.admin;

import me.ghostdevelopment.kore.Functions;
import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


@SuppressWarnings("ALL")
@CommandInfo(name = "warp", permission = "kore.warp")
public class CommandWarp extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("warp.enabled"))){
            sender.sendMessage(Utils.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length==1||args.length==2){

                if(args[0].equalsIgnoreCase("add")){

                    if(player.hasPermission("kore.warp.admin")){

                        String warp_name = args[1];

                        if (!Functions.checkWarp(warp_name)) {
                            Functions.addWarp(player.getLocation(), warp_name);

                            player.sendMessage(Utils.Color(LangFile.getFile().getString("warp.admin.added")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                    .replaceAll("%warp%", warp_name)
                            ));
                            return;
                        }else{
                            player.sendMessage(Utils.Color(LangFile.getFile().getString("warp.admin.already-exist")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                    .replaceAll("%warp%", warp_name)
                            ));
                            return;
                        }

                    }else{
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("no-permissions")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                        return;
                    }

                }else if (args[0].equalsIgnoreCase("remove")){

                    if(player.hasPermission("kore.warp.admin")||player.isOp()){

                        String warp_name = args[1];

                        if (Functions.checkWarp(warp_name)) {
                            Functions.delWarp(warp_name);

                            player.sendMessage(Utils.Color(LangFile.getFile().getString("warp.admin.removed")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                    .replaceAll("%warp%", warp_name)
                            ));
                            return;
                        }else{
                            player.sendMessage(Utils.Color(LangFile.getFile().getString("warp.not-found")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            ));
                            return;
                        }

                    }else{
                        player.sendMessage(Utils.Color(LangFile.getFile().getString("no-permissions")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                        return;
                    }

                }else{

                    if(args.length==1) {
                        String warp_name = args[0];

                        if (Functions.checkWarp(warp_name)) {

                            player.teleport(Functions.getWarpLoc(warp_name));
                            player.sendMessage(Utils.Color(LangFile.getFile().getString("warp.warped")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                    .replaceAll("%warp%", warp_name)
                            ));
                            return;
                        }else{
                            player.sendMessage(Utils.Color(LangFile.getFile().getString("warp.not-found")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            ));
                            return;
                        }

                    }else{
                        try {
                            String warp_name = args[0];
                            Player target = Bukkit.getPlayer(args[1]);

                            if (Functions.checkWarp(warp_name)) {

                                target.teleport(Functions.getWarpLoc(warp_name));
                                target.sendMessage(Utils.Color(LangFile.getFile().getString("warp.warped")
                                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                        .replaceAll("%warp%", warp_name)
                                ));
                                player.sendMessage(Utils.Color(LangFile.getFile().getString("warp.warped-other")
                                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                        .replaceAll("%warp%", warp_name)
                                        .replaceAll("%player%", target.getName())
                                ));
                                return;
                            } else {
                                player.sendMessage(Utils.Color(LangFile.getFile().getString("warp.not-found")
                                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                ));
                                return;
                            }
                        }catch (Exception e){
                            player.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            ));
                            return;
                        }

                    }

                }

            }else{
                player.sendMessage(Utils.Color(LangFile.getFile().getString("warp.usage.player")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }

        }else{

            if(args.length==2){
                try {
                    String warp_name = args[0];
                    Player target = Bukkit.getPlayer(args[1]);

                    if (Functions.checkWarp(warp_name)) {

                        target.teleport(Functions.getWarpLoc(warp_name));
                        target.sendMessage(Utils.Color(LangFile.getFile().getString("warp.warped")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%warp%", warp_name)
                        ));
                        sender.sendMessage(Utils.Color(LangFile.getFile().getString("warp.warped-other")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                                .replaceAll("%warp%", warp_name)
                                .replaceAll("%player%", target.getName())
                        ));
                        return;
                    } else {
                        sender.sendMessage(Utils.Color(LangFile.getFile().getString("warp.not-found")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                        return;
                    }
                }catch (Exception e){
                    sender.sendMessage(Utils.Color(LangFile.getFile().getString("invalid-target")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                    return;
                }

            }else{
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("warp.usage.console")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            }

        }

    }

}
