package com.kpabr.DeeperCaves.world.biome;


import net.minecraft.init.Blocks;

public class BiomeGenDeepWorld extends BiomeGenDeeperCavesBase
{
    public BiomeGenDeepWorld(int biomeID)
    {
        super(biomeID);
        this.spawnableMonsterList.clear();
    	this.biomeName = "Deep World";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;

    }
    
}