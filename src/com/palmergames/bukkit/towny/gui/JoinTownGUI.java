package com.palmergames.bukkit.towny.gui;

import com.palmergames.bukkit.towny.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class JoinTownGUI {
	public static void hook(Player p) {
		Inventory inv = Bukkit.createInventory(null, 3*9, "Escolha uma ação");
		inv.setItem(11,new ItemBuilder(Material.PLAYER_HEAD).setName("§7Cidades Públicas").setLore("","§fFaça parte de uma §acidade pública§f,", "§fclicando aqui, você irá"," §fpara uma lista","§fdas cidades disponíveis.").setSkullOwner("Flashlight").toItemStack());
		inv.setItem(15,new ItemBuilder(Material.PLAYER_HEAD).setName("§7Cidades Privadas").setLore("","§fFaça parte de uma §7cidade particular§f,", "§fsó você e seus amigos! §fclicando aqui, você irá para","uma lista §fdos convites recebidos para fazer parte de alguma cidade.").setSkullOwner("Flashlight").toItemStack());
	    p.openInventory(inv);
	}
}
