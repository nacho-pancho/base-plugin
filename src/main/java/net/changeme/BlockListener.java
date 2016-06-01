package net.changeme;

//import org.bukkit.ChatColor;
import org.bukkit.block.Block;
//import org.bukkit.block.BlockState;
//import org.bukkit.block.BlockFace;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.Location;

/**
 * block listener
 *
 * @author cppchriscpp
 */
public class BlockListener implements Listener {
    private final Plugin plugin;

    /**
     * Constructor
     *
     * @param plugin
     *            The plugin to attach to.
     */
    public BlockListener(final Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Called when a block is placed
     */
    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        org.bukkit.World world = player.getWorld();
        Block block = event.getBlock();
        Location bl = block.getLocation();
        plugin.log.debug("BlockPlaceEvent at " + bl);
    }

    /**
     * Called when a block is broken
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockBreak(BlockBreakEvent event) {
    }
}
