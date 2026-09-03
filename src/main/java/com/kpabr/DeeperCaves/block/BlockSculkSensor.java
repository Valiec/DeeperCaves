package com.kpabr.DeeperCaves.block;

import com.kpabr.DeeperCaves.client.RenderSculkSensor;
import com.kpabr.DeeperCaves.client.RenderSculkVein;
import com.kpabr.DeeperCaves.entity.TileEntitySculkSensor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSculkSensor extends Block implements ITileEntityProvider {

	public IIcon side;
	public IIcon top;
	public IIcon bottom;
	public IIcon tendrils;
	public IIcon tendrils_active;

	public BlockSculkSensor(Material par2Material) {
		super(par2Material);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}

	public int getMixedBrightnessForBlock(IBlockAccess world, int x, int y, int z)
	{
		int lightData = super.getMixedBrightnessForBlock(world, x, y, z);
		int blockLight = (lightData >> 4) & 15;

		int meta = world.getBlockMetadata(x, y, z);
		int increase = 4;
		if(meta == 1)
		{
			if(blockLight <= 15-increase)
			{
				blockLight += increase;
			}
			else {
				blockLight = 15;
			}

			lightData = lightData & 255; //clear block light data
			lightData = lightData | (blockLight << 4);
		}

		return lightData;
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

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.side = iconRegister.registerIcon("DeeperCaves:sculk_sensor_side");
		this.top = iconRegister.registerIcon("DeeperCaves:sculk_sensor_top");
		this.bottom = iconRegister.registerIcon("DeeperCaves:sculk_sensor_bottom");
		this.tendrils = iconRegister.registerIcon("DeeperCaves:sculk_sensor_tendril_inactive");
		this.tendrils_active = iconRegister.registerIcon("DeeperCaves:sculk_sensor_tendril_active");

	}

	public IIcon getTendrilTextureFromMeta(int meta) {
		if(meta == 1) {
			return this.tendrils_active;
		}
		else {
			return this.tendrils;
		}

	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j)
	{
		if (i == 1)
		{
			return this.top;
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
			return this.top;
		}
	}

	@Override
	public int getRenderType() {
		return RenderSculkSensor.renderID;
	}


	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntitySculkSensor();
	}
}
