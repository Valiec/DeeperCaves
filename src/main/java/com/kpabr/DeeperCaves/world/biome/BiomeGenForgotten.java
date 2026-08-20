package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.DeeperBlocks;

import net.minecraft.init.Blocks;

public class BiomeGenForgotten extends BiomeGenDeeper
{
    public BiomeGenForgotten(int p_i45377_1_)
    {
        super(p_i45377_1_);
        this.spawnableMonsterList.clear();
    	this.biomeName = "Forgotten";
        this.topBlock = Blocks.bedrock;
        this.fillerBlock = DeeperBlocks.deepStone;
        this.theBiomeDecorator.generateLakes = true;

    }
}