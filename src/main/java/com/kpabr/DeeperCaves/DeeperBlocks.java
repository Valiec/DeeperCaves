package com.kpabr.DeeperCaves;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSlab;

public class DeeperBlocks {


    /*Block declarations*/
    
    public static Block example;
    public static Block dropPortal;
    public static Block returnPortal;
    
    
    
    public void registerBlocks()
    {
        GameRegistry.registerBlock(this.example, "example_block");
        GameRegistry.registerBlock(this.dropPortal, "drop_portal");
        GameRegistry.registerBlock(this.returnPortal, "return_portal");
        
    }
    public void setupBlocks()
    {
        
        this.example = new BlockExample(Material.rock).setBlockTextureName("deepercaves:example").setBlockName("example").setHardness(1.5F).setResistance(15.0F);
        this.dropPortal = new BlockDropPortal(Material.rock).setBlockName("dropPortal");
        this.returnPortal = new BlockReturnPortal(Material.rock).setBlockName("returnPortal");
        
    }
    public void setupHarvestLevels()
    {
        /*Setting up block harvest levels*/
        this.example.setHarvestLevel("pickaxe", 3);
       
    }
    
}
