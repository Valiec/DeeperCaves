package com.kpabr.DeeperCaves.world.biome;

import net.minecraft.init.Blocks;

public class BiomeGenFarVoid extends BiomeGenDeeper
{
    public BiomeGenFarVoid(int p_i45377_1_)
    {
        super(p_i45377_1_);
    	this.biomeName = "Far Void";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator.generateLakes = true;

    }
}