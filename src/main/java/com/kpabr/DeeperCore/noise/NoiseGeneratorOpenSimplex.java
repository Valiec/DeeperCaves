package com.kpabr.DeeperCore.noise;

import net.minecraft.world.gen.NoiseGenerator;

import static com.kpabr.DeeperCore.lib.kdotjpg.OpenSimplex2.noise3_ImproveXZ;

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
    public void populateNoiseArray(double[] noiseArray, double xOffset, double yOffset, double zOffset, int xSize, int ySize, int zSize, double xScale, double yScale, double zScale, double noiseScale) {
        for (int x = 0; x < xSize; ++x) {
            double fracX = (x*xScale)+xOffset;
            for (int z = 0; z < zSize; ++z) {
                double fracZ = (z*zScale)+zOffset;
                for (int y = 0; y < ySize; ++y) {
                    double fracY = (y*yScale)+yOffset;
                    noiseArray[(x * ySize * zSize) + (z * ySize) + y] += noise3_ImproveXZ(this.seed, fracX, fracY, fracZ) / noiseScale;
                }
            }
        }
    }
}