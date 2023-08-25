package me.ghostdevelopment.kore;

import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import me.ghostdevelopment.kore.files.StorageFile;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Functions {

    public static void reloadFiles(){

        try {
            Bukkit.getScheduler().runTask(Kore.getInstance(), () -> {
                Bukkit.getPluginManager().disablePlugin(Kore.getInstance());
                Bukkit.getPluginManager().enablePlugin(Kore.getInstance());
            });
            SettingsFile.reload();
            LangFile.reload();
            StorageFile.reload();
        }catch (Exception ignored){}

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

// /////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void addHologram(String name, Location location){

        String path = "holograms."+name+".";

        StorageFile.getFile().set(path+".x",location.getX());
        StorageFile.getFile().set(path+".y",location.getY());
        StorageFile.getFile().set(path+".z",location.getZ());
        StorageFile.getFile().set(path+".world",String.valueOf(location.getWorld().getName()));
        List<String> lines = new ArrayList<>();
        lines.add(null);
        for(String line : lines){
            StorageFile.getFile().set(path+".lines", line);
        }
        StorageFile.save();

    }

    public static void addLines(String name, List<String> lines){

        String path = "holograms."+name+".";

        StorageFile.getFile().set(path+".lines", lines);
        StorageFile.save();

    }

    public static void removeHolo(String name){

        String path = "holograms."+name;
        StorageFile.getFile().set(path, null);
        StorageFile.save();

    }

    public static void removeLine(String name, Integer line) {
        String path = "holograms." + name + '.';
        List<?> lines = StorageFile.getFile().getList(path + "lines");

        if (line >= 0 && line < lines.size()) {
            lines.remove(line);
            StorageFile.getFile().set(path + ".lines", String.valueOf(lines));
            StorageFile.save();
        } else {
            System.out.println("Invalid line number. The line does not exist.");
        }
    }

}
