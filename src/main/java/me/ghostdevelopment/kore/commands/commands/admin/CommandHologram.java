package me.ghostdevelopment.kore.commands.commands.admin;

import me.ghostdevelopment.kore.Functions;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import me.ghostdevelopment.kore.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@CommandInfo(name = "holo", permission = "kore.holo", tabCompleter = true)
public class CommandHologram extends KoreCommand {

    private static String defaultLine = Color.Color("&fYou can add lines using &b/holo addline <text>&f and remove this using &b/holo removeline 1");

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("holograms.enabled"))){
            sender.sendMessage(Color.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player){
            Player player = ((Player) sender);

            if(args.length==0||args.length==1){
                player.sendMessage(Color.Color(LangFile.getFile().getString("holograms.usage")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            } else if (args.length>=2) {

                if(args[1].equalsIgnoreCase("create")){
                    String name = args[2];
                    Functions.addHologram(name, player.getLocation());
                    List<String> lines = new ArrayList<>();
                    lines.add(Color.Color(defaultLine));
                    Functions.addLines(name, lines);

                    ArmorStand holo = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
                    holo.setGravity(false);
                    holo.setVisible(false);
                    holo.setSmall(true);
                    holo.setCustomNameVisible(true);
                    holo.setCustomName(defaultLine);

                    return;
                } else if (args[1].equalsIgnoreCase("delete")) {

                    //

                }

                /*
                for (int i = 1; i < args.length; i++) {
                    player.sendMessage(args[i]);
                }
                 */

            }

        }else{
            sender.sendMessage(Color.Color(LangFile.getFile().getString("only-players")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        return completions;
    }
}
