package com.nftworlds.wrldshopkeeper;

import org.bukkit.inventory.ItemStack;

public class PlayerBuyItemPayload {
    public ItemStack items;

    public PlayerBuyItemPayload(ItemStack items) {
        this.items = items;
    }
}
