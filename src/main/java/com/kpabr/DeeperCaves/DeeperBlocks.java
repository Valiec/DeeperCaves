package com.kpabr.DeeperCaves;

import com.kpabr.DeeperCaves.block.BlockAmetrine;
import com.kpabr.DeeperCaves.block.BlockBase;
import com.kpabr.DeeperCaves.block.BlockCompressedOre;
import com.kpabr.DeeperCaves.block.BlockCompressedRedstoneOre;
import com.kpabr.DeeperCaves.block.BlockCryingObsidian;
import com.kpabr.DeeperCaves.block.BlockCrystal;
import com.kpabr.DeeperCaves.block.BlockDeepStone;
import com.kpabr.DeeperCaves.block.BlockDeeperPortal;
import com.kpabr.DeeperCaves.block.BlockFakeBedrock;
import com.kpabr.DeeperCaves.block.BlockFragmentedBedrock;
import com.kpabr.DeeperCaves.block.BlockFragmentedBedrockOre;
import com.kpabr.DeeperCaves.block.BlockMagmaStone;
import com.kpabr.DeeperCaves.block.BlockOreBase;
import com.kpabr.DeeperCaves.block.BlockProfundium;
import com.kpabr.DeeperCaves.block.BlockReturnPortal;
import com.kpabr.DeeperCaves.block.BlockVanillaOre;
import com.kpabr.DeeperCaves.block.BlockVanillaRedstoneOre;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
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
    public static Block lavaPortal;
    public static Block nearVoidPortal;
    
    public static Block deepWorldPortal;
    public static Block darknessPortal;
    public static Block abandonedCavesPortal;
    
    public static Block mutationPortal;
    
    public static Block farVoidPortal;
    
    public static Block forgottenPortal;
    
    public static Block evilPortal;
    public static Block finalLabyrinthPortal;
    
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
    
    public static Block dccoalOre;
    public static Block dcironOre;
    public static Block dcgoldOre;
    public static Block dclapisOre;
    public static Block dcredstoneOre;
    public static Block dcredstoneOre_glowing;
    public static Block dcdiamondOre;
    public static Block dcemeraldOre;
    
    public static Block dcsilverOre;
    public static Block dcsapphireOre;
    public static Block dcaquamarineOre;
    public static Block dcrubyOre;
    
    public static Block csilverOre;
    public static Block csapphireOre;
    public static Block caquamarineOre;
    public static Block crubyOre;
    
    public static Block dcoalOre;
    public static Block dironOre;
    public static Block dgoldOre;
    public static Block dlapisOre;
    public static Block dredstoneOre;
    public static Block dredstoneOre_glowing;
    public static Block ddiamondOre;
    public static Block demeraldOre;
    
    public static Block ddcoalOre;
    public static Block ddironOre;
    public static Block ddgoldOre;
    public static Block ddlapisOre;
    public static Block ddredstoneOre;
    public static Block ddredstoneOre_glowing;
    public static Block dddiamondOre;
    public static Block ddemeraldOre;
    
    public static Block fragmentedBedrock;
    
    public static Block silverBlock;
    
    public static Block sapphireBlock;
    
    public static Block aquamarineBlock;
    
    public static Block ametrineBlock;
    
    public static Block tenebriumOre;
    public static Block tenebriumBlock;
    
    public static Block forgottenGemstoneOre;
    
    public static Block fakeBedrock;
    
    public static Block forgottenGemstoneBlock;
    
    public static Block barrierLayer;
    
    public static Block darkStone;
    
    public static Block vesperiteOre;
    
    public static Block abandonedStone;
    
    public static Block deepStone;
    
    public static Block deepCobble;
    
    public static Block cooledObsidian;
    
    public static Block heatedObsidian;
    
    public static Block vesperiteBlock;
    
    public static Block cryingObsidian;
    
    public static Block fragmentedCobble;
    
    public static Block soulStone;
    
    public static Block corruptedSoulStone;
    
    public static Block profundiumOre;
    
    public static Block profundiumBlock;
    
	public static Block evanesciteOre;
	
    public static Block evanesciteBlock;
    
    public static Block dpcoalOre;
    public static Block dpironOre;
    public static Block dpgoldOre;
    public static Block dplapisOre;
    public static Block dpredstoneOre;
    public static Block dpredstoneOre_glowing;
    public static Block dpdiamondOre;
    public static Block dpemeraldOre;
    
    public static Block crystal;
    
    public static Block rubyOre;
    
    public static Block rubyBlock;
    
    public static Block magmaStone;
    
    public static Block rottenPlanks;
    
    public static Block rustedBars;
    
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
        GameRegistry.registerBlock(this.lavaPortal, "lava_portal");
        GameRegistry.registerBlock(this.nearVoidPortal, "near_void_portal");
        
        GameRegistry.registerBlock(this.deepWorldPortal, "deep_world_portal");
        GameRegistry.registerBlock(this.darknessPortal, "darkness_portal");
        GameRegistry.registerBlock(this.abandonedCavesPortal, "abandoned_caves_portal");
        
        GameRegistry.registerBlock(this.mutationPortal, "mutation_portal");
        
        GameRegistry.registerBlock(this.farVoidPortal, "far_void_portal");
        
        GameRegistry.registerBlock(this.forgottenPortal, "forgotten_portal");
        
        GameRegistry.registerBlock(this.evilPortal, "evil_portal");
        GameRegistry.registerBlock(this.finalLabyrinthPortal, "final_labyrinth_portal");
        
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
        
        GameRegistry.registerBlock(this.dccoalOre, "deep_compressed_coal_ore");
        GameRegistry.registerBlock(this.dcironOre, "deep_compressed_iron_ore");
        GameRegistry.registerBlock(this.dcgoldOre, "deep_compressed_gold_ore");
        GameRegistry.registerBlock(this.dclapisOre, "deep_compressed_lapis_ore");
        GameRegistry.registerBlock(this.dcredstoneOre, "deep_compressed_redstone_ore");
        GameRegistry.registerBlock(this.dcredstoneOre_glowing, "deep_compressed_redstone_ore_glowing");
        GameRegistry.registerBlock(this.dcdiamondOre, "deep_compressed_diamond_ore");
        GameRegistry.registerBlock(this.dcemeraldOre, "deep_compressed_emerald_ore");
        
        GameRegistry.registerBlock(this.ddcoalOre, "dark_coal_ore");
        GameRegistry.registerBlock(this.ddironOre, "dark_iron_ore");
        GameRegistry.registerBlock(this.ddgoldOre, "dark_gold_ore");
        GameRegistry.registerBlock(this.ddlapisOre, "dark_lapis_ore");
        GameRegistry.registerBlock(this.ddredstoneOre, "dark_redstone_ore");
        GameRegistry.registerBlock(this.ddredstoneOre_glowing, "dark_redstone_ore_glowing");
        GameRegistry.registerBlock(this.dddiamondOre, "dark_diamond_ore");
        GameRegistry.registerBlock(this.ddemeraldOre, "dark_emerald_ore");
        
        GameRegistry.registerBlock(this.dcoalOre, "abandoned_caves_coal_ore");
        GameRegistry.registerBlock(this.dironOre, "abandoned_caves_iron_ore");
        GameRegistry.registerBlock(this.dgoldOre, "abandoned_caves_gold_ore");
        GameRegistry.registerBlock(this.dlapisOre, "abandoned_caves_lapis_ore");
        GameRegistry.registerBlock(this.dredstoneOre, "abandoned_caves_redstone_ore");
        GameRegistry.registerBlock(this.dredstoneOre_glowing, "abandoned_caves_redstone_ore_glowing");
        GameRegistry.registerBlock(this.ddiamondOre, "abandoned_caves_diamond_ore");
        GameRegistry.registerBlock(this.demeraldOre, "abandoned_caves_emerald_ore");
        
        GameRegistry.registerBlock(this.fragmentedBedrock, "fragmented_bedrock");
        
        GameRegistry.registerBlock(this.silverBlock, "silver_block");
        
        GameRegistry.registerBlock(this.sapphireBlock, "sapphire_block");
        GameRegistry.registerBlock(this.aquamarineBlock, "aquamarine_block");
        GameRegistry.registerBlock(this.ametrineBlock, "ametrine_block");
        
        GameRegistry.registerBlock(this.tenebriumOre, "tenebrium_ore"); 
        GameRegistry.registerBlock(this.tenebriumBlock, "tenebrium_block");
        
        GameRegistry.registerBlock(this.forgottenGemstoneOre, "forgotten_gemstone_ore");
        
        GameRegistry.registerBlock(this.fakeBedrock, "fake_bedrock");
        
        GameRegistry.registerBlock(this.forgottenGemstoneBlock, "forgotten_gemstone_block");
        
        GameRegistry.registerBlock(this.barrierLayer, "barrier_layer");
        
        GameRegistry.registerBlock(this.darkStone, "dark_stone");
        
        GameRegistry.registerBlock(this.vesperiteOre, "vesperite_ore");
        
        GameRegistry.registerBlock(this.abandonedStone, "abandoned_stone");
        
        GameRegistry.registerBlock(this.deepStone, "deep_stone");
        
        GameRegistry.registerBlock(this.cooledObsidian, "supercooled_obsidian");
        GameRegistry.registerBlock(this.heatedObsidian, "heated_obsidian");
        
        GameRegistry.registerBlock(this.vesperiteBlock, "vesperite_block");
        
        GameRegistry.registerBlock(this.deepCobble, "deep_cobblestone");
        
        GameRegistry.registerBlock(this.fragmentedCobble, "fragmented_cobblestone");
        
        GameRegistry.registerBlock(this.cryingObsidian, "crying_obsidian");
        
        GameRegistry.registerBlock(this.soulStone, "soul_stone");
        
        GameRegistry.registerBlock(this.corruptedSoulStone, "corrupted_soul_stone");
        
        GameRegistry.registerBlock(this.profundiumOre, "profundium_ore");
        
        GameRegistry.registerBlock(this.profundiumBlock, "profundium_block");
        
        GameRegistry.registerBlock(this.evanesciteOre, "evanescite_ore");
        
        GameRegistry.registerBlock(this.evanesciteBlock, "evanescite_block");
        
        GameRegistry.registerBlock(this.dpcoalOre, "deep_coal_ore");
        GameRegistry.registerBlock(this.dpironOre, "deep_iron_ore");
        GameRegistry.registerBlock(this.dpgoldOre, "deep_gold_ore");
        GameRegistry.registerBlock(this.dplapisOre, "deep_lapis_ore");
        GameRegistry.registerBlock(this.dpredstoneOre, "deep_redstone_ore");
        GameRegistry.registerBlock(this.dpredstoneOre_glowing, "deep_redstone_ore_glowing");
        GameRegistry.registerBlock(this.dpdiamondOre, "deep_diamond_ore");
        GameRegistry.registerBlock(this.dpemeraldOre, "deep_emerald_ore");
     
        GameRegistry.registerBlock(this.crystal, ItemBlockCrystal.class, "crystal");
        
        GameRegistry.registerBlock(this.rubyOre, "ruby_ore");
        
        GameRegistry.registerBlock(this.rubyBlock, "ruby_block");
        
        GameRegistry.registerBlock(this.magmaStone, "magma_stone");
        
        GameRegistry.registerBlock(this.dcsilverOre, "deep_compressed_silver_ore");
        GameRegistry.registerBlock(this.dcsapphireOre, "deep_compressed_sapphire_ore");
        GameRegistry.registerBlock(this.dcaquamarineOre, "deep_compressed_aquamarine_ore");
        GameRegistry.registerBlock(this.dcrubyOre, "deep_compressed_ruby_ore");
        
        GameRegistry.registerBlock(this.csilverOre, "compressed_silver_ore");
        GameRegistry.registerBlock(this.csapphireOre, "compressed_sapphire_ore");
        GameRegistry.registerBlock(this.caquamarineOre, "compressed_aquamarine_ore");
        GameRegistry.registerBlock(this.crubyOre, "compressed_ruby_ore");
        
        GameRegistry.registerBlock(this.rottenPlanks, "rotten_planks");
        GameRegistry.registerBlock(this.rustedBars, "rusted_iron_bars");
    }
    public void registerBlocksOreDict()
    {
    	OreDictionary.registerOre("oreSilver", this.silverOre);
    	
    	OreDictionary.registerOre("oreSapphire", this.sapphireOre);
    	OreDictionary.registerOre("oreAquamarine", this.aquamarineOre);
    	OreDictionary.registerOre("oreAmetrine", this.ametrineOre);
    	
    	OreDictionary.registerOre("oreCompressedCoal", this.ccoalOre);
    	OreDictionary.registerOre("oreCompressedIron", this.cironOre);
    	OreDictionary.registerOre("oreCompressedGold", this.cgoldOre);
    	OreDictionary.registerOre("oreCompressedLapis", this.clapisOre);
    	OreDictionary.registerOre("oreCompressedRedstone", this.credstoneOre);
    	OreDictionary.registerOre("oreCompressedRedstone_glowing", this.credstoneOre_glowing);
    	OreDictionary.registerOre("oreCompressedDiamond", this.cdiamondOre);
    	OreDictionary.registerOre("oreCompressedEmerald", this.cemeraldOre);
    	
    	OreDictionary.registerOre("oreCompressedCoal", this.dccoalOre);
    	OreDictionary.registerOre("oreCompressedIron", this.dcironOre);
    	OreDictionary.registerOre("oreCompressedGold", this.dcgoldOre);
    	OreDictionary.registerOre("oreCompressedLapis", this.dclapisOre);
    	OreDictionary.registerOre("oreCompressedRedstone", this.dcredstoneOre);
    	OreDictionary.registerOre("oreCompressedRedstone_glowing", this.dcredstoneOre_glowing);
    	OreDictionary.registerOre("oreCompressedDiamond", this.dcdiamondOre);
    	OreDictionary.registerOre("oreCompressedEmerald", this.dcemeraldOre);
    	
    	OreDictionary.registerOre("oreCoal", this.dcoalOre);
    	OreDictionary.registerOre("oreIron", this.dironOre);
    	OreDictionary.registerOre("oreGold", this.dgoldOre);
    	OreDictionary.registerOre("oreLapis", this.dlapisOre);
    	OreDictionary.registerOre("oreRedstone", this.dredstoneOre);
    	OreDictionary.registerOre("oreRedstone_glowing", this.dredstoneOre_glowing);
    	OreDictionary.registerOre("oreDiamond", this.ddiamondOre);
    	OreDictionary.registerOre("oreEmerald", this.demeraldOre);
    	
    	OreDictionary.registerOre("oreCoal", this.ddcoalOre);
    	OreDictionary.registerOre("oreIron", this.ddironOre);
    	OreDictionary.registerOre("oreGold", this.ddgoldOre);
    	OreDictionary.registerOre("oreLapis", this.ddlapisOre);
    	OreDictionary.registerOre("oreRedstone", this.ddredstoneOre);
    	OreDictionary.registerOre("oreRedstone_glowing", this.ddredstoneOre_glowing);
    	OreDictionary.registerOre("oreDiamond", this.dddiamondOre);
    	OreDictionary.registerOre("oreEmerald", this.ddemeraldOre);
        
    	OreDictionary.registerOre("blockFragmentedBedrock", this.fragmentedBedrock);
    	
    	OreDictionary.registerOre("blockSilver", this.silverBlock);
    	
    	OreDictionary.registerOre("blockSapphire", this.sapphireBlock);
    	OreDictionary.registerOre("blockAquamarine", this.aquamarineBlock);
    	OreDictionary.registerOre("blockAmetrine", this.ametrineBlock);  
 
    	OreDictionary.registerOre("oreTenebrium", this.tenebriumOre);
    	OreDictionary.registerOre("blockTenebrium", this.tenebriumBlock);
    	
    	OreDictionary.registerOre("oreForgottenGemstone", this.forgottenGemstoneOre);
    	
    	OreDictionary.registerOre("blockForgottenGemstone", this.forgottenGemstoneBlock);
    	
    	OreDictionary.registerOre("stone", this.deepStone);
    	
    	OreDictionary.registerOre("cobblestone", this.deepCobble);
    	
    	OreDictionary.registerOre("stone", this.darkStone);
    	
    	OreDictionary.registerOre("cobblestone", this.darkStone);
    	
    	OreDictionary.registerOre("stone", this.abandonedStone);
    	
    	OreDictionary.registerOre("cobblestone", this.abandonedStone);
    	
    	OreDictionary.registerOre("oreProfundium", this.profundiumOre);
    	OreDictionary.registerOre("blockProfundium", this.profundiumBlock);
    	
    	OreDictionary.registerOre("oreVesperite", this.vesperiteOre);
    	OreDictionary.registerOre("blockVesperite", this.vesperiteBlock);
    	
    	OreDictionary.registerOre("oreEvanescite", this.evanesciteOre);
    	OreDictionary.registerOre("blockEvanescite", this.evanesciteBlock);
    	
    	OreDictionary.registerOre("oreCoal", this.dpcoalOre);
    	OreDictionary.registerOre("oreIron", this.dpironOre);
    	OreDictionary.registerOre("oreGold", this.dpgoldOre);
    	OreDictionary.registerOre("oreLapis", this.dplapisOre);
    	OreDictionary.registerOre("oreRedstone", this.dpredstoneOre);
    	OreDictionary.registerOre("oreRedstone_glowing", this.dpredstoneOre_glowing);
    	OreDictionary.registerOre("oreDiamond", this.dpdiamondOre);
    	OreDictionary.registerOre("oreEmerald", this.dpemeraldOre);
    	
    	OreDictionary.registerOre("oreRuby", this.rubyOre);
    	
    	OreDictionary.registerOre("blockRuby", this.rubyBlock);
    }
    public void setupBlocks()
    {
        
        this.silverOre = new BlockBase(Material.rock).setBlockTextureName("deepercaves:silver_ore").setBlockName("silverOre").setHardness(3.0F).setResistance(5.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.rubyOre = new BlockOreBase(Material.rock, DeeperCaves.items.ruby, 1, 1, true, 5, 8).setBlockTextureName("deepercaves:ruby_ore").setBlockName("ruby_ore").setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dropPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.dropDimID).setBlockName("dropPortal").setHardness(3.5F).setResistance(10000000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        this.returnPortal = new BlockReturnPortal(Material.rock).setBlockName("returnPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.mazePortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.mazeDimID).setBlockName("mazePortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.crystalPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.crystalDimID).setBlockName("crystalPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.compressedPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.compressedDimID).setBlockName("compressedPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.bedrockPlainsPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.finalLabyrinthDimID).setBlockName("bedrockPlainsPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        
        this.nearNetherPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.nearNetherDimID).setBlockName("nearNetherPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.lavaPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.lavaDimID).setBlockName("lavaPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.nearVoidPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.nearVoidDimID).setBlockName("nearVoidPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        
        this.deepWorldPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.deepWorldDimID).setBlockName("deepWorldPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.darknessPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.darknessDimID).setBlockName("darknessPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.abandonedCavesPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.abandonedCavesDimID).setBlockName("abandonedCavesPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        
        this.mutationPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.mutationDimID).setBlockName("mutationPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        
        this.farVoidPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.farVoidDimID).setBlockName("farVoidPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        
        this.forgottenPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.forgottenDimID).setBlockName("forgottenPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        
        this.evilPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.evilDimID).setBlockName("evilPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        this.finalLabyrinthPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.finalLabyrinthDimID).setBlockName("finalLabyrinthPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        
        this.sapphireOre = new BlockOreBase(Material.rock, DeeperCaves.items.sapphireGem, 1, 1, true, 3, 6).setBlockTextureName("deepercaves:sapphire_ore").setBlockName("sapphireOre").setHardness(3.0F).setResistance(5.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.aquamarineOre = new BlockOreBase(Material.rock, DeeperCaves.items.aquamarine, 3, 3, true, 3, 6).setBlockTextureName("deepercaves:aquamarineOre").setBlockName("aquamarineOre").setHardness(3.0F).setResistance(5.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);     
        this.ametrineOre = new BlockOreBase(Material.rock, DeeperCaves.items.ametrineGem, 1, 1, true, 5, 8).setBlockTextureName("deepercaves:ametrine").setBlockName("ametrineOre").setHardness(4.5F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        this.ccoalOre = new BlockCompressedOre(Material.rock, Blocks.coal_ore).setBlockTextureName("deepercaves:ccoal_ore").setBlockName("ccoalOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.cironOre = new BlockCompressedOre(Material.rock, Blocks.iron_ore).setBlockTextureName("deepercaves:ciron_ore").setBlockName("cironOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.cgoldOre = new BlockCompressedOre(Material.rock, Blocks.gold_ore).setBlockTextureName("deepercaves:cgold_ore").setBlockName("cgoldOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.clapisOre = new BlockCompressedOre(Material.rock, Blocks.lapis_ore).setBlockTextureName("deepercaves:clapis_ore").setBlockName("clapisOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.credstoneOre = new BlockCompressedRedstoneOre(false).setBlockTextureName("deepercaves:credstone_ore").setBlockName("credstoneOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.credstoneOre_glowing = new BlockCompressedRedstoneOre(true).setBlockTextureName("deepercaves:credstone_ore").setBlockName("credstoneOre").setHardness(6.0F).setResistance(10.0F).setLightLevel(0.625F);
        this.cdiamondOre = new BlockCompressedOre(Material.rock, Blocks.diamond_ore).setBlockTextureName("deepercaves:cdiamond_ore").setBlockName("cdiamondOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.cemeraldOre = new BlockCompressedOre(Material.rock, Blocks.emerald_ore).setBlockTextureName("deepercaves:cemerald_ore").setBlockName("cemeraldOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        this.dccoalOre = new BlockCompressedOre(Material.rock, Blocks.coal_ore).setBlockTextureName("deepercaves:dccoal_ore").setBlockName("dccoalOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dcironOre = new BlockCompressedOre(Material.rock, Blocks.iron_ore).setBlockTextureName("deepercaves:dciron_ore").setBlockName("dcironOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dcgoldOre = new BlockCompressedOre(Material.rock, Blocks.gold_ore).setBlockTextureName("deepercaves:dcgold_ore").setBlockName("dcgoldOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dclapisOre = new BlockCompressedOre(Material.rock, Blocks.lapis_ore).setBlockTextureName("deepercaves:dclapis_ore").setBlockName("dclapisOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dcredstoneOre = new BlockCompressedRedstoneOre(false).setBlockTextureName("deepercaves:dcredstone_ore").setBlockName("dcredstoneOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dcredstoneOre_glowing = new BlockCompressedRedstoneOre(true).setBlockTextureName("deepercaves:dcredstone_ore").setBlockName("dcredstoneOre").setHardness(14.0F).setResistance(14.0F).setLightLevel(0.625F);
        this.dcdiamondOre = new BlockCompressedOre(Material.rock, Blocks.diamond_ore).setBlockTextureName("deepercaves:dcdiamond_ore").setBlockName("dcdiamondOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dcemeraldOre = new BlockCompressedOre(Material.rock, Blocks.emerald_ore).setBlockTextureName("deepercaves:dcemerald_ore").setBlockName("dcemeraldOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        this.dcsilverOre = new BlockCompressedOre(Material.rock, DeeperCaves.blocks.silverOre).setBlockTextureName("deepercaves:dcsilver_ore").setBlockName("dcsilverOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dcsapphireOre = new BlockCompressedOre(Material.rock, DeeperCaves.blocks.sapphireOre).setBlockTextureName("deepercaves:dcsapphire_ore").setBlockName("dcsapphireOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dcaquamarineOre = new BlockCompressedOre(Material.rock, DeeperCaves.blocks.aquamarineOre).setBlockTextureName("deepercaves:dcaquamarine_ore").setBlockName("dcaquamarineOre").setHardness(14.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dcrubyOre = new BlockCompressedOre(Material.rock, DeeperCaves.blocks.rubyOre).setBlockTextureName("deepercaves:dcruby_ore").setBlockName("dcrubyOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        this.csilverOre = new BlockCompressedOre(Material.rock, DeeperCaves.blocks.silverOre).setBlockTextureName("deepercaves:csilver_ore").setBlockName("csilverOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.csapphireOre = new BlockCompressedOre(Material.rock, DeeperCaves.blocks.sapphireOre).setBlockTextureName("deepercaves:csapphire_ore").setBlockName("csapphireOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.caquamarineOre = new BlockCompressedOre(Material.rock, DeeperCaves.blocks.aquamarineOre).setBlockTextureName("deepercaves:caquamarine_ore").setBlockName("caquamarineOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.crubyOre = new BlockCompressedOre(Material.rock, DeeperCaves.blocks.rubyOre).setBlockTextureName("deepercaves:cruby_ore").setBlockName("crubyOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        this.dcoalOre = new BlockVanillaOre(Material.rock, Blocks.coal_ore).setBlockTextureName("deepercaves:dcoal_ore").setBlockName("dcoalOre").setHardness(5.0F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dironOre = new BlockVanillaOre(Material.rock, Blocks.iron_ore).setBlockTextureName("deepercaves:diron_ore").setBlockName("dironOre").setHardness(5.0F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dgoldOre = new BlockVanillaOre(Material.rock, Blocks.gold_ore).setBlockTextureName("deepercaves:dgold_ore").setBlockName("dgoldOre").setHardness(5.0F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dlapisOre = new BlockVanillaOre(Material.rock, Blocks.lapis_ore).setBlockTextureName("deepercaves:dlapis_ore").setBlockName("dlapisOre").setHardness(5.0F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dredstoneOre = new BlockVanillaRedstoneOre(false).setBlockTextureName("deepercaves:dredstone_ore").setBlockName("dredstoneOre").setHardness(5.0F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dredstoneOre_glowing = new BlockVanillaRedstoneOre(true).setBlockTextureName("deepercaves:dredstone_ore").setBlockName("dredstoneOre").setHardness(5.0F).setResistance(6.0F).setLightLevel(0.625F);
        this.ddiamondOre = new BlockVanillaOre(Material.rock, Blocks.diamond_ore).setBlockTextureName("deepercaves:ddiamond_ore").setBlockName("ddiamondOre").setHardness(5.0F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.demeraldOre = new BlockVanillaOre(Material.rock, Blocks.emerald_ore).setBlockTextureName("deepercaves:demerald_ore").setBlockName("demeraldOre").setHardness(5.0F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        this.ddcoalOre = new BlockVanillaOre(Material.rock, Blocks.coal_ore).setBlockTextureName("deepercaves:ddcoal_ore").setBlockName("ddcoalOre").setHardness(9.0F).setResistance(7.5F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.ddironOre = new BlockVanillaOre(Material.rock, Blocks.iron_ore).setBlockTextureName("deepercaves:ddiron_ore").setBlockName("ddironOre").setHardness(9.0F).setResistance(7.5F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.ddgoldOre = new BlockVanillaOre(Material.rock, Blocks.gold_ore).setBlockTextureName("deepercaves:ddgold_ore").setBlockName("ddgoldOre").setHardness(9.0F).setResistance(7.5F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.ddlapisOre = new BlockVanillaOre(Material.rock, Blocks.lapis_ore).setBlockTextureName("deepercaves:ddlapis_ore").setBlockName("ddlapisOre").setHardness(9.0F).setResistance(7.5F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.ddredstoneOre = new BlockVanillaRedstoneOre(false).setBlockTextureName("deepercaves:ddredstone_ore").setBlockName("ddredstoneOre").setHardness(9.0F).setResistance(7.5F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.ddredstoneOre_glowing = new BlockVanillaRedstoneOre(true).setBlockTextureName("deepercaves:ddredstone_ore").setBlockName("ddredstoneOre").setHardness(9.0F).setResistance(7.5F).setLightLevel(0.625F);
        this.dddiamondOre = new BlockVanillaOre(Material.rock, Blocks.diamond_ore).setBlockTextureName("deepercaves:dddiamond_ore").setBlockName("dddiamondOre").setHardness(9.0F).setResistance(7.5F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.ddemeraldOre = new BlockVanillaOre(Material.rock, Blocks.emerald_ore).setBlockTextureName("deepercaves:ddemerald_ore").setBlockName("ddemeraldOre").setHardness(9.0F).setResistance(7.5F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        this.fragmentedBedrock = new BlockFragmentedBedrock(Material.rock).setBlockTextureName("deepercaves:fragmented_bedrock").setBlockName("fragmentedBedrock").setHardness(45.5F).setResistance(1500000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.silverBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:silver_block").setBlockName("silverBlock").setHardness(5.0F).setResistance(12.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.sapphireBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:sapphireBlock").setBlockName("sapphire_block").setHardness(5.0F).setResistance(12.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        this.aquamarineBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:aquamarine_block").setBlockName("aquamarine_block").setHardness(4.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        this.ametrineBlock = new BlockAmetrine(Material.rock).setBlockName("ametrineBlock").setHardness(7.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.tenebriumOre = new BlockBase(Material.rock).setBlockTextureName("deepercaves:tenebrium").setBlockName("tenebrium_ore").setHardness(8.5F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.tenebriumBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:tenebriumBlock").setBlockName("tenebrium_block").setHardness(10.5F).setResistance(20.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.forgottenGemstoneOre = new BlockFragmentedBedrockOre(Material.rock, DeeperCaves.items.forgottenGemstone, 1, 1, true, 7, 10).setBlockTextureName("deepercaves:forgotten_gemstone_ore").setBlockName("forgottenGemstoneOre").setHardness(45.5F).setResistance(1500000.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        this.fakeBedrock = new BlockFakeBedrock(Material.rock).setBlockTextureName("minecraft:bedrock").setBlockName("fakeBedrock").setHardness(45.5F).setResistance(1500000.0F).setBlockUnbreakable().setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.forgottenGemstoneBlock = new BlockFakeBedrock(Material.rock).setBlockTextureName("deepercaves:forgotten_gemstone_block").setBlockName("forgottenGemstoneBlock").setHardness(45.5F).setResistance(1500000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.barrierLayer = new BlockBase(Material.rock).setBlockTextureName("deepercaves:barrier_layer").setBlockName("barrierLayer").setHardness(45.5F).setResistance(1500000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves).setBlockUnbreakable();
        
        this.darkStone = new BlockBase(Material.rock).setBlockTextureName("deepercaves:dark_stone").setBlockName("darkStone").setHardness(4.5F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves); //dark stone
        
        this.vesperiteOre = new BlockOreBase(Material.rock, DeeperCaves.items.vesperiteGem, 1, 1, true, 5, 8).setBlockTextureName("deepercaves:vesperite_ore").setBlockName("vesperiteOre").setHardness(9.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        this.abandonedStone = new BlockBase(Material.rock).setBlockTextureName("deepercaves:abandoned_stone").setBlockName("abandonedCavesStone").setHardness(2.5F).setResistance(12.0F).setCreativeTab(DeeperCaves.tabDeeperCaves); //abandoned stone
        
        this.deepStone = new BlockDeepStone().setBlockTextureName("deepercaves:deep_stone").setBlockName("deepStone").setHardness(3.5F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCaves); //deep stone
        
        this.cooledObsidian = new BlockBase(Material.rock).setBlockTextureName("deepercaves:cooled_obsidian").setBlockName("cooledObsidian").setHardness(85.0F).setResistance(8000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.heatedObsidian = new BlockBase(Material.rock).setBlockTextureName("deepercaves:heated_obsidian").setBlockName("heatedObsidian").setHardness(30.0F).setResistance(4000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.vesperiteBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:vesperite_block").setBlockName("vesperiteBlock").setHardness(5.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.deepCobble = new BlockBase(Material.rock).setBlockTextureName("deepercaves:deep_cobblestone").setBlockName("deepCobble").setHardness(3.5F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.fragmentedCobble = new BlockBase(Material.rock).setBlockTextureName("deepercaves:fragmented_cobblestone").setBlockName("fragmentedCobble").setHardness(3.5F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCaves); //!!!
        
        this.soulStone = new BlockBase(Material.rock).setBlockTextureName("deepercaves:soul_stone").setBlockName("soulStone").setHardness(4.0F).setResistance(13.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.corruptedSoulStone = new BlockBase(Material.rock).setBlockTextureName("deepercaves:corrupted_soul_stone").setBlockName("corruptedSoulStone").setHardness(3.0F).setResistance(12.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.cryingObsidian = new BlockCryingObsidian(Material.rock).setBlockTextureName("deepercaves:crying_obsidian").setBlockName("cryingObsidian").setHardness(60.0F).setResistance(6000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.profundiumOre = new BlockBase(Material.rock).setBlockTextureName("deepercaves:profundium_ore").setBlockName("profundiumOre").setHardness(8.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        this.profundiumBlock = new BlockProfundium(Material.rock).setBlockTextureName("deepercaves:profundium_block").setBlockName("profundiumBlock").setHardness(6.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.evanesciteOre = new BlockOreBase(Material.rock, DeeperCaves.items.evanesciteGem, 1, 1, true, 3, 6).setBlockTextureName("deepercaves:evanescite_ore").setBlockName("evanesciteOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        this.evanesciteBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:evanescite_block").setBlockName("evanesciteBlock").setHardness(6.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.dpcoalOre = new BlockVanillaOre(Material.rock, Blocks.coal_ore).setBlockTextureName("deepercaves:dpcoal_ore").setBlockName("dpcoalOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dpironOre = new BlockVanillaOre(Material.rock, Blocks.iron_ore).setBlockTextureName("deepercaves:dpiron_ore").setBlockName("dpironOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dpgoldOre = new BlockVanillaOre(Material.rock, Blocks.gold_ore).setBlockTextureName("deepercaves:dpgold_ore").setBlockName("dpgoldOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dplapisOre = new BlockVanillaOre(Material.rock, Blocks.lapis_ore).setBlockTextureName("deepercaves:dplapis_ore").setBlockName("dplapisOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dpredstoneOre = new BlockVanillaRedstoneOre(false).setBlockTextureName("deepercaves:dpredstone_ore").setBlockName("dpredstoneOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dpredstoneOre_glowing = new BlockVanillaRedstoneOre(true).setBlockTextureName("deepercaves:dpredstone_ore").setBlockName("dpredstoneOre").setHardness(7.0F).setResistance(7.0F).setLightLevel(0.625F);
        this.dpdiamondOre = new BlockVanillaOre(Material.rock, Blocks.diamond_ore).setBlockTextureName("deepercaves:dpdiamond_ore").setBlockName("dpdiamondOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        this.dpemeraldOre = new BlockVanillaOre(Material.rock, Blocks.emerald_ore).setBlockTextureName("deepercaves:dpemerald_ore").setBlockName("dpemeraldOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        this.crystal = new BlockCrystal(Material.glass).setBlockName("crystal").setLightOpacity(0).setHardness(1.0F).setResistance(2.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.rubyBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:rubyBlock").setBlockName("ruby_block").setLightOpacity(0).setHardness(3.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);

        this.magmaStone = new BlockMagmaStone(Material.rock).setBlockTextureName("deepercaves:magma_stone").setBlockName("magma_stone").setLightOpacity(0).setHardness(1.2F).setResistance(5.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.rottenPlanks = new BlockBase(Material.wood).setBlockTextureName("deepercaves:rotting_planks").setBlockName("rotten_planks").setLightOpacity(0).setHardness(1.2F).setResistance(5.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        this.rustedBars = new BlockRustedBars("deepercaves:rusty_bars", "deepercaves:rusty_bars", Material.iron, true).setBlockTextureName("deepercaves:rusty_bars").setBlockName("rusted_iron_bars").setLightOpacity(0).setHardness(1.2F).setResistance(5.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
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
        
        this.dccoalOre.setHarvestLevel("pickaxe", 1);
        this.dcironOre.setHarvestLevel("pickaxe", 2);
        this.dcgoldOre.setHarvestLevel("pickaxe", 3);
        this.dclapisOre.setHarvestLevel("pickaxe", 2);
        this.dcredstoneOre.setHarvestLevel("pickaxe", 3);
        this.dcredstoneOre_glowing.setHarvestLevel("pickaxe", 3);
        this.dcdiamondOre.setHarvestLevel("pickaxe", 3);
        this.dcemeraldOre.setHarvestLevel("pickaxe", 3);
        
        this.dcsilverOre.setHarvestLevel("pickaxe", 3);
        this.dcsapphireOre.setHarvestLevel("pickaxe", 3);
        this.dcaquamarineOre.setHarvestLevel("pickaxe", 3);
        this.dcrubyOre.setHarvestLevel("pickaxe", 3);
        
        this.csilverOre.setHarvestLevel("pickaxe", 3);
        this.csapphireOre.setHarvestLevel("pickaxe", 3);
        this.caquamarineOre.setHarvestLevel("pickaxe", 3);
        this.crubyOre.setHarvestLevel("pickaxe", 3);
        
        this.ddcoalOre.setHarvestLevel("pickaxe", 0);
        this.ddironOre.setHarvestLevel("pickaxe", 1);
        this.ddgoldOre.setHarvestLevel("pickaxe", 2);
        this.ddlapisOre.setHarvestLevel("pickaxe", 1);
        this.ddredstoneOre.setHarvestLevel("pickaxe", 2);
        this.ddredstoneOre_glowing.setHarvestLevel("pickaxe", 2);
        this.dddiamondOre.setHarvestLevel("pickaxe", 2);
        this.ddemeraldOre.setHarvestLevel("pickaxe", 2);
        
        this.fragmentedBedrock.setHarvestLevel("pickaxe", 4);
        
        this.tenebriumOre.setHarvestLevel("pickaxe", 4);
        this.tenebriumBlock.setHarvestLevel("pickaxe", 4);
      
        this.forgottenGemstoneOre.setHarvestLevel("pickaxe", 4);
        
        this.forgottenGemstoneBlock.setHarvestLevel("pickaxe", 4);
        
        this.vesperiteOre.setHarvestLevel("pickaxe", 3);
        this.vesperiteBlock.setHarvestLevel("pickaxe", 3);
        
        this.cooledObsidian.setHarvestLevel("pickaxe", 4);
        this.heatedObsidian.setHarvestLevel("pickaxe", 2);
        
        this.darkStone.setHarvestLevel("pickaxe", 1);
        this.abandonedStone.setHarvestLevel("pickaxe", 1);
        this.deepStone.setHarvestLevel("pickaxe", 2);
        
        this.cryingObsidian.setHarvestLevel("pickaxe", 3);
        this.soulStone.setHarvestLevel("pickaxe", 2);
        this.corruptedSoulStone.setHarvestLevel("pickaxe", 2);
        
        this.fragmentedCobble.setHarvestLevel("pickaxe", 0);
        
        this.profundiumOre.setHarvestLevel("pickaxe", 4);
        this.profundiumBlock.setHarvestLevel("pickaxe", 4);
        
        this.evanesciteOre.setHarvestLevel("pickaxe", 3);
        this.evanesciteBlock.setHarvestLevel("pickaxe", 3);

        this.dcoalOre.setHarvestLevel("pickaxe", 0);
        this.dironOre.setHarvestLevel("pickaxe", 1);
        this.dgoldOre.setHarvestLevel("pickaxe", 2);
        this.dlapisOre.setHarvestLevel("pickaxe", 1);
        this.dredstoneOre.setHarvestLevel("pickaxe", 2);
        this.dredstoneOre_glowing.setHarvestLevel("pickaxe", 2);
        this.ddiamondOre.setHarvestLevel("pickaxe", 2);
        this.demeraldOre.setHarvestLevel("pickaxe", 2);
        
        this.dpcoalOre.setHarvestLevel("pickaxe", 0);
        this.dpironOre.setHarvestLevel("pickaxe", 1);
        this.dpgoldOre.setHarvestLevel("pickaxe", 2);
        this.dplapisOre.setHarvestLevel("pickaxe", 1);
        this.dpredstoneOre.setHarvestLevel("pickaxe", 2);
        this.dpredstoneOre_glowing.setHarvestLevel("pickaxe", 2);
        this.dpdiamondOre.setHarvestLevel("pickaxe", 2);
        this.dpemeraldOre.setHarvestLevel("pickaxe", 2);
        
        this.crystal.setHarvestLevel("pickaxe", 0);
        
        this.dropPortal.setHarvestLevel("pickaxe", 0);
        
        this.rubyOre.setHarvestLevel("pickaxe", 2);
        this.rubyBlock.setHarvestLevel("pickaxe", 2);
    }
    
}
