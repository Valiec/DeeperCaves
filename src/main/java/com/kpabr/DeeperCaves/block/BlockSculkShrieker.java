package com.kpabr.DeeperCaves.block;

import com.kpabr.DeeperCaves.client.RenderSculkSensor;
import com.kpabr.DeeperCaves.client.RenderSculkShrieker;
import com.kpabr.DeeperCaves.entity.TileEntitySculkSensor;
import com.kpabr.DeeperCaves.entity.TileEntitySculkShrieker;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSculkShrieker extends Block implements ITileEntityProvider {

	public IIcon side;
	public IIcon top;
	public IIcon topInner;
	public IIcon topInnerActive;
	public IIcon bottom;

	public BlockSculkShrieker(Material par2Material) {
		super(par2Material);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
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

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.side = iconRegister.registerIcon("DeeperCaves:sculk_shrieker_side");
		this.top = iconRegister.registerIcon("DeeperCaves:sculk_shrieker_top");
		this.bottom = iconRegister.registerIcon("DeeperCaves:sculk_shrieker_bottom");
		this.topInner = iconRegister.registerIcon("DeeperCaves:sculk_shrieker_inner_top");
		this.topInnerActive = iconRegister.registerIcon("DeeperCaves:sculk_shrieker_can_summon_inner_top");
	}

	public IIcon getTopTextureFromMeta(int meta) {
		if((meta & 2) != 0) {
			return this.topInnerActive;
		}
		else {
			return this.topInner;
		}

	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j)
	{
		if (i == 1)
		{
			return getTopTextureFromMeta(j);
		}
		if (i == 4 || i == 5 || i == 2 || i == 3)
		{
			return this.side;
		}
		if (i == 0)
		{
			return this.bottom;
		}
		else
		{
			return this.topInner;
		}
	}

	@Override
	public int getRenderType() {
		return RenderSculkShrieker.renderID;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntitySculkShrieker();
	}


}
