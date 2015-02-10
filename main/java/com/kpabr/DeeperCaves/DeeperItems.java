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
import cpw.mods.fml.common.registry.GameRegistry;

public class DeeperItems {
    /*Item declarations*/
    public static Item silverIngot;
    public static Item sapphireGem;
    public static Item ametrineGem;
    
    public static Item aquamarine;
    
    public static Item ametrineTippedDiamondPickaxe;

    /*Tool and Armor Material declarations*/
    static ToolMaterial AmetrineD = EnumHelper.addToolMaterial("AMETRINE_D", 4, 1561, 13.0F, 3.0F, 10);
    
    public void registerItems()
    {
       
        GameRegistry.registerItem(this.silverIngot, "silver_ingot");
        GameRegistry.registerItem(this.sapphireGem, "sapphire_gem");
        GameRegistry.registerItem(this.ametrineGem, "ametrine_gem");
        
        GameRegistry.registerItem(this.aquamarine, "aquamarine");
        
        GameRegistry.registerItem(this.ametrineTippedDiamondPickaxe, "ametrine_tipped_diamond_pickaxe");
    }
    
    public void setupItems()
    {
    
        this.silverIngot = new ItemBase().setTextureName("deepercaves:silver_ingot").setUnlocalizedName("silverIngot").setCreativeTab(CreativeTabs.tabMaterials);
        this.sapphireGem = new ItemBase().setTextureName("deepercaves:sapphireGem").setUnlocalizedName("sapphireGem").setCreativeTab(CreativeTabs.tabMaterials);
        this.ametrineGem = new ItemBase().setTextureName("deepercaves:ametrineGem").setUnlocalizedName("ametrineGem").setCreativeTab(CreativeTabs.tabMaterials);
        
        this.aquamarine = new ItemBase().setTextureName("deepercaves:aquamarine").setUnlocalizedName("aquamarine").setCreativeTab(CreativeTabs.tabMaterials);
        
        this.ametrineTippedDiamondPickaxe = new ItemPickaxeBase(this.AmetrineD).setTextureName("deepercaves:ametrineTippedDiamondPickaxe").setUnlocalizedName("ametrineTippedDiamondPickaxe").setCreativeTab(CreativeTabs.tabTools);
    }
}
