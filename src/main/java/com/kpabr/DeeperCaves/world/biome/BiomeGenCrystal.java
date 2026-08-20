package com.kpabr.DeeperCaves.world.biome;

import net.minecraft.init.Blocks;

public class BiomeGenCrystal extends BiomeGenDeeper
{
    public BiomeGenCrystal(int p_i45377_1_)
    {
        super(p_i45377_1_);
    	this.biomeName = "Crystal";
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = Blocks.dirt;

    }
}