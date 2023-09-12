package me.ghostdevelopment.kore.commands;

import me.ghostdevelopment.kore.Kore;
import me.ghostdevelopment.kore.utils.Color;
import me.ghostdevelopment.kore.files.LangFile;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("ALL")
public abstract class KoreCommand implements CommandExecutor, TabCompleter {
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

        if(Kore.getInstance().getConfig().getBoolean("commands.asynchronously")) {

            Bukkit.getScheduler().runTask(Kore.getInstance(), ()->{

                if (!(commandInfo.permission().isEmpty())) {
                    if (!(sender.hasPermission(commandInfo.permission())
                            || sender.hasPermission(commandInfo.permission2())
                            || sender.hasPermission(commandInfo.permission3())
                            || sender.hasPermission("kore.*")
                            || sender.hasPermission("*")
                    )) {
                        sender.sendMessage(Color.Color(LangFile.getFile().getString("no-permissions")
                                .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                        ));
                        return;
                    }
                }

                execute(sender, args);
                return;
            });

            return true;

        }else{
            if (!(commandInfo.permission().isEmpty())) {
                if (!(sender.hasPermission(commandInfo.permission())
                        || sender.hasPermission(commandInfo.permission2())
                        || sender.hasPermission(commandInfo.permission3())
                        || sender.hasPermission("kore.*")
                        || sender.hasPermission("*")
                )) {
                    sender.sendMessage(Color.Color(LangFile.getFile().getString("no-permissions")
                            .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                    ));
                    return false;
                }
            }

            execute(sender, args);
            return true;
        }
    }

    public abstract void execute(CommandSender sender, String[] args);
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        return new ArrayList<>();
    }
}
