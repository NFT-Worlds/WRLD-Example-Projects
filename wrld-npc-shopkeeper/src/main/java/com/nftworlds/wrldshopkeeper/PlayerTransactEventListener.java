package com.nftworlds.wrldshopkeeper;

import com.nftworlds.wallet.event.PlayerTransactEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerTransactEventListener implements Listener {

    @EventHandler
    public void onPlayerTransact(PlayerTransactEvent<?> e) {
        if (e.getPayload() instanceof PlayerBuyItemPayload payload) {
            e.getPlayer().sendMessage("Transaction complete!");
            e.getPlayer().getInventory().addItem(payload.items);
        }
    }
}
