package com.kpabr.DeeperCaves.world.biome;


import com.kpabr.DeeperCore.worldgen.LayerOregen;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenDrop extends BiomeGenDeeperCavesBase
{
    public BiomeGenDrop(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Drop";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;

    }

    public void generateOres(World world, Random random, int x, int z) {
        LayerOregen.addOre(Blocks.dirt, world, random, x, z, 16, 16, 32, 15, 0, 256, Blocks.stone);
        LayerOregen.addOre(Blocks.gravel, world, random, x, z, 16, 16, 32, 8, 0, 256, Blocks.stone);
        LayerOregen.addOre(Blocks.coal_ore, world, random, x, z, 16, 16, 16, 25, 0, 256, Blocks.stone);
        LayerOregen.addOre(Blocks.iron_ore, world, random, x, z, 16, 16, 8, 50, 0, 256, Blocks.stone);
        LayerOregen.addOre(Blocks.gold_ore, world, random, x, z, 16, 16, 8, 10, 0, 256, Blocks.stone);
        LayerOregen.addOre(Blocks.redstone_ore, world, random, x, z, 16, 16, 7, 80, 0, 256, Blocks.stone);
        LayerOregen.addOre(Blocks.diamond_ore, world, random, x, z, 16, 16, 7, 10, 0, 256, Blocks.stone);
        LayerOregen.addOre(Blocks.lapis_ore, world, random, x, z, 16, 16, 6, 12, 0, 256, Blocks.stone);

        LayerOregen.addOre(Blocks.gold_ore, world, random, x, z, 16, 16, 16, 8, 0, 256, Blocks.stone);
        LayerOregen.addOre(Blocks.diamond_ore, world, random, x, z, 16, 16, 12, 2, 0, 256, Blocks.stone);
        LayerOregen.addOre(Blocks.emerald_ore, world, random, x, z, 16, 16, 8, 1, 0, 256, Blocks.stone);

    }
}