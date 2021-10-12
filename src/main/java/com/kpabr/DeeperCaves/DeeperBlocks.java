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

    public static Block incenditeOre;

    public static Block prisciumOre;

    public static Block robustiumRaw;
    
    public void registerBlocks()
    {
        GameRegistry.registerBlock(DeeperBlocks.silverOre, "silver_ore");
        GameRegistry.registerBlock(DeeperBlocks.dropPortal, "drop_portal");
        GameRegistry.registerBlock(DeeperBlocks.returnPortal, "return_portal");
        GameRegistry.registerBlock(DeeperBlocks.mazePortal, "maze_portal");
        GameRegistry.registerBlock(DeeperBlocks.crystalPortal, "crystal_portal");
        GameRegistry.registerBlock(DeeperBlocks.compressedPortal, "compressed_portal");
        GameRegistry.registerBlock(DeeperBlocks.bedrockPlainsPortal, "bedrock_plains_portal");
        
        GameRegistry.registerBlock(DeeperBlocks.nearNetherPortal, "near_nether_portal");
        GameRegistry.registerBlock(DeeperBlocks.lavaPortal, "lava_portal");
        GameRegistry.registerBlock(DeeperBlocks.nearVoidPortal, "near_void_portal");
        
        GameRegistry.registerBlock(DeeperBlocks.deepWorldPortal, "deep_world_portal");
        GameRegistry.registerBlock(DeeperBlocks.darknessPortal, "darkness_portal");
        GameRegistry.registerBlock(DeeperBlocks.abandonedCavesPortal, "abandoned_caves_portal");
        
        GameRegistry.registerBlock(DeeperBlocks.mutationPortal, "mutation_portal");
        
        GameRegistry.registerBlock(DeeperBlocks.farVoidPortal, "far_void_portal");
        
        GameRegistry.registerBlock(DeeperBlocks.forgottenPortal, "forgotten_portal");
        
        GameRegistry.registerBlock(DeeperBlocks.evilPortal, "evil_portal");
        GameRegistry.registerBlock(DeeperBlocks.finalLabyrinthPortal, "final_labyrinth_portal");
        
        GameRegistry.registerBlock(DeeperBlocks.sapphireOre, "sapphire_ore");
        GameRegistry.registerBlock(DeeperBlocks.aquamarineOre, "aquamarine_ore");
        GameRegistry.registerBlock(DeeperBlocks.ametrineOre, "ametrine_ore");
        
        GameRegistry.registerBlock(DeeperBlocks.ccoalOre, "compressed_coal_ore");
        GameRegistry.registerBlock(DeeperBlocks.cironOre, "compressed_iron_ore");
        GameRegistry.registerBlock(DeeperBlocks.cgoldOre, "compressed_gold_ore");
        GameRegistry.registerBlock(DeeperBlocks.clapisOre, "compressed_lapis_ore");
        GameRegistry.registerBlock(DeeperBlocks.credstoneOre, "compressed_redstone_ore");
        GameRegistry.registerBlock(DeeperBlocks.credstoneOre_glowing, "compressed_redstone_ore_glowing");
        GameRegistry.registerBlock(DeeperBlocks.cdiamondOre, "compressed_diamond_ore");
        GameRegistry.registerBlock(DeeperBlocks.cemeraldOre, "compressed_emerald_ore");
        
        GameRegistry.registerBlock(DeeperBlocks.dccoalOre, "deep_compressed_coal_ore");
        GameRegistry.registerBlock(DeeperBlocks.dcironOre, "deep_compressed_iron_ore");
        GameRegistry.registerBlock(DeeperBlocks.dcgoldOre, "deep_compressed_gold_ore");
        GameRegistry.registerBlock(DeeperBlocks.dclapisOre, "deep_compressed_lapis_ore");
        GameRegistry.registerBlock(DeeperBlocks.dcredstoneOre, "deep_compressed_redstone_ore");
        GameRegistry.registerBlock(DeeperBlocks.dcredstoneOre_glowing, "deep_compressed_redstone_ore_glowing");
        GameRegistry.registerBlock(DeeperBlocks.dcdiamondOre, "deep_compressed_diamond_ore");
        GameRegistry.registerBlock(DeeperBlocks.dcemeraldOre, "deep_compressed_emerald_ore");
        
        GameRegistry.registerBlock(DeeperBlocks.ddcoalOre, "dark_coal_ore");
        GameRegistry.registerBlock(DeeperBlocks.ddironOre, "dark_iron_ore");
        GameRegistry.registerBlock(DeeperBlocks.ddgoldOre, "dark_gold_ore");
        GameRegistry.registerBlock(DeeperBlocks.ddlapisOre, "dark_lapis_ore");
        GameRegistry.registerBlock(DeeperBlocks.ddredstoneOre, "dark_redstone_ore");
        GameRegistry.registerBlock(DeeperBlocks.ddredstoneOre_glowing, "dark_redstone_ore_glowing");
        GameRegistry.registerBlock(DeeperBlocks.dddiamondOre, "dark_diamond_ore");
        GameRegistry.registerBlock(DeeperBlocks.ddemeraldOre, "dark_emerald_ore");
        
        GameRegistry.registerBlock(DeeperBlocks.dcoalOre, "abandoned_caves_coal_ore");
        GameRegistry.registerBlock(DeeperBlocks.dironOre, "abandoned_caves_iron_ore");
        GameRegistry.registerBlock(DeeperBlocks.dgoldOre, "abandoned_caves_gold_ore");
        GameRegistry.registerBlock(DeeperBlocks.dlapisOre, "abandoned_caves_lapis_ore");
        GameRegistry.registerBlock(DeeperBlocks.dredstoneOre, "abandoned_caves_redstone_ore");
        GameRegistry.registerBlock(DeeperBlocks.dredstoneOre_glowing, "abandoned_caves_redstone_ore_glowing");
        GameRegistry.registerBlock(DeeperBlocks.ddiamondOre, "abandoned_caves_diamond_ore");
        GameRegistry.registerBlock(DeeperBlocks.demeraldOre, "abandoned_caves_emerald_ore");
        
        GameRegistry.registerBlock(DeeperBlocks.fragmentedBedrock, "fragmented_bedrock");
        
        GameRegistry.registerBlock(DeeperBlocks.silverBlock, "silver_block");
        
        GameRegistry.registerBlock(DeeperBlocks.sapphireBlock, "sapphire_block");
        GameRegistry.registerBlock(DeeperBlocks.aquamarineBlock, "aquamarine_block");
        GameRegistry.registerBlock(DeeperBlocks.ametrineBlock, "ametrine_block");
        
        GameRegistry.registerBlock(DeeperBlocks.tenebriumOre, "tenebrium_ore"); 
        GameRegistry.registerBlock(DeeperBlocks.tenebriumBlock, "tenebrium_block");
        
        GameRegistry.registerBlock(DeeperBlocks.forgottenGemstoneOre, "forgotten_gemstone_ore");
        
        GameRegistry.registerBlock(DeeperBlocks.fakeBedrock, "fake_bedrock");
        
        GameRegistry.registerBlock(DeeperBlocks.forgottenGemstoneBlock, "forgotten_gemstone_block");
        
        GameRegistry.registerBlock(DeeperBlocks.barrierLayer, "barrier_layer");
        
        GameRegistry.registerBlock(DeeperBlocks.darkStone, "dark_stone");
        
        GameRegistry.registerBlock(DeeperBlocks.vesperiteOre, "vesperite_ore");
        
        GameRegistry.registerBlock(DeeperBlocks.abandonedStone, "abandoned_stone");
        
        GameRegistry.registerBlock(DeeperBlocks.deepStone, "deep_stone");
        
        GameRegistry.registerBlock(DeeperBlocks.cooledObsidian, "supercooled_obsidian");
        GameRegistry.registerBlock(DeeperBlocks.heatedObsidian, "heated_obsidian");
        
        GameRegistry.registerBlock(DeeperBlocks.vesperiteBlock, "vesperite_block");
        
        GameRegistry.registerBlock(DeeperBlocks.deepCobble, "deep_cobblestone");
        
        GameRegistry.registerBlock(DeeperBlocks.fragmentedCobble, "fragmented_cobblestone");
        
        GameRegistry.registerBlock(DeeperBlocks.cryingObsidian, "crying_obsidian");
        
        GameRegistry.registerBlock(DeeperBlocks.soulStone, "soul_stone");
        
        GameRegistry.registerBlock(DeeperBlocks.corruptedSoulStone, "corrupted_soul_stone");
        
        GameRegistry.registerBlock(DeeperBlocks.profundiumOre, "profundium_ore");
        
        GameRegistry.registerBlock(DeeperBlocks.profundiumBlock, "profundium_block");
        
        GameRegistry.registerBlock(DeeperBlocks.evanesciteOre, "evanescite_ore");
        
        GameRegistry.registerBlock(DeeperBlocks.evanesciteBlock, "evanescite_block");
        
        GameRegistry.registerBlock(DeeperBlocks.dpcoalOre, "deep_coal_ore");
        GameRegistry.registerBlock(DeeperBlocks.dpironOre, "deep_iron_ore");
        GameRegistry.registerBlock(DeeperBlocks.dpgoldOre, "deep_gold_ore");
        GameRegistry.registerBlock(DeeperBlocks.dplapisOre, "deep_lapis_ore");
        GameRegistry.registerBlock(DeeperBlocks.dpredstoneOre, "deep_redstone_ore");
        GameRegistry.registerBlock(DeeperBlocks.dpredstoneOre_glowing, "deep_redstone_ore_glowing");
        GameRegistry.registerBlock(DeeperBlocks.dpdiamondOre, "deep_diamond_ore");
        GameRegistry.registerBlock(DeeperBlocks.dpemeraldOre, "deep_emerald_ore");
     
        GameRegistry.registerBlock(DeeperBlocks.crystal, ItemBlockCrystal.class, "crystal");
        
        GameRegistry.registerBlock(DeeperBlocks.rubyOre, "ruby_ore");
        
        GameRegistry.registerBlock(DeeperBlocks.rubyBlock, "ruby_block");
        
        GameRegistry.registerBlock(DeeperBlocks.magmaStone, "magma_stone");
        
        GameRegistry.registerBlock(DeeperBlocks.dcsilverOre, "deep_compressed_silver_ore");
        GameRegistry.registerBlock(DeeperBlocks.dcsapphireOre, "deep_compressed_sapphire_ore");
        GameRegistry.registerBlock(DeeperBlocks.dcaquamarineOre, "deep_compressed_aquamarine_ore");
        GameRegistry.registerBlock(DeeperBlocks.dcrubyOre, "deep_compressed_ruby_ore");
        
        GameRegistry.registerBlock(DeeperBlocks.csilverOre, "compressed_silver_ore");
        GameRegistry.registerBlock(DeeperBlocks.csapphireOre, "compressed_sapphire_ore");
        GameRegistry.registerBlock(DeeperBlocks.caquamarineOre, "compressed_aquamarine_ore");
        GameRegistry.registerBlock(DeeperBlocks.crubyOre, "compressed_ruby_ore");
        
        GameRegistry.registerBlock(DeeperBlocks.rottenPlanks, "rotten_planks");
        GameRegistry.registerBlock(DeeperBlocks.rustedBars, "rusted_iron_bars");

        GameRegistry.registerBlock(DeeperBlocks.incenditeOre, "incendite_ore");
        GameRegistry.registerBlock(DeeperBlocks.prisciumOre, "priscium_ore");

        GameRegistry.registerBlock(DeeperBlocks.robustiumRaw, "raw_robustium");
    }
    public void registerBlocksOreDict()
    {
    	OreDictionary.registerOre("oreSilver", DeeperBlocks.silverOre);
    	
    	OreDictionary.registerOre("oreSapphire", DeeperBlocks.sapphireOre);
    	OreDictionary.registerOre("oreAquamarine", DeeperBlocks.aquamarineOre);
    	OreDictionary.registerOre("oreAmetrine", DeeperBlocks.ametrineOre);
    	
    	OreDictionary.registerOre("oreCompressedCoal", DeeperBlocks.ccoalOre);
    	OreDictionary.registerOre("oreCompressedIron", DeeperBlocks.cironOre);
    	OreDictionary.registerOre("oreCompressedGold", DeeperBlocks.cgoldOre);
    	OreDictionary.registerOre("oreCompressedLapis", DeeperBlocks.clapisOre);
    	OreDictionary.registerOre("oreCompressedRedstone", DeeperBlocks.credstoneOre);
    	OreDictionary.registerOre("oreCompressedRedstone_glowing", DeeperBlocks.credstoneOre_glowing);
    	OreDictionary.registerOre("oreCompressedDiamond", DeeperBlocks.cdiamondOre);
    	OreDictionary.registerOre("oreCompressedEmerald", DeeperBlocks.cemeraldOre);
    	
    	OreDictionary.registerOre("oreCompressedCoal", DeeperBlocks.dccoalOre);
    	OreDictionary.registerOre("oreCompressedIron", DeeperBlocks.dcironOre);
    	OreDictionary.registerOre("oreCompressedGold", DeeperBlocks.dcgoldOre);
    	OreDictionary.registerOre("oreCompressedLapis", DeeperBlocks.dclapisOre);
    	OreDictionary.registerOre("oreCompressedRedstone", DeeperBlocks.dcredstoneOre);
    	OreDictionary.registerOre("oreCompressedRedstone_glowing", DeeperBlocks.dcredstoneOre_glowing);
    	OreDictionary.registerOre("oreCompressedDiamond", DeeperBlocks.dcdiamondOre);
    	OreDictionary.registerOre("oreCompressedEmerald", DeeperBlocks.dcemeraldOre);
    	
    	OreDictionary.registerOre("oreCoal", DeeperBlocks.dcoalOre);
    	OreDictionary.registerOre("oreIron", DeeperBlocks.dironOre);
    	OreDictionary.registerOre("oreGold", DeeperBlocks.dgoldOre);
    	OreDictionary.registerOre("oreLapis", DeeperBlocks.dlapisOre);
    	OreDictionary.registerOre("oreRedstone", DeeperBlocks.dredstoneOre);
    	OreDictionary.registerOre("oreRedstone_glowing", DeeperBlocks.dredstoneOre_glowing);
    	OreDictionary.registerOre("oreDiamond", DeeperBlocks.ddiamondOre);
    	OreDictionary.registerOre("oreEmerald", DeeperBlocks.demeraldOre);
    	
    	OreDictionary.registerOre("oreCoal", DeeperBlocks.ddcoalOre);
    	OreDictionary.registerOre("oreIron", DeeperBlocks.ddironOre);
    	OreDictionary.registerOre("oreGold", DeeperBlocks.ddgoldOre);
    	OreDictionary.registerOre("oreLapis", DeeperBlocks.ddlapisOre);
    	OreDictionary.registerOre("oreRedstone", DeeperBlocks.ddredstoneOre);
    	OreDictionary.registerOre("oreRedstone_glowing", DeeperBlocks.ddredstoneOre_glowing);
    	OreDictionary.registerOre("oreDiamond", DeeperBlocks.dddiamondOre);
    	OreDictionary.registerOre("oreEmerald", DeeperBlocks.ddemeraldOre);
        
    	OreDictionary.registerOre("blockFragmentedBedrock", DeeperBlocks.fragmentedBedrock);
    	
    	OreDictionary.registerOre("blockSilver", DeeperBlocks.silverBlock);
    	
    	OreDictionary.registerOre("blockSapphire", DeeperBlocks.sapphireBlock);
    	OreDictionary.registerOre("blockAquamarine", DeeperBlocks.aquamarineBlock);
    	OreDictionary.registerOre("blockAmetrine", DeeperBlocks.ametrineBlock);  
 
    	OreDictionary.registerOre("oreTenebrium", DeeperBlocks.tenebriumOre);
    	OreDictionary.registerOre("blockTenebrium", DeeperBlocks.tenebriumBlock);
    	
    	OreDictionary.registerOre("oreForgottenGemstone", DeeperBlocks.forgottenGemstoneOre);
    	
    	OreDictionary.registerOre("blockForgottenGemstone", DeeperBlocks.forgottenGemstoneBlock);
    	
    	OreDictionary.registerOre("stone", DeeperBlocks.deepStone);
    	
    	OreDictionary.registerOre("cobblestone", DeeperBlocks.deepCobble);
    	
    	OreDictionary.registerOre("stone", DeeperBlocks.darkStone);
    	
    	OreDictionary.registerOre("cobblestone", DeeperBlocks.darkStone);
    	
    	OreDictionary.registerOre("stone", DeeperBlocks.abandonedStone);
    	
    	OreDictionary.registerOre("cobblestone", DeeperBlocks.abandonedStone);
    	
    	OreDictionary.registerOre("oreProfundium", DeeperBlocks.profundiumOre);
    	OreDictionary.registerOre("blockProfundium", DeeperBlocks.profundiumBlock);
    	
    	OreDictionary.registerOre("oreVesperite", DeeperBlocks.vesperiteOre);
    	OreDictionary.registerOre("blockVesperite", DeeperBlocks.vesperiteBlock);
    	
    	OreDictionary.registerOre("oreEvanescite", DeeperBlocks.evanesciteOre);
    	OreDictionary.registerOre("blockEvanescite", DeeperBlocks.evanesciteBlock);
    	
    	OreDictionary.registerOre("oreCoal", DeeperBlocks.dpcoalOre);
    	OreDictionary.registerOre("oreIron", DeeperBlocks.dpironOre);
    	OreDictionary.registerOre("oreGold", DeeperBlocks.dpgoldOre);
    	OreDictionary.registerOre("oreLapis", DeeperBlocks.dplapisOre);
    	OreDictionary.registerOre("oreRedstone", DeeperBlocks.dpredstoneOre);
    	OreDictionary.registerOre("oreRedstone_glowing", DeeperBlocks.dpredstoneOre_glowing);
    	OreDictionary.registerOre("oreDiamond", DeeperBlocks.dpdiamondOre);
    	OreDictionary.registerOre("oreEmerald", DeeperBlocks.dpemeraldOre);
    	
    	OreDictionary.registerOre("oreRuby", DeeperBlocks.rubyOre);
    	
    	OreDictionary.registerOre("blockRuby", DeeperBlocks.rubyBlock);

        OreDictionary.registerOre("oreIncendite", DeeperBlocks.incenditeOre);
        OreDictionary.registerOre("orePriscium", DeeperBlocks.prisciumOre);

        OreDictionary.registerOre("blockRawRobustium", DeeperBlocks.robustiumRaw);
    }
    public void setupBlocks()
    {
        
        DeeperBlocks.silverOre = new BlockBase(Material.rock).setBlockTextureName("deepercaves:silver_ore").setBlockName("silverOre").setHardness(3.0F).setResistance(5.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.rubyOre = new BlockOreBase(Material.rock, DeeperCaves.items.ruby, 1, 1, true, 5, 8).setBlockTextureName("deepercaves:ruby_ore").setBlockName("ruby_ore").setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dropPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.dropDimID).setBlockName("dropPortal").setHardness(3.5F).setResistance(10000000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        DeeperBlocks.returnPortal = new BlockReturnPortal(Material.rock).setBlockName("returnPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        DeeperBlocks.mazePortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.mazeDimID).setBlockName("mazePortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        DeeperBlocks.crystalPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.crystalDimID).setBlockName("crystalPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        DeeperBlocks.compressedPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.compressedDimID).setBlockName("compressedPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        DeeperBlocks.bedrockPlainsPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.finalLabyrinthDimID).setBlockName("bedrockPlainsPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        
        DeeperBlocks.nearNetherPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.nearNetherDimID).setBlockName("nearNetherPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        DeeperBlocks.lavaPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.lavaDimID).setBlockName("lavaPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        DeeperBlocks.nearVoidPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.nearVoidDimID).setBlockName("nearVoidPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        
        DeeperBlocks.deepWorldPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.deepWorldDimID).setBlockName("deepWorldPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        DeeperBlocks.darknessPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.darknessDimID).setBlockName("darknessPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        DeeperBlocks.abandonedCavesPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.abandonedCavesDimID).setBlockName("abandonedCavesPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        
        DeeperBlocks.mutationPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.mutationDimID).setBlockName("mutationPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        
        DeeperBlocks.farVoidPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.farVoidDimID).setBlockName("farVoidPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        
        DeeperBlocks.forgottenPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.forgottenDimID).setBlockName("forgottenPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        
        DeeperBlocks.evilPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.evilDimID).setBlockName("evilPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        DeeperBlocks.finalLabyrinthPortal = new BlockDeeperPortal(Material.rock, DeeperCaves.worldgen.finalLabyrinthDimID).setBlockName("finalLabyrinthPortal").setHardness(3.5F).setResistance(10000000.0F).setBlockUnbreakable();
        
        DeeperBlocks.sapphireOre = new BlockOreBase(Material.rock, DeeperCaves.items.sapphireGem, 1, 1, true, 3, 6).setBlockTextureName("deepercaves:sapphire_ore").setBlockName("sapphireOre").setHardness(3.0F).setResistance(5.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.aquamarineOre = new BlockOreBase(Material.rock, DeeperCaves.items.aquamarine, 3, 3, true, 3, 6).setBlockTextureName("deepercaves:aquamarineOre").setBlockName("aquamarineOre").setHardness(3.0F).setResistance(5.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);     
        DeeperBlocks.ametrineOre = new BlockOreBase(Material.rock, DeeperCaves.items.ametrineGem, 1, 1, true, 5, 8).setBlockTextureName("deepercaves:ametrine").setBlockName("ametrineOre").setHardness(4.5F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        DeeperBlocks.ccoalOre = new BlockCompressedOre(Material.rock, Blocks.coal_ore).setBlockTextureName("deepercaves:ccoal_ore").setBlockName("ccoalOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.cironOre = new BlockCompressedOre(Material.rock, Blocks.iron_ore).setBlockTextureName("deepercaves:ciron_ore").setBlockName("cironOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.cgoldOre = new BlockCompressedOre(Material.rock, Blocks.gold_ore).setBlockTextureName("deepercaves:cgold_ore").setBlockName("cgoldOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.clapisOre = new BlockCompressedOre(Material.rock, Blocks.lapis_ore).setBlockTextureName("deepercaves:clapis_ore").setBlockName("clapisOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.credstoneOre = new BlockCompressedRedstoneOre(false).setBlockTextureName("deepercaves:credstone_ore").setBlockName("credstoneOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.credstoneOre_glowing = new BlockCompressedRedstoneOre(true).setBlockTextureName("deepercaves:credstone_ore").setBlockName("credstoneOre").setHardness(6.0F).setResistance(10.0F).setLightLevel(0.625F);
        DeeperBlocks.cdiamondOre = new BlockCompressedOre(Material.rock, Blocks.diamond_ore).setBlockTextureName("deepercaves:cdiamond_ore").setBlockName("cdiamondOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.cemeraldOre = new BlockCompressedOre(Material.rock, Blocks.emerald_ore).setBlockTextureName("deepercaves:cemerald_ore").setBlockName("cemeraldOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        DeeperBlocks.dccoalOre = new BlockCompressedOre(Material.rock, Blocks.coal_ore).setBlockTextureName("deepercaves:dccoal_ore").setBlockName("dccoalOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dcironOre = new BlockCompressedOre(Material.rock, Blocks.iron_ore).setBlockTextureName("deepercaves:dciron_ore").setBlockName("dcironOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dcgoldOre = new BlockCompressedOre(Material.rock, Blocks.gold_ore).setBlockTextureName("deepercaves:dcgold_ore").setBlockName("dcgoldOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dclapisOre = new BlockCompressedOre(Material.rock, Blocks.lapis_ore).setBlockTextureName("deepercaves:dclapis_ore").setBlockName("dclapisOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dcredstoneOre = new BlockCompressedRedstoneOre(false).setBlockTextureName("deepercaves:dcredstone_ore").setBlockName("dcredstoneOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dcredstoneOre_glowing = new BlockCompressedRedstoneOre(true).setBlockTextureName("deepercaves:dcredstone_ore").setBlockName("dcredstoneOre").setHardness(14.0F).setResistance(14.0F).setLightLevel(0.625F);
        DeeperBlocks.dcdiamondOre = new BlockCompressedOre(Material.rock, Blocks.diamond_ore).setBlockTextureName("deepercaves:dcdiamond_ore").setBlockName("dcdiamondOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dcemeraldOre = new BlockCompressedOre(Material.rock, Blocks.emerald_ore).setBlockTextureName("deepercaves:dcemerald_ore").setBlockName("dcemeraldOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        DeeperBlocks.dcsilverOre = new BlockCompressedOre(Material.rock, DeeperBlocks.silverOre).setBlockTextureName("deepercaves:dcsilver_ore").setBlockName("dcsilverOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dcsapphireOre = new BlockCompressedOre(Material.rock, DeeperBlocks.sapphireOre).setBlockTextureName("deepercaves:dcsapphire_ore").setBlockName("dcsapphireOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dcaquamarineOre = new BlockCompressedOre(Material.rock, DeeperBlocks.aquamarineOre).setBlockTextureName("deepercaves:dcaquamarine_ore").setBlockName("dcaquamarineOre").setHardness(14.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dcrubyOre = new BlockCompressedOre(Material.rock, DeeperBlocks.rubyOre).setBlockTextureName("deepercaves:dcruby_ore").setBlockName("dcrubyOre").setHardness(14.0F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        DeeperBlocks.csilverOre = new BlockCompressedOre(Material.rock, DeeperBlocks.silverOre).setBlockTextureName("deepercaves:csilver_ore").setBlockName("csilverOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.csapphireOre = new BlockCompressedOre(Material.rock, DeeperBlocks.sapphireOre).setBlockTextureName("deepercaves:csapphire_ore").setBlockName("csapphireOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.caquamarineOre = new BlockCompressedOre(Material.rock, DeeperBlocks.aquamarineOre).setBlockTextureName("deepercaves:caquamarine_ore").setBlockName("caquamarineOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.crubyOre = new BlockCompressedOre(Material.rock, DeeperBlocks.rubyOre).setBlockTextureName("deepercaves:cruby_ore").setBlockName("crubyOre").setHardness(6.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        DeeperBlocks.dcoalOre = new BlockVanillaOre(Material.rock, Blocks.coal_ore).setBlockTextureName("deepercaves:dcoal_ore").setBlockName("dcoalOre").setHardness(5.0F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dironOre = new BlockVanillaOre(Material.rock, Blocks.iron_ore).setBlockTextureName("deepercaves:diron_ore").setBlockName("dironOre").setHardness(5.0F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dgoldOre = new BlockVanillaOre(Material.rock, Blocks.gold_ore).setBlockTextureName("deepercaves:dgold_ore").setBlockName("dgoldOre").setHardness(5.0F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dlapisOre = new BlockVanillaOre(Material.rock, Blocks.lapis_ore).setBlockTextureName("deepercaves:dlapis_ore").setBlockName("dlapisOre").setHardness(5.0F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dredstoneOre = new BlockVanillaRedstoneOre(false).setBlockTextureName("deepercaves:dredstone_ore").setBlockName("dredstoneOre").setHardness(5.0F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dredstoneOre_glowing = new BlockVanillaRedstoneOre(true).setBlockTextureName("deepercaves:dredstone_ore").setBlockName("dredstoneOre").setHardness(5.0F).setResistance(6.0F).setLightLevel(0.625F);
        DeeperBlocks.ddiamondOre = new BlockVanillaOre(Material.rock, Blocks.diamond_ore).setBlockTextureName("deepercaves:ddiamond_ore").setBlockName("ddiamondOre").setHardness(5.0F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.demeraldOre = new BlockVanillaOre(Material.rock, Blocks.emerald_ore).setBlockTextureName("deepercaves:demerald_ore").setBlockName("demeraldOre").setHardness(5.0F).setResistance(6.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        DeeperBlocks.ddcoalOre = new BlockVanillaOre(Material.rock, Blocks.coal_ore).setBlockTextureName("deepercaves:ddcoal_ore").setBlockName("ddcoalOre").setHardness(9.0F).setResistance(7.5F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.ddironOre = new BlockVanillaOre(Material.rock, Blocks.iron_ore).setBlockTextureName("deepercaves:ddiron_ore").setBlockName("ddironOre").setHardness(9.0F).setResistance(7.5F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.ddgoldOre = new BlockVanillaOre(Material.rock, Blocks.gold_ore).setBlockTextureName("deepercaves:ddgold_ore").setBlockName("ddgoldOre").setHardness(9.0F).setResistance(7.5F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.ddlapisOre = new BlockVanillaOre(Material.rock, Blocks.lapis_ore).setBlockTextureName("deepercaves:ddlapis_ore").setBlockName("ddlapisOre").setHardness(9.0F).setResistance(7.5F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.ddredstoneOre = new BlockVanillaRedstoneOre(false).setBlockTextureName("deepercaves:ddredstone_ore").setBlockName("ddredstoneOre").setHardness(9.0F).setResistance(7.5F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.ddredstoneOre_glowing = new BlockVanillaRedstoneOre(true).setBlockTextureName("deepercaves:ddredstone_ore").setBlockName("ddredstoneOre").setHardness(9.0F).setResistance(7.5F).setLightLevel(0.625F);
        DeeperBlocks.dddiamondOre = new BlockVanillaOre(Material.rock, Blocks.diamond_ore).setBlockTextureName("deepercaves:dddiamond_ore").setBlockName("dddiamondOre").setHardness(9.0F).setResistance(7.5F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.ddemeraldOre = new BlockVanillaOre(Material.rock, Blocks.emerald_ore).setBlockTextureName("deepercaves:ddemerald_ore").setBlockName("ddemeraldOre").setHardness(9.0F).setResistance(7.5F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        DeeperBlocks.fragmentedBedrock = new BlockFragmentedBedrock(Material.rock).setBlockTextureName("deepercaves:fragmented_bedrock").setBlockName("fragmentedBedrock").setHardness(45.5F).setResistance(1500000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.silverBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:silver_block").setBlockName("silverBlock").setHardness(5.0F).setResistance(12.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.sapphireBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:sapphireBlock").setBlockName("sapphire_block").setHardness(5.0F).setResistance(12.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        DeeperBlocks.aquamarineBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:aquamarine_block").setBlockName("aquamarine_block").setHardness(4.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        DeeperBlocks.ametrineBlock = new BlockAmetrine(Material.rock).setBlockName("ametrineBlock").setHardness(7.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.tenebriumOre = new BlockBase(Material.rock).setBlockTextureName("deepercaves:tenebrium").setBlockName("tenebrium_ore").setHardness(8.5F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.tenebriumBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:tenebriumBlock").setBlockName("tenebrium_block").setHardness(10.5F).setResistance(20.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.forgottenGemstoneOre = new BlockFragmentedBedrockOre(Material.rock, DeeperCaves.items.forgottenGemstone, 1, 1, true, 7, 10).setBlockTextureName("deepercaves:forgotten_gemstone_ore").setBlockName("forgottenGemstoneOre").setHardness(45.5F).setResistance(1500000.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        DeeperBlocks.fakeBedrock = new BlockFakeBedrock(Material.rock).setBlockTextureName("minecraft:bedrock").setBlockName("fakeBedrock").setHardness(45.5F).setResistance(1500000.0F).setBlockUnbreakable().setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.forgottenGemstoneBlock = new BlockFakeBedrock(Material.rock).setBlockTextureName("deepercaves:forgotten_gemstone_block").setBlockName("forgottenGemstoneBlock").setHardness(45.5F).setResistance(1500000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.barrierLayer = new BlockBase(Material.rock).setBlockTextureName("deepercaves:barrier_layer").setBlockName("barrierLayer").setHardness(45.5F).setResistance(1500000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves).setBlockUnbreakable();
        
        DeeperBlocks.darkStone = new BlockBase(Material.rock).setBlockTextureName("deepercaves:dark_stone").setBlockName("darkStone").setHardness(4.5F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves); //dark stone
        
        DeeperBlocks.vesperiteOre = new BlockOreBase(Material.rock, DeeperCaves.items.vesperiteGem, 1, 1, true, 5, 8).setBlockTextureName("deepercaves:vesperite_ore").setBlockName("vesperiteOre").setHardness(9.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        DeeperBlocks.abandonedStone = new BlockBase(Material.rock).setBlockTextureName("deepercaves:abandoned_stone").setBlockName("abandonedCavesStone").setHardness(2.5F).setResistance(12.0F).setCreativeTab(DeeperCaves.tabDeeperCaves); //abandoned stone
        
        DeeperBlocks.deepStone = new BlockDeepStone().setBlockTextureName("deepercaves:deep_stone").setBlockName("deepStone").setHardness(3.5F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCaves); //deep stone
        
        DeeperBlocks.cooledObsidian = new BlockBase(Material.rock).setBlockTextureName("deepercaves:cooled_obsidian").setBlockName("cooledObsidian").setHardness(85.0F).setResistance(8000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.heatedObsidian = new BlockBase(Material.rock).setBlockTextureName("deepercaves:heated_obsidian").setBlockName("heatedObsidian").setHardness(30.0F).setResistance(4000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.vesperiteBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:vesperite_block").setBlockName("vesperiteBlock").setHardness(5.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.deepCobble = new BlockBase(Material.rock).setBlockTextureName("deepercaves:deep_cobblestone").setBlockName("deepCobble").setHardness(3.5F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.fragmentedCobble = new BlockBase(Material.rock).setBlockTextureName("deepercaves:fragmented_cobblestone").setBlockName("fragmentedCobble").setHardness(3.5F).setResistance(14.0F).setCreativeTab(DeeperCaves.tabDeeperCaves); //!!!
        
        DeeperBlocks.soulStone = new BlockBase(Material.rock).setBlockTextureName("deepercaves:soul_stone").setBlockName("soulStone").setHardness(4.0F).setResistance(13.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.corruptedSoulStone = new BlockBase(Material.rock).setBlockTextureName("deepercaves:corrupted_soul_stone").setBlockName("corruptedSoulStone").setHardness(3.0F).setResistance(12.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.cryingObsidian = new BlockCryingObsidian(Material.rock).setBlockTextureName("deepercaves:crying_obsidian").setBlockName("cryingObsidian").setHardness(60.0F).setResistance(6000.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.profundiumOre = new BlockBase(Material.rock).setBlockTextureName("deepercaves:profundium_ore").setBlockName("profundiumOre").setHardness(8.0F).setResistance(10.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        DeeperBlocks.profundiumBlock = new BlockProfundium(Material.rock).setBlockTextureName("deepercaves:profundium_block").setBlockName("profundiumBlock").setHardness(6.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.evanesciteOre = new BlockOreBase(Material.rock, DeeperCaves.items.evanesciteGem, 1, 1, true, 3, 6).setBlockTextureName("deepercaves:evanescite_ore").setBlockName("evanesciteOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        DeeperBlocks.evanesciteBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:evanescite_block").setBlockName("evanesciteBlock").setHardness(6.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.dpcoalOre = new BlockVanillaOre(Material.rock, Blocks.coal_ore).setBlockTextureName("deepercaves:dpcoal_ore").setBlockName("dpcoalOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dpironOre = new BlockVanillaOre(Material.rock, Blocks.iron_ore).setBlockTextureName("deepercaves:dpiron_ore").setBlockName("dpironOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dpgoldOre = new BlockVanillaOre(Material.rock, Blocks.gold_ore).setBlockTextureName("deepercaves:dpgold_ore").setBlockName("dpgoldOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dplapisOre = new BlockVanillaOre(Material.rock, Blocks.lapis_ore).setBlockTextureName("deepercaves:dplapis_ore").setBlockName("dplapisOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dpredstoneOre = new BlockVanillaRedstoneOre(false).setBlockTextureName("deepercaves:dpredstone_ore").setBlockName("dpredstoneOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dpredstoneOre_glowing = new BlockVanillaRedstoneOre(true).setBlockTextureName("deepercaves:dpredstone_ore").setBlockName("dpredstoneOre").setHardness(7.0F).setResistance(7.0F).setLightLevel(0.625F);
        DeeperBlocks.dpdiamondOre = new BlockVanillaOre(Material.rock, Blocks.diamond_ore).setBlockTextureName("deepercaves:dpdiamond_ore").setBlockName("dpdiamondOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        DeeperBlocks.dpemeraldOre = new BlockVanillaOre(Material.rock, Blocks.emerald_ore).setBlockTextureName("deepercaves:dpemerald_ore").setBlockName("dpemeraldOre").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);
        
        DeeperBlocks.crystal = new BlockCrystal(Material.glass).setBlockName("crystal").setLightOpacity(0).setHardness(1.0F).setResistance(2.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.rubyBlock = new BlockBase(Material.rock).setBlockTextureName("deepercaves:rubyBlock").setBlockName("ruby_block").setLightOpacity(0).setHardness(3.0F).setResistance(15.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);

        DeeperBlocks.magmaStone = new BlockMagmaStone(Material.rock).setBlockTextureName("deepercaves:magma_stone").setBlockName("magma_stone").setLightOpacity(0).setHardness(1.2F).setResistance(5.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.rottenPlanks = new BlockBase(Material.wood).setBlockTextureName("deepercaves:rotting_planks").setBlockName("rotten_planks").setLightOpacity(0).setHardness(1.2F).setResistance(5.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);
        
        DeeperBlocks.rustedBars = new BlockRustedBars("deepercaves:rusty_bars", "deepercaves:rusty_bars", Material.iron, true).setBlockTextureName("deepercaves:rusty_bars").setBlockName("rusted_iron_bars").setLightOpacity(0).setHardness(1.2F).setResistance(5.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);

        DeeperBlocks.incenditeOre = new BlockOreBase(Material.rock, DeeperItems.incenditeGem, 1, 0, true, 3, 6).setBlockTextureName("deepercaves:incendite_ore").setBlockName("incendite_ore").setHardness(3.0F).setResistance(5.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);

        DeeperBlocks.prisciumOre = new BlockBase(Material.rock).setBlockTextureName("deepercaves:priscium_ore").setBlockName("priscium_ore").setHardness(7.0F).setResistance(7.0F).setCreativeTab(DeeperCaves.tabDeeperCavesOres);

        DeeperBlocks.robustiumRaw = new BlockBase(Material.rock).setBlockTextureName("deepercaves:raw_robustium").setBlockName("robustiumRaw").setHardness(5.0F).setResistance(12.0F).setCreativeTab(DeeperCaves.tabDeeperCaves);

    }
    public void setupHarvestLevels()
    {
        /*Setting up block harvest levels*/
        DeeperBlocks.silverOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.silverBlock.setHarvestLevel("pickaxe", 2);
        
        DeeperBlocks.sapphireOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.sapphireBlock.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.aquamarineOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.aquamarineBlock.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.ametrineOre.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.ametrineBlock.setHarvestLevel("pickaxe", 3);
        
        
        DeeperBlocks.ccoalOre.setHarvestLevel("pickaxe", 1);
        DeeperBlocks.cironOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.cgoldOre.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.clapisOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.credstoneOre.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.credstoneOre_glowing.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.cdiamondOre.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.cemeraldOre.setHarvestLevel("pickaxe", 3);
        
        DeeperBlocks.dccoalOre.setHarvestLevel("pickaxe", 1);
        DeeperBlocks.dcironOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.dcgoldOre.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.dclapisOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.dcredstoneOre.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.dcredstoneOre_glowing.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.dcdiamondOre.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.dcemeraldOre.setHarvestLevel("pickaxe", 3);
        
        DeeperBlocks.dcsilverOre.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.dcsapphireOre.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.dcaquamarineOre.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.dcrubyOre.setHarvestLevel("pickaxe", 3);
        
        DeeperBlocks.csilverOre.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.csapphireOre.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.caquamarineOre.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.crubyOre.setHarvestLevel("pickaxe", 3);
        
        DeeperBlocks.ddcoalOre.setHarvestLevel("pickaxe", 0);
        DeeperBlocks.ddironOre.setHarvestLevel("pickaxe", 1);
        DeeperBlocks.ddgoldOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.ddlapisOre.setHarvestLevel("pickaxe", 1);
        DeeperBlocks.ddredstoneOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.ddredstoneOre_glowing.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.dddiamondOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.ddemeraldOre.setHarvestLevel("pickaxe", 2);
        
        DeeperBlocks.fragmentedBedrock.setHarvestLevel("pickaxe", 4);
        
        DeeperBlocks.tenebriumOre.setHarvestLevel("pickaxe", 4);
        DeeperBlocks.tenebriumBlock.setHarvestLevel("pickaxe", 4);
      
        DeeperBlocks.forgottenGemstoneOre.setHarvestLevel("pickaxe", 4);
        
        DeeperBlocks.forgottenGemstoneBlock.setHarvestLevel("pickaxe", 4);
        
        DeeperBlocks.vesperiteOre.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.vesperiteBlock.setHarvestLevel("pickaxe", 3);
        
        DeeperBlocks.cooledObsidian.setHarvestLevel("pickaxe", 4);
        DeeperBlocks.heatedObsidian.setHarvestLevel("pickaxe", 2);
        
        DeeperBlocks.darkStone.setHarvestLevel("pickaxe", 1);
        DeeperBlocks.abandonedStone.setHarvestLevel("pickaxe", 1);
        DeeperBlocks.deepStone.setHarvestLevel("pickaxe", 2);
        
        DeeperBlocks.cryingObsidian.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.soulStone.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.corruptedSoulStone.setHarvestLevel("pickaxe", 2);
        
        DeeperBlocks.fragmentedCobble.setHarvestLevel("pickaxe", 0);
        
        DeeperBlocks.profundiumOre.setHarvestLevel("pickaxe", 4);
        DeeperBlocks.profundiumBlock.setHarvestLevel("pickaxe", 4);
        
        DeeperBlocks.evanesciteOre.setHarvestLevel("pickaxe", 3);
        DeeperBlocks.evanesciteBlock.setHarvestLevel("pickaxe", 3);

        DeeperBlocks.dcoalOre.setHarvestLevel("pickaxe", 0);
        DeeperBlocks.dironOre.setHarvestLevel("pickaxe", 1);
        DeeperBlocks.dgoldOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.dlapisOre.setHarvestLevel("pickaxe", 1);
        DeeperBlocks.dredstoneOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.dredstoneOre_glowing.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.ddiamondOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.demeraldOre.setHarvestLevel("pickaxe", 2);
        
        DeeperBlocks.dpcoalOre.setHarvestLevel("pickaxe", 0);
        DeeperBlocks.dpironOre.setHarvestLevel("pickaxe", 1);
        DeeperBlocks.dpgoldOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.dplapisOre.setHarvestLevel("pickaxe", 1);
        DeeperBlocks.dpredstoneOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.dpredstoneOre_glowing.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.dpdiamondOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.dpemeraldOre.setHarvestLevel("pickaxe", 2);
        
        DeeperBlocks.crystal.setHarvestLevel("pickaxe", 0);
        
        DeeperBlocks.dropPortal.setHarvestLevel("pickaxe", 0);
        
        DeeperBlocks.rubyOre.setHarvestLevel("pickaxe", 2);
        DeeperBlocks.rubyBlock.setHarvestLevel("pickaxe", 2);

        DeeperBlocks.incenditeOre.setHarvestLevel("pickaxe", 4);
        DeeperBlocks.profundiumOre.setHarvestLevel("pickaxe", 4);
    }
    
}
