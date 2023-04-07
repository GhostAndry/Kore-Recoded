package me.ghostdevelopment.kore.bukkit.files;

import me.ghostdevelopment.kore.bukkit.Console;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("ALL")
public class HomesFile {
    private static File file;
    private static FileConfiguration homesFile;

    public static void setUp(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("KoreRecoded").getDataFolder(), "homes.yml");
        if(!(file.exists())){
            try {
                file.createNewFile();
            }catch (IOException e){
            }
        }
        homesFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile(){return homesFile;}
    public static void reload(){homesFile=YamlConfiguration.loadConfiguration(file);}
    public static void save(){
        try {
            homesFile.save(file);
        }catch (Exception e){
            Console.warning("&cCould not write on homes.yml file.");
        }
    }

}
