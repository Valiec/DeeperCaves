package com.kpabr.DeeperCaves.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;
import java.util.Random;

public class BlockVanillaStone extends Block {

    public IIcon normal;
    public IIcon polished;
    public String name;

    public BlockVanillaStone(String name) {
        super(Material.rock);
        this.name = name;
        // TODO Auto-generated constructor stub
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.normal = iconRegister.registerIcon("DeeperCaves:"+name);
        this.polished = iconRegister.registerIcon("DeeperCaves:"+name+"_polished");

    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int j)
    {
        return j == 1 ? this.polished : this.normal;
    }

    @Override
    public boolean canSilkHarvest()
    {
        return true;
    }

    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        for (int i = 0; i<2; i++)
        {
            p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
        }
    }

}
