package sypherox;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public class RodSpeedCMD implements CommandExecutor, TabCompleter {

    private final RodSpeed plugin;

    public RodSpeedCMD(RodSpeed plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission(plugin.getPermissionNode())) {
            sender.sendMessage(plugin.getMsgNoPermission());
            return true;
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            plugin.loadConfig();
            sender.sendMessage(plugin.getMsgReloaded());
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(plugin.getMsgUsage());
            return true;
        }

        try {
            float newMultiplier = Float.parseFloat(args[0]);
            plugin.setRodMultiplier(newMultiplier);
            sender.sendMessage(plugin.getMsgSet(newMultiplier));
        } catch (NumberFormatException e) {
            sender.sendMessage(plugin.getMsgInvalidNumber());
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("0.5", "0.75", "1.0", "1.1", "15", "2.0", "reload");
        }
        return null;
    }
}