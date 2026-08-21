package com.kpabr.DeeperCaves.world.biome;


import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCore.worldgen.LayerOregen;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenEvil extends BiomeGenDeeperCavesBase
{
    public BiomeGenEvil(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Evil";
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;

    }

    public void generateOres(World world, Random random, int x, int z) {
        LayerOregen.addOre(DeeperBlocks.soulStone, world, random, x, z, 16, 16, 25, 180, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.corruptedSoulStone, world, random, x, z, 16, 16, 16, 120, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.cryingObsidian, world, random, x, z, 16, 16, 14, 92, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.prisciumOre, world, random, x, z, 16, 16, 6, 67, 0, 255, DeeperBlocks.deepStone);
        LayerOregen.addOre(DeeperBlocks.profundiumOre, world, random, x, z, 16, 16, 3, 50, 0, 255, DeeperBlocks.deepStone);
    }
}