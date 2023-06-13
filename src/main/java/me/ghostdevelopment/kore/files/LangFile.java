package me.ghostdevelopment.kore.files;

import me.ghostdevelopment.kore.Console;
import me.ghostdevelopment.kore.Kore;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("all")
public class LangFile {

    private static final Kore main = Kore.getInstance();
    private static File file;
    private static FileConfiguration config;

    public static void setUp(){
        String path = main.getDataFolder().getPath() + "/lang/";
        File dir = new File(path);
        File file = new File(dir, lang + ".yml");
        if(!(file.exists())){
            main.saveResource(file.getName(), false);
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile(){return config;}
    public static void reload(){config=YamlConfiguration.loadConfiguration(file);}
    public static void save(){
        try {
            config.save(file);
        }catch (Exception e){
            Console.warning("&cCould not write on .");
        }
    }
}