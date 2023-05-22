package me.ghostdevelopment.kore;

import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import me.ghostdevelopment.kore.files.StorageFile;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Functions {

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

        LangFile.getFile().addDefault("orbitalcannon.shoot", "%prefix% &aThe Orbital Cannon fired a shot at %coords%.");
        LangFile.getFile().addDefault("orbitalcannon.tell", "%prefix% &c&lYou've been hit by an orbital cannon shot!");
        LangFile.getFile().addDefault("orbitalcannon.usage", "%prefix% &cUsage: /orbitalcannon <player | x y z>");

        LangFile.getFile().addDefault("smite.smited-player", "%prefix% &aSmited %player%");
        LangFile.getFile().addDefault("smite.usage", "%prefix% &cUsage: /smite <player>");

        LangFile.getFile().addDefault("kill.killed", "%prefix% &aKilled %player%.");
        LangFile.getFile().addDefault("kill.usage.player", "%prefix% &cUsage: /kill &1[player]");
        LangFile.getFile().addDefault("kill.usage.console", "%prefix% &cUsage: /kill <player>");

        LangFile.getFile().addDefault("warp.warped", "%prefix% &aYou have been warped to %warp%");
        LangFile.getFile().addDefault("warp.warped-other", "%prefix% &aYou have warped %player% to %warp%");
        LangFile.getFile().addDefault("warp.not-found", "%prefix% &cWarp not found.");
        LangFile.getFile().addDefault("warp.admin.added", "%prefix% &a%warp% was succesfully added.");
        LangFile.getFile().addDefault("warp.admin.already-exist", "%prefix% &c%warp% already exist");
        LangFile.getFile().addDefault("warp.admin.removed", "%prefix% &a%warp% was succesfully removed.");
        LangFile.getFile().addDefault("warp.usage.player", "%prefix% &cUsage: /warp <name> &1[player]");
        LangFile.getFile().addDefault("warp.usage.console", "%prefix% &cUsage: /warp <name> <player>");
        LangFile.getFile().addDefault("warp.usage.admin.add", "%prefix% &cUsage: /warp add <name>");
        LangFile.getFile().addDefault("warp.usage.admin.remove", "%prefix% &cUsage: /warp remove <name>");

        LangFile.getFile().addDefault("home.teleported", "%prefix% &aYou have been teleported to your home.");
        LangFile.getFile().addDefault("home.teleported-other", "%prefix% &aYou have teleported %player% to his house.");
        LangFile.getFile().addDefault("home.not-set", "%prefix% &cYou haven't set your home yet.");
        LangFile.getFile().addDefault("home.set", "%prefix% &aYour home has been set to your position.");
        LangFile.getFile().addDefault("home.removed", "%prefix% &cYour home has been removed.");
        LangFile.getFile().addDefault("home.usage", "%prefix% &cUsage /home &1[set|remove]");

        LangFile.getFile().addDefault("speed.set", "%prefix% Your speed was set to %speed%");
        LangFile.getFile().addDefault("speed.set-other", "%prefix% %player%'s speed was set to %speed%");
        LangFile.getFile().addDefault("speed.invalid-value", "%prefix% &cInvalid speed value");
        LangFile.getFile().addDefault("speed.invalid-type", "%prefix% &cInvalid speed type. Speed types: Walk or Walking, Fly or Flight");
        LangFile.getFile().addDefault("speed.usage.player", "%prefix% &cUsage: /speed <value> &1[player] [type]");
        LangFile.getFile().addDefault("speed.usage.console", "%prefix% &cUsage: /speed <value> <player> <type>");

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

        SettingsFile.getFile().addDefault("orbitalcannon.enabled", true);
        SettingsFile.getFile().addDefault("orbitalcannon.tell-to-victim", true);

        SettingsFile.getFile().addDefault("smite.enable", true);

        SettingsFile.getFile().addDefault("kill.enabled", true);

        SettingsFile.getFile().addDefault("warp.enabled", true);

        SettingsFile.getFile().addDefault("home.enabled", true);

        SettingsFile.getFile().addDefault("speed.enabled", true);

        SettingsFile.getFile().addDefault("chat.enabled", true);
        SettingsFile.getFile().addDefault("chat.format", "%sender%: %message%");
        List<String> words = new ArrayList<>();
        words.add("fuck");
        words.add("shit");
        SettingsFile.getFile().addDefault("chat.blacklist-words", words);

    }

// /////////////////////////////////////////////////////////////////////////////////////////////////////

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

// /////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void addWarp(Location location, String warp_name){
        warp_name=warp_name.toLowerCase();

        StorageFile.getFile().set("warps."+warp_name+".world", location.getWorld().getName());
        StorageFile.getFile().set("warps."+warp_name+".x", location.getX());
        StorageFile.getFile().set("warps."+warp_name+".y", location.getY());
        StorageFile.getFile().set("warps."+warp_name+".z", location.getZ());
        StorageFile.getFile().set("warps."+warp_name+".yaw", location.getYaw());
        StorageFile.getFile().set("warps."+warp_name+".pitch", location.getPitch());
        StorageFile.save();

    }

    public static Location getWarpLoc(String warp_name){
        warp_name=warp_name.toLowerCase();
        Location loc = new Location(
                Bukkit.getWorld(StorageFile.getFile().getString("warps."+warp_name+".world")),
                StorageFile.getFile().getDouble("warps."+warp_name+".x"),
                StorageFile.getFile().getDouble("warps."+warp_name+".y"),
                StorageFile.getFile().getDouble("warps."+warp_name+".z"),
                (float) StorageFile.getFile().getDouble("warps."+warp_name+".yaw"),
                (float) StorageFile.getFile().getDouble("warps."+warp_name+".pitch")
        );
        return loc;
    }

    public static void delWarp(String warp_name){
        warp_name=warp_name.toLowerCase();

        StorageFile.getFile().set("warps."+warp_name+".world", null);
        StorageFile.getFile().set("warps."+warp_name+".x", null);
        StorageFile.getFile().set("warps."+warp_name+".y", null);
        StorageFile.getFile().set("warps."+warp_name+".z", null);
        StorageFile.getFile().set("warps."+warp_name+".yaw", null);
        StorageFile.getFile().set("warps."+warp_name+".pitch", null);
        StorageFile.getFile().set("warps."+warp_name, null);
        StorageFile.save();

    }

    public static Boolean checkWarp(String warp_name){
        warp_name=warp_name.toLowerCase();
        if(StorageFile.getFile().contains("warps."+warp_name)){
            return true;
        }else{
            return false;
        }

    }

// /////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void addHome(Player player){

        String name= player.getName();
        Location location = player.getLocation();

        name=name.toLowerCase();

        StorageFile.getFile().set("homes."+name+".world", location.getWorld().getName());
        StorageFile.getFile().set("homes."+name+".x", location.getX());
        StorageFile.getFile().set("homes."+name+".y", location.getY());
        StorageFile.getFile().set("homes."+name+".z", location.getZ());
        StorageFile.getFile().set("homes."+name+".yaw", location.getYaw());
        StorageFile.getFile().set("homes."+name+".pitch", location.getPitch());
        StorageFile.save();

    }

    public static void delHome(Player player){

        String name= player.getName();
        Location location = player.getLocation();

        name=name.toLowerCase();

        StorageFile.getFile().set("homes."+name+".world", null);
        StorageFile.getFile().set("homes."+name+".x", null);
        StorageFile.getFile().set("homes."+name+".y", null);
        StorageFile.getFile().set("homes."+name+".z", null);
        StorageFile.getFile().set("homes."+name+".yaw", null);
        StorageFile.getFile().set("homes."+name+".pitch", null);
        StorageFile.getFile().set("homes."+name, null);
        StorageFile.save();

    }

    public static Location getHomeLoc(Player player){

        String name= player.getName();

        name=name.toLowerCase();

        Location loc = new Location(
                Bukkit.getWorld(StorageFile.getFile().getString("homes."+name+".world")),
                StorageFile.getFile().getDouble("homes."+name+".x"),
                StorageFile.getFile().getDouble("homes."+name+".y"),
                StorageFile.getFile().getDouble("homes."+name+".z"),
                (float) StorageFile.getFile().getDouble("homes."+name+".yaw"),
                (float) StorageFile.getFile().getDouble("homes."+name+".pitch")
        );
        return loc;
    }

    public static Boolean checkHome(Player player){

        String name= player.getName();

        name=name.toLowerCase();

        if(StorageFile.getFile().contains("homes."+name)){
            return true;
        }else{
            return false;
        }

    }

// /////////////////////////////////////////////////////////////////////////////

    public static void setSpeed(Player player, String type, Float speed){
    
        if(type.equals("walk")){
            player.setWalkSpeed(speed / 10.0f);
        } else if (type.equals("fly") || type.equals("flight")) {
            player.setFlySpeed(speed / 10.0f);
        }
    
    }

}
