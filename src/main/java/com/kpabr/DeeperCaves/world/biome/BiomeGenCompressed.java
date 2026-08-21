package com.kpabr.DeeperCaves.world.biome;


import net.minecraft.init.Blocks;

public class BiomeGenCompressed extends BiomeGenDeeperCavesBase
{
    public BiomeGenCompressed(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Compressed";
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = Blocks.dirt;

    }
}