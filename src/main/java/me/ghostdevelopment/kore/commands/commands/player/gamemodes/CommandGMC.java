package me.ghostdevelopment.kore.commands.commands.player.gamemodes;

import me.ghostdevelopment.kore.Kore;
import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.commands.CommandInfo;
import org.bukkit.entity.Player;

@CommandInfo(name = "gmc", permission = "kore.gamemode.creative", permission2 =  "kore.gamemode.*", onlyPlayers = true)
public class CommandGMC extends Command {
    private Kore plugin;
    @Override
    public void execute(Player player, String[] args) {

        if(!(plugin.getConfig().getBoolean("gamemode.enabled"))){
            player.sendMessage(Utils.Color("&cThis command is disabled"));
            return;
        }


        player.sendMessage(Utils.Color(""));

    }
}
