package com.kpabr.DeeperCaves.block;

import java.util.Random;

import com.kpabr.DeeperCaves.DeeperBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCompressedRedstoneOre extends BlockCompressedOre {
	
	private boolean glow;
	
	public BlockCompressedRedstoneOre(boolean glow){
		super(Material.rock, Blocks.redstone_ore);
        if (glow)
        {
            this.setTickRandomly(true);
        }
        this.glow = glow;
	}
    public int tickRate(World p_149738_1_)
    {
        return 30;
    }
    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer player)
    {
        this.func_150185_e(world, i, j, k);
        super.onBlockClicked(world, i, j, k, player);
    }
    public void onEntityWalking(World world, int i, int j, int k, Entity player)
    {
        this.func_150185_e(world, i, j, k);
        super.onEntityWalking(world, i, j, k, player);
    }
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        this.func_150185_e(world, i, j, k);
        return super.onBlockActivated(world, i, j, k, player, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
    }
    private void func_150185_e(World p_150185_1_, int p_150185_2_, int p_150185_3_, int p_150185_4_)
    {
        this.func_150186_m(p_150185_1_, p_150185_2_, p_150185_3_, p_150185_4_);

        if (this == DeeperBlocks.credstoneOre)
        {
            p_150185_1_.setBlock(p_150185_2_, p_150185_3_, p_150185_4_, DeeperBlocks.credstoneOre_glowing);
        }
    }
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        if (this == DeeperBlocks.credstoneOre_glowing)
        {
            p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, DeeperBlocks.credstoneOre);
        }
    }
    public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return Items.redstone;
    }
	@Override
	public int quantityDroppedWithBonus(int fortuneLevel, Random rand)
    {
        if (fortuneLevel > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, rand, fortuneLevel))
        {
            int j = rand.nextInt(fortuneLevel + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }

            return this.quantityDropped(rand) * (j + 1);
        }
        else
        {
            return this.quantityDropped(rand);
        }
    }
    public int quantityDropped(Random random)
    {
        return (4 + random.nextInt(2));
    }
    public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_)
    {
        super.dropBlockAsItemWithChance(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
    }
    private Random rand = new Random();
    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
    {
        if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item.getItemFromBlock(this))
        {
            return 1 + rand.nextInt(5) * (2 + rand.nextInt(2));
        }
        return 0;
    }
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        if (this.glow)
        {
            this.func_150186_m(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_);
        }
    }
    private void func_150186_m(World p_150186_1_, int p_150186_2_, int p_150186_3_, int p_150186_4_)
    {
        Random random = p_150186_1_.rand;
        double d0 = 0.0625D;

        for (int l = 0; l < 6; ++l)
        {
            double d1 = (double)((float)p_150186_2_ + random.nextFloat());
            double d2 = (double)((float)p_150186_3_ + random.nextFloat());
            double d3 = (double)((float)p_150186_4_ + random.nextFloat());

            if (l == 0 && !p_150186_1_.getBlock(p_150186_2_, p_150186_3_ + 1, p_150186_4_).isOpaqueCube())
            {
                d2 = (double)(p_150186_3_ + 1) + d0;
            }

            if (l == 1 && !p_150186_1_.getBlock(p_150186_2_, p_150186_3_ - 1, p_150186_4_).isOpaqueCube())
            {
                d2 = (double)(p_150186_3_ + 0) - d0;
            }

            if (l == 2 && !p_150186_1_.getBlock(p_150186_2_, p_150186_3_, p_150186_4_ + 1).isOpaqueCube())
            {
                d3 = (double)(p_150186_4_ + 1) + d0;
            }

            if (l == 3 && !p_150186_1_.getBlock(p_150186_2_, p_150186_3_, p_150186_4_ - 1).isOpaqueCube())
            {
                d3 = (double)(p_150186_4_ + 0) - d0;
            }

            if (l == 4 && !p_150186_1_.getBlock(p_150186_2_ + 1, p_150186_3_, p_150186_4_).isOpaqueCube())
            {
                d1 = (double)(p_150186_2_ + 1) + d0;
            }

            if (l == 5 && !p_150186_1_.getBlock(p_150186_2_ - 1, p_150186_3_, p_150186_4_).isOpaqueCube())
            {
                d1 = (double)(p_150186_2_ + 0) - d0;
            }

            if (d1 < (double)p_150186_2_ || d1 > (double)(p_150186_2_ + 1) || d2 < 0.0D || d2 > (double)(p_150186_3_ + 1) || d3 < (double)p_150186_4_ || d3 > (double)(p_150186_4_ + 1))
            {
                p_150186_1_.spawnParticle("reddust", d1, d2, d3, 0.0D, 0.0D, 0.0D);
            }
        }
    }
    protected ItemStack createStackedBlock(int p_149644_1_)
    {
        return new ItemStack(DeeperBlocks.credstoneOre);
    }
    
}
