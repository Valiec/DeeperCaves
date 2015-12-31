package com.kpabr.DeeperCaves.block;

import java.util.Random;

import com.kpabr.DeeperCaves.DeeperCaves;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
/*
 * Created by Valiec2019
 * on February 18, 2014
 * using Minecraft Forge 10.12.0.1022
 */
public class BlockFragmentedBedrock extends BlockBase {

	public BlockFragmentedBedrock(Material par2Material) {
		super(par2Material);
		// TODO Auto-generated constructor stub
	}
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)
    {
        if (entity instanceof EntityWither)
        {
            return false;
        }
        else if (entity instanceof EntityDragon)
        {
            return false;
        }

        return true;
    } 
	@Override
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		ItemStack item = p_149727_5_.getCurrentEquippedItem();
		if(item != null && item.getItem() == DeeperCaves.items.forgottenGemstone)
		{
			p_149727_1_.setBlock(p_149727_2_, p_149727_3_, p_149727_4_, DeeperCaves.blocks.returnPortal);
			item.stackSize--;
			if(item.stackSize == 0)
			{
			p_149727_5_.setCurrentItemOrArmor(0, null);	
			}
			else
			{
			p_149727_5_.setCurrentItemOrArmor(0, item);
			}
			return true;
		}
			
		return false;
	}

}
