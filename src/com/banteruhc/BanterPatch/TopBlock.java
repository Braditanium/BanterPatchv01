package com.banteruhc.BanterPatch;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * Created by Brad on 2/19/2017.
 */
public class TopBlock implements CommandExecutor {
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String string, String[] strings) {
        if(string.equalsIgnoreCase("top")) {
            Player player = (Player) sender;
            Location location = player.getLocation();
            Double border = player.getWorld().getWorldBorder().getSize();
            if (sender.hasPermission("command.top") && border >= 405) {
                location.setY(player.getWorld().getHighestBlockAt(location).getLocation().getY());
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&5Banter&4&lUHC&7] &aTeleporting you to highest block..."));
                player.teleport(location);
                return true;
            } else if (sender.hasPermission("command.top") && border < 405) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&5Banter&4&lUHC&7] &c&lSorry! &r&cYou can't use &e/top &cduring Death Match!"));
            } else if (!sender.hasPermission("command.top")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&5Banter&4&lUHC&7] &c&lSorry! &r&cOnly &7[&6TRYHARD&7] &cranks can use &e/top. Store: &dhttp://store.banteruhc.com"));

            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&5Banter&4&lUHC&7] &c&lSorry! &r&cSomething terribly wrong. It's broken!"));

            }
        }
        return true;
    }
}
