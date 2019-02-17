package com.kpabr.DeeperCaves.world.biome;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDeeperLiquids extends WorldGenLiquids
{
    private Block field_150521_a;
    private Block replaceBlock;
    private static final String __OBFID = "CL_00000434";

    public WorldGenDeeperLiquids(Block p_i45465_1_)
    {
    	super(p_i45465_1_);
        this.field_150521_a = p_i45465_1_;
    }
    public WorldGenDeeperLiquids setReplaceBlock(Block replace)
    {
    	replaceBlock = replace;
    	return this;
    }

    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        if (p_76484_1_.getBlock(p_76484_3_, p_76484_4_ + 1, p_76484_5_) != replaceBlock)
        {
            return false;
        }
        else if (p_76484_1_.getBlock(p_76484_3_, p_76484_4_ - 1, p_76484_5_) != replaceBlock)
        {
            return false;
        }
        else if (p_76484_1_.getBlock(p_76484_3_, p_76484_4_, p_76484_5_).getMaterial() != Material.air && p_76484_1_.getBlock(p_76484_3_, p_76484_4_, p_76484_5_) != replaceBlock)
        {
            return false;
        }
        else
        {
            int l = 0;

            if (p_76484_1_.getBlock(p_76484_3_ - 1, p_76484_4_, p_76484_5_) == replaceBlock)
            {
                ++l;
            }

            if (p_76484_1_.getBlock(p_76484_3_ + 1, p_76484_4_, p_76484_5_) == replaceBlock)
            {
                ++l;
            }

            if (p_76484_1_.getBlock(p_76484_3_, p_76484_4_, p_76484_5_ - 1) == replaceBlock)
            {
                ++l;
            }

            if (p_76484_1_.getBlock(p_76484_3_, p_76484_4_, p_76484_5_ + 1) == replaceBlock)
            {
                ++l;
            }

            int i1 = 0;

            if (p_76484_1_.isAirBlock(p_76484_3_ - 1, p_76484_4_, p_76484_5_))
            {
                ++i1;
            }

            if (p_76484_1_.isAirBlock(p_76484_3_ + 1, p_76484_4_, p_76484_5_))
            {
                ++i1;
            }

            if (p_76484_1_.isAirBlock(p_76484_3_, p_76484_4_, p_76484_5_ - 1))
            {
                ++i1;
            }

            if (p_76484_1_.isAirBlock(p_76484_3_, p_76484_4_, p_76484_5_ + 1))
            {
                ++i1;
            }

            if (l == 3 && i1 == 1)
            {
                p_76484_1_.setBlock(p_76484_3_, p_76484_4_, p_76484_5_, this.field_150521_a, 0, 2);
                p_76484_1_.scheduledUpdatesAreImmediate = true;
                this.field_150521_a.updateTick(p_76484_1_, p_76484_3_, p_76484_4_, p_76484_5_, p_76484_2_);
                p_76484_1_.scheduledUpdatesAreImmediate = false;
            }

            return true;
        }
    }
}