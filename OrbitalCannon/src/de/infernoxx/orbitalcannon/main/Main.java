package de.infernoxx.orbitalcannon.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.infernoxx.orbitalcannon.commands.MainCommand;

public class Main extends JavaPlugin {
	
	
	public void onEnable() {
		
		PluginManager pm = Bukkit.getPluginManager();
		
		getCommand("orbitalcannon").setExecutor(new MainCommand());
	}
	
}
