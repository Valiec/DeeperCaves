package com.kpabr.DeeperCaves.world.biome;


import net.minecraft.init.Blocks;

public class BiomeGenLava extends BiomeGenDeeperCavesBase
{
    public BiomeGenLava(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Lava";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator = new LavaDecorator();
        this.theBiomeDecorator.generateLakes = true;
    }
}