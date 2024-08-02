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
    public void onPlayerHunger(FoodLevelChangeEvent event) {

        if (SettingsFile.getFile().getBoolean("world-manipulator.enable")) {
            if (SettingsFile.getFile().getBoolean("world-manipulator.rules.anti-hunger")) {
                if (event.getFoodLevel() < 20) {
                    event.setFoodLevel(20);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onWeatherChange(WeatherChangeEvent event) {

        if (SettingsFile.getFile().getBoolean("world-manipulator.enable")) {
            if (SettingsFile.getFile().getBoolean("world-manipulator.rules.anti-weather")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {

        if (SettingsFile.getFile().getBoolean("world-manipulator.enable")) {
            if (SettingsFile.getFile().getBoolean("world-manipulator.rules.anti-join-message")) {
                event.setJoinMessage(null);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuit(PlayerQuitEvent event) {

        if (SettingsFile.getFile().getBoolean("world-manipulator.enable")) {
            if (SettingsFile.getFile().getBoolean("world-manipulator.rules.anti-join-message")) {
                event.setQuitMessage(null);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMobSpawn(EntitySpawnEvent event) {

        if (SettingsFile.getFile().getBoolean("world-manipulator.enable")) {
            if (SettingsFile.getFile().getBoolean("world-manipulator.rules.anti-mob-spawn")) {
                if (event.getEntityType().equals(EntityType.DROPPED_ITEM)
                        || event.getEntityType().equals(EntityType.FALLING_BLOCK)
                        || event.getEntityType().equals(EntityType.PRIMED_TNT)
                        || event.getEntityType().equals(EntityType.PRIMED_TNT)
                        || event.getEntityType().equals(EntityType.ITEM_FRAME)
                        || event.getEntityType().equals(EntityType.ARMOR_STAND)
                        || event.getEntityType().equals(EntityType.ENDER_CRYSTAL)
                        || event.getEntityType().equals(EntityType.SPLASH_POTION)
                        || event.getEntityType().equals(EntityType.ARROW)
                        || event.getEntityType().equals(EntityType.SNOWBALL)
                        || event.getEntityType().equals(EntityType.EGG)
                        || event.getEntityType().equals(EntityType.FIREBALL)
                        || event.getEntityType().equals(EntityType.SMALL_FIREBALL)
                        || event.getEntityType().equals(EntityType.ENDER_PEARL)
                        || event.getEntityType().equals(EntityType.WITHER_SKULL)
                        || event.getEntityType().equals(EntityType.MINECART)
                        || event.getEntityType().equals(EntityType.MINECART_CHEST)
                        || event.getEntityType().equals(EntityType.MINECART_FURNACE)
                        || event.getEntityType().equals(EntityType.MINECART_TNT)
                        || event.getEntityType().equals(EntityType.MINECART_HOPPER)
                        || event.getEntityType().equals(EntityType.MINECART_MOB_SPAWNER)
                        || event.getEntityType().equals(EntityType.FIREWORK)
                        || event.getEntityType().equals(EntityType.FISHING_HOOK)
                        || event.getEntityType().equals(EntityType.LIGHTNING)
                ) return;
                event.setCancelled(true);
            }
        }
    }

}
