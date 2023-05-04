package me.ghostdevelopment.kore.events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.ghostdevelopment.kore.Utils;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

@SuppressWarnings("ALL")
public class ChatManager implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event){

        if(SettingsFile.getFile().getBoolean("chat.enabled")) {
            event.setCancelled(true);
            String message = event.getMessage();
            String author = event.getPlayer().getName();
            for(Player other: Bukkit.getOnlinePlayers()){
                String replacedMessage = PlaceholderAPI.setPlaceholders(other, message);
                other.sendMessage(Utils.Color(SettingsFile.getFile().getString("chat.format")
                        .replaceAll("%sender%", author)
                        .replaceAll("%message%", replacedMessage)
                ));
            }

        }

    }

}
