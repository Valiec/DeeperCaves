package com.kpabr.DeeperCaves;

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
public class BlockOreBase extends Block {
	
	private Item drop;
	private int quantity;
	private int randval;

	public BlockOreBase(Material par2Material, Item drop, int quantity, int randval) {
		super(par2Material);
		this.drop = drop;
		this.quantity = quantity;
		this.randval = randval;
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean canSilkHarvest()
    {
        return true;
    }
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
    {
		System.out.println(this.drop);
		System.out.println(DeeperCaves.items.sapphireGem);
        return this.drop;
    }
	@Override
    public int quantityDropped(Random par1Random)
    {
        return this.quantity + par1Random.nextInt(randval);
    }

}
