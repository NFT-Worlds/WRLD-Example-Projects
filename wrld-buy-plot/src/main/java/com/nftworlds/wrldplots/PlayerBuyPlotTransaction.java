package com.nftworlds.wrldplots;


import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class PlayerBuyPlotTransaction {
    public ProtectedRegion plotToBuy;

    public PlayerBuyPlotTransaction(ProtectedRegion plotToBuy) {
        this.plotToBuy = plotToBuy;
    }
}
