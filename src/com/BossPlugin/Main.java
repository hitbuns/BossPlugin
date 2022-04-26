package com.BossPlugin;

import com.BossPlugin.Commands.CmdBoss;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommands();
        registerListeners();
    }

    void registerCommands() {
        new CmdBoss(this);
    }

    void registerListeners() {

    }


}
