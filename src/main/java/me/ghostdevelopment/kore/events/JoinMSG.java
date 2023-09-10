package me.ghostdevelopment.kore.events;

import me.ghostdevelopment.kore.Kore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinMSG implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event){

        if(Kore.getInstance().getConfig().getString("server.join-msg").isEmpty() || Kore.getInstance().getConfig().getString("server.join-msg") == null) return;

        event.setJoinMessage(Kore.getInstance().getConfig().getString("server.join-msg"));

    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerQuit(PlayerQuitEvent event){

        if(Kore.getInstance().getConfig().getString("server.join-msg").isEmpty() || Kore.getInstance().getConfig().getString("server.join-msg") == null) return;

        event.setQuitMessage(Kore.getInstance().getConfig().getString("server.leave-msg"));

    }

}
