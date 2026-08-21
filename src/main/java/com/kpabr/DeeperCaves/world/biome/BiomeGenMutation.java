package com.kpabr.DeeperCaves.world.biome;


import net.minecraft.init.Blocks;

public class BiomeGenMutation extends BiomeGenDeeperCavesBase
{
    public BiomeGenMutation(int biomeID)
    {
        super(biomeID);
        this.spawnableMonsterList.clear();
    	this.biomeName = "Mutation";
        this.theBiomeDecorator = new LavaDecorator();
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator.generateLakes = true;

    }
}