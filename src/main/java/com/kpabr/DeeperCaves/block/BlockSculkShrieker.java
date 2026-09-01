package com.kpabr.DeeperCaves.block;

import com.kpabr.DeeperCaves.client.RenderSculkSensor;
import com.kpabr.DeeperCaves.client.RenderSculkShrieker;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockSculkShrieker extends Block {

	public IIcon side;
	public IIcon top;
	public IIcon topInner;
	public IIcon topInnerActive;
	public IIcon bottom;

	public BlockSculkShrieker(Material par2Material) {
		super(par2Material);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public boolean isOpaqueCube()
	{
		return false;
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

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j)
	{
		if (i == 1)
		{
			return this.topInner;
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


}
