package com.SpawnSet.Utilities;

import org.bukkit.ChatColor;

public class Utils {

    public static String color(String s) {
        return s != null ? ChatColor.translateAlternateColorCodes('&',s) : null;
    }

}
