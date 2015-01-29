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
    public static Item example;

    /*Tool and Armor Material declarations*/
    static ToolMaterial Enderite = EnumHelper.addToolMaterial("ENDERITE", 4, 2544, 16.0F, 6, 28);
    static ToolMaterial Flamerite = EnumHelper.addToolMaterial("FLAMERITE", 3, 865, 14.0F, 4, 26);
    static ToolMaterial gFlamerite = EnumHelper.addToolMaterial("GFLAMERITE", 3, 782, 14.0F, 4, 26);
    static ToolMaterial Endstone = EnumHelper.addToolMaterial("ENDSTONE", 1, 181, 4.0F, 1.0F, 14);
    static ToolMaterial Netherstone = EnumHelper.addToolMaterial("NETHERSTONE", 1, 151, 4.0F, 1.0F, 10);
    static ToolMaterial InfusedQuartz = EnumHelper.addToolMaterial("INFUSEDQUARTZ", 2, 250, 12.0F, 2.0F, 14);
    
    static ArmorMaterial EnderiteArmor = EnumHelper.addArmorMaterial("ENDERITE", 57, new int[]{4, 8, 6, 4}, 30);
    static ArmorMaterial FlameriteArmor = EnumHelper.addArmorMaterial("FLAMERITE", 55, new int[]{4, 6, 5, 3}, 25);
    static ArmorMaterial gFlameriteArmor = EnumHelper.addArmorMaterial("GFLAMERITE", 53, new int[]{4, 6, 5, 3}, 25);
    static ArmorMaterial InfusedQuartzArmor = EnumHelper.addArmorMaterial("INFUSEDQUARTZ", 15, new int[]{3, 8, 5, 2}, 25);

    public void registerItems()
    {
       
        GameRegistry.registerItem(this.example, "example_item");
    }
    
    public void setupItems()
    {
    
        this.example = new ItemExample().setTextureName("deepercaves:example").setUnlocalizedName("example");
    }
}
