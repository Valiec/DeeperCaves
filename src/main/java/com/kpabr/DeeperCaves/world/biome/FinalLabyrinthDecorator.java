package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCore.world.WorldProviderDeeperCaves;
import com.kpabr.DeeperCore.world.biome.DeeperBaseDecorator;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.LAKE;

public class FinalLabyrinthDecorator extends DeeperBaseDecorator {


    public static NoiseGeneratorOctaves sculkNoise;

    double[] boneDensityNoiseField = new double[62720];
    double[] sculkNoiseField = new double[62720];
    //double[] vineTendrilNoiseField = new double[1];

    public static NoiseGeneratorOctaves boneNoise;


    public boolean neighborsSolid(int x, int y, int z) {
        if(this.currentWorld.getBlock(x, y - 1, z).isNormalCube()) {
            return true;
        }

        if(this.currentWorld.getBlock(x, y + 1, z).isNormalCube()) {
            return true;
        }

        if(this.currentWorld.getBlock(x - 1, y, z).isNormalCube()) {
            return true;
        }

        if(this.currentWorld.getBlock(x + 1, y, z).isNormalCube()) {
            return true;
        }

        if(this.currentWorld.getBlock(x, y, z - 1).isNormalCube()) {
            return true;
        }

        if(this.currentWorld.getBlock(x, y, z + 1).isNormalCube()) {
            return true;
        }

        return false;
    }

    @Override
    protected void decorate(BiomeGenBase biome)
    {

        //if(sculkNoise == null) { //don't have a world earlier, or this isn't the same world
        //
        //}



        if(biome.biomeID == DeeperCaves.worldgen.finalLabyrinth.biomes.get("Final Labyrinth Sculk").biomeID) {


            if (sculkNoise == null) {
                sculkNoise = new NoiseGeneratorOctaves(new Random(currentWorld.getSeed() + ((WorldProviderDeeperCaves)currentWorld.provider).layer.seedOffset), 1);
            }

            if (boneNoise == null) {
                boneNoise = new NoiseGeneratorOctaves(new Random(this.currentWorld.getSeed() + ((WorldProviderDeeperCaves) this.currentWorld.provider).layer.seedOffset + 1), 1);

            }


            int i;

            int j;
            int k;

            int i1;


        /*for (i1 = 0; i1 < 960; ++i1)
        {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.randomGenerator.nextInt(102)+1;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            if(this.currentWorld.getBlock(i, j-1, k) == DeeperBlocks.sculk && this.currentWorld.getBlock(i, j, k) == Blocks.air)
            {
                this.currentWorld.setBlock(i, j, k, DeeperBlocks.sculkSensor, 0, 2);
            }
        }*/

            sculkNoiseField = sculkNoise.generateNoiseOctaves(sculkNoiseField, chunk_X + 8, 0, chunk_Z + 8, 16, 245, 16, 0.15, 0.15, 0.15);


            boneDensityNoiseField = boneNoise.generateNoiseOctaves(boneDensityNoiseField, chunk_X + 8, 0, chunk_Z + 8, 16, 245, 16, 0.08, 0.08, 0.08);


            for (i1 = 0; i1 < 512; ++i1) {
                i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                j = this.randomGenerator.nextInt(244) + 1;
                k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                if (this.currentWorld.getBlock(i, j-1, k) != Blocks.air && this.currentWorld.getBlock(i, j, k) == Blocks.air && this.randomGenerator.nextFloat() < Math.abs(boneDensityNoiseField[((i-(this.chunk_X+8)) * 16 * 245) + ((k-(this.chunk_Z+8)) * 245) + j])) {
                    int curj = j;

                    while (curj < 245 && this.currentWorld.getBlock(i, curj, k) == Blocks.air) {
                        this.currentWorld.setBlock(i, curj, k, DeeperBlocks.sculkBone, 0, 2);
                        curj++;
                    }
                }
            }

        /*for (i1 = 0; i1 < 240; ++i1)
        {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.randomGenerator.nextInt(102)+1;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            if(this.currentWorld.getBlock(i, j-1, k) == DeeperBlocks.sculk && this.currentWorld.getBlock(i, j, k) == Blocks.air)
            {
                this.currentWorld.setBlock(i, j, k, DeeperBlocks.sculkShrieker, 0, 2);
            }
        }

        for (i1 = 0; i1 < 288; ++i1)
        {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.randomGenerator.nextInt(102)+1;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            if(this.currentWorld.getBlock(i, j-1, k) == DeeperBlocks.sculk && this.currentWorld.getBlock(i, j, k) == Blocks.air)
            {
                this.currentWorld.setBlock(i, j, k, DeeperBlocks.sculkCatalyst, 0, 2);
            }
        }*/


            int k1, j1;

            for (i1 = 0; i1 < 16; ++i1) {
                for (k1 = 0; k1 < 16; ++k1) {
                    for (j1 = 0; j1 < 245; ++j1) {
                        if(sculkNoiseField[i1 * 16 * 245 + k1 * 245 + j1] > 0.5)
                        {
                            if(this.currentWorld.getBlock(chunk_X+i1+8, j1, chunk_Z+k1+8) == Blocks.air && neighborsSolid(chunk_X+i1+8, j1, chunk_Z+k1+8))
                            {
                                this.currentWorld.setBlock(chunk_X+i1+8, j1, chunk_Z+k1+8, DeeperBlocks.sculkVein, 0, 2);
                            }
                        }
                    }
                }
            }

            /*for (i1 = 0; i1 < 3200; ++i1) {
                i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                j = this.randomGenerator.nextInt(246) + 1;
                k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                if (neighborsSolid(i, j, k) && this.currentWorld.getBlock(i, j, k) == Blocks.air) {

                    int generated = 0;
                    int genMax = this.randomGenerator.nextInt(16) + 4;

                    for (int i1b = 0; i1b < 120; ++i1b) {

                        if(generated >= genMax) {
                            break;
                        }

                        int i2 = i + this.randomGenerator.nextInt(8) - 4;
                        int j2 = j + this.randomGenerator.nextInt(8) - 4;
                        int k2 = k + this.randomGenerator.nextInt(8) - 4;

                        if (j2 < 0) {
                            j2 = 0;
                        }

                        if (j2 > 255) {
                            j2 = 255;
                        }

                        if (neighborsSolid(i2, j2, k2) && this.currentWorld.getBlock(i2, j2, k2) == Blocks.air) {
                            this.currentWorld.setBlock(i2, j2, k2, DeeperBlocks.sculkVein, 0, 2);
                            generated++;
                        }
                    }

                }
            }*/
        }

        decorateAdditional(biome);
    }

    protected void decorateAdditional(BiomeGenBase biome)
    {
        //do nothing
    }
}
