package com.kpabr.DeeperCaves;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabDeeperCaves extends CreativeTabs {
    
    public int i;
    public Block block;
    public String name;
    
    public TabDeeperCaves(int par1, String par2Str, int i)
    {
        super(par1, par2Str);
        this.i = i;
        this.name = par2Str;
        // TODO Auto-generated constructor stub
    }
    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        if (i == 0)
        {
        return DeeperItems.sapphireGem;
        }
        if (i == 1)
        {
        return DeeperItems.ametrineTippedDiamondPickaxe;
        }
        else
        {
        return DeeperItems.ametrineTippedSilverSword;
        }
    }
    public String getTranslatedTabLabel()
    {
        return this.name;
    }

}
