package com.nftworlds.wrldshopkeeper.menuitems;

import com.nftworlds.wallet.objects.Network;
import com.nftworlds.wrldshopkeeper.PlayerBuyItemPayload;
import com.nftworlds.wrldshopkeeper.WRLDShopkeeperPlugin;
import ninja.amp.ampmenus.events.ItemClickEvent;
import ninja.amp.ampmenus.items.MenuItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class AppleItem extends MenuItem {
    private static final String DISPLAY_NAME = ChatColor.RED + "Apples!";
    private static final ItemStack ITEM = new ItemStack(Material.APPLE, 64);

    public AppleItem() {
        super(DISPLAY_NAME, ITEM);
    }

    // This method controls what happens when the MenuItem is clicked
    @Override
    public void onItemClick(ItemClickEvent event) {
        PlayerBuyItemPayload payload = new PlayerBuyItemPayload(ITEM);
        double price = 15.0;
        WRLDShopkeeperPlugin.getPayments().getNFTPlayer(event.getPlayer()).requestWRLD(
                price, Network.POLYGON, "Purchasing 64 apples", payload
        );
    }
}
