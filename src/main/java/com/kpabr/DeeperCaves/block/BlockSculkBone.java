package com.kpabr.DeeperCaves.block;

import com.kpabr.DeeperCaves.client.RenderBlockTextureRotation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.List;
import java.util.Random;

public class BlockSculkBone extends BlockRotatedPillar {

    public IIcon side;
    public IIcon end;
    public IIcon sideVeins;
    public IIcon endVeins;
    public IIcon sideVines;
    public IIcon endVines;

    public IIcon[] sides;
    public IIcon[] ends;


    public BlockSculkBone(Material sponge, boolean rotating) {
        super(sponge);
    }

    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)
    {
        if (entity instanceof EntityWither)
        {
            return false;
        }
        else if (entity instanceof EntityDragon)
        {
            return false;
        }

        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.side = iconRegister.registerIcon("DeeperCaves:sculk_bone");
        this.end = iconRegister.registerIcon("DeeperCaves:sculk_bone_end");
        this.sideVeins = iconRegister.registerIcon("DeeperCaves:sculk_bone_veins");
        this.endVeins = iconRegister.registerIcon("DeeperCaves:sculk_bone_end_veins");
        this.sideVines = iconRegister.registerIcon("DeeperCaves:sculk_bone_vines");
        this.endVines = iconRegister.registerIcon("DeeperCaves:sculk_bone_end");

        this.sides = new IIcon[] {this.side, this.sideVines, this.sideVeins};
        this.ends = new IIcon[] {this.end, this.endVines, this.endVeins};

    }

    @Override
    protected IIcon getSideIcon(int p_150163_1_) {
        return this.sides[p_150163_1_ & 3];
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int p_150161_1_)
    {
        return this.ends[p_150161_1_ & 3];
    }

    @Override
    public boolean canSilkHarvest()
    {
        return true;
    }

    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return null;
    }

    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        for (int i = 0; i<3; i++)
        {
            p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
        }
    }

}
