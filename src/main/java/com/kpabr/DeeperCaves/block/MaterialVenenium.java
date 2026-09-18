package com.kpabr.DeeperCaves.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;

public class MaterialVenenium extends MaterialLiquid {
    public MaterialVenenium()
    {
        super(MapColor.limeColor);
        // TODO Auto-generated constructor stub
    }
    @Override
    public boolean isLiquid()
    {
        return true;
    }
}

