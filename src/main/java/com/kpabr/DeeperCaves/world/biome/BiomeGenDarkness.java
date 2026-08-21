package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.DeeperBlocks;


import com.kpabr.DeeperCore.worldgen.LayerOregen;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

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

    public void generateOres(World world, Random random, int x, int z) {
        LayerOregen.addOre(DeeperBlocks.ddcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.ddironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.ddgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.ddlapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.ddredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.dddiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperBlocks.darkStone);
        LayerOregen.addOre(DeeperBlocks.ddemeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperBlocks.darkStone);

        LayerOregen.addOre(DeeperBlocks.vesperiteOre, world, random, x, z, 16, 16, 6, 80, 0, 255, DeeperBlocks.darkStone);
    }
}