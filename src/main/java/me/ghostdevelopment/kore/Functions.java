package me.ghostdevelopment.kore;

import me.ghostdevelopment.kore.files.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Functions {

    private static Kore plugin;

    public static void reloadFiles(){

        SettingsFile.reload();
        LangFile.reload();
        StorageFile.reload();

    }

    public static void setLangFile(){

        LangFile.getFile().addDefault("prefix", "&b&lKore&f:");
        LangFile.getFile().addDefault("no-permissions", "%prefix% &cYou don't have permissions.");
        LangFile.getFile().addDefault("only-players", "%prefix% &cOnly players can run this command!");
        LangFile.getFile().addDefault("command-disabled", "%prefix% &cThis command is disabled");
        LangFile.getFile().addDefault("invalid-target", "%prefix% &cPlayer not found.");

        LangFile.getFile().addDefault("reload.success", "%prefix% &aSuccessfully reloaded!");
        LangFile.getFile().addDefault("reload.error", "%prefix% &cInternal error. Check the console for more info.");

        LangFile.getFile().addDefault("gamemode.changed", "%prefix% &aYour gamemode was changed to &e&o%gamemode%");
        LangFile.getFile().addDefault("gamemode.changed-other", "%prefix% &a%player%'s gamemode was changed to &e&o%gamemode%");
        LangFile.getFile().addDefault("gamemode.usage.console", "%prefix% &cUsage: /gamemode <gamemode> <player>");
        LangFile.getFile().addDefault("gamemode.usage.player", "%prefix% &cUsage: /gamemode <gamemode> &1[player]");

        LangFile.getFile().addDefault("fly.enabled", "%prefix% &aFly enabled.");
        LangFile.getFile().addDefault("fly.disabled", "%prefix% &cFly disabled.");
        LangFile.getFile().addDefault("fly.enabled-other", "%prefix% &aFly enabled for %player%.");
        LangFile.getFile().addDefault("fly.disabled-other", "%prefix% &cFly disabled for %player%.");
        LangFile.getFile().addDefault("fly.usage.console", "%prefix% &cUsage: /fly <player>");
        LangFile.getFile().addDefault("fly.usage.player", "%prefix% &cUsage: /fly &1[player]");

        LangFile.getFile().addDefault("teleport.teleported", "%prefix% &aTeleported to %player%");
        LangFile.getFile().addDefault("teleport.teleported-other", "%prefix% &aTeleported %player% to %target%");
        LangFile.getFile().addDefault("teleport.usage.player", "%prefix% &cUsage: /teleport <player> &1[player]");
        LangFile.getFile().addDefault("teleport.usage.console", "%prefix% &cUsage: /teleport <player> <player>");

        LangFile.getFile().addDefault("god.enabled", "%prefix% &aGodmode enabled.");
        LangFile.getFile().addDefault("god.disabled", "%prefix% &cGodmode disabled.");
        LangFile.getFile().addDefault("god.enabled-other", "%prefix% &aGodmode enabled for %player%.");
        LangFile.getFile().addDefault("god.disabled-other", "%prefix% &cGodmode disabled for %player%.");
        LangFile.getFile().addDefault("god.usage.player", "%prefix% &cUsage: /god &1[player]");
        LangFile.getFile().addDefault("god.usage.console", "%prefix% &cUsage: /god <player>");

        LangFile.getFile().addDefault("heal.healed", "%prefix% &aHealed!");
        LangFile.getFile().addDefault("heal.healed-other", "%prefix% &a%player% has been healed!");
        LangFile.getFile().addDefault("heal.usage.player", "%prefix% &cUsage: /heal &1[player]");
        LangFile.getFile().addDefault("heal.usage.console", "%prefix% &cUsage: /heal <player>");

        LangFile.getFile().addDefault("vanish.enabled", "%prefix% &aVanish turned on.");
        LangFile.getFile().addDefault("vanish.disabled", "%prefix% &aVanish turned off.");
        LangFile.getFile().addDefault("vanish.enabled-other", "%prefix% &aVanish turned on for &e&o%player%.");
        LangFile.getFile().addDefault("vanish.disabled-other", "%prefix% &aVanish turned off for &e&o%player%.");
        LangFile.getFile().addDefault("vanish.usage.player", "%prefix% &cUsage: /vanish &1[player]");
        LangFile.getFile().addDefault("vanish.usage.console", "%prefix% &cUsage: /vanish <player>");

        LangFile.getFile().addDefault("spawn.set", "%prefix% &aSpawn has beed set to %x% %y% %z%.");
        LangFile.getFile().addDefault("spawn.teleported", "%prefix% &aTeleported to spawn");
        LangFile.getFile().addDefault("spawn.teleported-other", "%prefix% &aTeleported %player% to spawn");
        LangFile.getFile().addDefault("spawn.nonexistent", "%prefix% &cSpawn point wasn't set yet");
        LangFile.getFile().addDefault("spawn.usage.admin", "%prefix% &cUsage: /setspawn");
        LangFile.getFile().addDefault("spawn.usage.player", "%prefix% &cUsage: /spawn &1[player]");
        LangFile.getFile().addDefault("spawn.usage.console", "%prefix% &cUsage: /spawn <player>");

    }

    public static void setupSettings(){

        SettingsFile.getFile().addDefault("gamemode.enabled", true);

        SettingsFile.getFile().addDefault("fly.enabled", true);

        SettingsFile.getFile().addDefault("teleport.enabled", true);

        SettingsFile.getFile().addDefault("godmode.enabled", true);

        SettingsFile.getFile().addDefault("heal.enabled", true);

        SettingsFile.getFile().addDefault("vanish.enabled", true);

        SettingsFile.getFile().addDefault("spawn.enabled", true);
        SettingsFile.getFile().addDefault("spawn.on-join", true);

        SettingsFile.getFile().addDefault("trash.enabled", true);

    }

    public static void setSpawnLoc(Location loc){
        StorageFile.getFile().set("spawn.world", loc.getWorld().getName());
        StorageFile.getFile().set("spawn.x", loc.getX());
        StorageFile.getFile().set("spawn.y", loc.getY());
        StorageFile.getFile().set("spawn.z", loc.getZ());
        StorageFile.getFile().set("spawn.pitch", loc.getPitch());
        StorageFile.getFile().set("spawn.yaw", loc.getYaw());
        StorageFile.save();
    }
    public static Location getSpawnLocation(){
        Location loc = new Location(
                Bukkit.getWorld(StorageFile.getFile().getString("spawn.world")),
                StorageFile.getFile().getDouble("spawn.x"),
                StorageFile.getFile().getDouble("spawn.y"),
                StorageFile.getFile().getDouble("spawn.z"),
                (float) StorageFile.getFile().getDouble("spawn.yaw"),
                (float) StorageFile.getFile().getDouble("spawn.pitch")
        );
        return loc;
    }

}
