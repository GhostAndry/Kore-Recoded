package me.ghostdevelopment.kore.events;

import me.ghostdevelopment.kore.Functions;
import me.ghostdevelopment.kore.files.SettingsFile;
import me.ghostdevelopment.kore.files.StorageFile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SpawnOnJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        if(StorageFile.getFile().contains("spawn.world")
                ||StorageFile.getFile().contains("spawn.x")
                ||StorageFile.getFile().contains("spawn.y")
                ||StorageFile.getFile().contains("spawn.z")
                ||StorageFile.getFile().contains("spawn.yaw")
                ||StorageFile.getFile().contains("spawn.pitch")
        ){
            if(SettingsFile.getFile().getBoolean("spawn.enabled")){
                if(SettingsFile.getFile().getBoolean("spawn.on-join")){
                    event.getPlayer().teleport(Functions.getSpawnLocation());
                }
            }
        }
    }
}
