package me.ghostdevelopment.kore;

import lombok.Getter;
import me.ghostdevelopment.kore.commands.KoreCommand;
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

        System.out.println("\n\n" +
                " _  __              \n" +
                "| |/ /              \n" +
                "| ' / ___  _ __ ___ \n" +
                "|  < / _ \\| '__/ _ \\\n" +
                "| . \\ (_) | | |  __/\n" +
                "|_|\\_\\___/|_|  \\___|\n" +
                "\n");

        Metrics metrics = new Metrics(this, 18653);

        metrics.addCustomChart(new Metrics.SimplePie("language", () -> {
            return SettingsFile.getFile().getString("messages");
        }));

        if(getServer().getPluginManager().getPlugin("PlaceholderAPI")!=null){
            new RegisterPlaceholders().register();
        }else{
            Console.warning("PlaceholderAPI is absent in minecraft server.\nPlaceholders won't work without it!");
        }

        saveDefaultConfig();
        setupFiles();
        try {
            registerCommands();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        registerEvents();

        new UpdateChecker(this, 107023).getVersion(version -> {
            if (!this.getDescription().getVersion().equals(version)) {
                getLogger().info("[Kore] There is a new update available.Version: "+version);
            }
        });

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String packageName = getClass().getPackage().getName();
        for(Class<? extends KoreCommand> clazz: new Reflections(packageName + ".commands.commands").getSubTypesOf(KoreCommand.class)){
            KoreCommand command = clazz.getDeclaredConstructor().newInstance();
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

        LangFile.setUp();
        LangFile.getFile().options().copyDefaults(true);
        LangFile.save();

        StorageFile.setUp();
        StorageFile.getFile().options().copyDefaults(true);
        StorageFile.save();
    }

}


/*

TODO: TPA COMMAND
TODO: Add hexacolor support
TODO: Add color permission
TODO: Add weather command
TODO: Add time command

 */