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
    public static void setUp(String lang) {
        File langFolder = new File(main.getDataFolder().getPath() + "/lang/");
        if (!langFolder.exists()) {
            langFolder.mkdirs();
        }

        File file = new File(langFolder, lang + ".yml");
        if (!file.exists()) {
            String resourcePath = "lang/" + lang + ".yml";
            if (main.getResource(resourcePath) == null) {
                file.createNewFile();
            } else {
                main.saveResource(resourcePath, false);
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static boolean checkFileExists(String lang) {
        File langFolder = new File(main.getDataFolder().getPath() + "/lang/");
        File file = new File(langFolder, lang + ".yml");
        return file.exists();
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