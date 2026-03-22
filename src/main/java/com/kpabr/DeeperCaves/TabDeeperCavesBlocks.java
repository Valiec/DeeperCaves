package com.kpabr.DeeperCaves;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabDeeperCavesBlocks extends CreativeTabs {

    public boolean isBlock;
    public Item item;
    public String name;
    public Block block;
    

    public TabDeeperCavesBlocks(int par1, String par2Str, Block par3Block)
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
        return Item.getItemFromBlock(DeeperBlocks.fragmentedBedrock);
        
    }
    public String getTranslatedTabLabel()
    {
        return this.name;
    }
    
}
