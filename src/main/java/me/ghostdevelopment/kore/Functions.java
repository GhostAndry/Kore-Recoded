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
        LangFile.getFile().addDefault("gamemode.usage.player", "%prefix% &cUsage: /gamemode <gamemode> &1[player]");

        LangFile.getFile().addDefault("fly.enabled", "%prefix% &aFly enabled.");
        LangFile.getFile().addDefault("fly.disabled", "%prefix% &cFly disabled.");
        LangFile.getFile().addDefault("fly.enabled-other", "%prefix% &aFly enabled for %player%.");
        LangFile.getFile().addDefault("fly.disabled-other", "%prefix% &cFly disabled for %player%.");
        LangFile.getFile().addDefault("fly.usage.console", "%prefix% &cUsage: /fly <player>");
        LangFile.getFile().addDefault("fly.usage.player", "%prefix% &cUsage: /fly &1[player]");

        LangFile.getFile().addDefault("teleport.teleported", "%prefix% &aTeleported to %player%");
        LangFile.getFile().addDefault("teleport.teleported-other", "%prefix% &aTeleported %player% to %target%");
        LangFile.getFile().addDefault("teleport.usage.player", "%prefix% &cUsage: /teleport <player> &1[player]");
        LangFile.getFile().addDefault("teleport.usage.console", "%prefix% &cUsage: /teleport <player> <player>");

        LangFile.getFile().addDefault("god.enabled", "%prefix% &aGodmode enabled.");
        LangFile.getFile().addDefault("god.disabled", "%prefix% &cGodmode disabled.");
        LangFile.getFile().addDefault("god.enabled-other", "%prefix% &aGodmode enabled for %player%.");
        LangFile.getFile().addDefault("god.disabled-other", "%prefix% &cGodmode disabled for %player%.");
        LangFile.getFile().addDefault("god.usage.player", "%prefix% &cUsage: /god &1[player]");
        LangFile.getFile().addDefault("god.usage.console", "%prefix% &cUsage: /god <player>");

    }

    public static void setupSettings(){

        SettingsFile.getFile().addDefault("gamemode.enabled", true);
        SettingsFile.getFile().addDefault("fly.enabled", true);
        SettingsFile.getFile().addDefault("teleport.enabled", true);
        SettingsFile.getFile().addDefault("godmode.enabled", true);

    }

}
