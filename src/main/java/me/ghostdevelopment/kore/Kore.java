package me.ghostdevelopment.kore;

import me.ghostdevelopment.kore.commands.Command;
import me.ghostdevelopment.kore.files.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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


    private void registerCommands(){
        String packageName = getClass().getPackage().getName();
        for(Class<? extends Command> clazz: new Reflections(packageName + ".commands.commands").getSubTypesOf(Command.class)){
            try {
                Command command = clazz.getDeclaredConstructor().newInstance();
                getCommand(command.getCommandInfo().name()).setExecutor(command);
                Bukkit.getLogger().info(ChatColor.GREEN+"Command %command% ha been loaded.".replace("%command%", command.getCommandInfo().name()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void registerEvents(){
        ArrayList<Listener> events = new ArrayList<>();

        //add all events and listeners


        for(Listener l : events){
            getServer().getPluginManager().registerEvents(l, this);
        }


    }

    private void setupFiles(){
        FreezeLocFile.setUp();
        FreezeLocFile.getFile().options().copyDefaults(true);
        FreezeLocFile.save();

        HomesFile.setUp();
        HomesFile.getFile().options().copyDefaults(true);
        HomesFile.save();

        LangFile.setUp();
        LangFile.getFile().options().copyDefaults(true);
        LangFile.save();

        SpawnFile.setUp();
        SpawnFile.getFile().options().copyDefaults(true);
        SpawnFile.save();

        WarpsFile.setUp();
        WarpsFile.getFile().options().copyDefaults(true);
        WarpsFile.save();
    }

}
