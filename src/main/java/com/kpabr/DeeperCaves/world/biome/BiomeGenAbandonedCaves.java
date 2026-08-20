package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.DeeperBlocks;

import net.minecraft.init.Blocks;

public class BiomeGenAbandonedCaves extends BiomeGenDeeper
{
    public BiomeGenAbandonedCaves(int p_i45377_1_)
    {
        super(p_i45377_1_);
    	this.biomeName = "Abandoned Caves";
        this.topBlock = Blocks.bedrock;
        this.fillerBlock = DeeperBlocks.abandonedStone;
        this.theBiomeDecorator.generateLakes = true;

    }
}