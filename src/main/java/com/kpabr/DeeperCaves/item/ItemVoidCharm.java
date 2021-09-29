package com.kpabr.DeeperCaves.item;

import com.kpabr.DeeperCaves.DeeperCaves;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
/*
 * Created by Valiec2019
 * on February 18, 2014
 * using Minecraft Forge 10.12.0.1022
 */
public class ItemVoidCharm extends Item {

	public ItemVoidCharm() {
		this.setMaxStackSize(1);
	}
	public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) 
	{
		if(p_77663_3_ instanceof EntityPlayer) {
			DeeperCaves.voidFlag.put(((EntityPlayer)p_77663_3_).getUniqueID(), true);
		}
	}
	

}
