package com.palmergames.bukkit.towny.gui.listeners;

import com.google.common.collect.Lists;
import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.gui.JoinTownGUI;
import com.palmergames.bukkit.towny.gui.MainGUI;
import com.palmergames.bukkit.towny.gui.interpreter.TownCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickGUI implements Listener {
	@EventHandler
	public void invClick(InventoryClickEvent e) {
		if(e.getClickedInventory() == MainGUI.inv) {
			e.setCancelled(true);
			if(e.getCurrentItem() == null) return;
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Entrar")) {
				e.getWhoClicked().closeInventory();
				JoinTownGUI.hook((Player) e.getWhoClicked());	
			}
			else if 
			(e.getCurrentItem().getItemMeta().getDisplayName().contains("Criar")) {
				e.getWhoClicked().closeInventory();
				foo((Player) e.getWhoClicked());
				
			}
		}
	}
	public void foo(Player target) {
		Towny.getSignMenuFactory()
			.newMenu(Lists.newArrayList("","","",""))
			.reopenIfFail()
			.response((player, lines) -> {
				player.sendMessage(lines[0] + lines[1] + lines[2] + lines[3]);
				
				return true;
			})
			.open(target);
	}
}
