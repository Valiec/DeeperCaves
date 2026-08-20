package com.kpabr.DeeperCaves.world.biome;

import net.minecraft.init.Blocks;

public class BiomeGenNearNether extends BiomeGenDeeper
{
    public BiomeGenNearNether(int p_i45377_1_)
    {
        super(p_i45377_1_);
    	this.biomeName = "Near Nether";
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = Blocks.dirt;

    }
}