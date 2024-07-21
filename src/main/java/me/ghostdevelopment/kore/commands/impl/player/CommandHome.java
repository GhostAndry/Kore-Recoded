package me.ghostdevelopment.kore.commands.impl.player;

import me.ghostdevelopment.kore.Functions;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import me.ghostdevelopment.kore.utils.Color;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("ALL")
@CommandInfo(name = "home", permission = "kore.home")
public class CommandHome extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!SettingsFile.getFile().getBoolean("home.enabled")) {
            sendMessage(sender, "command-disabled");
            return;
        }

        if (!(sender instanceof Player)) {
            sendMessage(sender, "only-players");
            return;
        }

        Player player = (Player) sender;
        if (args.length == 0) {
            handleHomeTeleport(player);
        } else if (args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "set":
                    handleSetHome(player);
                    break;
                case "remove":
                    handleRemoveHome(player);
                    break;
                default:
                    sendMessage(player, "home.usage");
                    break;
            }
        } else {
            sendMessage(player, "home.usage");
        }
    }

    private void handleHomeTeleport(Player player) {
        if (Functions.checkHome(player)) {
            Location home = Functions.getHomeLoc(player);
            player.teleport(home);
            sendMessage(player, "home.teleported");
        } else {
            sendMessage(player, "home.not-set");
        }
    }

    private void handleSetHome(Player player) {
        if (!Functions.checkHome(player)) {
            try {
                Functions.addHome(player);
                sendMessage(player, "home.set");
            } catch (Exception e) {
                sendMessage(player, "&cAn error occurred while setting home.");
            }
        } else {
            sendMessage(player, "home.already-set");
        }
    }

    private void handleRemoveHome(Player player) {
        if (Functions.checkHome(player)) {
            try {
                Functions.delHome(player);
                sendMessage(player, "home.removed");
            } catch (Exception e) {
                sendMessage(player, "&cAn error occurred while removing home.");
            }
        } else {
            sendMessage(player, "home.not-set");
        }
    }

    public void sendMessage(@NotNull CommandSender sender, String message) {
        sender.sendMessage(Color.Color(LangFile.getString(message)
                .replaceAll("%prefix%", LangFile.getString("prefix"))
        ));
    }

    public void sendMessage(@NotNull Player player, String message) {
        player.sendMessage(Color.Color(LangFile.getString(message)
                .replaceAll("%prefix%", LangFile.getString("prefix"))
        ));
    }
}
