package com.kpabr.DeeperCaves.world.biome;

import net.minecraft.init.Blocks;

public class BiomeGenNearVoid extends BiomeGenDeeper
{
    public BiomeGenNearVoid(int p_i45377_1_)
    {
        super(p_i45377_1_);
    	this.biomeName = "Near Void";
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = Blocks.dirt;

    }
}