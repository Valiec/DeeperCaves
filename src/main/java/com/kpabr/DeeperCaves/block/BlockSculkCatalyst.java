package com.kpabr.DeeperCaves.block;

import com.kpabr.DeeperCaves.client.RenderSculkSensor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

public class BlockSculkCatalyst extends Block {

	public IIcon side;
	public IIcon top;
	public IIcon bottom;
	public IIcon sideBloom;
	public IIcon topBloom;

	public BlockSculkCatalyst(Material par2Material) {
		super(par2Material);
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.side = iconRegister.registerIcon("DeeperCaves:sculk_catalyst_side");
		this.top = iconRegister.registerIcon("DeeperCaves:sculk_catalyst_top");
		this.bottom = iconRegister.registerIcon("DeeperCaves:sculk_catalyst_bottom");
		this.sideBloom = iconRegister.registerIcon("DeeperCaves:sculk_catalyst_side_bloom");
		this.topBloom = iconRegister.registerIcon("DeeperCaves:sculk_catalyst_top_bloom");

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

}
