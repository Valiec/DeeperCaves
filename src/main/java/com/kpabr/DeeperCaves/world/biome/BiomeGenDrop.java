package com.kpabr.DeeperCaves.world.biome;


import net.minecraft.init.Blocks;

public class BiomeGenDrop extends BiomeGenDeeperCavesBase
{
    public BiomeGenDrop(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Drop";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;

    }
}