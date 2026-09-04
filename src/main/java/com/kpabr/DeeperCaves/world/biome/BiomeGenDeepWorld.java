package com.kpabr.DeeperCaves.world.biome;


import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCore.world.biome.LayerOregen;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenDeepWorld extends BiomeGenDeeperCavesBase
{
    public BiomeGenDeepWorld(int biomeID)
    {
        super(biomeID);
        this.spawnableMonsterList.clear();
    	this.biomeName = "Deep World";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;

    }

    public void generateOres(World world, Random random, int x, int z) {
        //LayerOregen.addOre(Blocks.dirt, world, random, x, z, 16, 16, 32, 15, 0, 256, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(Blocks.gravel, world, random, x, z, 16, 16, 32, 8, 0, 256, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.dcoalOre, world, random, x, z, 16, 16, 16, 25, 0, 256, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.dironOre, world, random, x, z, 16, 16, 8, 50, 0, 256, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.dgoldOre, world, random, x, z, 16, 16, 8, 10, 0, 256, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.dredstoneOre, world, random, x, z, 16, 16, 7, 80, 0, 256, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.ddiamondOre, world, random, x, z, 16, 16, 7, 10, 0, 256, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.dlapisOre, world, random, x, z, 16, 16, 6, 12, 0, 256, DeeperBlocks.abandonedStone);

        LayerOregen.addOre(DeeperBlocks.dcoalOre, world, random, x, z, 16, 16, 15, 160, 0, 255, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.dironOre, world, random, x, z, 16, 16, 10, 130, 0, 255, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.dgoldOre, world, random, x, z, 16, 16, 8, 30, 0, 255, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.dlapisOre, world, random, x, z, 16, 16, 7, 35, 0, 255, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.dredstoneOre, world, random, x, z, 16, 16, 8, 108, 0, 255, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.ddiamondOre, world, random, x, z, 16, 16, 8, 13, 0, 255, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.demeraldOre, world, random, x, z, 16, 16, 3, 8, 0, 255, DeeperBlocks.abandonedStone);
    }
    
}