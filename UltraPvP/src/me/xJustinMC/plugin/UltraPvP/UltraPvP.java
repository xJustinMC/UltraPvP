package me.xJustinMC.plugin.UltraPvP;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class UltraPvP extends JavaPlugin{
	public Logger logger = Logger.getLogger("Minecraft");
	public int number = 5;
	
	public void onEnable(){
		PluginDescriptionFile pdfFile = getDescription();
		this.logger.info("UltraPvP by xJustinMC v" + pdfFile.getVersion() + " has been enabled!");
		Commands();
	}
	
	private void Commands() {
		
	}

	public void onDisable(){
		PluginDescriptionFile pdfFile = getDescription();
		this.logger.severe("UltraPvP by xJustinMC v" + pdfFile.getVersion() + " has been disabled!");
		
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		final Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("heal")) {
			Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(this, new Runnable(){
				public void run(){
					if(number != -1){
						if(number != 0){
							player.sendMessage(number + "...");
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