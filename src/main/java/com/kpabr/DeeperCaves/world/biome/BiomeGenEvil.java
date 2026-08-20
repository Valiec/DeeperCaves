package com.kpabr.DeeperCaves.world.biome;

import net.minecraft.init.Blocks;

public class BiomeGenEvil extends BiomeGenDeeper
{
    public BiomeGenEvil(int p_i45377_1_)
    {
        super(p_i45377_1_);
    	this.biomeName = "Evil";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator.generateLakes = true;

    }
}