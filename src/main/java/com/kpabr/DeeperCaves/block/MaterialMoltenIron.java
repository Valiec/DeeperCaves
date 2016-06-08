package com.kpabr.DeeperCaves.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;

public class MaterialMoltenIron extends MaterialLiquid {

	public MaterialMoltenIron() 
	{
		super(MapColor.tntColor);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isLiquid()
	{
		return true;
	}

}
