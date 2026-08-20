package com.kpabr.DeeperCaves.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockMagmaStone extends Block {
	

	public BlockMagmaStone(Material par2Material) {
		super(par2Material);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity)
	{
		entity.setFire(5);
	}
	@Override
	public boolean canSilkHarvest()
    {
        return true;
    }
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return null;
    }

}
