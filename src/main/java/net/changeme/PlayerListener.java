package net.changeme;


import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
//import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;
import org.bukkit.Material;
import org.bukkit.Chunk;
import java.util.Collection;

/**
 * Handle events for all Player related events
 *
 * @author Change Me  <changeme@someprovider>
 */
public class PlayerListener implements Listener {
    private final Plugin plugin;

    /**
     * Constructor.
     *
     * @param instance
     *            The plugin to attach to.
     */
    public PlayerListener(Plugin instance) {
        plugin = instance;
    }

    /**
     * @param event The information associated to this event
     */
    @EventHandler
    public void onEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        Location loc = player.getLocation();
        Collection<Entity> nearbyEntities = loc.getWorld().getNearbyEntities(loc,5,5,5);
    }
}
