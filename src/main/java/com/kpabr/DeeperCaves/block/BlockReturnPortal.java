package com.kpabr.DeeperCaves.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockReturnPortal extends BlockDeeperPortal
{
    public static boolean field_149948_a;
    private static final String __OBFID = "CL_00000236";

    public BlockReturnPortal(Material p_i45404_1_)
    {
        super(p_i45404_1_, 0, true, true);
        
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
    	this.blockIcon = p_149651_1_.registerIcon("deepercaves:portal_3");
    }
}