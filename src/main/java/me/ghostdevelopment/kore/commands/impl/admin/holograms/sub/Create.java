package me.ghostdevelopment.kore.commands.impl.admin.holograms.sub;

import me.ghostdevelopment.kore.commands.SubCommands;
import me.ghostdevelopment.kore.files.LangFile;
import org.bukkit.entity.Player;

public class Create extends SubCommands {

    public Create() {
        super("create", LangFile.getString("holorams.usage.create"));
    }

    @Override
    public void execute(Player player, String[] args) {

    }
}
