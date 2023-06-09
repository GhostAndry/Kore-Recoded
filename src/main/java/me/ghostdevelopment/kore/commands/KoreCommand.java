package me.ghostdevelopment.kore.commands;

import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.files.LangFile;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

@SuppressWarnings("ALL")
public abstract class KoreCommand implements CommandExecutor {
    private final CommandInfo commandInfo;

    public KoreCommand(){
        commandInfo = getClass().getDeclaredAnnotation(CommandInfo.class);
        Objects.requireNonNull(commandInfo, "Commands must have @CommandInfo annotations");
    }

    public CommandInfo getCommandInfo() {
        return commandInfo;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if(!(commandInfo.permission().isEmpty())){
            if(!(sender.hasPermission(commandInfo.permission())
                    ||sender.hasPermission(commandInfo.permission2())
                    ||sender.hasPermission(commandInfo.permission3())
                    ||sender.hasPermission("kore.*")
                    ||sender.hasPermission("*")
            )){
                sender.sendMessage(Utils.Color(LangFile.getFile().getString("no-permissions")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return false;
            }
        }

        execute(sender, args);
        return false;
    }

    public abstract void execute(CommandSender sender, String[] args);
}
