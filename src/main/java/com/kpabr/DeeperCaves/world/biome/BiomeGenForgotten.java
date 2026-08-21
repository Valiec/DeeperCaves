package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.DeeperBlocks;


import com.kpabr.DeeperCore.worldgen.LayerOregen;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

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

    public void generateOres(World world, Random random, int x, int z) {
        LayerOregen.addOre(DeeperBlocks.dpcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.dpironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.dpgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.dplapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.dpredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.dpdiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.dpemeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.evanesciteOre, world, random, x, z, 16, 16, 6, 180, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.profundiumOre, world, random, x, z, 16, 16, 6, 90, 0, 255, DeeperBlocks.deepStone);
    }
}