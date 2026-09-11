package com.kpabr.DeeperCaves.block;

import com.kpabr.DeeperCaves.DeeperBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockPrisciumBulb extends Block {

	public IIcon normal;
	public IIcon powered;

	public boolean lit;


	public BlockPrisciumBulb(Material par2Material, boolean lit) {
		super(par2Material);
		this.lit = lit;
	}

	public boolean isPowered(World world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z) == 1;
	}

	public void onBlockAdded(World world, int x, int y, int z)
	{
		if (!world.isRemote)
		{
			if (this.lit && !world.isBlockIndirectlyGettingPowered(x, y, z) && this.isPowered(world, x, y, z))
			{
				world.scheduleBlockUpdate(x, y, z, this, 4);
			}
			else if (this.lit && world.isBlockIndirectlyGettingPowered(x, y, z) && !this.isPowered(world, x, y, z))
			{
				world.setBlock(x, y, z, DeeperBlocks.prisciumBulb, 0, 2);
			}
			else if (!this.lit && world.isBlockIndirectlyGettingPowered(x, y, z) && !this.isPowered(world, x, y, z))
			{
				world.setBlock(x, y, z, DeeperBlocks.prisciumBulbLit, 0, 2);
			}
			else if (!this.lit && !world.isBlockIndirectlyGettingPowered(x, y, z) && this.isPowered(world, x, y, z))
			{
				world.scheduleBlockUpdate(x, y, z, this, 4);

			}
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		if (!world.isRemote)
		{
			if (this.lit && !world.isBlockIndirectlyGettingPowered(x, y, z) && this.isPowered(world, x, y, z))
			{
				world.scheduleBlockUpdate(x, y, z, this, 4);
			}
			else if (this.lit && world.isBlockIndirectlyGettingPowered(x, y, z) && !this.isPowered(world, x, y, z))
			{
				world.setBlock(x, y, z, DeeperBlocks.prisciumBulb, 1, 2);
			}
			else if (!this.lit && world.isBlockIndirectlyGettingPowered(x, y, z) && !this.isPowered(world, x, y, z))
			{
				world.setBlock(x, y, z, DeeperBlocks.prisciumBulbLit, 1, 2);
			}
			else if (!this.lit && !world.isBlockIndirectlyGettingPowered(x, y, z) && this.isPowered(world, x, y, z))
			{
				world.scheduleBlockUpdate(x, y, z, this, 4);

			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.normal = iconRegister.registerIcon("DeeperCaves:priscium_bulb"+(this.lit ? "_lit" : ""));
		this.powered = iconRegister.registerIcon("DeeperCaves:priscium_bulb_powered"+(this.lit ? "_lit" : ""));

	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(DeeperBlocks.prisciumBulb);
	}

	@Override
	public boolean canSilkHarvest()
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j)
	{
		return j == 1 ? this.powered : this.normal;
	}

	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(x, y, z))
		{
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		}
	}

}
