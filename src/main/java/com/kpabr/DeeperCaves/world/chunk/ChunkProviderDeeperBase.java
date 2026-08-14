package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.init.Blocks;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.*;

public abstract class ChunkProviderDeeperBase extends ChunkProviderGenerate implements IChunkProvider
{
    /** RNG. */
    Random rand;
    NoiseGeneratorPerlin perlinNoise;
    public NoiseGeneratorOctaves mobSpawnerNoise;
    /** Reference to the World object. */
    World worldObj;
    /** are map structures going to be generated (e.g. strongholds) */
    boolean mapFeaturesEnabled = false;
    public boolean doMineshafts;
    WorldType field_147435_p = null;
    double[] stoneNoise = new double[256];
    MapGenBase caveGenerator;
    /** Holds Stronghold Generator */
    MapGenStronghold strongholdGenerator = new MapGenStronghold();
    /** Holds Mineshaft Generator */
    MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
    MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
    /** Holds ravine generator */
    MapGenBase ravineGenerator;
    /** The biomes that are used to generate the chunk */
    BiomeGenBase[] biomesForGeneration;
    public Block baseBlock = Blocks.stone;
    public Block voidBlock = Blocks.air;
    public int lowerBarrierY = -1;
    public int upperBarrierY = 257;
    public int voidTerrainCutoff = 0;

    {
        strongholdGenerator = (MapGenStronghold) TerrainGen.getModdedMapGen(strongholdGenerator, STRONGHOLD);
        mineshaftGenerator = (MapGenMineshaft) TerrainGen.getModdedMapGen(mineshaftGenerator, MINESHAFT);
        scatteredFeatureGenerator = (MapGenScatteredFeature) TerrainGen.getModdedMapGen(scatteredFeatureGenerator, SCATTERED_FEATURE);
    }

    public ChunkProviderDeeperBase(World par1World, long par2, boolean par4)
    {
    	super(par1World, par2, par4);
        this.doMineshafts = true;
        this.worldObj = par1World;
        this.mapFeaturesEnabled = par4;
        this.field_147435_p = par1World.getWorldInfo().getTerrainType();
        this.rand = new Random(par2);
        this.perlinNoise = new NoiseGeneratorPerlin(this.rand, 4);
        this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);

        NoiseGenerator[] noiseGens = {perlinNoise, mobSpawnerNoise};
        noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.rand, noiseGens);
        this.perlinNoise = (NoiseGeneratorPerlin)noiseGens[0];
        this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[1];
    }

    public void initCaveRavineGen(MapGenBase caves, MapGenBase ravines)
    {
        this.caveGenerator = caves;
        this.ravineGenerator = ravines;
    }

    @Override
    public void func_147424_a(int p_147424_1_, int p_147424_2_, Block[] p_147424_3_)
    {
        initWorldBlocks(p_147424_1_, p_147424_2_, p_147424_3_);
    }


    public void initWorldBlocks(int p_147424_1_, int p_147424_2_, Block[] p_147424_3_)
    {
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, p_147424_1_ * 4 - 2, p_147424_2_ * 4 - 2, 10, 10);

        for (int k = 0; k < 4; ++k)
        {
            for (int j1 = 0; j1 < 4; ++j1)
            {
                for (int k2 = 0; k2 < 32; ++k2)
                {
                    for (int l2 = 0; l2 < 8; ++l2)
                    {
                        for (int i3 = 0; i3 < 4; ++i3)
                        {
                            int j3 = i3 + k * 4 << 12 | j1 * 4 << 8 | k2 * 8 + l2;
                            short short1 = 256;
                            j3 -= short1;

                            for (int k3 = 0; k3 < 4; ++k3)
                            {
                                if (k2 * 8 + l2 < voidTerrainCutoff)
                                {
                                    p_147424_3_[j3 += short1] = this.voidBlock;
                                }
                                else
                                {
                                    p_147424_3_[j3 += short1] = this.baseBlock;
                                }
                            }

                        }

                    }
                }
            }
        }
    }

    @Override
    public void replaceBlocksForBiome(int p_147422_1_, int p_147422_2_, Block[] p_147422_3_, byte[] p_147422_4_, BiomeGenBase[] p_147422_5_)
    {
        ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, p_147422_1_, p_147422_2_, p_147422_3_, p_147422_5_);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Result.DENY) return;

        double d0 = 0.03125D;
        this.stoneNoise = this.perlinNoise.func_151599_a(this.stoneNoise, (double)(p_147422_1_ * 16), (double)(p_147422_2_ * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

        for (int k = 0; k < 16; ++k)
        {
            for (int l = 0; l < 16; ++l)
            {
                BiomeGenBase biomegenbase = p_147422_5_[l + k * 16];
                biomegenbase.genTerrainBlocks(this.worldObj, this.rand, p_147422_3_, p_147422_4_, p_147422_1_ * 16 + k, p_147422_2_ * 16 + l, this.stoneNoise[l + k * 16]);
                int i1 = p_147422_1_ * 16 + k & 15;
                int j1 = p_147422_2_ * 16 + l & 15;
                int k1 = p_147422_3_.length / 256;
                for (int l1 = 255; l1 >= 0; --l1)
                {
                    int i2 = (j1 * 16 + i1) * k1 + l1;

                    if (l1 <= 5 && p_147422_3_[i2] == Blocks.bedrock && this.voidTerrainCutoff <= l1)
                    {
                    	p_147422_3_[i2] = this.baseBlock;
                    }
                    if (l1 <= 5 && p_147422_3_[i2] == Blocks.bedrock && this.voidTerrainCutoff > l1)
                    {
                        p_147422_3_[i2] = this.voidBlock;
                    }
                    if (l1 >= 250 && l1 <= 255 && p_147422_3_[i2] == Blocks.bedrock)
                    {
                    	p_147422_3_[i2] = this.baseBlock;
                    }
                    if (l1 <= lowerBarrierY)
                    {
                        p_147422_3_[i2] = DeeperBlocks.barrierLayer;
                    }
                    if (l1 >= upperBarrierY)
                    {
                    	p_147422_3_[i2] = DeeperBlocks.barrierLayer;
                    }
                }
            }
        }
    }

    public void finalGenPass(int p_147422_1_, int p_147422_2_, Block[] p_147422_3_, byte[] p_147422_4_, BiomeGenBase[] p_147422_5_)
    {}

    /**
     * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
     * specified chunk from the map seed and chunk seed
     */
    @Override
    public Chunk provideChunk(int par1, int par2)
    {
        this.rand.setSeed((long)par1 * 341873128712L + (long)par2 * 132897987541L);
        Block[] ablock = new Block[65536];
        byte[] abyte = new byte[65536];
        this.func_147424_a(par1, par2, ablock);
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
        this.replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
        if(this.caveGenerator != null) {
            this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
        }
        if(this.ravineGenerator != null) {
            this.ravineGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
        }

        if (this.mapFeaturesEnabled)
        {
            if(this.doMineshafts) {
                this.mineshaftGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
            }
            //this.strongholdGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
            //this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
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
    
    /**
     * Populates chunk with ores etc etc
     */
    @Override
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
            if(this.doMineshafts) {
                this.mineshaftGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
            }
            this.strongholdGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
            this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
        }

        int k1;
        int l1;
        int i2;

        if (biomegenbase != BiomeGenBase.desert && biomegenbase != BiomeGenBase.desertHills && !flag && this.rand.nextInt(4) == 0
            && TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, LAKE))
        {
            k1 = k + this.rand.nextInt(16) + 8;
            l1 = this.rand.nextInt(256);
            i2 = l + this.rand.nextInt(16) + 8;
            (new WorldGenLakes(Blocks.water)).generate(this.worldObj, this.rand, k1, l1, i2);
        }

        if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, LAVA) && !flag && this.rand.nextInt(8) == 0)
        {
            k1 = k + this.rand.nextInt(16) + 8;
            l1 = this.rand.nextInt(this.rand.nextInt(248) + 8);
            i2 = l + this.rand.nextInt(16) + 8;

            if (l1 < 63 || this.rand.nextInt(10) == 0)
            {
                (new WorldGenLakes(Blocks.lava)).generate(this.worldObj, this.rand, k1, l1, i2);
            }
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

        for (int var3 = 0; var3 < 20; ++var3)
        {
            int var4 = k + this.rand.nextInt(16) + 8;
            int var5 = this.rand.nextInt(255);
            int var6 = l + this.rand.nextInt(16) + 8;
            (new WorldGenLiquids(Blocks.flowing_lava)).generate(this.worldObj, this.rand, var4, var5, var6);
        }

        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(par1IChunkProvider, worldObj, rand, par2, par3, flag));

        BlockFalling.fallInstantly = false;
    }

}