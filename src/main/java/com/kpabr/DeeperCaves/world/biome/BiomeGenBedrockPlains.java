package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperConfig;
import com.kpabr.DeeperCore.worldgen.LayerOregen;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenBedrockPlains extends BiomeGenDeeperCavesBase
{
    public BiomeGenBedrockPlains(int biomeID)
    {
        super(biomeID);
    	this.biomeName = "Bedrock Plains";
        this.theBiomeDecorator = new DeeperDecorator();
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = Blocks.dirt;
    }

    public void generateOres(World world, Random random, int x, int z) {
        LayerOregen.addOre(DeeperBlocks.fragmentedBedrock, world, random, x, z, 16, 16, 8, 4, DeeperConfig.bedrockPlainsFloorHeight-8, DeeperConfig.bedrockPlainsCeilingHeight+8, Blocks.bedrock);

    }
}