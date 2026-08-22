package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCaves.DeeperConfig;
import com.kpabr.DeeperCaves.DeeperFluids;
import com.kpabr.DeeperCore.world.cave.MapGenDeeperRavine;

import com.kpabr.DeeperCore.world.feature.WorldGenDeeperLakes;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.init.Blocks;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.*;

import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.*;

public class ChunkProviderBedrockPlains extends ChunkProviderDeeperCavesBase
{
    /** RNG. */
    private MapGenBase caveGenerator = null;
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(DeeperConfig.bedrockPlainsFloorHeight-16, DeeperConfig.bedrockPlainsFloorHeight+16, 60, 0.8, 5.0, Blocks.bedrock, -1, DeeperConfig.bedrockPlainsFloorHeight+8, false);

    private MapGenBase ravineGenerator2 = new MapGenDeeperRavine(DeeperConfig.bedrockPlainsCeilingHeight-8, DeeperConfig.bedrockPlainsCeilingHeight+16, 60, 0.8, 2.0, Blocks.bedrock, DeeperConfig.bedrockPlainsCeilingHeight-8, DeeperConfig.bedrockPlainsCeilingHeight+16, false, 413, false);

    NoiseGeneratorOctaves floorHeightNoise;
    NoiseGeneratorOctaves ceilingHeightNoise;
    NoiseGeneratorPerlin pillarHeightNoise;
    double[] floorNoise;
    double[] pillarNoise;
    double[] ceilingNoise;

    public ChunkProviderBedrockPlains(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.setupGenFromLayer(DeeperCaves.worldgen.bedrockPlains);
        this.voidBlock = Blocks.air;

        this.floorHeightNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.ceilingHeightNoise = new NoiseGeneratorOctaves(this.rand, 4);
        this.pillarHeightNoise = new NoiseGeneratorPerlin(this.rand, 1);
    }

    public void replaceBlocksForBiome(int p_147422_1_, int p_147422_2_, Block[] p_147422_3_, byte[] p_147422_4_, BiomeGenBase[] p_147422_5_)
    {
        ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, p_147422_1_, p_147422_2_, p_147422_3_, p_147422_5_);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Event.Result.DENY) return;

        double d0 = 0.03125D;
        this.stoneNoise = this.perlinNoise.func_151599_a(this.stoneNoise, (double)(p_147422_1_ * 16), (double)(p_147422_2_ * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

        int bedrockPlainsGapHeight = DeeperConfig.bedrockPlainsCeilingHeight-DeeperConfig.bedrockPlainsFloorHeight;

        floorNoise = this.floorHeightNoise.generateNoiseOctaves(floorNoise, p_147422_1_*16, 0, p_147422_2_*16, 16, 1, 16, 2, 0, 2);

        pillarNoise = this.pillarHeightNoise.func_151599_a(pillarNoise, p_147422_1_*16, p_147422_2_*16, 16, 16, 0.02, 0.02, 1);

        ceilingNoise = this.ceilingHeightNoise.generateNoiseOctaves(ceilingNoise, p_147422_1_*16, 0, p_147422_2_*16, 16, 1, 16, 0.25, 0, 0.25);


        for (int k = 0; k < 16; ++k)
        {
            for (int l = 0; l < 16; ++l)
            {
                BiomeGenBase biomegenbase = p_147422_5_[l + k * 16];
                //biomegenbase.genTerrainBlocks(this.worldObj, this.rand, p_147422_3_, p_147422_4_, p_147422_1_ * 16 + k, p_147422_2_ * 16 + l, this.stoneNoise[l + k * 16]);
                boolean flag = true;
                Block block = Blocks.grass;
                //byte b0 = (byte)(this.field_150604_aj & 255);
                Block block1 = Blocks.dirt;
                //int l = (int)(this.stoneNoise[l + k * 16] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
                int i1 = p_147422_1_ * 16 + k & 15;
                int j1 = p_147422_2_ * 16 + l & 15;
                int k1 = p_147422_3_.length / 256;

                int trueFloorHeight = DeeperConfig.bedrockPlainsFloorHeight + (int)(0.1*floorNoise[j1 * 16 + i1]);

                int trueCeilingHeight = (trueFloorHeight + bedrockPlainsGapHeight) - (int)(ceilingNoise[j1 * 16 + i1]);

                double pillarVal = ((pillarNoise[i1 * 16 + j1])-0.4);

                if(pillarVal > 0) {
                    trueFloorHeight += (int)(130*pillarVal);
                    trueCeilingHeight -= (int)(130*pillarVal);
                }

                for (int l1 = 255; l1 >= 0; --l1)
                {
                    int i2 = (j1 * 16 + i1) * k1 + l1;

                    /*int i3;
                    if(l1<255)
                    {
                        i3 = (j1 * 16 + i1) * k1 + (l1+1);
                    }
                    else
                    {
                        i3 = i2;
                    }*/

                    if (l1 >= DeeperConfig.bedrockPlainsCeilingHeight + 8 && l1 >= trueCeilingHeight)
                    {
                        p_147422_3_[i2] = DeeperBlocks.barrierLayer;
                    }
                    else if (l1 >= trueCeilingHeight - this.rand.nextInt(2))
                    {
                        p_147422_3_[i2] = Blocks.bedrock;
                    }
                    else if (l1 <= trueFloorHeight-30)
                    {
                        p_147422_3_[i2] = Blocks.air;
                    }
                    else if (l1 <= trueFloorHeight)
                    {
                        p_147422_3_[i2] = Blocks.bedrock;
                    }
                    else if (l1 >= trueFloorHeight && l1 <= DeeperConfig.bedrockPlainsFloorHeight-2)
                    {
                        p_147422_3_[i2] = DeeperFluids.moltenIronBlock;
                    }
                    else
                    {
                        p_147422_3_[i2] = Blocks.air;
                    }

                }
            }

        }

        this.ravineGenerator2.func_151539_a(this, this.worldObj, p_147422_1_, p_147422_2_, p_147422_3_);
    }

    /**
     * Populates chunk with ores etc etc
     */
    public void populate(IChunkProvider par1IChunkProvider, int par2, int par3)
    {
        BlockFalling.fallInstantly = true;
        int k = par2 * 16;
        int l = par3 * 16;
        BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
        this.rand.setSeed(this.worldObj.getSeed());
        long i1 = this.rand.nextLong() / 2L * 2L + 1L;
        long j1 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long)par2 * i1 + (long)par3 * j1 ^ this.worldObj.getSeed());
        boolean flag = false;

        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(par1IChunkProvider, worldObj, rand, par2, par3, flag));

        if (this.mapFeaturesEnabled)
        {
            //this.mineshaftGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
            //this.strongholdGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
            this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
        }

        int k1;
        int l1;
        int i2;

        if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, LAVA) && !flag && this.rand.nextInt(8) == 0)
        {
            k1 = k + this.rand.nextInt(16) + 8;
            l1 = this.rand.nextInt(256);
            i2 = l + this.rand.nextInt(16) + 8;

            (new WorldGenDeeperLakes(DeeperFluids.moltenIronBlock, Blocks.bedrock)).generate(this.worldObj, this.rand, k1, l1, i2);
        }

        boolean doGen = TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, DUNGEON);
        for (k1 = 0; doGen && k1 < 8; ++k1)
        {
            l1 = k + this.rand.nextInt(16) + 8;
            i2 = this.rand.nextInt(256);
            int j2 = l + this.rand.nextInt(16) + 8;
            (new WorldGenDungeons()).generate(this.worldObj, this.rand, l1, i2, j2);
        }

        biomegenbase.decorate(this.worldObj, this.rand, k, l);
        if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, ANIMALS))
        {
            SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
        }
        k += 8;
        l += 8;

        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(par1IChunkProvider, worldObj, rand, par2, par3, flag));

        BlockFalling.fallInstantly = false;
    }


}