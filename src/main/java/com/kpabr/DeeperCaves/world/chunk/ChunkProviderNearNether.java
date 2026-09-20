package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCore.NoiseGeneratorOctavesOpenSimplex;
import com.kpabr.DeeperCore.world.WorldProviderDeeperCaves;
import com.kpabr.DeeperCore.world.cave.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCore.world.cave.MapGenDeeperRavine;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.NoiseGeneratorOctaves;

import java.util.Random;

public class ChunkProviderNearNether extends ChunkProviderDeeperCavesBase
{
    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault(false, 1.0F, 1.5D, 255, 0, 0, 47, 4, true, false, DeeperBlocks.deepStone, DeeperBlocks.basalt);
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 3, 1.5, 1.0, DeeperBlocks.deepStone, DeeperBlocks.basalt);

    NoiseGeneratorOctavesOpenSimplex caveNoise;
    NoiseGeneratorOctavesOpenSimplex caveNoise2;

    double[] caveNoiseField = new double[59392];
    double[] caveDensityNoiseField = new double[59392];


    public ChunkProviderNearNether(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.generateLavaLakes = true;
        this.generateWaterLakes = false;
        this.setupGenFromLayer(DeeperCaves.worldgen.nearNether);
        caveNoise = new NoiseGeneratorOctavesOpenSimplex(new Random(this.worldObj.getSeed() + ((WorldProviderDeeperCaves)this.worldObj.provider).layer.seedOffset + 1), 3);
        caveNoise2 = new NoiseGeneratorOctavesOpenSimplex(new Random(this.worldObj.getSeed() + ((WorldProviderDeeperCaves)this.worldObj.provider).layer.seedOffset + 2), 1);
    }

    public void finalGenPass(int p_147422_1_, int p_147422_2_, Block[] p_147422_3_, byte[] p_147422_4_, BiomeGenBase[] p_147422_5_)
    {
        caveNoiseField = caveNoise.generateNoiseOctaves(caveNoiseField, p_147422_1_*16, 0, p_147422_2_*16, 16, 102, 16, 0.1, 0.1, 0.1, 3);

        caveDensityNoiseField = caveNoise2.generateNoiseOctaves(caveDensityNoiseField, p_147422_1_*16, 0, p_147422_2_*16, 16, 102, 16, 0.01, 0.01, 0.01);

        for(int sculkX = 0; sculkX < 16; sculkX++) {
            for(int sculkZ = 0; sculkZ < 16; sculkZ++) {
                for(int sculkY = 0; sculkY < 102; sculkY++) {
                    int ind = (sculkX * 16 * 102) + (sculkZ * 102) + sculkY;
                    int blockInd = (sculkX * 16 * 256) + (sculkZ * 256) + sculkY;
                    //double rangeClamp = Math.pow(1.26, Math.max(0, Math.abs((sculkY+26)-51)-15));
                    Block b = p_147422_3_[blockInd];
                    if (caveNoiseField[ind]*Math.abs(caveDensityNoiseField[ind]+0.75) > 1.9 && (b == DeeperBlocks.deepStone || b == DeeperBlocks.basalt)) {
                        p_147422_3_[blockInd] = Blocks.air;
                    }

                }
            }
        }
    }

}