package com.kpabr.DeeperCaves.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockPriscium extends Block {
	

	public BlockPriscium(Material par2Material) {
		super(par2Material);
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side)
	{
		return true;
	}

}
