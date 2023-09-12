package me.ghostdevelopment.kore;

import lombok.Getter;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.commands.commands.fun.CommandSpawnmob;
import me.ghostdevelopment.kore.events.*;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import me.ghostdevelopment.kore.files.StorageFile;
import me.ghostdevelopment.kore.utils.Console;
import me.ghostdevelopment.kore.utils.Metrics;
import me.ghostdevelopment.kore.utils.RegisterPlaceholders;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
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

        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new RegisterPlaceholders().register();
        } else {
            Console.warning("PlaceholderAPI is absent in minecraft server.\nPlaceholders won't work without it!");
        }

        saveDefaultConfig();
        setupFiles();
        addEntities();
        try {
            registerCommands();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        registerEvents();

        new UpdateChecker(this, 107023).getVersion(version -> {
            if (!this.getDescription().getVersion().equals(version)) {
                getLogger().info("There is a new update available.Version: " + version);
            }
        });

    }

    public static int calculateY(){
        String serverVersion = Bukkit.getServer().getVersion();
        String[] versionParts = serverVersion.split("\\.");
        int majorVersion = Integer.parseInt(versionParts[1]);

        if(majorVersion>=18) return -64;
        else return 0;
    }

    private void addEntities(){
        String serverVersion = Bukkit.getServer().getVersion();
        String[] versionParts = serverVersion.split("\\.");
        int majorVersion = Integer.parseInt(versionParts[1]);

        switch (majorVersion) {
            case 8:
                for (EntityType entityType : EntityType.values()) {
                    if (entityType.isAlive() && !entityType.name().equals("PLAYER")) {
                        CommandSpawnmob.getEntities().add(entityType);
                    }
                }
                break;
            case 9:
                for (EntityType entityType : EntityType.values()) {
                    if (entityType.isAlive() && !entityType.name().equals("PLAYER")) {
                        CommandSpawnmob.getEntities().add(entityType);
                    }
                }
                break;
            case 10:
                for (EntityType entityType : EntityType.values()) {
                    if (entityType.isAlive() && !entityType.name().equals("PLAYER")) {
                        CommandSpawnmob.getEntities().add(entityType);
                    }
                }
                break;
            case 11:
                for (EntityType entityType : EntityType.values()) {
                    if (entityType.isAlive() && !entityType.name().equals("PLAYER")) {
                        CommandSpawnmob.getEntities().add(entityType);
                    }
                }
                break;
            case 12:
                for (EntityType entityType : EntityType.values()) {
                    if (entityType.isAlive() && !entityType.name().equals("PLAYER")) {
                        CommandSpawnmob.getEntities().add(entityType);
                    }
                }
                break;
            case 13:
                for (EntityType entityType : EntityType.values()) {
                    if (entityType.isAlive() && !entityType.name().equals("PLAYER")) {
                        CommandSpawnmob.getEntities().add(entityType);
                    }
                }
                break;
            case 14:
                for (EntityType entityType : EntityType.values()) {
                    if (entityType.isAlive() && !entityType.name().equals("PLAYER")) {
                        CommandSpawnmob.getEntities().add(entityType);
                    }
                }
                break;
            case 15:
                for (EntityType entityType : EntityType.values()) {
                    if (entityType.isAlive() && !entityType.name().equals("PLAYER")) {
                        CommandSpawnmob.getEntities().add(entityType);
                    }
                }
                break;
            case 16:
                for (EntityType entityType : EntityType.values()) {
                    if (entityType.isAlive() && !entityType.name().equals("PLAYER")) {
                        CommandSpawnmob.getEntities().add(entityType);
                    }
                }
                break;
            case 17:
                for (EntityType entityType : EntityType.values()) {
                    if (entityType.isAlive() && !entityType.name().equals("PLAYER")) {
                        CommandSpawnmob.getEntities().add(entityType);
                    }
                }
                break;
            case 18:
                for (EntityType entityType : EntityType.values()) {
                    if (entityType.isAlive() && !entityType.name().equals("PLAYER")) {
                        CommandSpawnmob.getEntities().add(entityType);
                    }
                }
                break;
            case 19:
                for (EntityType entityType : EntityType.values()) {
                    if (entityType.isAlive() && !entityType.name().equals("PLAYER")) {
                        CommandSpawnmob.getEntities().add(entityType);
                    }
                }
                break;
            case 20:
                for (EntityType entityType : EntityType.values()) {
                    if (entityType.isAlive() && !entityType.name().equals("PLAYER")) {
                        CommandSpawnmob.getEntities().add(entityType);
                    }
                }
                break;
            default:
                break;
        }
        return;
    }

    private void registerCommands() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String packageName = getClass().getPackage().getName();
        for(Class<? extends KoreCommand> clazz: new Reflections(packageName + ".commands.commands").getSubTypesOf(KoreCommand.class)){
            KoreCommand command = null;
            try {
                command = clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            try {
                getCommand(command.getCommandInfo().name()).setExecutor(command);
                if(command.getCommandInfo().tabCompleter()){
                    getCommand(command.getCommandInfo().name()).setTabCompleter(command);
                }
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

        if(SettingsFile.getFile().getBoolean("godmode.enabled")){
            events.add(new GodMode());
        }
        if(SettingsFile.getFile().getBoolean("vanish.enabled")){
            events.add(new VanishPlayer());
        }
        if(SettingsFile.getFile().getBoolean("spawn.enabled")){
            if(SettingsFile.getFile().getBoolean("spawn.on-join")){
                events.add(new Spawn());
            }
        }

        if(SettingsFile.getFile().getBoolean("chat.enabled")){
            events.add(new ChatManager());
        }

        if(SettingsFile.getFile().getBoolean("world-manipulator.enable")){
            events.add(new WorldManipulator());
        }

        if(!(Kore.getInstance().getConfig().getString("server.join-msg") == null || Kore.getInstance().getConfig().getString("server.join-msg").isEmpty())){
            events.add(new JoinMSG());
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
TODO: Add weather command
TODO: Add time command

*/