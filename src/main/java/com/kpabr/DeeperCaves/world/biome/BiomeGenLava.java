package com.kpabr.DeeperCaves.world.biome;


import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCore.world.biome.LayerOregen;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenLava extends BiomeGenDeeperCavesBase
{
    public BiomeGenLava(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Lava";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator = new LavaDecorator();
        this.theBiomeDecorator.generateLakes = true;
    }

    public void generateOres(World world, Random random, int x, int z) {
        LayerOregen.addOre(Blocks.dirt, world, random, x, z, 16, 16, 32, 15, 0, 256, DeeperBlocks.deepStone);
        LayerOregen.addOre(Blocks.gravel, world, random, x, z, 16, 16, 32, 8, 0, 256, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.ncoalOre, world, random, x, z, 16, 16, 16, 25, 0, 256, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.nironOre, world, random, x, z, 16, 16, 8, 50, 0, 256, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.ngoldOre, world, random, x, z, 16, 16, 8, 10, 0, 256, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.nredstoneOre, world, random, x, z, 16, 16, 7, 80, 0, 256, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.ndiamondOre, world, random, x, z, 16, 16, 7, 10, 0, 256, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.nlapisOre, world, random, x, z, 16, 16, 6, 12, 0, 256, DeeperBlocks.deepStone);


        LayerOregen.addOre(DeeperBlocks.magmaStone, world, random, x, z, 16, 16, 40, 80, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(Blocks.cobblestone, world, random, x, z, 16, 16, 15, 120, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.fragmentedCobble, world, random, x, z, 16, 16, 14, 80, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.fragmentedBedrock, world, random, x, z, 16, 16, 8, 55, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(Blocks.flowing_lava, world, random, x, z, 16, 16, 1, 65, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.incenditeOre, world, random, x, z, 16, 16, 3, 4, 0, 50, DeeperBlocks.deepStone);
    }
}