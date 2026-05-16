package sypherox;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class RodSpeed extends JavaPlugin implements Listener {

    private float rodMultiplier;
    private String msgNoPermission;
    private String msgUsage;
    private String msgSet;
    private String msgInvalidNumber;
    private String msgReloaded;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadConfig();
        getServer().getPluginManager().registerEvents(this, this);
        getCommand(getCommandName()).setExecutor(new RodSpeedCMD(this));
        getLogger().info("RodSpeed enabled! Multiplier: " + rodMultiplier);
    }

    public void loadConfig() {
        reloadConfig();
        FileConfiguration config = getConfig();

        rodMultiplier = (float) config.getDouble("rod-multiplier", 1.0);

        msgNoPermission = colorize(config.getString("messages.no-permission", "&cYou don't have permission to use this command."));
        msgUsage        = colorize(config.getString("messages.usage", "&cUsage: /{cmd} <multiplier>"));
        msgSet          = colorize(config.getString("messages.set", "&aRod multiplier set to &e{value}&a."));
        msgInvalidNumber= colorize(config.getString("messages.invalid-number", "&cPlease provide a valid number."));
        msgReloaded     = colorize(config.getString("messages.reloaded", "&aConfig reloaded successfully."));
    }

    private String colorize(String input) {
        return input.replace("&", "\u00A7");
    }

    public void setRodMultiplier(float newMultiplier) {
        this.rodMultiplier = newMultiplier;
        getConfig().set("rod-multiplier", (double) newMultiplier);
        saveConfig();
    }

    // --- Getters for messages ---
    public String getMsgNoPermission() { return msgNoPermission; }
    public String getMsgUsage()        { return msgUsage.replace("{cmd}", getCommandName()); }
    public String getMsgSet(float val) { return msgSet.replace("{value}", String.valueOf(val)); }
    public String getMsgInvalidNumber(){ return msgInvalidNumber; }
    public String getMsgReloaded()     { return msgReloaded; }

    public String getCommandName() {
        return getConfig().getString("command-name", "rodspeed");
    }

    public String getPermissionNode() {
        return getConfig().getString("permission", "rodspeed.use");
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent e) {
        if (e.getEntityType() == EntityType.FISHING_HOOK) {
            Projectile hook = e.getEntity();
            hook.setVelocity(hook.getVelocity().multiply(rodMultiplier));
        }
    }
}