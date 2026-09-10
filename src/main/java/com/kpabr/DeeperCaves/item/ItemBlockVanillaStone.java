package com.kpabr.DeeperCaves.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockVanillaStone extends ItemBlock{

    public ItemBlockVanillaStone(Block p_i45328_1_)
    {
        super(p_i45328_1_);
        setHasSubtypes(true);
      
    }
    private final static String[] names = {
        "", "_polished"
    };
    
    @Override
    public int getMetadata (int damageValue) {
        return damageValue;
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return this.getUnlocalizedName() + names[itemstack.getItemDamage()];
    }
    
}
