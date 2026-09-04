package com.kpabr.DeeperCaves.world.biome;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.LAKE;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.structure.cavevillage.CaveVillage;
import com.kpabr.DeeperCore.world.WorldProviderDeeperCaves;
import com.kpabr.DeeperCore.world.biome.DeeperBaseDecorator;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class ForgottenDecorator extends DeeperBaseDecorator {


    @Override
    protected void decorate(BiomeGenBase biome)
    {
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
                j = this.randomGenerator.nextInt(234)+1;
                k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                if(this.currentWorld.getBlock(i, j-1, k) == DeeperBlocks.sculk && this.currentWorld.getBlock(i, j, k) == Blocks.air)
                {
                    this.currentWorld.setBlock(i, j, k, DeeperBlocks.sculkSensor, 0, 2);
                }
            }


        for (i1 = 0; i1 < 320; ++i1)
        {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.randomGenerator.nextInt(234)+1;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            if(this.currentWorld.getBlock(i, j+1, k) == DeeperBlocks.sculk && this.currentWorld.getBlock(i, j, k) == Blocks.air)
            {
                int curj = j;
                int veinHeight = this.randomGenerator.nextInt(77)+3;
                while(curj > 0 && curj > j-veinHeight && this.currentWorld.getBlock(i, curj, k) == Blocks.air) {
                    this.currentWorld.setBlock(i, curj, k, DeeperBlocks.sculkVines, 0, 2);
                    curj--;
                }

            }
        }

        for (i1 = 0; i1 < 80; ++i1)
        {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.randomGenerator.nextInt(234)+1;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            if(this.currentWorld.getBlock(i, j-1, k) == DeeperBlocks.sculk && this.currentWorld.getBlock(i, j, k) == Blocks.air)
            {
                this.currentWorld.setBlock(i, j, k, DeeperBlocks.sculkShrieker, 0, 2);
            }
        }

        for (i1 = 0; i1 < 96; ++i1)
        {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.randomGenerator.nextInt(234)+1;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            if(this.currentWorld.getBlock(i, j-1, k) == DeeperBlocks.sculk && this.currentWorld.getBlock(i, j, k) == Blocks.air)
            {
                this.currentWorld.setBlock(i, j, k, DeeperBlocks.sculkCatalyst, 0, 2);
            }
        }


        for (i1 = 0; i1 < 480; ++i1)
        {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.randomGenerator.nextInt(234)+1;
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
