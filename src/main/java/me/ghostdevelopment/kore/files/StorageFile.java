package me.ghostdevelopment.kore.files;

import me.ghostdevelopment.kore.Console;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("ALL")
public class StorageFile {

    private static File file;
    private static FileConfiguration warpsFile;

    public static void setUp(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("KoreRecoded").getDataFolder(), "storage.yml");
        if(!(file.exists())){
            try {
                file.createNewFile();
            }catch (IOException e){
            }
        }
        warpsFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile(){return warpsFile;}
    public static void reload(){warpsFile=YamlConfiguration.loadConfiguration(file);}
    public static void save(){
        try {
            warpsFile.save(file);
        }catch (Exception e){
            Console.warning("&cCould not write on warps.yml file.");
        }
    }
}
