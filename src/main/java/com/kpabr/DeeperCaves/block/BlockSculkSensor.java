package com.kpabr.DeeperCaves.block;

import com.kpabr.DeeperCaves.client.RenderSculkSensor;
import com.kpabr.DeeperCaves.client.RenderSculkVein;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockSculkSensor extends Block {

	public IIcon side;
	public IIcon top;
	public IIcon bottom;
	public IIcon tendrils;
	public IIcon tendrils_active;

	public BlockSculkSensor(Material par2Material) {
		super(par2Material);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
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


}
