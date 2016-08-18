package com.kpabr.DeeperCaves;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class TabDeeperCavesOres extends CreativeTabs {

    public boolean isBlock = false;
    public Item item;
    public String name;
    public Block block;
    

    public TabDeeperCavesOres(int par1, String par2Str, Block par3Block)
    {
        super(par1, par2Str);
        this.isBlock = true;
        this.name = par2Str;
        this.block = par3Block;
        // TODO Auto-generated constructor stub
    }
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return Item.getItemFromBlock(DeeperCaves.blocks.dcdiamondOre);
        
    }
    public String getTranslatedTabLabel()
    {
        return this.name;
    }
    
}
