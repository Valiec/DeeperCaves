package com.kpabr.DeeperCaves.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
/*
 * Created by Valiec2019
 * on February 18, 2014
 * using Minecraft Forge 10.12.0.1022
 */
public class ItemCrystal extends Item {

    private final static String[] names = {
            "0", "1",  "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12"
        };
    
    private IIcon[] texture;
	
	public ItemCrystal() {
		setHasSubtypes(true);
		setMaxDamage(0);
		this.texture = new IIcon[13];
	}

	
	@Override
	public IIcon getIconFromDamage(int i)
	{
		return texture[i];
		
	}
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        for (int i  = 0; i<13; i++)
        {
        this.texture[i] = iconRegister.registerIcon("DeeperCaves:crystal_shard_"+Integer.toString(i));
        }
    }
    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "_" + names[itemstack.getItemDamage()];
    }
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_)
    {
        for (int i = 0; i < 13; ++i)
        {
            p_150895_3_.add(new ItemStack(p_150895_1_, 1, i));
        }
    }
}
