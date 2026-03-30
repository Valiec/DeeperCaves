package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCaves.DeeperFluids;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperRavine;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperRavineCompressed;

import com.kpabr.DeeperCaves.world.gen.feature.WorldGenDeeperLakes;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.init.Blocks;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.*;

import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.*;

public class ChunkProviderBedrockPlains extends ChunkProviderDeeperBase
{
    /** RNG. */
    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault();
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 3, 1.5, 1.0, DeeperBlocks.fragmentedBedrock);

    {
        caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderBedrockPlains(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 102;
        this.voidBlock = Blocks.air;
    }

    public void replaceBlocksForBiome(int p_147422_1_, int p_147422_2_, Block[] p_147422_3_, byte[] p_147422_4_, BiomeGenBase[] p_147422_5_)
    {
        ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, p_147422_1_, p_147422_2_, p_147422_3_, p_147422_5_);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Event.Result.DENY) return;

        double d0 = 0.03125D;
        this.stoneNoise = this.field_147430_m.func_151599_a(this.stoneNoise, (double)(p_147422_1_ * 16), (double)(p_147422_2_ * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

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

                    if (l1 >= DeeperCaves.worldgen.bedrockPlainsCeilingHeight - this.rand.nextInt(5))
                    {
                        p_147422_3_[i2] = Blocks.bedrock;
                    }
                    else if (l1 >= DeeperCaves.worldgen.bedrockPlainsCeilingHeight)
                    {
                        p_147422_3_[i2] = DeeperBlocks.barrierLayer;
                    }
                    else if (l1 == DeeperCaves.worldgen.bedrockPlainsFloorHeight-1)
                    {
                        p_147422_3_[i2] = DeeperBlocks.nearNetherPortal;
                    }
                    else if (l1 <= DeeperCaves.worldgen.bedrockPlainsFloorHeight)
                    {
                        p_147422_3_[i2] = Blocks.bedrock;
                    }
                    else
                    {
                        p_147422_3_[i2] = Blocks.air;
                    }

                }
            }

        }
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
            this.mineshaftGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
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
            (new WorldGenDeeperLakes(DeeperFluids.moltenIronBlock, Blocks.bedrock)).generate(this.worldObj, this.rand, k1, l1, i2);
        }

        if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, LAVA) && !flag && this.rand.nextInt(8) == 0)
        {
            k1 = k + this.rand.nextInt(16) + 8;
            l1 = this.rand.nextInt(this.rand.nextInt(248) + 8);
            i2 = l + this.rand.nextInt(16) + 8;

            if (l1 < 63 || this.rand.nextInt(10) == 0)
            {
                (new WorldGenDeeperLakes(DeeperCaves.fluids.moltenIronBlock, Blocks.bedrock)).generate(this.worldObj, this.rand, k1, l1, i2);
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

        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(par1IChunkProvider, worldObj, rand, par2, par3, flag));

        BlockFalling.fallInstantly = false;
    }


}