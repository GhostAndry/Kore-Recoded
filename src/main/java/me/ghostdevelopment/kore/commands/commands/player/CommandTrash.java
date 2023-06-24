package me.ghostdevelopment.kore.commands.commands.player;

import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

@SuppressWarnings("ALL")
@CommandInfo(name = "trash", permission = "kore.trash", moduleName = "trash")
public class CommandTrash extends KoreCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("trash.enabled"))){
            sender.sendMessage(Utils.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player){

            Player player = (Player) sender;

            Inventory inventory = Bukkit.createInventory(player, 54, Utils.Color("&cTrash"));

            player.openInventory(inventory);

        }else{
            sender.sendMessage(Utils.Color(LangFile.getFile().getString("only-players")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
        }
    }
}
