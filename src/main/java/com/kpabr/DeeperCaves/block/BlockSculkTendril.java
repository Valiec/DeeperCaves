package com.kpabr.DeeperCaves.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSculkTendril extends Block {


	public IIcon icon;
	public IIcon iconTop;

	public BlockSculkTendril(Material par2Material) {
		super(par2Material);
		// TODO Auto-generated constructor stub
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	{
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.icon = iconRegister.registerIcon("DeeperCaves:sculk_kelp_plant");
		this.iconTop = iconRegister.registerIcon("DeeperCaves:sculk_kelp");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j)
	{
		return (j & 1) == 0 ? this.iconTop : this.icon;
	}

	@Override
	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
		if(p_149695_3_ < 255 && p_149695_1_.getBlock(p_149695_2_, p_149695_3_+1, p_149695_4_) == this) {
			p_149695_1_.setBlockMetadataWithNotify(p_149695_2_, p_149695_3_, p_149695_4_, 1, 2);
		}
		else if(p_149695_3_ < 255 && p_149695_1_.getBlockMetadata(p_149695_2_, p_149695_3_, p_149695_4_) != 0
				&& p_149695_1_.getBlock(p_149695_2_, p_149695_3_+1, p_149695_4_) != this) {
			p_149695_1_.setBlockMetadataWithNotify(p_149695_2_, p_149695_3_, p_149695_4_, 0, 2);
		}
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return null;
	}

	@Override
	public boolean canSilkHarvest()
	{
		return true;
	}

	@Override
	public int getRenderType() {
		return 1;
	}

}
