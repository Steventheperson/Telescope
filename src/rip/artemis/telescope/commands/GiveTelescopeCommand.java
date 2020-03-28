package rip.artemis.telescope.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import rip.artemis.telescope.Color;
import rip.artemis.telescope.Telescope;
import rip.artemis.telescope.TelescopeManager;

public class GiveTelescopeCommand implements CommandExecutor {
	private Telescope plugin;

	public GiveTelescopeCommand(Telescope plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("telescope.givecommand")) {
			if (p.getInventory().firstEmpty() != -1) {
				TelescopeManager.giveTelescope(p);
			} else {
				p.sendMessage(Color.chat(plugin.getConfig().getString("full-inventory")));
				return false;
			}
				if (plugin.getConfig().getBoolean("message-toggle") == true) {
					p.sendMessage(Color.chat(plugin.getConfig().getString("message")));
				}
		} else {
			p.sendMessage(Color.chat(plugin.getConfig().getString("no_permission")));
		}
		return false;
	}
}
