package me.ghostdevelopment.kore;

import lombok.Getter;
import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.events.ChatManager;
import me.ghostdevelopment.kore.events.GodMode;
import me.ghostdevelopment.kore.events.SpawnOnJoin;
import me.ghostdevelopment.kore.events.VanishPlayer;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import me.ghostdevelopment.kore.files.StorageFile;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@SuppressWarnings("ALL")
public final class Kore extends JavaPlugin {

    @Getter private static Kore instance;

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        Metrics metrics = new Metrics(this, 18653);

        if(getServer().getPluginManager().getPlugin("PlaceholderAPI")!=null){
            new RegisterPlaceholders().register();
        }else{
            Console.warning("PlaceholderAPI is absent in minecraft server.\nPlaceholders won't work without it!");
        }

        setupFiles();
        try {
            registerCommands();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        registerEvents();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String packageName = getClass().getPackage().getName();
        for(Class<? extends Command> clazz: new Reflections(packageName + ".commands.commands").getSubTypesOf(Command.class)){
            Command command = clazz.getDeclaredConstructor().newInstance();
            try {
                getCommand(command.getCommandInfo().name()).setExecutor(command);
                Console.info("[Kore] Enabled %module% module"
                        .replace("%module%", command.getCommandInfo().name())
                );
            } catch (Exception e) {
                System.err.println("[Kore] Can't load %module% module"
                        .replace("%module%", command.getCommandInfo().name())
                );
            }
        }
    }

    private void registerEvents(){
        ArrayList<Listener> events = new ArrayList<>();

        //add all events and listeners
        if(SettingsFile.getFile().getBoolean("godmode.enabled")){
            events.add(new GodMode());
        }
        if(SettingsFile.getFile().getBoolean("vanish.enabled")){
            events.add(new VanishPlayer());
        }
        if(SettingsFile.getFile().getBoolean("spawn.enabled")){
            if(SettingsFile.getFile().getBoolean("spawn.on-join")){
                events.add(new SpawnOnJoin());
            }
        }

        if(SettingsFile.getFile().getBoolean("chat.enabled")){
            events.add(new ChatManager());
        }

        for(Listener l : events){
            getServer().getPluginManager().registerEvents(l, this);
        }
    }

    private void setupFiles(){
        SettingsFile.setUp();
        Functions.setupSettings();
        SettingsFile.getFile().options().copyDefaults(true);
        SettingsFile.save();

        LangFile.setUp();
        Functions.setLangFile();
        LangFile.getFile().options().copyDefaults(true);
        LangFile.save();

        StorageFile.setUp();
        StorageFile.getFile().options().copyDefaults(true);
        StorageFile.save();
    }

}