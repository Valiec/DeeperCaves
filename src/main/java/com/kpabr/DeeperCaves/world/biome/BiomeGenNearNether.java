package com.kpabr.DeeperCaves.world.biome;


import net.minecraft.init.Blocks;

public class BiomeGenNearNether extends BiomeGenDeeperCavesBase
{
    public BiomeGenNearNether(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Near Nether";
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = Blocks.dirt;

    }
}