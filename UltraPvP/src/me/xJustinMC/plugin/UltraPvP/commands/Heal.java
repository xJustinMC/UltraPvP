package me.xJustinMC.plugin.UltraPvP.commands;

import me.xJustinMC.plugin.UltraPvP.UltraPvP;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
	public UltraPvP plugin;

	public Heal(UltraPvP instance) {
		instance = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player player = (Player) sender;
		final CommandSender s = sender;
		final Player self = player.getServer().getPlayer(sender.getName());

		if (commandLabel.equalsIgnoreCase("heal")) {

			player.sendMessage("Healing in 5...");

			Bukkit.getServer().getScheduler()
					.scheduleSyncDelayedTask(plugin, new Runnable() {
						public void run() {
							s.sendMessage("4...");
							Bukkit.getServer()
									.getScheduler()
									.scheduleSyncDelayedTask(plugin,
											new Runnable() {
												public void run() {
													s.sendMessage("3...");
													Bukkit.getServer()
													.getScheduler()
													.scheduleSyncDelayedTask(plugin,
															new Runnable() {
																public void run() {
																	s.sendMessage("2...");
																	Bukkit.getServer()
																	.getScheduler()
																	.scheduleSyncDelayedTask(plugin,
																			new Runnable() {
																				public void run() {
																					s.sendMessage("1...");
																					Bukkit.getServer()
																					.getScheduler()
																					.scheduleSyncDelayedTask(plugin,
																							new Runnable() {
																								public void run() {
																									s.sendMessage("Healed!");
																									self.setHealth(20.0);
																									self.setFoodLevel(20);
																									self.setFireTicks(0);
																									self.setRemainingAir(20);
																								}
																							}, 20L);
																				}
																			}, 20L);
																}
															}, 20L);
												}
											}, 20L);
						}
					}, 20L);
		}
		return false;
	}
}
