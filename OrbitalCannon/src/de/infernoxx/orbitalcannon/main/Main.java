package de.infernoxx.orbitalcannon.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.infernoxx.orbitalcannon.commands.MainCommand;
import de.infernoxx.orbitalcannon.commands.TabCompleter;
import de.infernoxx.orbitalcannon.utils.CustomConfig;

public class Main extends JavaPlugin {
	
	
	private static Main instance;
	public static Main getInstance() {
		return instance;
	}
	
	public PluginManager pm = Bukkit.getPluginManager();
	
	public void onEnable() {
		instance = this;
		
		CustomConfig.setup();
		CustomConfig.get().options().copyDefaults(true);
		CustomConfig.save();
		
		getCommand("orbitalcannon").setExecutor(new MainCommand());
		getCommand("orbitalcannon").setTabCompleter(new TabCompleter());
	}
	
}
