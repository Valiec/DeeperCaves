package com.kpabr.DeeperCaves.world.biome;


import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCore.world.biome.LayerOregen;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenFarVoid extends BiomeGenDeeperCavesBase
{
    public BiomeGenFarVoid(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Far Void";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;

    }

    public void generateOres(World world, Random random, int x, int z) {
        LayerOregen.addOre(DeeperBlocks.dccoalOre, world, random, x, z, 16, 16, 15, 4, 220, 235, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.dcironOre, world, random, x, z, 16, 16, 10, 2, 220, 235, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.dcgoldOre, world, random, x, z, 16, 16, 8, 1, 220, 235, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.dclapisOre, world, random, x, z, 16, 16, 7, 1, 220, 235, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.dcredstoneOre, world, random, x, z, 16, 16, 8, 1, 220, 235, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.dcdiamondOre, world, random, x, z, 16, 16, 8, 1, 220, 235, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.dcemeraldOre, world, random, x, z, 16, 16, 3, 1, 220, 235, DeeperBlocks.darkStone);
        LayerOregen.addOre(Blocks.obsidian, world, random, x, z, 16, 16, 15, 3, 220, 255, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.cooledObsidian, world, random, x, z, 16, 16, 15, 3, 220, 255, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.heatedObsidian, world, random, x, z, 16, 16, 15, 3, 220, 255, DeeperBlocks.darkStone);
        LayerOregen.addOre(Blocks.end_stone, world, random, x, z, 16, 16, 15, 1, 128, 255, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.dcsapphireOre, world, random, x, z, 16, 16, 4, 32, 0, 255, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.dcaquamarineOre, world, random, x, z, 16, 16, 9, 40, 0, 255, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.dcsilverOre, world, random, x, z, 16, 16, 4, 32, 0, 255, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.dcrubyOre, world, random, x, z, 16, 16, 5, 35, 0, 255, DeeperBlocks.darkStone);
    }
}