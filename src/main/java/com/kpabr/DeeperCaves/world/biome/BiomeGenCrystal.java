package com.kpabr.DeeperCaves.world.biome;


import net.minecraft.init.Blocks;

public class BiomeGenCrystal extends BiomeGenDeeperCavesBase
{
    public BiomeGenCrystal(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Crystal";
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = Blocks.dirt;

    }
}