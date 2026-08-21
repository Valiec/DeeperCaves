package com.kpabr.DeeperCaves.block;

import com.kpabr.DeeperCaves.DeeperBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class BlockFenceBase extends BlockFence {
    public BlockFenceBase(String str, Material wood) {
        super(str, wood);
    }

    public static boolean func_149825_a(Block theBlock)
    {
        return theBlock == Blocks.fence || theBlock == Blocks.nether_brick_fence || theBlock == DeeperBlocks.rottenFence;
    }
}
