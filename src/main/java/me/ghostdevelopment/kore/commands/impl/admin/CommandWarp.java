package me.ghostdevelopment.kore.commands.impl.admin;

import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.files.SettingsFile;
import me.ghostdevelopment.kore.files.StorageFile;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.Functions;

import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("ALL")
@CommandInfo(name = "warp", permission = "kore.warp", tabCompleter = true)
public class CommandWarp extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("warp.enabled"))){
            sender.sendMessage(LangFile.getString("command-disabled"));
            return;
        }

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length==1||args.length==2){
                if(args[0].equalsIgnoreCase("add")){
                    if(player.hasPermission("kore.warp.admin")){
                        try {
                            String warp_name = args[1];

                            if (!Functions.checkWarp(warp_name)) {
                                Functions.addWarp(player.getLocation(), warp_name);

                                player.sendMessage(LangFile.getString("warp.admin.added")
                                        .replaceAll("%warp%", warp_name));
                                return;
                            } else {
                                player.sendMessage(LangFile.getString("warp.admin.already-exist")
                                        .replaceAll("%warp%", warp_name));
                                return;
                            }
                        }catch (Exception e){
                            player.sendMessage(LangFile.getString("warp.usage.admin"));
                            return;
                        }
                    }else{
                        player.sendMessage(LangFile.getString("no-permissions"));
                        return;
                    }

                }else if (args[0].equalsIgnoreCase("remove")){
                    if(player.hasPermission("kore.warp.admin")||player.isOp()){
                        try {
                            String warp_name = args[1];

                            if (Functions.checkWarp(warp_name)) {
                                Functions.delWarp(warp_name);

                                player.sendMessage(LangFile.getString("warp.admin.removed")
                                        .replaceAll("%warp%", warp_name));
                                return;
                            } else {
                                player.sendMessage(LangFile.getString("warp.not-found"));
                                return;
                            }
                        }catch (Exception e){
                            player.sendMessage(LangFile.getString("warp.usage.admin"));
                            return;
                        }

                    }else{
                        player.sendMessage(LangFile.getString("no-permissions"));
                        return;
                    }

                }else{

                    if(args.length==1) {
                        String warp_name = args[0];

                        if (Functions.checkWarp(warp_name)) {

                            player.teleport(Functions.getWarpLoc(warp_name));
                            player.sendMessage(LangFile.getString("warp.warped")
                                    .replaceAll("%warp%", warp_name));
                            return;
                        }else{
                            player.sendMessage(LangFile.getString("warp.not-found"));
                            return;
                        }

                    }else{
                        try {
                            String warp_name = args[0];
                            Player target = Bukkit.getPlayer(args[1]);

                            if (Functions.checkWarp(warp_name)) {

                                target.teleport(Functions.getWarpLoc(warp_name));
                                target.sendMessage(LangFile.getString("warp.warped")
                                        .replaceAll("%warp%", warp_name));
                                player.sendMessage(LangFile.getString("warp.warped-other")
                                        .replaceAll("%warp%", warp_name)
                                        .replaceAll("%player%", target.getName()));
                                return;
                            } else {
                                player.sendMessage(LangFile.getString("warp.not-found"));
                                return;
                            }
                        }catch (Exception e){
                            player.sendMessage(LangFile.getString("invalid-target"));
                            return;
                        }

                    }

                }

            }else{
                player.sendMessage(LangFile.getString("warp.usage.player"));
                return;
            }

        }else{

            if(args.length==2){
                try {
                    String warp_name = args[0];
                    Player target = Bukkit.getPlayer(args[1]);

                    if (Functions.checkWarp(warp_name)) {

                        target.teleport(Functions.getWarpLoc(warp_name));
                        target.sendMessage(LangFile.getString("warp.warped")
                                .replaceAll("%warp%", warp_name));
                        sender.sendMessage(LangFile.getString("warp.warped-other")
                                .replaceAll("%warp%", warp_name)
                                .replaceAll("%player%", target.getName()));
                        return;
                    } else {
                        sender.sendMessage(LangFile.getString("warp.not-found"));
                        return;
                    }
                }catch (Exception e){
                    sender.sendMessage(LangFile.getString("invalid-target"));
                    return;
                }

            }else{
                sender.sendMessage(LangFile.getString("warp.usage.console"));
                return;
            }
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            if (sender.hasPermission("kore.warp.admin")
                    || sender.hasPermission("kore.warp.*")
                    || sender.hasPermission("kore.*")
                    || sender.hasPermission("*")
                    || sender.isOp()
            ) {
                completions.add("add");
                completions.add("remove");
            }
            Set<String> warps = StorageFile.getFile().getConfigurationSection("warps").getKeys(false);
            String partialName = args[0].toLowerCase();
            for (String warp : warps) {
                if (warp.toLowerCase().startsWith(partialName)) {
                    completions.add(warp);
                }
            }
        } else if (args.length == 2) {
            String subCommand = args[0].toLowerCase();
            if (subCommand.equals("add")
                    && (sender.hasPermission("kore.warp.admin")
                    || sender.hasPermission("kore.warp.*")
                    || sender.hasPermission("kore.*")
                    || sender.hasPermission("*")
                    || sender.isOp())
            ) {
                String partialName = args[1].toLowerCase();
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.getName().toLowerCase().startsWith(partialName)) {
                        completions.add(player.getName());
                    }
                }
            } else if (subCommand.equals("remove")
                    && (sender.hasPermission("kore.warp.admin")
                    || sender.hasPermission("kore.warp.*")
                    || sender.hasPermission("kore.*")
                    || sender.hasPermission("*")
                    || sender.isOp())
            ) {
                Set<String> warps = StorageFile.getFile().getConfigurationSection("warps").getKeys(false);
                String partialName = args[1].toLowerCase();
                for (String warp : warps) {
                    if (warp.toLowerCase().startsWith(partialName)) {
                        completions.add(warp);
                    }
                }
            }
        }

        return completions;
    }
}
