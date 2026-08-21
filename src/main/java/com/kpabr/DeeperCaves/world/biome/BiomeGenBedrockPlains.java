package com.kpabr.DeeperCaves.world.biome;

import net.minecraft.init.Blocks;

public class BiomeGenBedrockPlains extends BiomeGenDeeperCavesBase
{
    public BiomeGenBedrockPlains(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Bedrock Plains";
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = Blocks.dirt;
    }
}