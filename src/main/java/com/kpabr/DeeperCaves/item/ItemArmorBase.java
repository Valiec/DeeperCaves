package com.kpabr.DeeperCaves.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorBase extends ItemArmor {

	public ItemArmorBase(ArmorMaterial arg0, int arg1, int arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
		return null;

    }

}
