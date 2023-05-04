package me.ghostdevelopment.kore;

import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.events.GodMode;
import me.ghostdevelopment.kore.events.SpawnOnJoin;
import me.ghostdevelopment.kore.events.VanishPlayer;
import me.ghostdevelopment.kore.files.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.util.ArrayList;

public final class Kore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        setupFiles();
        registerCommands();
        registerEvents();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @SuppressWarnings("ALL")
    private void registerCommands(){
        String packageName = getClass().getPackage().getName();
        for(Class<? extends Command> clazz: new Reflections(packageName + ".commands.commands").getSubTypesOf(Command.class)){
            try {
                Command command = clazz.getDeclaredConstructor().newInstance();
                getCommand(command.getCommandInfo().name()).setExecutor(command);
                Console.info("[KoreRecoded] Enabled %module% module"
                        .replace("%module%", command.getCommandInfo().name())
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
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


    /*

    TODO: Speed
    TODO: Kill,
    TODO: Smite,
    TODO: Explode,
    TODO: Home,
    TODO: Trash,
    TODO: Warp

    */


}
