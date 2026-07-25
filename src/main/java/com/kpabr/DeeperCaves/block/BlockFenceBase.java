package com.kpabr.DeeperCaves.block;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperCaves;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class BlockFenceBase extends BlockFence {
    public BlockFenceBase(String str, Material wood) {
        super(str, wood);
    }

    public static boolean func_149825_a(Block p_149825_0_)
    {
        return p_149825_0_ == Blocks.fence || p_149825_0_ == Blocks.nether_brick_fence || p_149825_0_ == DeeperBlocks.rottenFence;
    }
}
