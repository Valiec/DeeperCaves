package com.kpabr.DeeperCaves.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenDeeper extends BiomeGenBase
{
    public BiomeGenDeeper(int p_i45377_1_)
    {
        super(p_i45377_1_);
        this.temperature = 0.80F;
        this.setHeight(BiomeGenBase.height_LowHills);
        this.topBlock = Blocks.stone;
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.treesPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 0;
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = Blocks.stone;
        this.rainfall = 0.68F;

    }
}