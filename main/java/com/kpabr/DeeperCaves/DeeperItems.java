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

    /*Tool and Armor Material declarations*/
    static ToolMaterial Test = EnumHelper.addToolMaterial("TEST", 4, 2544, 16.0F, 6, 28);
    
    public void registerItems()
    {
       
        GameRegistry.registerItem(this.silverIngot, "silver_ingot");
    }
    
    public void setupItems()
    {
    
        this.silverIngot = new ItemSilverIngot().setTextureName("deepercaves:silver_ingot").setUnlocalizedName("silverIngot");
    }
}
