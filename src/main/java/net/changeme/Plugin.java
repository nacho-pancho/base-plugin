package net.changeme;

import java.util.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Plugin extends org.bukkit.plugin.java.JavaPlugin {

    /**
     * Logging component.
     */
    private String pluginName;
    private static final String permissionNode = "boothportals.";
    private String pluginVersion;
    private ResourceBundle i18nResource; // for Internationalization
    Logger log;

    public void onLoad() {
        org.bukkit.plugin.PluginDescriptionFile pdfFile = this.getDescription();
        pluginName = pdfFile.getName();
        pluginVersion = pdfFile.getVersion();
    }

    void configurePlugin() {
        FileConfiguration conf = getConfig();

        conf.get("locale_country", "UY");
        final String language = conf.getString("locale_language", "es");
        final String country = conf.getString("locale_country", "");
        log.info("Locale set to " + language + " " + country);
        final Locale locale = new Locale(language, country);
        i18nResource = ResourceBundle.getBundle("Messages", locale);
        boolean debugMode = conf.getBoolean("debug", false);
        log.info("Debug mode is " + debugMode);
        log = new Logger(pluginName + " v" + pluginVersion, debugMode);
    }

    public void onEnable() {
        configurePlugin();
        org.bukkit.plugin.PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new BlockListener(this), this);
        pm.registerEvents(new PlayerListener(this), this);
        getCommand("armageddon").setExecutor(new CommandExecutor(this));
    }

    public void onDisable() {
    }


    boolean hasPermission(Player player, String permission) {
        return player.hasPermission(permissionNode + permission);
    }

}
