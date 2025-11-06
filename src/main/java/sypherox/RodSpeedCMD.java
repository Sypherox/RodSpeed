package sypherox;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class RodSpeedCMD implements CommandExecutor {

    private final RodSpeed plugin;

    public RodSpeedCMD(RodSpeed plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("rodspeed.use")) {
            sender.sendMessage("§cYou don't have permission to use this command");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage("§cUsage: /rodspeed <multiplier>");
            return true;
        }

        try {
            float newMultiplier = Float.parseFloat(args[0]);
            plugin.setRodMultiplier(newMultiplier);

            FileConfiguration config = plugin.getConfig();
            config.set("rod-multiplier", newMultiplier);
            plugin.saveConfig();

            sender.sendMessage("§aSet the rod multiplier to " + newMultiplier);
        } catch (NumberFormatException e) {
            sender.sendMessage("§cPlease provide a valid multiplier");
        }

        return true;
    }
}
