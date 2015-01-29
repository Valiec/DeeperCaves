package com.kpabr.DeeperCaves;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;

public class DeeperFuelHandler implements IFuelHandler {
    @Override
    public int getBurnTime(ItemStack fuel)
    {
        if (fuel.isItemEqual(new ItemStack(DeeperCaves.blocks.example, fuel.stackSize)))
        {
            return 300;
        }
        return 0;
    }
}
