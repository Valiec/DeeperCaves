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
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.NoiseGeneratorOctaves;

import java.util.Random;


public class ChunkProviderForgotten extends ChunkProviderDeeperCavesBase
{
    NoiseGeneratorOctaves sculkNoise;
    long seed;

    double[] noiseField = new double[59392];

    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault(true,  1.0F, 12.0D, 150, 0,   0, 36,  7, true,  false, DeeperBlocks.forgottenStone);
    private MapGenBase caveGenerator2 = new MapGenDeeperCavesDefault(false, 1.0F,  2.5D, 255, 0, 150, 47,  4, true,  false, DeeperBlocks.forgottenStone);
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 13, 7.5, 5.5, DeeperBlocks.forgottenStone);

    public ChunkProviderForgotten(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.setupGenFromLayer(DeeperCaves.worldgen.forgotten);
    }


    /**
     * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
     * specified chunk from the map seed and chunk seed
     */
    public Chunk provideChunk(int par1, int par2)
    {
        this.rand.setSeed((long)par1 * 341873128712L + (long)par2 * 132897987541L);
        Block[] ablock = new Block[65536];
        byte[] abyte = new byte[65536];
        this.func_147424_a(par1, par2, ablock);
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
        this.replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
        this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
        this.caveGenerator2.func_151539_a(this, this.worldObj, par1, par2, ablock);

        if (this.mapFeaturesEnabled)
        {
            this.mineshaftGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
            this.strongholdGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
            this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
        }

        this.finalGenPass(par1, par2, ablock, abyte, this.biomesForGeneration);

        Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
        byte[] abyte1 = chunk.getBiomeArray();

        for (int k = 0; k < abyte1.length; ++k)
        {
            abyte1[k] = (byte)this.biomesForGeneration[k].biomeID;
        }

        chunk.generateSkylightMap();
        return chunk;
    }


    public void finalGenPass(int p_147422_1_, int p_147422_2_, Block[] p_147422_3_, byte[] p_147422_4_, BiomeGenBase[] p_147422_5_)
    {
        if(sculkNoise == null || this.seed != this.worldObj.getSeed()) { //don't have a world earlier, or this isn't the same world
            sculkNoise = new NoiseGeneratorOctaves(new Random(this.worldObj.getSeed() + ((WorldProviderDeeperCaves)this.worldObj.provider).layer.seedOffset), 2);
            this.seed = this.worldObj.getSeed();
        }

        noiseField = sculkNoise.generateNoiseOctaves(noiseField, p_147422_1_*16, 0, p_147422_2_*16, 16, 232, 16, 0.15, 0.15, 0.15);

        for(int sculkX = 0; sculkX < 16; sculkX++) {
            for(int sculkZ = 0; sculkZ < 16; sculkZ++) {
                for(int sculkY = 0; sculkY < 232; sculkY++) {
                    int ind = (sculkX * 16 * 232) + (sculkZ * 232) + sculkY;
                    int blockInd = (sculkX * 16 * 256) + (sculkZ * 256) + sculkY;
                    if (noiseField[ind] < -0.15 && p_147422_3_[blockInd] == DeeperBlocks.forgottenStone) {
                        p_147422_3_[blockInd] = DeeperBlocks.sculk;
                    }
                    else if (sculkY < 231 && noiseField[ind] < -0.08 && p_147422_3_[blockInd] != null && p_147422_3_[blockInd].isNormalCube()  && (p_147422_3_[blockInd+1] == Blocks.air || p_147422_3_[blockInd+1] == null)) {
                        p_147422_3_[blockInd+1] = DeeperBlocks.sculkVein;
                    }
                }
            }
        }
    }



}