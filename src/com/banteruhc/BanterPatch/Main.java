package com.banteruhc.BanterPatch;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

/**
 * Created by Brad on 2/19/2017.
 */
public class Main extends JavaPlugin {
    private static Plugin plugin;
    @Override
    public void onEnable(){
        plugin = this;
        registerEvents(this, new CutClean(), new GoldenHead(), new PlayerJoin(), new MoreApples());
        getCommand("top").setExecutor(new TopBlock());
        getCommand("craft").setExecutor(new CraftCommand());
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
//                getLogger().info("Runnable running...");
                World world = Bukkit.getWorld("world");
                for(int x = -64; x <= 64; x++) {
//                    getLogger().info("Running X: " + x);
                    for(int z = -64; z <=64; z++) {
//                        getLogger().info("Running Z: " + z);
                        int y = world.getHighestBlockYAt(x, z) - 1;
//                        getLogger().info("Running Y: " + y);
                        Block block = world.getBlockAt(x, y, z);
//                        getLogger().info("Block at: " + x + ", " + y + ", " + z + " is a: " + block);
                        if(block.isLiquid()) {
//                            getLogger().info("Looks like " + block + " is water or lava, replacing with grass.");
                            block.setType(Material.GRASS);
                        }
                    }
                }
            }
        });
    }
    @Override
    public void onDisable(){
        plugin = null;
    }
    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for(Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
    public static Plugin getPlugin() {
        return plugin;
    }

}