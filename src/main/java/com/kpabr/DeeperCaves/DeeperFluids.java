package com.kpabr.DeeperCaves;

import com.kpabr.DeeperCaves.block.BlockFluidMoltenIron;
import com.kpabr.DeeperCaves.block.FluidMoltenIron;

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
	
	public static Block moltenIronBlock;


    public void setupFluids()
    {
    	this.moltenIron = new FluidMoltenIron("fluidMoltenIron");
        FluidRegistry.registerFluid(this.moltenIron);
    }
    public void setupFluidBlocks()
    {
    	this.moltenIronBlock = new BlockFluidMoltenIron(this.moltenIron, DeeperCaves.materials.moltenIron).setBlockName("moltenIron").setBlockTextureName("deepercaves:molten_iron").setCreativeTab(null);
        GameRegistry.registerBlock(this.moltenIronBlock, "molten_iron");
    }

    
}
