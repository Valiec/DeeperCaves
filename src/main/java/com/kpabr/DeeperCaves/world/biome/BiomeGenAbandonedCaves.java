package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.DeeperBlocks;

import com.kpabr.DeeperCore.world.biome.LayerOregen;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenAbandonedCaves extends BiomeGenDeeperCavesBase
{
    public BiomeGenAbandonedCaves(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Abandoned Caves";
        this.topBlock = Blocks.bedrock;
        this.fillerBlock = DeeperBlocks.abandonedStone;
        this.theBiomeDecorator = new AbandonedCavesDecorator();
        this.theBiomeDecorator.generateLakes = true;

    }

    public void generateOres(World world, Random random, int x, int z) {
        LayerOregen.addOre(DeeperBlocks.dcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.dironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.dgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.dlapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.dredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.ddiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperBlocks.abandonedStone);
        LayerOregen.addOre(DeeperBlocks.demeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperBlocks.abandonedStone);
    }
}