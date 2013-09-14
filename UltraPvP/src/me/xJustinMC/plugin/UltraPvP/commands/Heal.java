package me.xJustinMC.plugin.UltraPvP.commands;

import me.xJustinMC.plugin.UltraPvP.UltraPvP;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor{
	public int number = 1;
	
	public UltraPvP plugin;
	public Heal(UltraPvP instance){
		instance = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		final Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("heal")) {
			player.sendMessage("Healing in 10 seconds");
			
			Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
				public void run(){
					if(number > -1){
						if(number <= 1){
							number--;
						}
						else{
							player.sendMessage("Healed");
							player.setHealth(20.0);
						}
					}
				}
			}, 0L, 100L);
		}
		return false;
	}
}
