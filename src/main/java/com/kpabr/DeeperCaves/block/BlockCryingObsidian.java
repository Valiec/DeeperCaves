package com.kpabr.DeeperCaves.block;

import java.util.ArrayList;
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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
/*
 * Created by Valiec2019
 * on February 18, 2014
 * using Minecraft Forge 10.12.0.1022
 */
public class BlockCryingObsidian extends Block {
	

	public BlockCryingObsidian(Material par2Material) {
		super(par2Material);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean canSilkHarvest()
    {
        return true;
    }
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune)
    {
		ArrayList a =  new ArrayList<ItemStack>();
		a.add(new ItemStack(Item.getItemFromBlock(Blocks.obsidian), 1));
		a.add(new ItemStack(Items.dye, 2*(fortune+1), 4));
        return a;
        
    }

}
