package com.github.TrungLam;

import java.util.logging.Logger;


import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LightTrail extends JavaPlugin implements Listener{
	public static LightTrail plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public final PluginDescriptionFile pdf = this.getDescription();
	public static boolean t = false;
	
	public void onDisable(){
		logger.info(pdf + " is disabled");
	}
	public void onEnable(){
		logger.info(pdf + " is enabled");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
	}
	@EventHandler
	public void playerMove(PlayerMoveEvent event){
		if (t){
			Player player = event.getPlayer();
			player.getLocation().getBlock().setType(Material.TORCH);
		}
	}
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args){
		if (Label.equalsIgnoreCase("li")){
			t = (t) ? false : true;
		}
		return false;
	}
}
