package com.kpabr.DeeperCaves.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSculkVine extends Block {


	public BlockSculkVine(Material par2Material) {
		super(par2Material);
		// TODO Auto-generated constructor stub
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public int getRenderType() {
		return 1;
	}

}
