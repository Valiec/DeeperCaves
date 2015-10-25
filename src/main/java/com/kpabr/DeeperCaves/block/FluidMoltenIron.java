package com.kpabr.DeeperCaves.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraftforge.fluids.Fluid;

public class FluidMoltenIron extends Fluid {

	public FluidMoltenIron(String fluidName) {
		super(fluidName);
		this.density = 20;
		this.viscosity = 2500;
		// TODO Auto-generated constructor stub
	}
	

}
