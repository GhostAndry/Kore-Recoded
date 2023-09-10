package me.ghostdevelopment.kore.events;

import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WorldManipulator implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerHunger(FoodLevelChangeEvent event){

        if(SettingsFile.getFile().getBoolean("world-manipulator.enable")){
            if(SettingsFile.getFile().getBoolean("world-manipulator.rules.anti-hunger")){
                if(event.getFoodLevel()<20){
                    event.setFoodLevel(20);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onWeatherChange(WeatherChangeEvent event){

        if(SettingsFile.getFile().getBoolean("world-manipulator.enable")){
            if(SettingsFile.getFile().getBoolean("world-manipulator.rules.anti-weather")){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event){

        if(SettingsFile.getFile().getBoolean("world-manipulator.enable")){
            if(SettingsFile.getFile().getBoolean("world-manipulator.rules.anti-join-message")){
                event.setJoinMessage(null);
            }
        }
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuit(PlayerQuitEvent event){

        if(SettingsFile.getFile().getBoolean("world-manipulator.enable")){
            if(SettingsFile.getFile().getBoolean("world-manipulator.rules.anti-join-message")){
                event.setQuitMessage(null);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMobSpawn(EntitySpawnEvent event){

        if(SettingsFile.getFile().getBoolean("world-manipulator.enable")){
            if(SettingsFile.getFile().getBoolean("world-manipulator.rules.anti-mob-spawn")){
                if(event.getEntityType().equals(EntityType.DROPPED_ITEM)) return;
                event.setCancelled(true);
            }
        }
    }

}
