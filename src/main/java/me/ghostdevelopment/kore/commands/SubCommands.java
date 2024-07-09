package me.ghostdevelopment.kore.commands;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

@Getter
@Setter
public abstract class SubCommands {

    private String name;
    private String syntax;

    public SubCommands(String name, String syntax) {
        this.name = name;
        this.syntax = syntax;
    }

    public abstract void execute(Player player, String[] args);
}
