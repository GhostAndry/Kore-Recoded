package me.ghostdevelopment.kore.files;

import lombok.SneakyThrows;
import me.ghostdevelopment.kore.Console;
import me.ghostdevelopment.kore.Kore;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.FileUtil;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

@SuppressWarnings("all")
public class LangFile {

    private static final Kore main = Kore.getInstance();
    private static File file;
    private static FileConfiguration config;

    public static void setUp(){
        Arrays.asList("it", "en", "ru", "es", main.getConfig().getString("messages")).forEach(lang -> setUp(lang));
    }

    @SneakyThrows
    public static void setUp(String lang){
        File file = new File(new File(main.getDataFolder().getPath() + "/lang/"), lang + ".yml");
        if(!file.exists()){
            if (main.getResource(file.getPath().replace('\\', '/'))==null) {
                file.createNewFile();
                // to
            } else main.saveResource(file.getPath(), false);
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile(){return config;}
    public static void reload(){setUp();}
    public static void save(){
        try {
            config.save(file);
        }catch (Exception e){
            Console.warning(e.getMessage());
        }
    }
}