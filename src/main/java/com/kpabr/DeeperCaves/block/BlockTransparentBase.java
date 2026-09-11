package com.kpabr.DeeperCaves.block;

import net.minecraft.block.material.Material;

public class BlockTransparentBase extends BlockBase {
    public BlockTransparentBase(Material rock) {
        super(rock);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
}
