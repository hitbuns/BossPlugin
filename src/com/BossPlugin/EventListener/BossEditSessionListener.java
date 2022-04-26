package com.BossPlugin.EventListener;

import com.BossPlugin.EditSessionSystem.EditSessionHandlerList;
import com.BossPlugin.Utilities.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BossEditSessionListener implements Listener {

    EditSessionHandlerList editSessionHandlerList = EditSessionHandlerList.getInstance();

    public BossEditSessionListener(JavaPlugin javaPlugin) {
        javaPlugin.getServer().getPluginManager().registerEvents(this,javaPlugin);
    }

    @EventHandler
    public void onEditSession(AsyncPlayerChatEvent asyncPlayerChatEvent) {

        Player p = asyncPlayerChatEvent.getPlayer();

        if (!p.hasPermission("admin.op")) return;

        EditSessionHandlerList.EditSession editSession = editSessionHandlerList.getorAdd(p);

        if (editSession.editName) {

            editSession.bossName = asyncPlayerChatEvent.getMessage();
            editSession.editName = false;

            p.sendMessage(Utils.color("&aYou have successfully set the boss's name to "+ editSession.bossName));

        }
    }



}
