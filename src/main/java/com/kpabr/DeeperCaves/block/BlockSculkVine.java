package com.kpabr.DeeperCaves.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockSculkVine extends Block {


	public BlockSculkVine(Material par2Material) {
		super(Material.vine);
		// TODO Auto-generated constructor stub
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	{
		return null;
	}

	@Override
	public int getRenderType() {
		return 1;
	}

}
