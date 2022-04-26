package com.BossPlugin.EditSessionSystem;

import org.bukkit.OfflinePlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EditSessionHandlerList {

    private static final EditSessionHandlerList Instance = new EditSessionHandlerList();
    private final Map<UUID,EditSession> editSessionMap = new HashMap<>();

    public EditSession getorAdd(OfflinePlayer offlinePlayer) {
        return offlinePlayer != null ? getorAdd(offlinePlayer.getUniqueId()) : null;
    }

    public EditSession getorAdd(UUID uuid) {
        if (uuid == null) return null;
        EditSession editSession = editSessionMap.get(uuid);
        if (editSession == null) editSessionMap.put(uuid,editSession = new EditSession(uuid));
        return editSession;
    }

    public static EditSessionHandlerList getInstance() {
        return Instance;
    }

    public static class EditSession {
        //boss edit session triggers
        public boolean editName = false;

        //boss data
        public String bossName;

        private final UUID uuid;

        public EditSession(UUID uuid) {
            this.uuid = uuid;
        }

        public UUID getUuid() {
            return uuid;
        }
    }

}
