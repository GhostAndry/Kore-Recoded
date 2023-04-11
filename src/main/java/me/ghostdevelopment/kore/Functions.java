package me.ghostdevelopment.kore;

import me.ghostdevelopment.kore.files.*;


@SuppressWarnings("ALL")
public class Functions {

    private static Kore plugin;

    public static void reloadFiles(){

        SettingsFile.reload();
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

        LangFile.getFile().addDefault("gamemode.changed", "%prefix% &aYour gamemode was changed to &e&o%gamemode%");
        LangFile.getFile().addDefault("gamemode.changed-other", "%prefix% &a%player%'s gamemode was changed to &e&o%gamemode%");
        LangFile.getFile().addDefault("gamemode.usage.console", "%prefix% &cUsage: /gamemode <gamemode> <player>");
        LangFile.getFile().addDefault("gamemode.usage.player", "%prefix% &cUsage: /gamemode <gamemode> &7[player]");

        LangFile.getFile().addDefault("fly.enabled", "%prefix% &aFly enabled.");
        LangFile.getFile().addDefault("fly.disabled", "%prefix% &aFly disabled.");
        LangFile.getFile().addDefault("fly.enabled-other", "%prefix% &aFly enabled.");
        LangFile.getFile().addDefault("fly.disabled-other", "%prefix% &aFly disabled.");
        LangFile.getFile().addDefault("fly.usage.console", "");
        LangFile.getFile().addDefault("fly.usage.player", "");

    }

    public static void setupSettings(){

        SettingsFile.getFile().addDefault("gamemode.enabled", true);
        SettingsFile.getFile().addDefault("fly.enabled", true);

    }

}
