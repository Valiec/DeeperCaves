package com.kpabr.DeeperCaves.block;

import com.kpabr.DeeperCaves.client.RenderSculkVein;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockSculkLayer extends Block {

	public IIcon icon;

	public BlockSculkLayer(Material par2Material) {
		super(par2Material);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.05F, 1.0F);
		// TODO Auto-generated constructor stub
	}

	public boolean isOpaqueCube()
	{
		return false;
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
