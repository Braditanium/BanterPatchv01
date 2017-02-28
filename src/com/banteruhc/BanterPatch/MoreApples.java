package com.banteruhc.BanterPatch;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

/**
 * Created by Brad on 2/25/2017.
 */
public class MoreApples implements Listener{
    @EventHandler
    public void onLeafDecay(LeavesDecayEvent event) {
        Random random = new Random();
        int amt = random.nextInt(100);
        if(amt <= 94) {
            return;
        }
        if (amt >= 95) {
            ItemStack apple = new ItemStack(Material.APPLE, 1);
            event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), apple);
        }
    }
}
