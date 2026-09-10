package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperCavesFinalLabyrinth;

import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperRavineFinalLabyrinth;
import com.kpabr.DeeperCore.world.WorldProviderDeeperCaves;
import com.kpabr.DeeperCore.world.chunk.ChunkProviderDeeperBase;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.NoiseGeneratorOctaves;

import java.util.Random;


public class ChunkProviderFinalLabyrinth extends ChunkProviderDeeperCavesBase
{

    NoiseGeneratorOctaves sculkNoise;

    double[] noiseField = new double[62720];

    private MapGenBase caveGenerator = new MapGenDeeperCavesFinalLabyrinth();
    private MapGenBase ravineGenerator = new MapGenDeeperRavineFinalLabyrinth(234, 15, 3.5, 1.8, DeeperBlocks.fakeBedrock);

    public ChunkProviderFinalLabyrinth(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        this.doMineshafts = false;
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.setupGenFromLayer(DeeperCaves.worldgen.finalLabyrinth);
        sculkNoise = new NoiseGeneratorOctaves(new Random(this.worldObj.getSeed() + ((WorldProviderDeeperCaves)this.worldObj.provider).layer.seedOffset), 2);
    }

    /*public boolean solidNeighbors(int i, int j, int k, Block[] blocks) {
        if ((j > 0 && data[index - 1] != null && data[index - 1] != DeeperBlocks.sculkVein) ||
                (j < 256 && data[index + 1] != null && data[index + 1] != DeeperBlocks.sculkVein)) {
            sculkVein = true;
        } else if ((index > 256 && data[index - 256] != null && data[index - 256] != DeeperBlocks.sculkVein) ||
                (index < 65280 && data[index + 256] != null && data[index + 256] != DeeperBlocks.sculkVein)) {
            sculkVein = true;
        } else if ((index > 4096 && data[index - 4096] != null && data[index - 4096] != DeeperBlocks.sculkVein)
                || (index < 61440 && data[index + 4096] != null && data[index + 4096] != DeeperBlocks.sculkVein)) {
            sculkVein = true;
        }
    }*/


    public void finalGenPass(int p_147422_1_, int p_147422_2_, Block[] p_147422_3_, byte[] p_147422_4_, BiomeGenBase[] p_147422_5_)
    {
       /* noiseField = sculkNoise.generateNoiseOctaves(noiseField, p_147422_1_*16, 0, p_147422_2_*16, 16, 232, 16, 0.15, 0.15, 0.15);



        for(int sculkX = 0; sculkX < 16; sculkX++) {
            for(int sculkZ = 0; sculkZ < 16; sculkZ++) {

                BiomeGenBase biome = p_147422_5_[sculkZ + sculkX * 16];

                if(biome.biomeID == DeeperCaves.worldgen.finalLabyrinth.biomes.get("Final Labyrinth Sculk").biomeID) {

                    for (int sculkY = 0; sculkY < 245; sculkY++) {
                        int ind = (sculkX * 16 * 245) + (sculkZ * 245) + sculkY;
                        int blockInd = (sculkX * 16 * 256) + (sculkZ * 256) + sculkY;
                        if (sculkY < 244 && noiseField[ind] < -0.08 && p_147422_3_[blockInd] != null && p_147422_3_[blockInd].isNormalCube() && (p_147422_3_[blockInd + 1] == Blocks.air || p_147422_3_[blockInd + 1] == null)) {
                            p_147422_3_[blockInd + 1] = DeeperBlocks.sculkVein;
                        }
                    }
                }
            }
        }*/
    }


}