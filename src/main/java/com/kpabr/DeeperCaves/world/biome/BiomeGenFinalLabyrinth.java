package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.DeeperBlocks;

import net.minecraft.init.Blocks;

public class BiomeGenFinalLabyrinth extends BiomeGenDeeper
{
    public BiomeGenFinalLabyrinth(int p_i45377_1_)
    {
        super(p_i45377_1_);
    	this.biomeName = "Final Labyrinth";
        this.topBlock = Blocks.bedrock;
        this.fillerBlock = DeeperBlocks.fragmentedBedrock;
        this.theBiomeDecorator.generateLakes = true;

    }
}