package com.kpabr.DeeperCore.worldgen;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenDeeperBase extends BiomeGenBase
{
    public BiomeGenDeeperBase(int biomeID)
    {
        super(biomeID);
        this.temperature = 0.80F;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        //exists so strongholds work if they're needed
        this.rootHeight = 0.01F;
        this.topBlock = Blocks.stone;
        this.theBiomeDecorator.treesPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 0;
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.theBiomeDecorator.generateLakes = false;
        this.fillerBlock = Blocks.stone;
        this.rainfall = 0.68F;

    }
}