package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.DeeperBlocks;


import com.kpabr.DeeperCore.world.biome.LayerOregen;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenFinalLabyrinthSculk extends BiomeGenDeeperCavesBase
{
    public BiomeGenFinalLabyrinthSculk(int biomeID)
    {
        super(biomeID);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
    	this.biomeName = "Final Labyrinth Sculk";
        this.topBlock = Blocks.bedrock;
        this.fillerBlock = DeeperBlocks.fragmentedBedrock;
        this.theBiomeDecorator = new FinalLabyrinthDecorator();
        this.theBiomeDecorator.generateLakes = false;

    }

    public void generateOres(World world, Random random, int x, int z) {
        LayerOregen.addOre(DeeperBlocks.forgottenGemstoneOre, world, random, x, z, 16, 16, 4, 50, 0, 255, DeeperBlocks.fragmentedBedrock);
    }
}