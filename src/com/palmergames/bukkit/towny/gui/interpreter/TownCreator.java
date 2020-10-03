package com.palmergames.bukkit.towny.gui.interpreter;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class TownCreator implements Listener {
	public static List<Player> AWAITING = new ArrayList<>();
	
	@EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
	public void chat(PlayerChatEvent e) {
		if(AWAITING.contains(e.getPlayer())) {
			AWAITING.remove(e.getPlayer());
			Bukkit.dispatchCommand(e.getPlayer(), "town create " + e.getMessage());
			e.setCancelled(true);
		}
	}
}
