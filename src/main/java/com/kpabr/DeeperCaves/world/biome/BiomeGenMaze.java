package com.kpabr.DeeperCaves.world.biome;


import net.minecraft.init.Blocks;

public class BiomeGenMaze extends BiomeGenDeeperCavesBase
{
    public BiomeGenMaze(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Maze";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;
    }
}