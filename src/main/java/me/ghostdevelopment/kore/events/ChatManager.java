package me.ghostdevelopment.kore.events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.ghostdevelopment.kore.Kore;
import me.ghostdevelopment.kore.utils.Color;
import me.ghostdevelopment.kore.files.SettingsFile;
import me.ghostdevelopment.kore.utils.Console;
import me.ghostdevelopment.kore.utils.RegisterPlaceholders;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

@SuppressWarnings("ALL")
public class ChatManager implements Listener {
    private static String formattedMessage;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event){

        if(SettingsFile.getFile().getBoolean("chat.enabled")) {
            event.setCancelled(true);
            String message = event.getMessage();
            String author = event.getPlayer().getName();

            if(!(event.getPlayer().hasPermission("kore.chatbypass")
                    ||event.getPlayer().hasPermission("kore.*")
                    ||event.getPlayer().isOp())
            ){
                List<String> blacklist_words = SettingsFile.getFile().getStringList("chat.blacklist-words");
                for (String word : blacklist_words) {
                    if (message.contains(word))
                        message = message.replaceAll(word, "***");
                }
            }

            formattedMessage = SettingsFile.getFile().getString("chat.format");
            formattedMessage = formattedMessage.replaceAll("%sender%", author).replace("%message%", message);

            if(Kore.getInstance().getServer().getPluginManager().getPlugin("PlaceholderAPI")!=null){
                Bukkit.broadcastMessage(Color.Color(PlaceholderAPI.setPlaceholders(event.getPlayer(), formattedMessage)));
            }else{
                Bukkit.broadcastMessage(Color.Color(formattedMessage));
            }

        }

    }

}