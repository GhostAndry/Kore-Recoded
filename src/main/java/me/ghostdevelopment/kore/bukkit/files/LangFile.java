package me.ghostdevelopment.kore.bukkit.files;

import me.ghostdevelopment.kore.bukkit.Console;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LangFile {

    private static File file;
    private static FileConfiguration config;

    public static void setUp(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("KoreRecoded").getDataFolder(), "language.yml");
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
            Console.warning("&cCould not write on language.yml file.");
        }
    }

}
