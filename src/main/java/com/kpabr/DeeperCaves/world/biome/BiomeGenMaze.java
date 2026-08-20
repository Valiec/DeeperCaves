package com.kpabr.DeeperCaves.world.biome;

import net.minecraft.init.Blocks;

public class BiomeGenMaze extends BiomeGenDeeper
{
    public BiomeGenMaze(int p_i45377_1_)
    {
        super(p_i45377_1_);
    	this.biomeName = "Maze";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator.generateLakes = true;
    }
}