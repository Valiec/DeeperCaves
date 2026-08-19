package com.kpabr.DeeperCaves.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.IBlockAccess;

public class BlockBarrier extends BlockBase {
    public BlockBarrier(Material par2Material) {
        super(par2Material);
    }

    public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z) {
        return false;
    }
}
