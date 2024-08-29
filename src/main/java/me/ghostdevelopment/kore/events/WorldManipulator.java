package me.ghostdevelopment.kore.events;

import me.ghostdevelopment.kore.files.SettingsFile;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import lombok.Getter;
import lombok.Setter;

public class WorldManipulator implements Listener {

    @Getter @Setter
    private static boolean blacklist;
    @Getter
    private static final List<World> worlds = new ArrayList<>();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerHunger(FoodLevelChangeEvent event) {

        if(blacklist) {
            if(worlds.contains(event.getEntity().getWorld()))return;
        }else{
            if(worlds.contains(event.getEntity().getWorld())){

                if (SettingsFile.getFile().getBoolean("world-manipulator.enable")) {
                    if (SettingsFile.getFile().getBoolean("world-manipulator.rules.anti-hunger")) {
                        if (event.getFoodLevel() < 20) {
                            event.setFoodLevel(20);
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onWeatherChange(WeatherChangeEvent event) {

        if(blacklist) {
            if(worlds.contains(event.getWorld()))return;
        }else{
            if(worlds.contains(event.getWorld())){

                if (SettingsFile.getFile().getBoolean("world-manipulator.enable")) {
                    if (SettingsFile.getFile().getBoolean("world-manipulator.rules.anti-weather")) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {

        if(blacklist) {
            if(worlds.contains(event.getPlayer().getWorld()))return;
        }else{
            if(worlds.contains(event.getPlayer().getWorld())){

                if (SettingsFile.getFile().getBoolean("world-manipulator.enable")) {
                    if (SettingsFile.getFile().getBoolean("world-manipulator.rules.anti-join-message")) {
                        event.setJoinMessage(null);
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuit(PlayerQuitEvent event) {
        if(blacklist) {
            if(worlds.contains(event.getPlayer().getWorld()))return;
        }else{
            if(worlds.contains(event.getPlayer().getWorld())){

                if (SettingsFile.getFile().getBoolean("world-manipulator.enable")) {
                    if (SettingsFile.getFile().getBoolean("world-manipulator.rules.anti-join-message")) {
                        event.setQuitMessage(null);
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMobSpawn(EntitySpawnEvent event) {

        if(blacklist) {
            if(worlds.contains(event.getEntity().getWorld()))return;
        }else{
            if(worlds.contains(event.getEntity().getWorld())){

                if (SettingsFile.getFile().getBoolean("world-manipulator.enable")) {
                    if (SettingsFile.getFile().getBoolean("world-manipulator.rules.anti-mob-spawn")) {
                        if (event.getEntityType().equals(EntityType.FALLING_BLOCK)
                                || event.getEntityType().equals(EntityType.ITEM_FRAME)
                                || event.getEntityType().equals(EntityType.ARMOR_STAND)
                                || event.getEntityType().equals(EntityType.ARROW)
                                || event.getEntityType().equals(EntityType.SNOWBALL)
                                || event.getEntityType().equals(EntityType.EGG)
                                || event.getEntityType().equals(EntityType.FIREBALL)
                                || event.getEntityType().equals(EntityType.SMALL_FIREBALL)
                                || event.getEntityType().equals(EntityType.ENDER_PEARL)
                                || event.getEntityType().equals(EntityType.WITHER_SKULL)
                                || event.getEntityType().equals(EntityType.MINECART)
                        ) return;
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

}
