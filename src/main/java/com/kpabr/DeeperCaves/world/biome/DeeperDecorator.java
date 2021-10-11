package com.kpabr.DeeperCaves.world.biome;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.LAKE;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.COAL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIAMOND;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIRT;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GOLD;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GRAVEL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.IRON;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.LAPIS;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.REDSTONE;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class DeeperDecorator extends BiomeDecorator {

	@Override
	protected void genDecorations(BiomeGenBase p_150513_1_)
    {
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(currentWorld, randomGenerator, chunk_X, chunk_Z));
        this.generateOres();
        int i;
        int j;
        int k;
        
        int l;
        int i1;

        boolean doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, LAKE);
        if (doGen && this.generateLakes)
        {
            for (j = 0; j < 50; ++j)
            {
                k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                l = this.randomGenerator.nextInt(this.randomGenerator.nextInt(248) + 8);
                i1 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenLiquids(Blocks.flowing_water)).generate(this.currentWorld, this.randomGenerator, k, l, i1);
            }

            for (j = 0; j < 20; ++j)
            {
                k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                l = this.randomGenerator.nextInt(this.randomGenerator.nextInt(this.randomGenerator.nextInt(240) + 8) + 8);
                i1 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenLiquids(Blocks.flowing_lava)).generate(this.currentWorld, this.randomGenerator, k, l, i1);
            }
        }

        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
    }
	
	@Override
	protected void generateOres()
    {
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(currentWorld, randomGenerator, chunk_X, chunk_Z));
        if (TerrainGen.generateOre(currentWorld, randomGenerator, dirtGen, chunk_X, chunk_Z, DIRT))
        this.genStandardOre1(15, this.dirtGen, 0, 256);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, gravelGen, chunk_X, chunk_Z, GRAVEL))
        this.genStandardOre1(8, this.gravelGen, 0, 256);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, coalGen, chunk_X, chunk_Z, COAL))
        this.genStandardOre1(25, this.coalGen, 0, 256);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, ironGen, chunk_X, chunk_Z, IRON))
        this.genStandardOre1(50, this.ironGen, 0, 256);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, goldGen, chunk_X, chunk_Z, GOLD))
        this.genStandardOre1(10, this.goldGen, 0, 256);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, redstoneGen, chunk_X, chunk_Z, REDSTONE))
        this.genStandardOre1(80, this.redstoneGen, 0, 256);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, diamondGen, chunk_X, chunk_Z, DIAMOND))
        this.genStandardOre1(10, this.diamondGen, 0, 256);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, lapisGen, chunk_X, chunk_Z, LAPIS))
        this.genStandardOre1(12, this.lapisGen, 0, 256);
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
    }
}
