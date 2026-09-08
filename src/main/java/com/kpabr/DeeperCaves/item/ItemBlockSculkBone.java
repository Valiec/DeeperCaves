package com.kpabr.DeeperCaves.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSculkBone extends ItemBlock{

    public ItemBlockSculkBone(Block p_i45328_1_)
    {
        super(p_i45328_1_);
        setHasSubtypes(true);
        setUnlocalizedName("sculkBone");
      
    }
    private final static String[] names = {
        "", "vines",  "veins"
    };
    
    @Override
    public int getMetadata (int damageValue) {
        return damageValue;
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return "sculk_bone_" + names[itemstack.getItemDamage()];
    }
    
}
