package com.kpabr.DeeperCaves;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;

public class DeeperFuel implements IFuelHandler{
	@Override
	public int getBurnTime(ItemStack fuel)
    {
        if (fuel.isItemEqual(new ItemStack(DeeperItems.profundiumDust, fuel.stackSize)))
        {
            return 2000;
        }
        return 0;
    }
}
