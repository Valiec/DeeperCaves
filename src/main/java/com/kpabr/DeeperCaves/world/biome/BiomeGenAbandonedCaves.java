package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.DeeperBlocks;

import net.minecraft.init.Blocks;

public class BiomeGenAbandonedCaves extends BiomeGenDeeperCavesBase
{
    public BiomeGenAbandonedCaves(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Abandoned Caves";
        this.topBlock = Blocks.bedrock;
        this.fillerBlock = DeeperBlocks.abandonedStone;
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;

    }
}