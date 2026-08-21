package com.kpabr.DeeperCore.world.biome;

import net.minecraft.world.World;

import java.util.Random;

public interface DeeperBiome {
    public void generateOres(World world, Random random, int x, int z);
}
