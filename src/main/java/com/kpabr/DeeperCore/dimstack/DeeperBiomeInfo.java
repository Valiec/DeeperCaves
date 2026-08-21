package com.kpabr.DeeperCore.dimstack;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

public class DeeperBiomeInfo {
    public BiomeGenBase biomeGen;
    public BiomeDictionary.Type biomeType;

    public DeeperBiomeInfo(BiomeGenBase biomeGen, BiomeDictionary.Type biomeType) {
        this.biomeGen = biomeGen;
        this.biomeType = biomeType;
    }

    public void register() {
        BiomeDictionary.registerBiomeType(this.biomeGen, biomeType);
    }
}
