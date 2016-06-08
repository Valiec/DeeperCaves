package com.kpabr.DeeperCaves.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidVenenium extends BlockFluidClassic {
	
	public Fluid fluid;
	private IIcon still;
	private IIcon flow;

	public BlockFluidVenenium(Fluid fluid, Material material) {
		super(fluid, material);
		this.fluid = fluid;
		this.opaque = false;
		// TODO Auto-generated constructor stub
	}
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
		this.still = iconRegister.registerIcon("DeeperCaves:venenium_still");
		this.flow = iconRegister.registerIcon("DeeperCaves:venenium_flow");
		this.getFluid().setIcons(this.still, this.flow);
    }
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int j)
    {
            if (i <= 1)
            {
                    return this.still;
            }
            else
            {
                    return this.flow;
            }
    }
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

}
