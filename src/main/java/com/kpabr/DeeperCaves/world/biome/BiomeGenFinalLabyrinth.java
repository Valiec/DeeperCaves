package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.DeeperBlocks;


import net.minecraft.init.Blocks;

public class BiomeGenFinalLabyrinth extends BiomeGenDeeperCavesBase
{
    public BiomeGenFinalLabyrinth(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Final Labyrinth";
        this.topBlock = Blocks.bedrock;
        this.fillerBlock = DeeperBlocks.fragmentedBedrock;
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;

    }
}