package com.banteruhc.BanterPatch;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;
import java.util.Random;


/**
 * Created by Brad on 2/19/2017.
 */
public class CutClean implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        LivingEntity entity = e.getEntity();
        ItemStack drops;
        Iterator var;
        if(entity.getType() == EntityType.CHICKEN) {
            var = e.getDrops().iterator();
            while(var.hasNext()) {
                drops = (ItemStack)var.next();
                if(drops.getType() == Material.RAW_CHICKEN) {
                    drops.setType(Material.COOKED_CHICKEN);
                }
            }
        }
        if(entity.getType() == EntityType.SHEEP) {
            var = e.getDrops().iterator();
            while(var.hasNext()) {
                drops = (ItemStack)var.next();
                if(drops.getType() == Material.MUTTON) {
                    drops.setType(Material.COOKED_MUTTON);
                }
            }
        }
        if(entity.getType() == EntityType.RABBIT) {
            Random random = new Random();
            e.getDrops().add(new ItemStack(Material.LEATHER, random.nextInt(2)));
            var = e.getDrops().iterator();
            while(var.hasNext()) {
                drops = (ItemStack)var.next();
                if(drops.getType() == Material.RABBIT) {
                    drops.setType(Material.COOKED_RABBIT);
                }
            }
        }
        if(entity.getType() == EntityType.COW || entity.getType() == EntityType.MUSHROOM_COW) {
            var = e.getDrops().iterator();
            while(var.hasNext()) {
                drops = (ItemStack)var.next();
                if(drops.getType() == Material.RAW_BEEF) {
                    drops.setType(Material.COOKED_BEEF);
                }
            }
        }
        if(entity.getType() == EntityType.PIG) {
            Random random = new Random();
            e.getDrops().add(new ItemStack(Material.LEATHER, random.nextInt(2)));
            var = e.getDrops().iterator();
            while(var.hasNext()) {
                drops = (ItemStack)var.next();
                if(drops.getType() == Material.PORK) {
                    drops.setType(Material.GRILLED_PORK);
                }
            }
        }
        if(entity.getType() == EntityType.PIG_ZOMBIE) {
            Random random = new Random();
            e.getDrops().add(new ItemStack(Material.COOKED_BEEF, random.nextInt(3)));
            e.getDrops().add(new ItemStack(Material.LEATHER, random.nextInt(2)));
            e.getDrops().add(new ItemStack(Material.GOLDEN_APPLE, random.nextInt(2)));
            var = e.getDrops().iterator();
            while(var.hasNext()) {
                drops = (ItemStack)var.next();
                if(drops.getType() == Material.ROTTEN_FLESH) {
                    drops.setType(Material.AIR);
                }
            }
        }
        if(entity.getType() == EntityType.HORSE) {
            Random random = new Random();
            e.getDrops().add(new ItemStack(Material.COOKED_BEEF, random.nextInt(3)));
            var = e.getDrops().iterator();
            while(var.hasNext()) {
                drops = (ItemStack)var.next();
                if(drops.getType() == Material.LEATHER) {
                    drops.setType(Material.LEATHER);
                }
            }
        }

    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        Location clone = new Location(b.getWorld(), (double) b.getLocation().getBlockX() + 0.5D, (double) b.getLocation().getBlockY(), (double) b.getLocation().getBlockZ() + 0.5D);
        if (b.getType() == Material.IRON_ORE) {
            b.setType(Material.AIR);
            b.getState().update();
            b.getWorld().dropItemNaturally(clone, new ItemStack(Material.IRON_INGOT));
            ((ExperienceOrb) b.getWorld().spawn(clone, ExperienceOrb.class)).setExperience(3);
        }
        if (b.getType() == Material.STONE) {
            b.setType(Material.AIR);
            b.getState().update();
            b.getWorld().dropItemNaturally(clone, new ItemStack(Material.COBBLESTONE));
        }
        if (b.getType() == Material.GOLD_ORE) {
            b.setType(Material.AIR);
            b.getState().update();
            ((ExperienceOrb) b.getWorld().spawn(clone, ExperienceOrb.class)).setExperience(3);
            b.getWorld().dropItemNaturally(clone, new ItemStack(Material.GOLD_INGOT));
        }
        if (b.getType() == Material.GRAVEL) {
            b.setType(Material.AIR);
            b.getState().update();
            b.getWorld().dropItemNaturally(clone, new ItemStack(Material.FLINT));
        }
    }
}