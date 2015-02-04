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
    
    public static Block silverOre;
    public static Block dropPortal;
    public static Block returnPortal;
    public static Block mazePortal;
    public static Block crystalPortal;
    public static Block compressedPortal;
    public static Block bedrockPlainsPortal;
    
    
    
    public void registerBlocks()
    {
        GameRegistry.registerBlock(this.silverOre, "silver_ore");
        GameRegistry.registerBlock(this.dropPortal, "drop_portal");
        GameRegistry.registerBlock(this.returnPortal, "return_portal");
        GameRegistry.registerBlock(this.mazePortal, "maze_portal");
        GameRegistry.registerBlock(this.crystalPortal, "crystal_portal");
        GameRegistry.registerBlock(this.compressedPortal, "compressed_portal");
        GameRegistry.registerBlock(this.bedrockPlainsPortal, "bedrock_plains_portal");
        
    }
    public void setupBlocks()
    {
        
        this.silverOre = new BlockSilverOre(Material.rock).setBlockTextureName("deepercaves:silver_ore").setBlockName("silverOre").setHardness(0.5F).setResistance(15.0F).setCreativeTab(CreativeTabs.tabBlock);
        this.dropPortal = new BlockDropPortal(Material.rock).setBlockName("dropPortal");
        this.returnPortal = new BlockReturnPortal(Material.rock).setBlockName("returnPortal");
        this.mazePortal = new BlockMazePortal(Material.rock).setBlockName("mazePortal");
        this.crystalPortal = new BlockCrystalPortal(Material.rock).setBlockName("crystalPortal");
        this.compressedPortal = new BlockCompressedPortal(Material.rock).setBlockName("compressedPortal");
        this.bedrockPlainsPortal = new BlockBedrockPlainsPortal(Material.rock).setBlockName("bedrockPlainsPortal");
        
    }
    public void setupHarvestLevels()
    {
        /*Setting up block harvest levels*/
        this.silverOre.setHarvestLevel("pickaxe", 2);
       
    }
    
}
