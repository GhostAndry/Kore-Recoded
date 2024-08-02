package me.ghostdevelopment.kore.commands.impl.admin;

import me.ghostdevelopment.kore.Kore;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

@CommandInfo(name = "killmobs", permission = "kore.killmobs")
public class CommandKillMobs extends KoreCommand {

    private static final Set<EntityType> EXCLUDED_ENTITIES = new HashSet<>();

    static {
        EXCLUDED_ENTITIES.add(EntityType.DROPPED_ITEM);
        EXCLUDED_ENTITIES.add(EntityType.FALLING_BLOCK);
        EXCLUDED_ENTITIES.add(EntityType.PRIMED_TNT);
        EXCLUDED_ENTITIES.add(EntityType.ITEM_FRAME);
        EXCLUDED_ENTITIES.add(EntityType.ARMOR_STAND);
        EXCLUDED_ENTITIES.add(EntityType.ENDER_CRYSTAL);
        EXCLUDED_ENTITIES.add(EntityType.SPLASH_POTION);
        EXCLUDED_ENTITIES.add(EntityType.ARROW);
        EXCLUDED_ENTITIES.add(EntityType.SNOWBALL);
        EXCLUDED_ENTITIES.add(EntityType.EGG);
        EXCLUDED_ENTITIES.add(EntityType.FIREBALL);
        EXCLUDED_ENTITIES.add(EntityType.SMALL_FIREBALL);
        EXCLUDED_ENTITIES.add(EntityType.ENDER_PEARL);
        EXCLUDED_ENTITIES.add(EntityType.WITHER_SKULL);
        EXCLUDED_ENTITIES.add(EntityType.MINECART);
        EXCLUDED_ENTITIES.add(EntityType.MINECART_CHEST);
        EXCLUDED_ENTITIES.add(EntityType.MINECART_FURNACE);
        EXCLUDED_ENTITIES.add(EntityType.MINECART_TNT);
        EXCLUDED_ENTITIES.add(EntityType.MINECART_HOPPER);
        EXCLUDED_ENTITIES.add(EntityType.MINECART_MOB_SPAWNER);
        EXCLUDED_ENTITIES.add(EntityType.FIREWORK);
        EXCLUDED_ENTITIES.add(EntityType.FISHING_HOOK);
        EXCLUDED_ENTITIES.add(EntityType.LIGHTNING);
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!SettingsFile.getFile().getBoolean("killmobs.enabled")) {
            sender.sendMessage(LangFile.getString("command-disabled"));
            return;
        }

        if (args.length != 0) {
            sender.sendMessage(LangFile.getString("killmobs.usage"));
            return;
        }

        if (SettingsFile.getFile().getBoolean("killmobs.async")) {
            Bukkit.getScheduler().runTask(Kore.getInstance(), () -> {
                killMobs();
                sender.sendMessage(LangFile.getString("killmobs.killed"));
            });
        } else {
            killMobs();
            sender.sendMessage(LangFile.getString("killmobs.killed"));
        }
    }

    private void killMobs() {
        for (World world : Bukkit.getWorlds()) {
            for (Entity entity : world.getEntities()) {
                if (!EXCLUDED_ENTITIES.contains(entity.getType())) {
                    entity.remove();
                }
            }
        }
    }
}
