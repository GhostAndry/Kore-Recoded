package me.ghostdevelopment.kore.commands.impl.admin.holograms;

import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.utils.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@CommandInfo(name = "holo", permission = "kore.holo", tabCompleter = true)
public class CommandHolo extends KoreCommand {


    @Override
    public void execute(CommandSender sender, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;



        }else{
            sender.sendMessage(Color.Color(LangFile.getFile().getString("only-player")));
        }

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> completions = new ArrayList<>();
        
        return completions;
    }
}
