package com.kpabr.DeeperCaves.item;

import com.kpabr.DeeperCaves.DeeperCaves;

import com.kpabr.DeeperCaves.DeeperCavesExtendedPlayerData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemForgottenCharm extends Item {

	public ItemForgottenCharm() {
		this.setMaxStackSize(1);
	}
	public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) 
	{
		if(p_77663_3_ instanceof EntityPlayer) {
			DeeperCavesExtendedPlayerData extData = (DeeperCavesExtendedPlayerData) p_77663_3_.getExtendedProperties(DeeperCavesExtendedPlayerData.NAME);
			extData.setForgottenCharm();
		}
	}
	

}
