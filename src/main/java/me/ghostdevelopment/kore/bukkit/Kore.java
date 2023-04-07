package me.ghostdevelopment.kore.bukkit;

import me.ghostdevelopment.kore.bukkit.commands.Command;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
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

    }


}
