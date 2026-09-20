package com.kpabr.DeeperCore.noise;

import net.minecraft.world.gen.NoiseGenerator;

import java.util.Random;

import static com.kpabr.DeeperCore.lib.OpenSimplex2.noise3_ImproveXZ;

public class NoiseGeneratorOpenSimplex extends NoiseGenerator
{
    public long seed;

    public NoiseGeneratorOpenSimplex(long seed)
    {
        this.seed = seed;
    }


    /**
     * pars: noiseArray , xOffset , yOffset , zOffset , xSize , ySize , zSize , xScale, yScale , zScale , noiseScale.
     * noiseArray should be xSize*ySize*zSize in size
     */
    public void populateNoiseArray(double[] p_76308_1_, double p_76308_2_, double p_76308_4_, double p_76308_6_, int p_76308_8_, int p_76308_9_, int p_76308_10_, double p_76308_11_, double p_76308_13_, double p_76308_15_, double p_76308_17_) {
        for (int x = 0; x < p_76308_8_; ++x) {
            double fracX = (x*p_76308_11_)+p_76308_2_;
            for (int z = 0; z < p_76308_10_; ++z) {
                double fracZ = (z*p_76308_15_)+p_76308_6_;
                for (int y = 0; y < p_76308_9_; ++y) {
                    double fracY = (y*p_76308_13_)+p_76308_4_;
                    p_76308_1_[(x * p_76308_9_ * p_76308_10_) + (z * p_76308_9_) + y] += noise3_ImproveXZ(this.seed, fracX, fracY, fracZ) / p_76308_17_;
                }
            }
        }
    }
}