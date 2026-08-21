package com.kpabr.DeeperCaves.world.biome;


import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCore.worldgen.LayerOregen;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenCompressed extends BiomeGenDeeperCavesBase
{
    public BiomeGenCompressed(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Compressed";
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = Blocks.dirt;

    }

    public void generateOres(World world, Random random, int x, int z) {
        LayerOregen.addOre(DeeperBlocks.ccoalOre, world, random, x, z, 16, 16, 15, 160, 0, 255, Blocks.stone);
        LayerOregen.addOre(DeeperBlocks.cironOre, world, random, x, z, 16, 16, 10, 130, 0, 255, Blocks.stone);
        LayerOregen.addOre(DeeperBlocks.cgoldOre, world, random, x, z, 16, 16, 8, 30, 0, 255, Blocks.stone);
        LayerOregen.addOre(DeeperBlocks.clapisOre, world, random, x, z, 16, 16, 7, 35, 0, 255, Blocks.stone);
        LayerOregen.addOre(DeeperBlocks.credstoneOre, world, random, x, z, 16, 16, 8, 108, 0, 255, Blocks.stone);
        LayerOregen.addOre(DeeperBlocks.cdiamondOre, world, random, x, z, 16, 16, 8, 13, 0, 255, Blocks.stone);
        LayerOregen.addOre(DeeperBlocks.cemeraldOre, world, random, x, z, 16, 16, 3, 8, 0, 255, Blocks.stone);
        LayerOregen.addOre(DeeperBlocks.csapphireOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
        LayerOregen.addOre(DeeperBlocks.caquamarineOre, world, random, x, z, 16, 16, 9, 40, 0, 255, Blocks.stone);
        LayerOregen.addOre(DeeperBlocks.csilverOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
        LayerOregen.addOre(DeeperBlocks.crubyOre, world, random, x, z, 16, 16, 5, 35, 0, 255, Blocks.stone);
    }
}