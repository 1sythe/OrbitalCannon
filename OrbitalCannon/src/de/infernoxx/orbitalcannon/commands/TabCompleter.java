package de.infernoxx.orbitalcannon.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TabCompleter implements org.bukkit.command.TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String string, String[] args) {
		List<String> strings = new ArrayList();
		if(args.length == 1) {
			strings.add("setpower");
			strings.add("strike");
			strings.add("reload");
		} else if(args.length == 2) {
			for(Player p : Bukkit.getOnlinePlayers()) {
				strings.add(p.getDisplayName());
			}
		}
		
		return null;
	}
	
	

}
