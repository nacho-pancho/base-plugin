package net.changeme;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

/**
 * Handle events for all Player related events
 *
 * @author You
 */
public class CommandExecutor implements org.bukkit.command.CommandExecutor {
    private final Plugin plugin;

    public CommandExecutor(Plugin instance) {
        plugin = instance;
    }

    /** MUST return boolean */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String name = cmd.getName();
        if (name.equalsIgnoreCase("armageddon")) {
            if (sender instanceof Player) {
                if (!sender.hasPermission("changeme.armaeddon")) {
                    sender.sendMessage("You are not authorized to do this.");
                } else {
                    plugin.getServer().broadcastMessage(ChatColor.RED + "KABOOOOOOMMMM");
                }
                // kill all players!
            } else {
                return true;
            }
            return true;
        }
        return false;
    }
}
