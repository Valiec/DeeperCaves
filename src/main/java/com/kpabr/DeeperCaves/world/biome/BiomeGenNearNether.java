package com.kpabr.DeeperCaves.world.biome;


import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCore.world.biome.LayerOregen;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenNearNether extends BiomeGenDeeperCavesBase
{
    public BiomeGenNearNether(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Near Nether";
        this.theBiomeDecorator = new DeeperDecorator();
        ((DeeperDecorator)this.theBiomeDecorator).generateLavaLakes = true;
        ((DeeperDecorator)this.theBiomeDecorator).generateWaterLakes = false;
        this.fillerBlock = Blocks.dirt;

    }

    public void generateOres(World world, Random random, int x, int z) {
        LayerOregen.addOre(Blocks.soul_sand, world, random, x, z, 16, 16, 30, 15, 0, 256, DeeperBlocks.deepStone);
        LayerOregen.addOre(Blocks.gravel, world, random, x, z, 16, 16, 32, 8, 0, 256, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.ncoalOre, world, random, x, z, 16, 16, 16, 25, 0, 256, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.nironOre, world, random, x, z, 16, 16, 8, 50, 0, 256, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.ngoldOre, world, random, x, z, 16, 16, 8, 10, 0, 256, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.nredstoneOre, world, random, x, z, 16, 16, 7, 80, 0, 256, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.ndiamondOre, world, random, x, z, 16, 16, 7, 10, 0, 256, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.nlapisOre, world, random, x, z, 16, 16, 6, 12, 0, 256, DeeperBlocks.deepStone);

        LayerOregen.addOre(Blocks.netherrack, world, random, x, z, 16, 16, 40, 120, 0, 110, DeeperBlocks.deepStone);
        LayerOregen.addOre(Blocks.quartz_ore, world, random, x, z, 16, 16, 8, 55, 0, 110, Blocks.netherrack);
        LayerOregen.addOre(Blocks.glowstone, world, random, x, z, 16, 16, 20, 60, 0, 110, Blocks.netherrack);
    }
}