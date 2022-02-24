package com.nftworlds.wrldplots;

import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class CommandListPlotForSale implements CommandExecutor {
    // Persisting this data between server reboots is left as an exercise to the developer.
    private static final HashMap<String, Double> plotsForSaleAndPrice = new HashMap<>();

    public static Double getPlotPrice(String plotId) {
        return plotsForSaleAndPrice.get(plotId);
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 1) {
            sender.sendMessage("Usage: /sellplot <amount>");
            return false;
        }

        Double amount = Double.valueOf(args[0]);
        // get the plot
        ProtectedRegion region = PlotUtility.getPlotAtLocation(((Player) sender).getLocation());
        if (region != null) {
            String plotId = region.getId();

            sender.sendMessage("You have listed " + plotId + " for sale for " + amount + " WLRD.");

            region.setFlag(Flags.GREET_MESSAGE, "&aThis plot is for sale for &6" + amount + " WRLD&f. Run /buyplot to purchase it!");
            plotsForSaleAndPrice.put(plotId, amount);

            return true;
        }
        sender.sendMessage("There is no plot at your current location to sell!");
        return false;
    }
}
