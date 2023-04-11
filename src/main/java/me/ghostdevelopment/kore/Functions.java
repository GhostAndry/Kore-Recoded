package me.ghostdevelopment.kore;

import me.ghostdevelopment.kore.files.*;


@SuppressWarnings("ALL")
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
        LangFile.getFile().addDefault("command-disabled", "%prefix% &cThis command is disabled");
        LangFile.getFile().addDefault("invalid-target", "%prefix% &cPlayer not found.");

        LangFile.getFile().addDefault("reload.success", "%prefix% &aSuccessfully reloaded!");
        LangFile.getFile().addDefault("reload.error", "%prefix% &cInternal error. Check the console for more info.");

        LangFile.getFile().addDefault("gamemode.changed", "%prefix% &aYour gamemode was changed to %gamemode%");
        LangFile.getFile().addDefault("gamemode.changed-other", "%prefix% %player%'s gamemode was changed to %gamemode%");
        LangFile.getFile().addDefault("gamemode.usage.console", "%prefix% &cUsage: /gamemode <gamemode> <player>");
        LangFile.getFile().addDefault("gamemode.usage.player", "%prefix% &cUsage: /gamemode <gamemode> [player]");


    }

}
