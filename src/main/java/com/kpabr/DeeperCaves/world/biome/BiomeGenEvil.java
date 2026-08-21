package com.kpabr.DeeperCaves.world.biome;


import net.minecraft.init.Blocks;

public class BiomeGenEvil extends BiomeGenDeeperCavesBase
{
    public BiomeGenEvil(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Evil";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;

    }
}