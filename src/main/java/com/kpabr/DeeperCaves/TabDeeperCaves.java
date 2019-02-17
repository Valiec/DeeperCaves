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

public class TabDeeperCaves extends CreativeTabs {

    public boolean isBlock = false;
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
        return DeeperCaves.items.sapphireGem;
        }
        if (i == 1)
        {
        return DeeperCaves.items.ametrineTippedDiamondPickaxe;
        }
        else
        {
        return DeeperCaves.items.ametrineTippedSilverSword;
        }
    }
    public String getTranslatedTabLabel()
    {
        return this.name;
    }

}
