package com.kpabr.DeeperCaves.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.List;
import java.util.Random;

public class BlockSculkBigBone extends BlockSculkBone {


    public BlockSculkBigBone(Material sponge, boolean rotating) {
        super(sponge, rotating);
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.side = iconRegister.registerIcon("DeeperCaves:sculk_bone");
        this.end = iconRegister.registerIcon("DeeperCaves:sculk_big_bone_end");
        this.sideVeins = iconRegister.registerIcon("DeeperCaves:sculk_bone_veins");
        this.endVeins = iconRegister.registerIcon("DeeperCaves:sculk_big_bone_end_veins");
        this.sideVines = iconRegister.registerIcon("DeeperCaves:sculk_bone_vines");
        this.endVines = iconRegister.registerIcon("DeeperCaves:sculk_big_bone_end");

        this.sides = new IIcon[] {this.side, this.sideVines, this.sideVeins};
        this.ends = new IIcon[] {this.end, this.endVines, this.endVeins};

    }

    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        for (int i = 0; i<3; i++)
        {
            p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
        }
    }

}
