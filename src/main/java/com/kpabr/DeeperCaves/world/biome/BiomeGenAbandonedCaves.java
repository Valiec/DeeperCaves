package com.kpabr.DeeperCaves.world.biome;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import com.kpabr.DeeperCaves.DeeperCaves;

import net.minecraft.block.BlockFlower;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenAbandonedCaves extends BiomeGenBase
{
    public WorldGenerator theWorldGenerator;

    public BiomeGenAbandonedCaves(int p_i45377_1_, int p_i45377_2_)
    {
        super(p_i45377_1_);
    	this.biomeName = "Abandoned Caves";
        this.temperature = 0.80F;
        this.setHeight(BiomeGenBase.height_LowHills);
        this.topBlock = Blocks.bedrock;
        this.theBiomeDecorator.treesPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 0;
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.theBiomeDecorator.generateLakes = true;
        this.fillerBlock = DeeperCaves.blocks.abandonedStone;
        this.rainfall = 0.68F;

    }
}