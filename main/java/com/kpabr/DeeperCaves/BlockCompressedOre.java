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
public class BlockCompressedOre extends Block {

	Item drop;
	Block ore;
	public BlockCompressedOre(Material par2Material, Block ore) {
		super(par2Material);
		this.ore = ore;
		// TODO Auto-generated constructor stub
	}
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return ore.getItemDropped(par1, par2Random, par3);
    }
	@Override
    public int quantityDropped(Random par1Random)
    {
        return ore.quantityDropped(par1Random) * (2 + par1Random.nextInt(2));
    }

}
