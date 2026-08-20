package com.kpabr.DeeperCaves.world.biome;

import net.minecraft.init.Blocks;

public class BiomeGenMutation extends BiomeGenDeeper
{
    public BiomeGenMutation(int p_i45377_1_)
    {
        super(p_i45377_1_);
        this.spawnableMonsterList.clear();
    	this.biomeName = "Mutation";
        this.theBiomeDecorator = new LavaDecorator();
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator.generateLakes = true;

    }
}