package com.SpawnSet;

import com.SpawnSet.Commands.CmdSpawn;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private CmdSpawn cmdSpawn;

    @Override
    public void onEnable() {
        cmdSpawn = new CmdSpawn(this);
    }

    @Override
    public void onDisable() {
        cmdSpawn.onDisable();
    }
}
