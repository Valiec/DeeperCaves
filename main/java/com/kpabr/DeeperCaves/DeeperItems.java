package com.kpabr.DeeperCaves;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemRedstone;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class DeeperItems {
    /*Item declarations*/
    public static Item silverIngot;
    public static Item sapphireGem;
    public static Item ametrineGem;
    
    public static Item aquamarine;
    
    public static Item ametrineTippedDiamondPickaxe;
    
    public static Item ametrineTippedGoldenPickaxe;
    public static Item ametrineTippedIronPickaxe;
    public static Item ametrineTippedStonePickaxe;
    
    public static Item ametrineTippedWoodenPickaxe;
    
    public static Item tenebriumIngot;

    /*Tool and Armor Material declarations*/
    static ToolMaterial AmetrineD = EnumHelper.addToolMaterial("AMETRINE_D", 4, 1561, 14.0F, 3.0F, 10);
    
    static ToolMaterial AmetrineG = EnumHelper.addToolMaterial("AMETRINE_G", 1, 32, 18.0F, 0.0F, 22);
    static ToolMaterial AmetrineI = EnumHelper.addToolMaterial("AMETRINE_I", 3, 250, 11.0F, 2.0F, 14);
    static ToolMaterial AmetrineS = EnumHelper.addToolMaterial("AMETRINE_S", 2, 131, 9.0F, 1.0F, 5);
    
    static ToolMaterial AmetrineW = EnumHelper.addToolMaterial("AMETRINE_W", 1, 50, 7.0F, 0.0F, 15);
    
    public void registerItems()
    {
       
        GameRegistry.registerItem(this.silverIngot, "silver_ingot");
        GameRegistry.registerItem(this.sapphireGem, "sapphire_gem");
        GameRegistry.registerItem(this.ametrineGem, "ametrine_gem");
        
        GameRegistry.registerItem(this.aquamarine, "aquamarine");
        
        GameRegistry.registerItem(this.ametrineTippedDiamondPickaxe, "ametrine_tipped_diamond_pickaxe");
        
        GameRegistry.registerItem(this.ametrineTippedGoldenPickaxe, "ametrine_tipped_golden_pickaxe");
        GameRegistry.registerItem(this.ametrineTippedIronPickaxe, "ametrine_tipped_iron_pickaxe");
        GameRegistry.registerItem(this.ametrineTippedStonePickaxe, "ametrine_tipped_stone_pickaxe");
        
        GameRegistry.registerItem(this.ametrineTippedWoodenPickaxe, "ametrine_tipped_wooden_pickaxe");
        
        GameRegistry.registerItem(this.tenebriumIngot, "tenebriumIngot");
    }
    
    public void registerItemsOreDict()
    {
    	OreDictionary.registerOre("ingotSilver", this.silverIngot);  
    	OreDictionary.registerOre("gemSapphire", this.sapphireGem);  
    	OreDictionary.registerOre("gemAmetrine", this.ametrineGem);  
        
    	OreDictionary.registerOre("gemAquamarine", this.aquamarine);  
    	
    	OreDictionary.registerOre("ingotTenebrium", this.tenebriumIngot);  
    }
    
    public void setupItems()
    {
    
        this.silverIngot = new ItemBase().setTextureName("deepercaves:silver_ingot").setUnlocalizedName("silverIngot").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        this.sapphireGem = new ItemBase().setTextureName("deepercaves:sapphireGem").setUnlocalizedName("sapphireGem").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        this.ametrineGem = new ItemBase().setTextureName("deepercaves:ametrineGem").setUnlocalizedName("ametrineGem").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        this.aquamarine = new ItemBase().setTextureName("deepercaves:aquamarine").setUnlocalizedName("aquamarine").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        this.ametrineTippedDiamondPickaxe = new ItemPickaxeBase(this.AmetrineD).setTextureName("deepercaves:ametrineTippedDiamondPickaxe").setUnlocalizedName("ametrineTippedDiamondPickaxe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        
        this.ametrineTippedGoldenPickaxe = new ItemPickaxeBase(this.AmetrineG).setTextureName("deepercaves:ametrineTippedGoldenPickaxe").setUnlocalizedName("ametrineTippedGoldenPickaxe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        this.ametrineTippedIronPickaxe = new ItemPickaxeBase(this.AmetrineI).setTextureName("deepercaves:ametrineTippedIronPickaxe").setUnlocalizedName("ametrineTippedIronPickaxe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        this.ametrineTippedStonePickaxe = new ItemPickaxeBase(this.AmetrineS).setTextureName("deepercaves:ametrineTippedStonePickaxe").setUnlocalizedName("ametrineTippedStonePickaxe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        
        this.ametrineTippedWoodenPickaxe = new ItemPickaxeBase(this.AmetrineW).setTextureName("deepercaves:ametrineTippedWoodenPickaxe").setUnlocalizedName("ametrineTippedWoodenPickaxe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        
        this.tenebriumIngot = new ItemBase().setTextureName("deepercaves:tenebriumIngot").setUnlocalizedName("tenebriumIngot").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
    }
}
