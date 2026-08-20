package com.kpabr.DeeperCaves.world.biome;

import net.minecraft.init.Blocks;

public class BiomeGenCompressed extends BiomeGenDeeper
{
    public BiomeGenCompressed(int p_i45377_1_)
    {
        super(p_i45377_1_);
    	this.biomeName = "Compressed";
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = Blocks.dirt;

    }
}