package me.ghostdevelopment.kore.commands;

import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.files.LangFile;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public abstract class Command implements CommandExecutor {

    private final CommandInfo commandInfo;

    public Command(){
        commandInfo = getClass().getDeclaredAnnotation(CommandInfo.class);
        Objects.requireNonNull(commandInfo, "Commands must have @CommandInfo annotations");
    }

    public CommandInfo getCommandInfo() {
        return commandInfo;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if(!commandInfo.permission().isEmpty()){
            if(!sender.hasPermission(commandInfo.permission())){
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("no-permissions")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix%"))
                ));
                return false;
            }
        }

        if(commandInfo.onlyPlayers()){
            if(!(sender instanceof Player)) {
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("no-permissions")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix%"))
                ));
                return false;
            }
            execute((Player) sender, args);
        }

        execute(sender, args);
        return false;
    }

    public void execute(Player player, String[] args){}
    public void execute(CommandSender sender, String[] args){}
}