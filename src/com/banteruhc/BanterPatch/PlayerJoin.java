package com.banteruhc.BanterPatch;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Brad on 2/25/2017.
 */
public class PlayerJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 108000, 0, false, false));
    }

}
