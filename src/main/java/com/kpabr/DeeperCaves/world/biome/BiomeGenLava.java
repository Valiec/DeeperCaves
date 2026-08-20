package com.kpabr.DeeperCaves.world.biome;

import net.minecraft.init.Blocks;

public class BiomeGenLava extends BiomeGenDeeper
{
    public BiomeGenLava(int p_i45377_1_)
    {
        super(p_i45377_1_);
    	this.biomeName = "Lava";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator = new LavaDecorator();
        this.theBiomeDecorator.generateLakes = true;
    }
}