package com.nftworlds.wrldshopkeeper;

import com.nftworlds.wallet.api.WalletAPI;
import com.nftworlds.wrldshopkeeper.menuitems.AppleItem;
import com.nftworlds.wrldshopkeeper.menuitems.SteakItem;
import net.citizensnpcs.api.trait.TraitInfo;
import ninja.amp.ampmenus.items.CloseItem;
import ninja.amp.ampmenus.menus.ItemMenu;
import org.bukkit.plugin.java.JavaPlugin;

public class WRLDShopkeeperPlugin extends JavaPlugin {
    private static WRLDShopkeeperPlugin plugin;
    private static WalletAPI wallet;
    public static ItemMenu menu;

    public static WRLDShopkeeperPlugin getInstance() {
        return plugin;
    }
    public static WalletAPI getPayments() {
        return wallet;
    }

    public void onEnable() {
        plugin = this;
        wallet = new WalletAPI();

        getServer().getLogger().info("NFT Worlds Example Shopkeeper plugin enabled!");

        getServer().getPluginManager().registerEvents(new PlayerTransactEventListener(), this);
        net.citizensnpcs.api.CitizensAPI.getTraitFactory().
                registerTrait(TraitInfo.create(WRLDShopkeeperNPCTrait.class)
                        .withName("wrld-food-shopkeeper"));

        getServer().getLogger().info("Registered NPC traits!");


        menu = new ItemMenu("Shop", ItemMenu.Size.TWO_LINE, plugin);

        menu.setItem(17, new CloseItem());
        menu.setItem(0, new AppleItem());
        menu.setItem(1, new SteakItem());

    }
}
