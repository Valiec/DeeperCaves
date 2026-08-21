package com.kpabr.DeeperCaves.world.biome;


import net.minecraft.init.Blocks;

public class BiomeGenNearVoid extends BiomeGenDeeperCavesBase
{
    public BiomeGenNearVoid(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Near Void";
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = Blocks.dirt;

    }
}