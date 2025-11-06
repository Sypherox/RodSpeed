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

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadConfig();
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("rodspeed").setExecutor(new RodSpeedCMD(this));
    }

    private void loadConfig() {
        FileConfiguration config = getConfig();
        rodMultiplier = (float) config.getDouble("rod-multiplier", 1.0);
        saveConfig();
    }

    public void setRodMultiplier(float newMultiplier) {
        this.rodMultiplier = newMultiplier;
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent e) {
        Projectile hook = e.getEntity();
        if (e.getEntityType().equals(EntityType.FISHING_HOOK)) {
            hook.setVelocity(hook.getVelocity().multiply(rodMultiplier));
        }
    }
}
