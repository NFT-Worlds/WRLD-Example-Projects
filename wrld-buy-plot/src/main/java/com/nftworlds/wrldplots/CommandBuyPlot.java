package com.nftworlds.wrldplots;

import com.nftworlds.wallet.objects.Network;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandBuyPlot implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        ProtectedRegion region = PlotUtility.getPlotAtLocation(((Player)sender).getLocation());
        if (region != null) {
            Double price = CommandListPlotForSale.getPlotPrice(region.getId());
            if (price == null) {
                sender.sendMessage("Error: There is no plot for sale here!");
                return false;
            }
            PlayerBuyPlotPayload payload = new PlayerBuyPlotPayload(region);
            WRLDPlots.getPayments().getNFTPlayer((Player) sender).requestWRLD(
                    price, Network.POLYGON, "Purchasing plot " + region.getId(), payload
            );
        }
        return true;
    }
}
