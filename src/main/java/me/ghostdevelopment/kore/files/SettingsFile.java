package me.ghostdevelopment.kore.files;

import me.ghostdevelopment.kore.Console;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class SettingsFile {

    private static File file;
    private static FileConfiguration config;

    public static void setUp(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("KoreRecoded").getDataFolder(), "config.yml");
        if(!(file.exists())){
            try {
                file.createNewFile();
            }catch (IOException e){
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile(){return config;}
    public static void reload(){config=YamlConfiguration.loadConfiguration(file);}
    public static void save(){
        try {
            config.save(file);
        }catch (Exception e){
            Console.warning("&cCould not write on config.yml file.");
        }
    }
}
