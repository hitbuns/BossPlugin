package com.BossPlugin.Commands;

import com.BossPlugin.EditSessionSystem.EditSessionHandlerList;
import com.BossPlugin.EventListener.BossEditSessionListener;
import com.BossPlugin.Utilities.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CmdBoss implements CommandExecutor {

    private static CmdBoss Instance;
    EditSessionHandlerList editSessionHandlerList = EditSessionHandlerList.getInstance();

    public CmdBoss(JavaPlugin javaPlugin) {
        Instance = this;
        javaPlugin.getCommand("boss").setExecutor(this);

        //yes you can do this too
        new BossEditSessionListener(javaPlugin);

    }

    public static CmdBoss getInstance() {
        return Instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        //this is how you do args and also perms

        if (!(commandSender instanceof Player player && commandSender.hasPermission("admin.op"))) {
            commandSender.sendMessage(Utils.color("&cYou do not have permission to run this command!"));
            return true;
        }

        if (strings.length != 1) return sendUsage(commandSender);

        editSessionHandlerList.getorAdd(player).editName = true;
        player.sendMessage(Utils.color("&ePlease enter a name for the boss:"));

        return true;
    }

    boolean sendUsage(CommandSender commandSender) {
        commandSender.sendMessage(Utils.color("&cUsage: /boss create"));
        return true;
    }


}
