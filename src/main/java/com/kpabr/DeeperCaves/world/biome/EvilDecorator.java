package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.DeeperBlocks;
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

public class EvilDecorator extends DeeperBaseDecorator {


    public static NoiseGeneratorPerlin sculkNoise;

    double[] vineTendrilDensityNoiseField = new double[1];
    double[] vineTendrilNoiseField = new double[1];

    public static NoiseGeneratorOctaves vineTendrilNoise;
    public static NoiseGeneratorOctaves vineTendrilNoise2;

    @Override
    protected void decorate(BiomeGenBase biome)
    {

        //if(sculkNoise == null) { //don't have a world earlier, or this isn't the same world
        //    sculkNoise = new NoiseGeneratorPerlin(new Random(currentWorld.getSeed() + ((WorldProviderDeeperCaves)currentWorld.provider).layer.seedOffset), 1);
        //}

        //noiseField = sculkNoise.func_151600_a(noiseField, chunk_X, 0, chunk_Z, 1, 1, 0.15, 0.15, 1);

        vineTendrilNoise = new NoiseGeneratorOctaves(new Random(this.currentWorld.getSeed() + ((WorldProviderDeeperCaves)this.currentWorld.provider).layer.seedOffset + 3), 1);
        vineTendrilNoise2 = new NoiseGeneratorOctaves(new Random(this.currentWorld.getSeed() + ((WorldProviderDeeperCaves)this.currentWorld.provider).layer.seedOffset + 4), 1);

        int i;

        int j;
        int k;

        int i1;

        boolean doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, LAKE);
        if (doGen && this.generateWaterLakes) {
            for (i1 = 0; i1 < 50; ++i1) {
                i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                j = this.randomGenerator.nextInt(this.randomGenerator.nextInt(248) + 8);
                k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenLiquids(Blocks.flowing_water)).generate(this.currentWorld, this.randomGenerator, i, j, k);
            }
        }

        if (doGen && (this.generateLakes || this.generateLavaLakes)) {

            for (i1 = 0; i1 < 20; ++i1)
            {
                i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                j = this.randomGenerator.nextInt(this.randomGenerator.nextInt(this.randomGenerator.nextInt(240) + 8) + 8);
                k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenLiquids(Blocks.flowing_lava)).generate(this.currentWorld, this.randomGenerator, i, j, k);
            }
        }

        for (i1 = 0; i1 < 320; ++i1)
        {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.randomGenerator.nextInt(102)+1;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            if(this.currentWorld.getBlock(i, j-1, k) == DeeperBlocks.sculk && this.currentWorld.getBlock(i, j, k) == Blocks.air)
            {
                this.currentWorld.setBlock(i, j, k, DeeperBlocks.sculkSensor, 0, 2);
            }
        }

        vineTendrilDensityNoiseField = vineTendrilNoise2.generateNoiseOctaves(vineTendrilDensityNoiseField, chunk_X, 0, chunk_Z, 1, 1, 1, 0.08, 0.08, 0.08);

        vineTendrilNoiseField = vineTendrilNoise.generateNoiseOctaves(vineTendrilNoiseField, chunk_X, 0, chunk_Z, 1, 1, 1, 0.15, 0.15, 0.15);

        double vineTendrilFactor = vineTendrilNoiseField[0]+1;

        double vineTendrilFactor2 = (vineTendrilDensityNoiseField[0]*2)+1;

        if(vineTendrilFactor2 < 0)
        {
            vineTendrilFactor2 = 0;
        }

        if(vineTendrilFactor2 > 2)
        {
            vineTendrilFactor2 = 2;
        }

        double vineFactor = vineTendrilFactor;

        double tendrilFactor = 1.0/vineFactor;

        for (i1 = 0; i1 < 2400*(vineFactor*vineTendrilFactor2); ++i1)
        {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.randomGenerator.nextInt(102)+1;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            if((this.currentWorld.getBlock(i, j+1, k) == DeeperBlocks.sculk || this.currentWorld.getBlock(i, j+1, k) == DeeperBlocks.sculkFlesh) && this.currentWorld.getBlock(i, j, k) == Blocks.air)
            {
                int curj = j;

                int floorHeight = 1;

                int maxHeight = this.randomGenerator.nextInt(42)+3;

                while(floorHeight < maxHeight && this.currentWorld.getBlock(i, curj-floorHeight, k) == Blocks.air) {
                    floorHeight++;
                }

                int vineHeight = this.randomGenerator.nextInt(floorHeight)+1;

                while(curj > 0 && curj > j-vineHeight && this.currentWorld.getBlock(i, curj, k) == Blocks.air) {
                    this.currentWorld.setBlock(i, curj, k, DeeperBlocks.sculkVines, 0, 2);
                    curj--;
                }

            }
        }

        for (i1 = 0; i1 < 6400*(tendrilFactor*vineTendrilFactor2); ++i1)
        {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.randomGenerator.nextInt(102)+1;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            if((this.currentWorld.getBlock(i, j-1, k) == DeeperBlocks.sculk || this.currentWorld.getBlock(i, j-1, k) == DeeperBlocks.sculkFlesh) && this.currentWorld.getBlock(i, j, k) == Blocks.air)
            {
                int curj = j;
                int ceilingHeight = 1;

                int maxHeight = this.randomGenerator.nextInt(20)+3;

                while(ceilingHeight < maxHeight && this.currentWorld.getBlock(i, curj+ceilingHeight, k) == Blocks.air) {
                    ceilingHeight++;
                }

                int kelpHeight = this.randomGenerator.nextInt(ceilingHeight)+1;

                boolean generated = false;


                while(curj > 0 && curj < j+kelpHeight && this.currentWorld.getBlock(i, curj, k) == Blocks.air) {
                    this.currentWorld.setBlock(i, curj, k, DeeperBlocks.sculkKelp, 1, 2);
                    generated = true;
                    curj++;
                }

                if(generated) {
                    this.currentWorld.setBlock(i, curj - 1, k, DeeperBlocks.sculkKelp, 0, 2);
                }
            }
        }

        for (i1 = 0; i1 < 80; ++i1)
        {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.randomGenerator.nextInt(102)+1;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            if(this.currentWorld.getBlock(i, j-1, k) == DeeperBlocks.sculk && this.currentWorld.getBlock(i, j, k) == Blocks.air)
            {
                this.currentWorld.setBlock(i, j, k, DeeperBlocks.sculkShrieker, 0, 2);
            }
        }

        for (i1 = 0; i1 < 96; ++i1)
        {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.randomGenerator.nextInt(102)+1;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            if(this.currentWorld.getBlock(i, j-1, k) == DeeperBlocks.sculk && this.currentWorld.getBlock(i, j, k) == Blocks.air)
            {
                this.currentWorld.setBlock(i, j, k, DeeperBlocks.sculkCatalyst, 0, 2);
            }
        }


        for (i1 = 0; i1 < 480; ++i1)
        {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.randomGenerator.nextInt(102)+1;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            if(this.currentWorld.getBlock(i, j-1, k).isNormalCube() && this.currentWorld.getBlock(i, j, k) == Blocks.air)
            {
                this.currentWorld.setBlock(i, j, k, DeeperBlocks.sculkVein, 0, 2);
            }
        }

        decorateAdditional(biome);
    }

    protected void decorateAdditional(BiomeGenBase biome)
    {
        //do nothing
    }
}
