package me.xJustinMC.plugin.UltraPvP;

import java.util.logging.Logger;

import me.xJustinMC.plugin.UltraPvP.commands.Heal;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class UltraPvP extends JavaPlugin{
	public Logger logger = Logger.getLogger("Minecraft");
	
	public void onEnable(){
		PluginDescriptionFile pdfFile = getDescription();
		this.logger.info("UltraPvP by xJustinMC v" + pdfFile.getVersion() + " has been enabled!");
		Commands();
	}
	
	private void Commands() {
		getCommand("heal").setExecutor(new Heal(this));	
	}

	public void onDisable(){
		PluginDescriptionFile pdfFile = getDescription();
		this.logger.severe("UltraPvP by xJustinMC v" + pdfFile.getVersion() + " has been disabled!");
		
	}
}
