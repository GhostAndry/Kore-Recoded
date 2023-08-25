package me.ghostdevelopment.kore.commands.commands.admin;

import me.ghostdevelopment.kore.Functions;
import me.ghostdevelopment.kore.Kore;
import me.ghostdevelopment.kore.commands.CommandInfo;
import me.ghostdevelopment.kore.commands.KoreCommand;
import me.ghostdevelopment.kore.files.LangFile;
import me.ghostdevelopment.kore.files.SettingsFile;
import me.ghostdevelopment.kore.files.StorageFile;
import me.ghostdevelopment.kore.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@CommandInfo(name = "holo", permission = "kore.holo", tabCompleter = true)
public class CommandHologram extends KoreCommand {

    private static String defaultLine1 = Color.Color("&fYou can add lines using &b/holo addline <text>");
    private static String defaultLine2 = Color.Color("&f and remove this using &b/holo removeline <line num>");

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(SettingsFile.getFile().getBoolean("holograms.enabled"))){
            sender.sendMessage(Color.Color(LangFile.getFile().getString("command-disabled")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
            return;
        }

        if(sender instanceof Player){
            Player player = ((Player) sender);

            if(args.length==0||args.length==1){
                player.sendMessage(Color.Color(LangFile.getFile().getString("holograms.usage")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return;
            } else if (args.length==2) {

                if(args[0].equalsIgnoreCase("create")){
                    String name = args[1];
                    Functions.addHologram(name, player.getLocation());
                    List<String> lines = new ArrayList<>();
                    lines.add(Color.Color(defaultLine1));
                    lines.add(Color.Color(defaultLine2));
                    Functions.addLines(name, lines);

                    Location loc = player.getLocation();

                    double Y = loc.getY();

                    double distance = SettingsFile.getFile().getDouble("holograms.line-distance");

                    List<Entity> a = new ArrayList<>();

                    for(String line : lines) {
                        if(a.isEmpty()) {
                            ArmorStand holo = (ArmorStand) player.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
                            holo.setGravity(false);
                            holo.setVisible(false);
                            holo.setSmall(true);
                            holo.setCustomNameVisible(true);
                            holo.setCustomName(Color.Color(line));
                            a.add(holo);
                        }else{
                            Y = Y - distance;
                            loc.setY(Y);
                            ArmorStand holo = (ArmorStand) player.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
                            holo.setGravity(false);
                            holo.setVisible(false);
                            holo.setSmall(true);
                            holo.setCustomNameVisible(true);
                            holo.setCustomName(Color.Color(line));
                        }
                    }

                    return;
                } else if (args[0].equalsIgnoreCase("delete")||args[0].equalsIgnoreCase("remove")) {
                    String name = args[1];
                    List<String> lines = StorageFile.getFile().getStringList("holograms."+name+".lines");


                    Bukkit.getScheduler().runTask(Kore.getInstance(), () -> {

                        double distance = SettingsFile.getFile().getDouble("holograms.line-distance");

                        double dX = StorageFile.getFile().getDouble("holograms."+name+".x");
                        double dY = StorageFile.getFile().getDouble("holograms."+name+".y");
                        double dZ = StorageFile.getFile().getDouble("holograms."+name+".z");
                        World world = Bukkit.getWorld(StorageFile.getFile().getString("holograms."+name+".world"));

                        double Y = dY;

                        List<Entity> temp = new ArrayList<>();


                        for (String line : lines) {
                            for (Entity e : world.getEntities()) {
                                if (e == null) {
                                    continue;  // Skip null entities
                                }

                                if (!(e instanceof Player) && e.getCustomName() != null && e.getCustomName().equals(line)) {
                                    if (temp.isEmpty() && e.getLocation().getX() == dX && e.getLocation().getY() == dY && e.getLocation().getZ() == dZ && e.getLocation().getWorld().equals(world)) {
                                        Y = Y - distance;
                                        temp.add(e);
                                        e.remove();
                                    } else if (!temp.isEmpty() && e.getLocation().getX() == dX && e.getLocation().getY() == Y && e.getLocation().getZ() == dZ && e.getLocation().getWorld().equals(world)) {
                                        Y = Y - distance;
                                        e.remove();
                                    }
                                }
                            }
                        }
                        Functions.removeHolo(name);
                    });
                    return;
                }

                /*
                for (int i = 1; i < args.length; i++) {
                    player.sendMessage(args[i]);
                }
                 */

            }


            //for (int i = 1; i < args.length; i++) {
            //    player.sendMessage(args[i]);
            //}
        }else{
            sender.sendMessage(Color.Color(LangFile.getFile().getString("only-players")
                    .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
            ));
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        return completions;
    }
}
