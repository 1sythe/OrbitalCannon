package de.infernoxx.orbitalcannon.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.mysql.jdbc.StringUtils;

import de.infernoxx.orbitalcannon.main.Main;

public class MainCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(args.length == 0) {
				player.sendMessage("§cOrbitalCannon §7| §6Information");
			} else if(args.length == 2) {
				if(args[0].equalsIgnoreCase("strike")) {
					if(player.hasPermission("orbitalcannon.strike")) {
						Player target = Bukkit.getPlayer(args[1]);
						if(target != null) {
							if(!target.hasPermission("orbitalcannon.bypass")) {
								FileConfiguration config = Main.getPlugin(null).getConfig();
								int power = config.getInt("OrbitalCannon.Power");
								
								target.sendMessage("§b" + player.getName() + " §cattacked you with an Orbital Cannon!");
								player.sendMessage("§cYou striked §b" + target.getName() + " §cwith an Orbital Cannon!");
								target.getWorld().createExplosion(target.getLocation(), power);
							} else {
								player.sendMessage("§cOrbitalCannon §8>> §cThis player is protected against Orbital Cannons!");
							}
						} else {
							player.sendMessage("§cOrbitalCannon §8>> §cThis player is currently not online!");
						}
					} else {
						player.sendMessage("§cOrbitalCannon §8>> §cYou are not allowed to shoot an Orbital Cannon! §7(§corbitalcannon.strike§7)");
					}
				} else if(args[0].equalsIgnoreCase("setpower")) {
					if(player.hasPermission("orbitalcannon.setpower")) {
						if(StringUtils.isStrictlyNumeric(args[1])) {
							
							
							
							FileConfiguration config = Main // get plugin
							config.set("OrbitalCannon.Power", args[1]);
							// save config
							
							player.sendMessage("§cOrbital Cannon §8>> §aYou changed the Power of the Orbital Cannon to §b" + args[1] + "§a!");
							
							
							
						} else {
							
							player.sendMessage("§cOrbitalCannon §8>> §cPlease enter a Number");
							player.sendMessage("§6Tipp: Dont put a Number above 150!");
							
						}
					} else {
						player.sendMessage("§cOrbitalCannon §8>> §cYou dont have Permission to change the power of the Orbital Cannon!");
					}
				}
			}
		} else {
			System.out.println("Bitte benutze diesen Command im Spiel!");
		}
		return false;
	}

}
