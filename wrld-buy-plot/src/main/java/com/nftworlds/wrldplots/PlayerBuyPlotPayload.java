package com.nftworlds.wrldplots;


import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class PlayerBuyPlotPayload {
    public ProtectedRegion plotToBuy;

    public PlayerBuyPlotPayload(ProtectedRegion plotToBuy) {
        this.plotToBuy = plotToBuy;
    }
}
