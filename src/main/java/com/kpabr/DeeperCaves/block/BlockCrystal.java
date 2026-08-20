package com.kpabr.DeeperCaves.block;

import java.util.List;
import java.util.Random;

import com.kpabr.DeeperCaves.DeeperCaves;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import net.minecraft.world.IBlockAccess;

public class BlockCrystal extends Block 
{
	private IIcon[] texture;
	
        public BlockCrystal (Material material) 
        {
                super(material); 
                this.texture = new IIcon[16];
        }
        @Override
        public boolean isOpaqueCube()
        {
        	return false;
        }
        @SideOnly(Side.CLIENT)
        public int getRenderBlockPass()
        {
            return 1;
        }

        @Override
        public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
        {
            Block block = p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_);
            // don't render if facing other crystal or opaque blocks
            return !(block instanceof BlockCrystal) && super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
        }

        @Override
        public int damageDropped(int p_149692_1_)
        {
            return p_149692_1_;
        }
    	@Override
    	public Item getItemDropped(int par1, Random par2Random, int par3)
        {
            return DeeperCaves.items.crystalShard;
        }
        @Override
        public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_)
        {
            return 2+p_149679_2_.nextInt(3);
        }
        @Override
        @SideOnly(Side.CLIENT)
        public void registerBlockIcons(IIconRegister iconRegister) {
            for (int i  = 0; i<16; i++)
            {
            this.texture[i] = iconRegister.registerIcon("DeeperCaves:crystal_"+Integer.toString(i));
            }
        }
        @Override
        @SideOnly(Side.CLIENT)
        public IIcon getIcon(int i, int j)
        {
        	return this.texture[j];
        }
        public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
        {
            for (int i = 0; i<16; i++)
            {
                p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
            }
        }
    	@Override
    	public boolean canSilkHarvest()
        {
            return true;
        }
        
}