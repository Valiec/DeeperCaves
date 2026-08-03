package com.kpabr.DeeperCaves;

import com.kpabr.DeeperCaves.block.BlockFluidMoltenIron;
import com.kpabr.DeeperCaves.block.BlockFluidVenenium;
import com.kpabr.DeeperCaves.block.FluidMoltenIron;
import com.kpabr.DeeperCaves.block.FluidVenenium;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class DeeperFluids {


	/*Fluid declarations*/
	
	public static Fluid moltenIron;
	public static Fluid venenium;
	
	public static Block moltenIronBlock;
	public static Block veneniumBlock;


    public void setupFluids()
    {
    	moltenIron = new FluidMoltenIron("fluidMoltenIron").setLuminosity(15);
        FluidRegistry.registerFluid(moltenIron);
    	venenium = new FluidVenenium("fluidVenenium").setLuminosity(15);
        FluidRegistry.registerFluid(venenium);
    }
    public void setupFluidBlocks()
    {
    	moltenIronBlock = new BlockFluidMoltenIron(moltenIron, Material.lava).setBlockName("moltenIron").setBlockTextureName("deepercaves:molten_iron").setCreativeTab(null).setLightLevel(1.0F);
        GameRegistry.registerBlock(moltenIronBlock, "molten_iron");
        veneniumBlock = new BlockFluidVenenium(venenium, Material.lava).setBlockName("venenium").setBlockTextureName("deepercaves:venenium").setCreativeTab(null).setLightLevel(1.0F);
        GameRegistry.registerBlock(veneniumBlock, "venenium");
    }

    
}
