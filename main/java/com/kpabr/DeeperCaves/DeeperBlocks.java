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
import net.minecraftforge.oredict.OreDictionary;

public class DeeperBlocks {


    /*Block declarations*/
    
    public static Block silverOre;
    public static Block dropPortal;
    public static Block returnPortal;
    public static Block mazePortal;
    public static Block crystalPortal;
    public static Block compressedPortal;
    public static Block bedrockPlainsPortal;
    
    public static Block nearNetherPortal;
    //public static Block lavaPortal;
    public static Block nearVoidPortal;
    
    public static Block sapphireOre;
    public static Block aquamarineOre;
    public static Block ametrineOre;
    
    public static Block ccoalOre;
    public static Block cironOre;
    public static Block cgoldOre;
    public static Block clapisOre;
    public static Block credstoneOre;
    public static Block credstoneOre_glowing;
    public static Block cdiamondOre;
    public static Block cemeraldOre;
    
    public static Block fragmentedBedrock;
    
    public static Block silverBlock;
    
    public static Block sapphireBlock;
    
    public static Block aquamarineBlock;
    
    public static Block ametrineBlock;
    
    public static Block tenebriumOre;
    public static Block tenebriumBlock;
    
    public static Block forgottenGemstoneOre;
    
    public static Block fakeBedrock;
    
    
    
    public void registerBlocks()
    {
        GameRegistry.registerBlock(this.silverOre, "silver_ore");
        GameRegistry.registerBlock(this.dropPortal, "drop_portal");
        GameRegistry.registerBlock(this.returnPortal, "return_portal");
        GameRegistry.registerBlock(this.mazePortal, "maze_portal");
        GameRegistry.registerBlock(this.crystalPortal, "crystal_portal");
        GameRegistry.registerBlock(this.compressedPortal, "compressed_portal");
        GameRegistry.registerBlock(this.bedrockPlainsPortal, "bedrock_plains_portal");
        
        GameRegistry.registerBlock(this.nearNetherPortal, "near_nether_portal");
        //GameRegistry.registerBlock(this.lavaPortal, "lava_portal");
        GameRegistry.registerBlock(this.nearVoidPortal, "near_void_portal");
        
        GameRegistry.registerBlock(this.sapphireOre, "sapphire_ore");
        GameRegistry.registerBlock(this.aquamarineOre, "aquamarine_ore");
        GameRegistry.registerBlock(this.ametrineOre, "ametrine_ore");
        
        GameRegistry.registerBlock(this.ccoalOre, "compressed_coal_ore");
        GameRegistry.registerBlock(this.cironOre, "compressed_iron_ore");
        GameRegistry.registerBlock(this.cgoldOre, "compressed_gold_ore");
        GameRegistry.registerBlock(this.clapisOre, "compressed_lapis_ore");
        GameRegistry.registerBlock(this.credstoneOre, "compressed_redstone_ore");
        GameRegistry.registerBlock(this.credstoneOre_glowing, "compressed_redstone_ore_glowing");
        GameRegistry.registerBlock(this.cdiamondOre, "compressed_diamond_ore");
        GameRegistry.registerBlock(this.cemeraldOre, "compressed_emerald_ore");
        
        GameRegistry.registerBlock(this.fragmentedBedrock, "fragmented_bedrock");
        
        GameRegistry.registerBlock(this.silverBlock, "silver_block");
        
        GameRegistry.registerBlock(this.sapphireBlock, "sapphire_block");
        GameRegistry.registerBlock(this.aquamarineBlock, "aquamarine_block");
        GameRegistry.registerBlock(this.ametrineBlock, "ametrine_block");
        
        GameRegistry.registerBlock(this.tenebriumOre, "tenebrium_ore"); 
        GameRegistry.registerBlock(this.tenebriumBlock, "tenebrium_block");
        
        GameRegistry.registerBlock(this.forgottenGemstoneOre, "forgotten_gemstone_ore");
        
        GameRegistry.registerBlock(this.fakeBedrock, "fake_bedrock");
        
    }
    public void registerBlocksOreDict()
    {
    	OreDictionary.registerOre("oreSilver", this.silverOre);
    	
    	OreDictionary.registerOre("oreSapphire", this.sapphireOre);
    	OreDictionary.registerOre("oreAquamarine", this.aquamarineBlock);
    	OreDictionary.registerOre("oreAmetrine", this.ametrineOre);
    	
    	OreDictionary.registerOre("oreCompressedCoal", this.ccoalOre);
    	OreDictionary.registerOre("oreCompressedIron", this.cironOre);
    	OreDictionary.registerOre("oreCompressedGold", this.cgoldOre);
    	OreDictionary.registerOre("oreCompressedLapis", this.clapisOre);
    	OreDictionary.registerOre("oreCompressedRedstone", this.credstoneOre);
    	OreDictionary.registerOre("oreCompressedRedstone_glowing", this.credstoneOre_glowing);
    	OreDictionary.registerOre("oreCompressedDiamond", this.cdiamondOre);
    	OreDictionary.registerOre("oreCompressedEmerald", this.cemeraldOre);
        
    	OreDictionary.registerOre("blockFragmentedBedrock", this.fragmentedBedrock);
    	
    	OreDictionary.registerOre("blockSilver", this.silverBlock);
    	
    	OreDictionary.registerOre("blockSapphire", this.sapphireBlock);
    	OreDictionary.registerOre("blockSapphire", this.aquamarineBlock);
    	OreDictionary.registerOre("blockAquamarine", this.ametrineBlock);  
 
    	OreDictionary.registerOre("oreTenebrium", this.tenebriumOre);
    	OreDictionary.registerOre("blockTenebrium", this.tenebriumBlock);
    	
    	OreDictionary.registerOre("oreForgottenGemstone", this.forgottenGemstoneOre);
        
    }
    public void setupBlocks()
    {
        
        this.silverOre = new BlockBase(Material.rock).setBlockTextureName("deepercaves:silver_ore").setBlockName("silverOre").setHardness(3.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        this.dropPortal = new BlockDeeperPortal(Material.rock, 7).setBlockName("dropPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.returnPortal = new BlockReturnPortal(Material.rock).setBlockName("returnPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.mazePortal = new BlockDeeperPortal(Material.rock, 8).setBlockName("mazePortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.crystalPortal = new BlockDeeperPortal(Material.rock, 9).setBlockName("crystalPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.compressedPortal = new BlockDeeperPortal(Material.rock, 10).setBlockName("compressedPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.bedrockPlainsPortal = new BlockDeeperPortal(Material.rock, 11).setBlockName("bedrockPlainsPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        
        this.nearNetherPortal = new BlockDeeperPortal(Material.rock, 12).setBlockName("nearNetherPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        //this.lavaPortal = new BlockDeeperPortal(Material.rock, 13).setBlockName("lavaPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.nearVoidPortal = new BlockDeeperPortal(Material.rock, 14).setBlockName("nearVoidPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.sapphireOre = new BlockOreBase(Material.rock, DeeperCaves.items.sapphireGem, 1, 1).setBlockTextureName("deepercaves:sapphireOre").setBlockName("sapphireOre").setHardness(3.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        this.aquamarineOre = new BlockOreBase(Material.rock, DeeperCaves.items.aquamarine, 3, 3).setBlockTextureName("deepercaves:aquamarineOre").setBlockName("aquamarineOre").setHardness(3.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);     
        this.ametrineOre = new BlockOreBase(Material.rock, DeeperCaves.items.ametrineGem, 1, 1).setBlockTextureName("deepercaves:ametrine").setBlockName("ametrineOre").setHardness(4.5F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.ccoalOre = new BlockCompressedOre(Material.rock, Blocks.coal_ore).setBlockTextureName("deepercaves:ccoal_ore").setBlockName("ccoalOre").setHardness(3.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        this.cironOre = new BlockCompressedOre(Material.rock, Blocks.iron_ore).setBlockTextureName("deepercaves:ciron_ore").setBlockName("cironOre").setHardness(3.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        this.cgoldOre = new BlockCompressedOre(Material.rock, Blocks.gold_ore).setBlockTextureName("deepercaves:cgold_ore").setBlockName("cgoldOre").setHardness(3.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        this.clapisOre = new BlockCompressedOre(Material.rock, Blocks.lapis_ore).setBlockTextureName("deepercaves:clapis_ore").setBlockName("clapisOre").setHardness(3.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        this.credstoneOre = new BlockCompressedRedstoneOre(false).setBlockTextureName("deepercaves:credstone_ore").setBlockName("credstoneOre").setHardness(3.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        this.credstoneOre_glowing = new BlockCompressedRedstoneOre(true).setBlockTextureName("deepercaves:credstone_ore").setBlockName("credstoneOre").setHardness(3.0F).setResistance(15.0F).setLightLevel(0.625F);
        this.cdiamondOre = new BlockCompressedOre(Material.rock, Blocks.diamond_ore).setBlockTextureName("deepercaves:cdiamond_ore").setBlockName("cdiamondOre").setHardness(3.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        this.cemeraldOre = new BlockCompressedOre(Material.rock, Blocks.emerald_ore).setBlockTextureName("deepercaves:cemerald_ore").setBlockName("cemeraldOre").setHardness(3.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.fragmentedBedrock = new BlockFragmentedBedrock(Material.rock).setBlockTextureName("deepercaves:fragmented_bedrock").setBlockName("fragmentedBedrock").setHardness(45.5F).setResistance(1500000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.silverBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:silverBlock").setBlockName("silverBlock").setHardness(3.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.sapphireBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:sapphireBlock").setBlockName("sapphireBlock").setHardness(5.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        this.aquamarineBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:aquamarineBlock").setBlockName("aquamarineBlock").setHardness(4.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        this.ametrineBlock = new BlockAmetrine(Material.rock).setBlockName("ametrineBlock").setHardness(7.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.tenebriumOre = new BlockBase(Material.rock).setBlockTextureName("deepercaves:tenebrium").setBlockName("tenebriumOre").setHardness(8.5F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        this.tenebriumBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:tenebriumBlock").setBlockName("tenebriumBlock").setHardness(10.5F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.forgottenGemstoneOre = new BlockFragmentedBedrockOre(Material.rock, DeeperCaves.items.forgottenGemstone, 1, 1).setBlockTextureName("deepercaves:forgotten_gemstone_ore").setBlockName("forgottenGemstoneOre").setHardness(45.5F).setResistance(1500000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.fakeBedrock = new BlockFakeBedrock(Material.rock).setBlockTextureName("minecraft:bedrock").setBlockName("fakeBedrock").setHardness(45.5F).setResistance(1500000.0F).setBlockUnbreakable().setCreativeTab(null);
        
        
    }
    public void setupHarvestLevels()
    {
        /*Setting up block harvest levels*/
        this.silverOre.setHarvestLevel("pickaxe", 2);
        this.silverBlock.setHarvestLevel("pickaxe", 2);
        
        this.sapphireOre.setHarvestLevel("pickaxe", 2);
        this.sapphireBlock.setHarvestLevel("pickaxe", 2);
        this.aquamarineOre.setHarvestLevel("pickaxe", 2);
        this.aquamarineBlock.setHarvestLevel("pickaxe", 2);
        this.ametrineOre.setHarvestLevel("pickaxe", 3);
        this.ametrineBlock.setHarvestLevel("pickaxe", 3);
        
        
        this.ccoalOre.setHarvestLevel("pickaxe", 1);
        this.cironOre.setHarvestLevel("pickaxe", 2);
        this.cgoldOre.setHarvestLevel("pickaxe", 3);
        this.clapisOre.setHarvestLevel("pickaxe", 2);
        this.credstoneOre.setHarvestLevel("pickaxe", 3);
        this.credstoneOre_glowing.setHarvestLevel("pickaxe", 3);
        this.cdiamondOre.setHarvestLevel("pickaxe", 3);
        this.cemeraldOre.setHarvestLevel("pickaxe", 3);
        
        this.fragmentedBedrock.setHarvestLevel("pickaxe", 4);
        
        this.tenebriumOre.setHarvestLevel("pickaxe", 4);
        this.tenebriumBlock.setHarvestLevel("pickaxe", 4);
      
        this.forgottenGemstoneOre.setHarvestLevel("pickaxe", 4);
       
    }
    
}
