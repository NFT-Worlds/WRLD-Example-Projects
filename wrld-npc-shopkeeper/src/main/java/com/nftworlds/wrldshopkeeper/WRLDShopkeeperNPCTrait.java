package com.nftworlds.wrldshopkeeper;

import net.citizensnpcs.api.persistence.Persist;
import net.citizensnpcs.api.trait.Trait;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class WRLDShopkeeperNPCTrait extends Trait {
    WRLDShopkeeperPlugin plugin = null;

    public WRLDShopkeeperNPCTrait() {
        super("wrld-food-shopkeeper");
        plugin = JavaPlugin.getPlugin(WRLDShopkeeperPlugin.class);
    }

    @Persist("sellsSteak") boolean sellsSteak = false;
    @Persist("sellsApples") boolean sellsApples = false;

    @EventHandler
    public void onRightClick(net.citizensnpcs.api.event.NPCRightClickEvent event){
        if (event.getNPC() != this.getNPC()) {
            return;
        }
        WRLDShopkeeperPlugin.menu.open(event.getClicker());
    }

}
