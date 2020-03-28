package rip.artemis.telescope;

import org.bukkit.plugin.java.JavaPlugin;

import rip.artemis.telescope.commands.*;

public class Telescope extends JavaPlugin {
	public Telescope plugin;

	@Override
	public void onEnable() {
		plugin = this;
		saveDefaultConfig();
		reloadConfig();
		events();
		commands();
		plugin.getServer().getConsoleSender().sendMessage(Color.chat("&dTELESCOPE HAS BEEN ENABLED"));
	}

	@Override
	public void onDisable() {
		plugin = this;
		plugin.getServer().getConsoleSender().sendMessage(Color.chat("&dTELESCOPE HAS BEEN DISABLED"));
	}

	public void events() {
		getServer().getPluginManager().registerEvents(new TelescopeManager(this), this);
	}
	public void commands() {
		getCommand("telescope").setExecutor(new GiveTelescopeCommand(this));	
	}
}
