package com.kpabr.DeeperCaves.block;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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
