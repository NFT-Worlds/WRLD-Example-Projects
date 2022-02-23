package com.nftworlds.wrldplots;

import com.nftworlds.wallet.api.WalletAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class WRLDPlots extends JavaPlugin {
    private static WRLDPlots plugin;
    private static WalletAPI wallet;

    public static WRLDPlots getInstance() {
        return plugin;
    }
    public static WalletAPI getPayments() {
        return wallet;
    }

    public void onEnable() {
        plugin = this;
        wallet = new WalletAPI();

        getServer().getLogger().info("NFT Worlds plot plugin enabled!");
        getCommand("sellplot").setExecutor(new CommandListPlotForSale());
        getCommand("buyplot").setExecutor(new CommandBuyPlot());

        getServer().getPluginManager().registerEvents(new PlayerTransactEventListener(), this);

    }
}
