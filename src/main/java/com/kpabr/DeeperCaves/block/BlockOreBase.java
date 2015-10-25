package com.kpabr.DeeperCaves.block;

import java.util.Random;

import com.kpabr.DeeperCaves.DeeperCaves;

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
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
/*
 * Created by Valiec2019
 * on February 18, 2014
 * using Minecraft Forge 10.12.0.1022
 */
public class BlockOreBase extends BlockBase {
	
	public Item drop;
	public int quantity;
	public int randval;
	public boolean doXPdrop;
	public int xpmin;
	public int xpmax;

	public BlockOreBase(Material par2Material, Item drop, int quantity, int randval, boolean doXPdrop, int xpmin, int xpmax) {
		super(par2Material);
		this.drop = drop;
		this.quantity = quantity;
		this.randval = randval;
		this.doXPdrop = doXPdrop;
		this.xpmin = xpmin;
		this.xpmax = xpmax;
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean canSilkHarvest()
    {
        return true;
    }
	@Override
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7){
        
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
        
        if (doXPdrop){
           
           int var6 = MathHelper.getRandomIntegerInRange(par1World.rand, xpmin, xpmax);
           
           this.dropXpOnBlockBreak(par1World, par2, par3, par4, var6);
        }
           
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
	@Override
	public int quantityDroppedWithBonus(int fortuneLevel, Random rand)
    {
        if (fortuneLevel > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, rand, fortuneLevel))
        {
            int j = rand.nextInt(fortuneLevel + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }

            return this.quantityDropped(rand) * (j + 1);
        }
        else
        {
            return this.quantityDropped(rand);
        }
    }

}
