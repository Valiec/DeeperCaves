package com.kpabr.DeeperCaves.world.biome;


import net.minecraft.init.Blocks;

public class BiomeGenFarVoid extends BiomeGenDeeperCavesBase
{
    public BiomeGenFarVoid(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Far Void";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;

    }
}