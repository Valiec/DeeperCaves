package com.kpabr.DeeperCaves.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
/*
 * Created by Valiec2019
 * on February 18, 2014
 * using Minecraft Forge 10.12.0.1022
 */
public class BlockAmetrine extends BlockBase {

	private IIcon main;
	private IIcon left;
	private IIcon right;
	private IIcon mirror;
	
	public BlockAmetrine(Material par2Material) {
		super(par2Material);
		// TODO Auto-generated constructor stub
	}
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
		this.main = iconRegister.registerIcon("DeeperCaves:ametrineBlock");
		this.mirror = iconRegister.registerIcon("DeeperCaves:ametrineBlock_mirrored");
		this.left = iconRegister.registerIcon("DeeperCaves:ametrineBlock_orange");
		this.right = iconRegister.registerIcon("DeeperCaves:ametrineBlock_blue");
    }
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int j)
    {
            if (i == 2)
            {
                    return this.mirror;
            }
            if (i == 4)
            {
                    return this.left;
            }
            if (i == 5)
            {
                    return this.right;
            }
            else
            {
                    return this.main;
            }
    }

}
