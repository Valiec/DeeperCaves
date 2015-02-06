package com.kpabr.DeeperCaves;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
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
    
    public static Block sapphireOre;
    public static Block aquamarineOre;
    public static Block ametrineOre;
    
    public static Block ccoalOre;
    public static Block cironOre;
    public static Block cgoldOre;
    public static Block clapisOre;
    public static Block credstoneOre;
    public static Block cdiamondOre;
    public static Block cemeraldOre;
    
    public static Block fragmentedBedrock;
    
    
    
    public void registerBlocks()
    {
        GameRegistry.registerBlock(this.silverOre, "silver_ore");
        GameRegistry.registerBlock(this.dropPortal, "drop_portal");
        GameRegistry.registerBlock(this.returnPortal, "return_portal");
        GameRegistry.registerBlock(this.mazePortal, "maze_portal");
        GameRegistry.registerBlock(this.crystalPortal, "crystal_portal");
        GameRegistry.registerBlock(this.compressedPortal, "compressed_portal");
        GameRegistry.registerBlock(this.bedrockPlainsPortal, "bedrock_plains_portal");
        
        GameRegistry.registerBlock(this.sapphireOre, "sapphire_ore");
        GameRegistry.registerBlock(this.aquamarineOre, "aquamarine_ore");
        GameRegistry.registerBlock(this.ametrineOre, "ametrine_ore");
        
        GameRegistry.registerBlock(this.ccoalOre, "compressed_coal_ore");
        GameRegistry.registerBlock(this.cironOre, "compressed_iron_ore");
        GameRegistry.registerBlock(this.cgoldOre, "compressed_gold_ore");
        GameRegistry.registerBlock(this.clapisOre, "compressed_lapis_ore");
        GameRegistry.registerBlock(this.credstoneOre, "compressed_redstone_ore");
        GameRegistry.registerBlock(this.cdiamondOre, "compressed_diamond_ore");
        GameRegistry.registerBlock(this.cemeraldOre, "compressed_emerald_ore");
        
        GameRegistry.registerBlock(this.fragmentedBedrock, "fragmented_bedrock");
        
    }
    public void setupBlocks()
    {
        
        this.silverOre = new BlockSilverOre(Material.rock).setBlockTextureName("deepercaves:silver_ore").setBlockName("silverOre").setHardness(0.5F).setResistance(15.0F).setCreativeTab(CreativeTabs.tabBlock);
        this.dropPortal = new BlockDropPortal(Material.rock).setBlockName("dropPortal").setHardness(3.5F).setResistance(15.0F);
        this.returnPortal = new BlockReturnPortal(Material.rock).setBlockName("returnPortal").setHardness(3.5F).setResistance(15.0F);
        this.mazePortal = new BlockMazePortal(Material.rock).setBlockName("mazePortal").setHardness(3.5F).setResistance(15.0F);
        this.crystalPortal = new BlockCrystalPortal(Material.rock).setBlockName("crystalPortal").setHardness(3.5F).setResistance(15.0F);
        this.compressedPortal = new BlockCompressedPortal(Material.rock).setBlockName("compressedPortal").setHardness(3.5F).setResistance(15.0F);
        this.bedrockPlainsPortal = new BlockBedrockPlainsPortal(Material.rock).setBlockName("bedrockPlainsPortal").setHardness(3.5F).setResistance(15.0F);
        
        this.sapphireOre = new BlockSapphireOre(Material.rock).setBlockTextureName("deepercaves:sapphireOre").setBlockName("sapphireOre").setHardness(0.5F).setResistance(15.0F).setCreativeTab(CreativeTabs.tabBlock);
        this.aquamarineOre = new BlockSilverOre(Material.rock).setBlockTextureName("deepercaves:aquamarineOre").setBlockName("aquamarineOre").setHardness(0.5F).setResistance(15.0F).setCreativeTab(CreativeTabs.tabBlock);     
        this.ametrineOre = new BlockSilverOre(Material.rock).setBlockTextureName("deepercaves:ametrine").setBlockName("ametrineOre").setHardness(0.5F).setResistance(15.0F).setCreativeTab(CreativeTabs.tabBlock);
        
        this.ccoalOre = new BlockCompressedOre(Material.rock, Blocks.coal_ore).setBlockTextureName("deepercaves:ccoal_ore").setBlockName("ccoalOre").setHardness(0.5F).setResistance(15.0F).setCreativeTab(CreativeTabs.tabBlock);
        this.cironOre = new BlockCompressedOre(Material.rock, Blocks.iron_ore).setBlockTextureName("deepercaves:ciron_ore").setBlockName("cironOre").setHardness(0.5F).setResistance(15.0F).setCreativeTab(CreativeTabs.tabBlock);
        this.cgoldOre = new BlockCompressedOre(Material.rock, Blocks.gold_ore).setBlockTextureName("deepercaves:cgold_ore").setBlockName("cgoldOre").setHardness(0.5F).setResistance(15.0F).setCreativeTab(CreativeTabs.tabBlock);
        this.clapisOre = new BlockCompressedOre(Material.rock, Blocks.lapis_ore).setBlockTextureName("deepercaves:clapis_ore").setBlockName("clapisOre").setHardness(0.5F).setResistance(15.0F).setCreativeTab(CreativeTabs.tabBlock);
        this.credstoneOre = new BlockCompressedOre(Material.rock, Blocks.redstone_ore).setBlockTextureName("deepercaves:credstone_ore").setBlockName("credstoneOre").setHardness(0.5F).setResistance(15.0F).setCreativeTab(CreativeTabs.tabBlock);
        this.cdiamondOre = new BlockCompressedOre(Material.rock, Blocks.diamond_ore).setBlockTextureName("deepercaves:cdiamond_ore").setBlockName("cdiamondOre").setHardness(0.5F).setResistance(15.0F).setCreativeTab(CreativeTabs.tabBlock);
        this.cemeraldOre = new BlockCompressedOre(Material.rock, Blocks.emerald_ore).setBlockTextureName("deepercaves:cemerald_ore").setBlockName("cemeraldOre").setHardness(0.5F).setResistance(15.0F).setCreativeTab(CreativeTabs.tabBlock);
        
        this.fragmentedBedrock = new BlockFragmentedBedrock(Material.rock).setBlockTextureName("deepercaves:fragmented_bedrock").setBlockName("fragmentedBedrock").setHardness(35.5F).setResistance(1500000.0F).setCreativeTab(CreativeTabs.tabBlock);
        
        
    }
    public void setupHarvestLevels()
    {
        /*Setting up block harvest levels*/
        this.silverOre.setHarvestLevel("pickaxe", 2);
        
        this.sapphireOre.setHarvestLevel("pickaxe", 2);
        this.aquamarineOre.setHarvestLevel("pickaxe", 2);
        this.ametrineOre.setHarvestLevel("pickaxe", 3);
        
        this.ccoalOre.setHarvestLevel("pickaxe", 1);
        this.cironOre.setHarvestLevel("pickaxe", 2);
        this.cgoldOre.setHarvestLevel("pickaxe", 3);
        this.clapisOre.setHarvestLevel("pickaxe", 2);
        this.credstoneOre.setHarvestLevel("pickaxe", 3);
        this.cdiamondOre.setHarvestLevel("pickaxe", 3);
        this.cemeraldOre.setHarvestLevel("pickaxe", 3);
        
        this.fragmentedBedrock.setHarvestLevel("pickaxe", 3);
       
    }
    
}
