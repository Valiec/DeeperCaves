package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperCaves;
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


public class ChunkProviderEvil extends ChunkProviderDeeperCavesBase
{

    NoiseGeneratorOctaves sculkNoise;
    NoiseGeneratorOctaves caveNoise;
    NoiseGeneratorOctaves caveNoise2;

    double[] noiseField = new double[59392];
    double[] caveNoiseField = new double[59392];
    double[] caveDensityNoiseField = new double[59392];

    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault(false, 1.0F, 1.5D, 255, 0, 0, 47, 4, true, false, DeeperBlocks.forgottenStone);
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 15, 1.5, 1.0, DeeperBlocks.forgottenStone);

    public ChunkProviderEvil(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.setupGenFromLayer(DeeperCaves.worldgen.evil);
        sculkNoise = new NoiseGeneratorOctaves(new Random(this.worldObj.getSeed() + ((WorldProviderDeeperCaves)this.worldObj.provider).layer.seedOffset), 2);
        caveNoise = new NoiseGeneratorOctaves(new Random(this.worldObj.getSeed() + ((WorldProviderDeeperCaves)this.worldObj.provider).layer.seedOffset + 1), 3);
        caveNoise2 = new NoiseGeneratorOctaves(new Random(this.worldObj.getSeed() + ((WorldProviderDeeperCaves)this.worldObj.provider).layer.seedOffset + 2), 1);
    }

    public void finalGenPass(int p_147422_1_, int p_147422_2_, Block[] p_147422_3_, byte[] p_147422_4_, BiomeGenBase[] p_147422_5_)
    {
        noiseField = sculkNoise.generateNoiseOctaves(noiseField, p_147422_1_*16, 0, p_147422_2_*16, 16, 102, 16, 0.15, 0.15, 0.15);

        caveNoiseField = caveNoise.generateNoiseOctaves(caveNoiseField, p_147422_1_*16, 0, p_147422_2_*16, 16, 50, 16, 0.1, 0.1, 0.1);

        caveDensityNoiseField = caveNoise2.generateNoiseOctaves(caveDensityNoiseField, p_147422_1_*16, 0, p_147422_2_*16, 16, 50, 16, 0.01, 0.01, 0.01);

        for(int sculkX = 0; sculkX < 16; sculkX++) {
            for(int sculkZ = 0; sculkZ < 16; sculkZ++) {
                for(int sculkY = 0; sculkY < 50; sculkY++) {
                    int ind = (sculkX * 16 * 50) + (sculkZ * 50) + sculkY;
                    int blockInd = (sculkX * 16 * 256) + (sculkZ * 256) + sculkY + 26;
                    double rangeClamp = Math.pow(1.26, Math.max(0, Math.abs((sculkY+26)-51)-15));
                    if (caveNoiseField[ind]*Math.abs(caveDensityNoiseField[ind]+0.75) > 2.1*(rangeClamp) && p_147422_3_[blockInd] == DeeperBlocks.forgottenStone) {
                        p_147422_3_[blockInd] = Blocks.air;
                    }

                }
            }
        }

        for(int sculkX = 0; sculkX < 16; sculkX++) {
            for(int sculkZ = 0; sculkZ < 16; sculkZ++) {
                for(int sculkY = 0; sculkY < 102; sculkY++) {
                    int ind = (sculkX * 16 * 102) + (sculkZ * 102) + sculkY;
                    int blockInd = (sculkX * 16 * 256) + (sculkZ * 256) + sculkY;
                    if (noiseField[ind] < -0.2 && p_147422_3_[blockInd] == DeeperBlocks.forgottenStone) {
                        p_147422_3_[blockInd] = DeeperBlocks.sculkFlesh;
                    }
                    else if (noiseField[ind] < -0.05 && p_147422_3_[blockInd] == DeeperBlocks.forgottenStone) {
                        p_147422_3_[blockInd] = DeeperBlocks.sculk;
                    }
                    else if (sculkY < 101 && noiseField[ind] < -0.08 && p_147422_3_[blockInd] != null && p_147422_3_[blockInd].isNormalCube()  && (p_147422_3_[blockInd+1] == Blocks.air || p_147422_3_[blockInd+1] == null)) {
                        p_147422_3_[blockInd+1] = DeeperBlocks.sculkVein;
                    }
                }
            }
        }
    }


}