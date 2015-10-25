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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
/*
 * Created by Valiec2019
 * on February 18, 2014
 * using Minecraft Forge 10.12.0.1022
 */
public class BlockFragmentedBedrockOre extends BlockOreBase {
	

	public BlockFragmentedBedrockOre(Material par2Material, Item drop, int quantity, int randval, boolean doXPdrop, int xpmin, int xpmax) {
		super(par2Material, drop, quantity, randval, doXPdrop, xpmin, xpmax);
		this.drop = drop;
		this.quantity = quantity;
		this.randval = randval;
		// TODO Auto-generated constructor stub
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

}
