package com.kpabr.DeeperCaves.world.biome;

import net.minecraft.init.Blocks;

public class BiomeGenDeepWorld extends BiomeGenDeeper
{
    public BiomeGenDeepWorld(int p_i45377_1_)
    {
        super(p_i45377_1_);
        this.spawnableMonsterList.clear();
    	this.biomeName = "Deep World";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator.generateLakes = true;

    }
    
}