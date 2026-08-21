package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.DeeperBlocks;


import net.minecraft.init.Blocks;

public class BiomeGenForgotten extends BiomeGenDeeperCavesBase
{
    public BiomeGenForgotten(int biomeID)
    {
        super(biomeID);
        this.spawnableMonsterList.clear();
    	this.biomeName = "Forgotten";
        this.topBlock = Blocks.bedrock;
        this.fillerBlock = DeeperBlocks.deepStone;
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;

    }
}