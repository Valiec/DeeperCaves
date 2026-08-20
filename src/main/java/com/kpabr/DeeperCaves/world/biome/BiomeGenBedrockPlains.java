package com.kpabr.DeeperCaves.world.biome;

import net.minecraft.init.Blocks;

public class BiomeGenBedrockPlains extends BiomeGenDeeper
{
    public BiomeGenBedrockPlains(int p_i45377_1_)
    {
        super(p_i45377_1_);
    	this.biomeName = "Bedrock Plains";
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = Blocks.dirt;
    }
}