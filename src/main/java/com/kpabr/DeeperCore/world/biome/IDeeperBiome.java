package com.kpabr.DeeperCore.world.biome;

import net.minecraft.world.World;

import java.util.Random;

public interface IDeeperBiome {
    public void generateOres(World world, Random random, int x, int z);
}
