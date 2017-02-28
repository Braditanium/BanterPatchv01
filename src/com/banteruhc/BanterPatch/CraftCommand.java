package com.banteruhc.BanterPatch;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Brad on 2/26/2017.
 */
public class CraftCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String string, String[] strings) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("craft")) {
            if (sender != null) {
                if(player.hasPermission("command.craft")) {
                    player.openWorkbench(null, true);
                }
                else if(!player.hasPermission("command.craft")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&5Banter&4&lUHC&7] &c&lSorry! &r&cOnly &7[&dderp&7] &cranks and higher can do this! &dhttp://store.banteruhc.com"));
                }
                else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&5Banter&4&lUHC&7] &cIt's broken!"));
                }
            }
        }
        return true;
    }
}