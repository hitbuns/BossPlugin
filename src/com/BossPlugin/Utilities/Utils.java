package com.BossPlugin.Utilities;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static String color(String s) {
        return s != null ? ChatColor.translateAlternateColorCodes('&',s) : null;
    }

    public static List<String> color (List<String> color) {
        return color != null ? color.stream().map(Utils::color).collect(Collectors.toList()) : new ArrayList<>();
    }

}
