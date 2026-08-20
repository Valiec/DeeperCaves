package com.kpabr.DeeperCaves.world.biome;

import net.minecraft.init.Blocks;

public class BiomeGenDrop extends BiomeGenDeeper
{
    public BiomeGenDrop(int p_i45377_1_)
    {
        super(p_i45377_1_);
    	this.biomeName = "Drop";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator.generateLakes = true;

    }
}