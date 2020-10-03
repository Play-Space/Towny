package com.palmergames.bukkit.towny.gui;

import com.palmergames.bukkit.towny.utils.Heads;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class MainGUI {
	public static Inventory inv = Bukkit.createInventory(null, 6*9, "Você não faz parte de nenhuma cidade");
	public static void hook(Player p, GUIStates state) {
		if(state == GUIStates.NO_TOWN) {
			ItemStack SEM_TOWN_BARREIRA = new ItemStack(Material.BARRIER);
			ItemMeta SEM_TOWN_META = SEM_TOWN_BARREIRA.getItemMeta();

			SEM_TOWN_META.setDisplayName("§cVocê não faz parte de nenhuma cidade.");
			List<String> lore = new ArrayList<>();

			lore.add("");
			lore.add("§fCrie sua §ecidade§f, ou faça parte de uma, ");lore.add("§fjunte-se com §bnações§f, ou até crie nações,");lore.add("§fvença §cguerras§f e domine o §aservidor§f!");
			lore.add("");
			SEM_TOWN_META.setLore(lore);
			SEM_TOWN_BARREIRA.setItemMeta(SEM_TOWN_META);
			inv.setItem(inv.getSize()/2-5,SEM_TOWN_BARREIRA);
			
			
			// Entrar: +2 Criar: +6
			ItemStack CRIARTOWN = new ItemStack(Material.PLAYER_HEAD);
			
			SkullMeta CRIARTOWN_META = (SkullMeta)CRIARTOWN.getItemMeta();
            CRIARTOWN_META.setOwner("luece");
			CRIARTOWN_META.setDisplayName("§eCriar uma cidade");
			List<String> CRIARTOWN_lore = new ArrayList<>();

			CRIARTOWN_lore.add("");
			CRIARTOWN_lore.add("§fCrie sua §ecidade§f e §fjunte-se com §bnações§,");CRIARTOWN_lore.add("§fevolua-a e crie um grande mercado!");
			CRIARTOWN_lore.add("");
			
			CRIARTOWN_META.setLore(CRIARTOWN_lore);
			CRIARTOWN.setItemMeta(CRIARTOWN_META);
			inv.setItem(inv.getSize()/2+2,CRIARTOWN);

			ItemStack ENTRARTOWN = new ItemStack(Material.PLAYER_HEAD);

			SkullMeta ENTRARTOWN_META = (SkullMeta)ENTRARTOWN.getItemMeta();
			ENTRARTOWN_META.setOwner("God");
			ENTRARTOWN_META.setDisplayName("§eEntrar em uma cidade");
			List<String> ENTRARTOWN_lore = new ArrayList<>();

			ENTRARTOWN_lore.add("");
			ENTRARTOWN_lore.add("§fEntre em uma §ecidade§f, §fjunte-se com §boutros cidadões,");ENTRARTOWN_lore.add("§fe crie sua casa ou até uma loja!");
			ENTRARTOWN_lore.add("");

			ENTRARTOWN_META.setLore(ENTRARTOWN_lore);
			ENTRARTOWN.setItemMeta(ENTRARTOWN_META);
			inv.setItem(inv.getSize()/2+6,ENTRARTOWN);
			p.openInventory(inv);
			
		}
		

	}
	public enum GUIStates {
		NO_TOWN, MEMBER_OF_A_TOWN, MAYOR_OF_A_TOWN
	}

}
