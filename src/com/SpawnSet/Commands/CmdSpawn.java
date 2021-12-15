package com.SpawnSet.Commands;

import com.SpawnSet.Utilities.Config;
import com.SpawnSet.Utilities.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CmdSpawn implements CommandExecutor {
    
    Config config;
    private Location spawnPoint;
    
    public CmdSpawn(JavaPlugin javaPlugin) {
        javaPlugin.getCommand("spawn").setExecutor(this);
        javaPlugin.getCommand("setspawn").setExecutor(this);
        config = new Config(javaPlugin, javaPlugin.getDataFolder(),"config.yml");
        spawnPoint = config.getLocation("spawnPoint",Bukkit.getWorld("world").getSpawnLocation());
    }

    void save() {
        config.update("spawnPoint",spawnPoint);
    }

    public void onDisable() {
        save();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage(Utils.color("&cYou cannot run this command!"));
            return true;
        }

        if (s.equalsIgnoreCase("setspawn")) {

            if (!player.hasPermission("admin.access")) {
                commandSender.sendMessage(Utils.color("&cYou do not have permission to run this command!"));
                return true;
            }

            spawnPoint = player.getLocation().clone();
            commandSender.sendMessage(Utils.color("&aSuccessfully set spawnpoint!"));

        }

        if (s.equalsIgnoreCase("spawn")) {

            player.teleport(spawnPoint);
            player.sendMessage(Utils.color("&aYou have teleported to spawn!"));

        }



        return true;
    }
}
