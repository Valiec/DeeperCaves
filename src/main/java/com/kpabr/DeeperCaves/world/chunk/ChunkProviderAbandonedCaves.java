package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCaves.DeeperWorldgen;
import com.kpabr.DeeperCaves.structure.cavevillage.CaveVillage;
import com.kpabr.DeeperCore.dimstack.DeeperLayer;
import com.kpabr.DeeperCore.world.chunk.ChunkProviderDeeperBase;
import com.kpabr.DeeperCore.world.cave.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCore.world.cave.MapGenDeeperRavine;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.init.Blocks;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.*;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS;


public class ChunkProviderAbandonedCaves extends ChunkProviderDeeperCavesBase
{

    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault(true,  1.0F, 12.0D, 120, 0,   0, 36,  7, true,  false, DeeperBlocks.abandonedStone);
    private MapGenBase caveGenerator2 = new MapGenDeeperCavesDefault(false, 1.0F,  2.5D, 210, 0, 100, 47,  4, true,  false, DeeperBlocks.abandonedStone);
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(184, 13, 7.5, 5.5, DeeperBlocks.abandonedStone);


    //private MapGenBase caveGenerator = new MapGenDeeperCavesDefault(true,  1.0F, 12.0D, 150, 0,   0, 36,  7, true,  false, DeeperBlocks.abandonedStone);
    //private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 13, 7.5, 5.5, DeeperBlocks.abandonedStone);

    public ChunkProviderAbandonedCaves(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.setupGenFromLayer(DeeperCaves.worldgen.abandonedCaves);
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
            //this.strongholdGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
            //this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);

            if (this.rand.nextInt(6) == 0)
            {
                int i2 = par2*16 + rand.nextInt(16) + 8;
                int j2 = par3*16 + rand.nextInt(16) + 8;
                int k2 = this.rand.nextInt(60);
                (new CaveVillage()).generate(this.worldObj, this.rand, i2, k2, j2);
            }
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