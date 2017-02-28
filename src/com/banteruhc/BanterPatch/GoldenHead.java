package com.banteruhc.BanterPatch;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

/**
 * Created by Brad on 2/22/2017.
 */
public class GoldenHead implements Listener{
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player p = event.getEntity();
        ItemStack gHead = new ItemStack(Material.GOLDEN_APPLE, 1, (short)1);
        ItemMeta goldMeta = gHead.getItemMeta();
        goldMeta.setDisplayName(ChatColor.DARK_RED + "Golden Head");
        goldMeta.setLore(Arrays.asList("This Golden Head:", "Heals 4 Hearts", "Gives 2 Absorption Hearts", "Applies Speed 1 for 10 seconds"));
        gHead.setItemMeta(goldMeta);
        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), gHead);
    }
    @EventHandler
    // Thanks to LoonyRules for the onConsume stuff.
    public void onItemConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItem();
        if(itemStack.getType() == Material.GOLDEN_APPLE && itemStack.getDurability() == 1) {
            event.setCancelled(true);
            int amount = itemStack.getAmount();
            PlayerInventory playerInventory = player.getInventory();
            int slot = playerInventory.first(itemStack);

            // Removing the item because they don't have any left
            if (--amount <= 0) {
                playerInventory.clear(slot);
            } else {
                itemStack.setAmount(amount);
                playerInventory.setItem(slot, itemStack);
            }
            player.updateInventory();
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 2, false, true));
            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 0, false, true));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 0, false, true));
            player.setFoodLevel(player.getFoodLevel() + 4);
        }
    }
    @EventHandler
    public void onCraftItemEvent(CraftItemEvent event) {
        Recipe recipe = event.getRecipe();
        if(recipe.getResult().getType() == Material.GOLDEN_APPLE && recipe.getResult().getDurability() == 1) {
            event.setCancelled(true);
            event.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&5Banter&4&lUHC&7] &4&lSorry! &r&cYou cannot craft God Apples! They're disabled!"));
        }
    }
}