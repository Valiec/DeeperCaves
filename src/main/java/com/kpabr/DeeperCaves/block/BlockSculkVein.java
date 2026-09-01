package com.kpabr.DeeperCaves.block;

import com.kpabr.DeeperCaves.client.RenderSculkVein;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSculkVein extends Block {

	public IIcon icon;

	public BlockSculkVein(Material par2Material) {
		super(Material.plants);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
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

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{

		float minX = 0.0625F;
		float minY = 0.0625F;
		float minZ = 0.0625F;
		float maxX = 0.0625F;
		float maxY = 0.0625F;
		float maxZ = 0.0625F;

		boolean emptyNegX = true;
		boolean emptyNegY = true;
		boolean emptyNegZ = true;

		boolean floating = true;

		if(world.getBlock(x, y-1, z).isBlockNormalCube()) {
			floating = false;
			maxX = 1.0F;
			maxZ = 1.0F;
			emptyNegY = false;
		}

		if(world.getBlock(x-1, y, z).isBlockNormalCube()) {
			floating = false;
			maxY = 1.0F;
			maxZ = 1.0F;
			emptyNegX = false;
		}

		if(world.getBlock(x, y, z-1).isBlockNormalCube()) {
			floating = false;
			maxY = 1.0F;
			maxX = 1.0F;
			emptyNegZ = false;
		}

		if(world.getBlock(x, y+1, z).isBlockNormalCube()) {
			floating = false;
			maxX = 1.0F;
			maxZ = 1.0F;
			if(emptyNegY && maxY == 0.0625) {
				minY = 0.9375F;
				maxY = 1.0F;
			}
		}

		if(world.getBlock(x+1, y, z).isBlockNormalCube()) {
			floating = false;
			maxY = 1.0F;
			maxZ = 1.0F;
			if(emptyNegX && maxX == 0.0625) {
				minX = 0.9375F;
				maxX = 1.0F;
			}
		}

		if(world.getBlock(x, y, z+1).isBlockNormalCube()) {
			floating = false;
			maxY = 1.0F;
			maxX = 1.0F;
			if(emptyNegZ && maxZ == 0.0625) {
				minZ = 0.9375F;
				maxZ = 1.0F;
			}
		}

		if (floating) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
		else {
			setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
		}

	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	{
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.icon = iconRegister.registerIcon("DeeperCaves:sculk_vein");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j)
	{
		return this.icon;
	}

	@Override
	public int getRenderType() {
		return RenderSculkVein.renderID;
	}


}
