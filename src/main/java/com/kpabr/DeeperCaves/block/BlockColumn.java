package com.kpabr.DeeperCaves.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;
import java.util.Random;

public class BlockColumn extends BlockRotatedPillar {

    public IIcon side;
    public IIcon end;

    public String baseName;


    public BlockColumn(Material sponge, String baseName) {
        super(sponge);
        this.baseName = baseName;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.side = iconRegister.registerIcon("DeeperCaves:"+this.baseName);
        this.end = iconRegister.registerIcon("DeeperCaves:"+this.baseName+"_top");

    }

    @Override
    protected IIcon getSideIcon(int p_150163_1_) {
        return this.side;
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int p_150161_1_)
    {
        return this.end;
    }

}
