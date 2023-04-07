package me.ghostdevelopment.kore.bukkit;

import me.ghostdevelopment.kore.bukkit.files.*;

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

}
