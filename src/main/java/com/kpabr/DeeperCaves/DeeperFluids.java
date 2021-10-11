package com.kpabr.DeeperCaves;

import com.kpabr.DeeperCaves.block.BlockFluidMoltenIron;
import com.kpabr.DeeperCaves.block.BlockFluidVenenium;
import com.kpabr.DeeperCaves.block.FluidMoltenIron;
import com.kpabr.DeeperCaves.block.FluidVenenium;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class DeeperFluids {


	/*Fluid declarations*/
	
	public static Fluid moltenIron;
	public static Fluid venenium;
	
	public static Block moltenIronBlock;
	public static Block veneniumBlock;


    public void setupFluids()
    {
    	this.moltenIron = new FluidMoltenIron("fluidMoltenIron").setLuminosity(15);
        FluidRegistry.registerFluid(this.moltenIron);
    	this.venenium = new FluidVenenium("fluidVenenium").setLuminosity(15);
        FluidRegistry.registerFluid(this.venenium);
    }
    public void setupFluidBlocks()
    {
    	this.moltenIronBlock = new BlockFluidMoltenIron(this.moltenIron, Material.lava).setBlockName("moltenIron").setBlockTextureName("deepercaves:molten_iron").setCreativeTab(null);//.setLightLevel(15.0F);
        GameRegistry.registerBlock(this.moltenIronBlock, "molten_iron");
        this.veneniumBlock = new BlockFluidVenenium(this.venenium, Material.water).setBlockName("venenium").setBlockTextureName("deepercaves:venenium").setCreativeTab(null).setLightLevel(15.0F);
        GameRegistry.registerBlock(this.veneniumBlock, "venenium");
    }

    
}
