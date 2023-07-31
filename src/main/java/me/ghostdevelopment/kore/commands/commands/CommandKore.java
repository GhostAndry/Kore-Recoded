package me.ghostdevelopment.kore.commands.commands;

import me.ghostdevelopment.kore.Functions;
import me.ghostdevelopment.kore.Kore;
import me.ghostdevelopment.kore.utils.Color;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("ALL")
@CommandInfo(name = "kore")
public class CommandKore extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                player.sendMessage(Color.Color("\n&aThis server is running Kore."));
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("info")) {
                    player.sendMessage(Color.Color(
                            "&aKore $ver\n".replace("$ver", Kore.getInstance().getDescription().getVersion()) +
                                    "&aAuthor: &7GhostAndry\n" +
                                    "&aGitHub: &b&nhttps://github.com/GhostAndry/Kore-Recoded\n" +
                                    "\n"));
                } else if (args[0].equalsIgnoreCase("reload")) {

                    if (!player.hasPermission("kore.reload")) {
                        player.sendMessage(Color.Color(LangFile.getFile().getString("no-permissions")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                        return;
                    }
                    try {
                        Functions.reloadFiles();
                        sender.sendMessage(Color.Color(LangFile.getFile().getString("reload.success")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    } catch (NullPointerException e) {
                        Bukkit.getLogger().warning(e.getMessage());
                        player.sendMessage(Color.Color(LangFile.getFile().getString("reload.error")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }
                } else if (args[0].equalsIgnoreCase("help")) {
                    player.sendMessage(Color.Color("\n" +
                            "&c<mandatory> &1[optional]\n" +
                            "&7/kore <help|reload|info|(lang|language)>\n" +
                            "&7/gamemode &c<gamemode> &1[player]\n" +
                            "&7/gmc &1[player]\n" +
                            "&7/gms &1[player]\n" +
                            "&7/gma &1[player]\n" +
                            "&7/gmsp &1[player]\n" +
                            "&7/fly &1[player]\n" +
                            "&7/teleport /tp &c<player> &1[player]\n" +
                            "&7/heal &1[player]\n" +
                            "&7/god &1[player]\n" +
                            "&7/vanish /v &1[player]\n" +
                            "&7/setspawn\n" +
                            "&7/spawn &1[player]\n" +
                            "&7/trash /disposal\n" +
                            "&7/orbitalcannon &c<player | x y z> \n" +
                            "&7/smite &c<player>\n" +
                            "&7/kill &1[player]\n" +
                            "&7/warp &c<add|remove> <name>\n" +
                            "&7/warp &c<name> &1[player]\n" +
                            "&7/home &1[set|remove]\n" +
                            "&7/speed &c<value> &1[player] [type]\n"+
                            "\n"
                    ));
                }else{
                    player.sendMessage(Color.Color("\n&aThis server is running Kore."));
                }
            }else if (args.length==2) {

                if (args[0].equalsIgnoreCase("lang")||args[0].equalsIgnoreCase("language")) {

                    String lang = args[1];

                    if(!LangFile.checkFileExists(lang)){
                        player.sendMessage(Color.Color(LangFile.getFile().getString("messages.not-exist")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                        return;
                    }

                    SettingsFile.getFile().set("messages", lang);
                    SettingsFile.save();
                    Functions.reloadFiles();

                    player.sendMessage(Color.Color(LangFile.getFile().getString("messages.successfully-set")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                            .replaceAll("%lang%", LangFile.getFile().getString("lang-name"))
                    ));

                }else{
                    player.sendMessage(Color.Color("\n&aThis server is running Kore."));
                }
            }
        }else{
            if (args.length == 0) {
                sender.sendMessage(Color.Color("\n&aThis server is running Kore."));
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("info")) {
                    sender.sendMessage(Color.Color(
                            "&aKore $ver\n".replace("$ver", Kore.getInstance().getDescription().getVersion()) +
                                    "&aAuthor: &7GhostAndry\n" +
                                    "&aGitHub: &b&nhttps://github.com/GhostAndry/Kore-Recoded\n" +
                                    "\n"));
                } else if (args[0].equalsIgnoreCase("reload")) {
                    try {
                        Functions.reloadFiles();
                        sender.sendMessage(Color.Color(LangFile.getFile().getString("reload.success")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    } catch (NullPointerException e) {
                        Bukkit.getLogger().warning(e.getMessage());
                        sender.sendMessage(Color.Color(LangFile.getFile().getString("reload.error")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                    }
                } else if (args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage(Color.Color("\n" +
                            "&call parameters are mandatory!" +
                            "&7/kore <help|reload|info|(lang|language)>\n" +
                            "&7/gamemode &c<gamemode> <player>\n" +
                            "&7/gmc <player>\n" +
                            "&7/gms <player>\n" +
                            "&7/gma <player>\n" +
                            "&7/gmsp <player>\n" +
                            "&7/fly <player>\n" +
                            "&7/teleport /tp &c<player> <player>\n" +
                            "&7/heal <player>\n" +
                            "&7/god <player>\n" +
                            "&7/vanish /v <player>\n" +
                            "&7/setspawn\n" +
                            "&7/spawn &c<player>\n" +
                            "&7/trash /disposal\n" +
                            "&7/orbitalcannon &c<player | x y z> \n" +
                            "&7/smite &c<player>\n" +
                            "&7/kill <player>\n" +
                            "&7/warp &c<add|remove> <name>\n" +
                            "&7/warp &c<name> <player>\n" +
                            "&7/home &c<set|remove>\n" +
                            "&7/speed &c<value> <player> <type>\n"+
                            "\n"
                    ));
                }else{
                    sender.sendMessage(Color.Color("\n&aThis server is running Kore."));
                }
            } else if (args.length==2) {

                 if (args[0].equalsIgnoreCase("lang")||args[0].equalsIgnoreCase("language")) {

                     String lang = args[1];

                     if(!LangFile.checkFileExists(lang)){
                         sender.sendMessage(Color.Color(LangFile.getFile().getString("messages.not-exist")
                                 .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                         ));
                         return;
                     }

                     SettingsFile.getFile().set("messages", lang);
                     SettingsFile.save();
                     Functions.reloadFiles();

                     sender.sendMessage(Color.Color(LangFile.getFile().getString("messages.successfully-set")
                             .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                             .replaceAll("%lang%", LangFile.getFile().getString("lang-name"))
                     ));

                }else{
                     sender.sendMessage(Color.Color("\n&aThis server is running Kore."));
                }
            }
        }
    }
}
