package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.DeeperBlocks;

import net.minecraft.init.Blocks;

public class BiomeGenDarkness extends BiomeGenDeeper
{
    public BiomeGenDarkness(int p_i45377_1_)
    {
        super(p_i45377_1_);
    	this.biomeName = "Darkness";
        this.topBlock = Blocks.bedrock;
        this.fillerBlock = DeeperBlocks.darkStone;
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = Blocks.dirt;

    }
}