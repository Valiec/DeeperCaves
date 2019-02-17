package com.kpabr.DeeperCaves;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockCrystal extends ItemBlock{

    public ItemBlockCrystal(Block p_i45328_1_)
    {
        super(p_i45328_1_);
        setHasSubtypes(true);
        setUnlocalizedName("crystal");
      
    }
    private final static String[] names = {
        "0", "1",  "2", "3", "4", "5",
        "6", "7", "8", "9", "10",
        "11", "12"
    };
    
    @Override
    public int getMetadata (int damageValue) {
        return damageValue;
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "_" + names[itemstack.getItemDamage()];
    }
    
}
