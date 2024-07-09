package me.ghostdevelopment.kore.commands.impl.player;

import me.ghostdevelopment.kore.Functions;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("ALL")
@CommandInfo(name = "home", permission = "kore.home")
public class CommandHome extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("home.enabled"))) {
            sender.sendMessage(LangFile.getString("command-disabled"));
            return;
        }

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0 || args.length == 1) {

                if (args.length == 0) {

                    if (Functions.checkHome(player)) {

                        Location home = Functions.getHomeLoc(player);

                        player.teleport(home);
                        player.sendMessage(LangFile.getString("home.teleported"));
                        return;
                    } else {
                        player.sendMessage(LangFile.getString("home.not-set"));
                        return;
                    }

                } else if (args.length == 1) {

                    if (args[0].equalsIgnoreCase("set")) {

                        if (!Functions.checkHome(player)) {
                            try {
                                Functions.addHome(player);

                                player.sendMessage(LangFile.getString("home.set"));
                                return;
                            } catch (Exception e) {
                                throw new NullPointerException(e.getMessage());
                            }
                        }

                    } else if (args[0].equalsIgnoreCase("remove")) {

                        if (Functions.checkHome(player)) {
                            try {

                                Functions.delHome(player);

                                player.sendMessage(LangFile.getString("home.removed"));
                                return;

                            } catch (Exception e) {
                                throw new NullPointerException(e.getMessage());
                            }
                        }

                    } else {
                        player.sendMessage(LangFile.getString("home.usage"));
                        return;
                    }

                }

            } else {
                player.sendMessage(LangFile.getString("home.usage"));
                return;
            }

        } else {
            sender.sendMessage(LangFile.getString("only-players"));
        }

    }

}
