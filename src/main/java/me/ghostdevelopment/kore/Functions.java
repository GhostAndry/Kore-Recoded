package me.ghostdevelopment.kore;

import me.ghostdevelopment.kore.files.*;
import org.bukkit.configuration.file.FileConfiguration;

public class Functions {

    private static Kore plugin;

    public static void reloadFiles(){

        plugin.reloadConfig();
        FreezeLocFile.reload();
        HomesFile.reload();
        LangFile.reload();
        SpawnFile.reload();
        WarpsFile.reload();

    }

    public static void setLangFile(){

        LangFile.getFile().addDefault("prefix", "&b&lKore&f:");
        LangFile.getFile().addDefault("no-permissions", "%prefix% &cYou don't have permissions.");
        LangFile.getFile().addDefault("only-players", "%prefix% &cOnly players can run this command!");
        LangFile.getFile().addDefault("reload.success", "%prefix% &aSuccessfully reloaded!");
        LangFile.getFile().addDefault("reload.error", "%prefix% &cInternal error. Check the console for more info.");

    }

}
