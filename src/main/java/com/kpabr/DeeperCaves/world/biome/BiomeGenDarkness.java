package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.DeeperBlocks;


import net.minecraft.init.Blocks;

public class BiomeGenDarkness extends BiomeGenDeeperCavesBase
{
    public BiomeGenDarkness(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Darkness";
        this.topBlock = Blocks.bedrock;
        this.fillerBlock = DeeperBlocks.darkStone;
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = Blocks.dirt;

    }
}