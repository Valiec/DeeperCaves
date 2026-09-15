package com.kpabr.DeeperCaves.block;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.SculkActivation;
import com.kpabr.DeeperCaves.entity.TileEntitySculkActivatable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockSculkTendril extends Block {


	public IIcon icon;
	public IIcon iconTop;
	public IIcon iconActive;
	public IIcon iconTopActive;

	public BlockSculkTendril(Material par2Material) {
		super(par2Material);
		// TODO Auto-generated constructor stub
	}

	//replace with tendril root if no tendril below
	//replace above with tendril if above is root
	public void onBlockAdded(World world, int x, int y, int z) {
		if(!world.isRemote) {
			if(y == 0 || !(world.getBlock(x, y-1, z) instanceof BlockSculkTendril)) {
				int meta = world.getBlockMetadata(x, y, z);
				world.setBlock(x, y, z, DeeperBlocks.sculkKelpRoot, meta, 2);
			}

			if(y < 255 && world.getBlock(x, y+1, z) instanceof BlockSculkTendrilRoot) {
				int meta = world.getBlockMetadata(x, y+1, z);
				world.setBlock(x, y+1, z, DeeperBlocks.sculkKelp, meta, 2);
			}
		}
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if(!world.isRemote) {
			Block block = world.getBlock(x, y, z);
			while (y > 0 && block instanceof BlockSculkTendril && !(block instanceof BlockSculkTendrilRoot)) {
				y--;
				block = world.getBlock(x, y, z);
			}
			if (block instanceof BlockSculkTendrilRoot) {
				((TileEntitySculkActivatable) world.getTileEntity(x, y, z)).activate(0, new SculkActivation(entity, SculkActivation.ActivationType.CONTACT, null));
			}
		}

	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	{
		return null;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.icon = iconRegister.registerIcon("DeeperCaves:sculk_kelp_plant");
		this.iconTop = iconRegister.registerIcon("DeeperCaves:sculk_kelp");
		this.iconActive = iconRegister.registerIcon("DeeperCaves:sculk_kelp_plant_active");
		this.iconTopActive = iconRegister.registerIcon("DeeperCaves:sculk_kelp_active");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j)
	{
		if((j & 2) != 0) {
			return ((j & 4) == 0) ? this.iconTopActive : this.iconActive;
		}
		else {
			return ((j & 4) == 0) ? this.iconTop : this.icon;
		}
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		int meta = world.getBlockMetadata(x, y, z);

		if(y < 255 && world.getBlock(x, y+1, z) instanceof BlockSculkTendril) {
			world.setBlockMetadataWithNotify(x, y, z, meta | 4, 2);
		}
		else if(y < 255 && (meta & 1) != 0
				&& !(world.getBlock(x, y+1, z) instanceof BlockSculkTendril)) {
			world.setBlockMetadataWithNotify(x, y, z, meta & ~4, 2);
		}
	}

	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		return (meta & 0b011) == 0 ? 0 : 4;
	}

	@Override
	public int damageDropped(int par1)
	{
		return par1 & ~0b110;
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return null;
	}

	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
	{
		for (int i = 0; i<2; i++)
		{
			p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
		}
	}

	@Override
	public boolean canSilkHarvest()
	{
		return true;
	}

	@Override
	public int getRenderType() {
		return 1;
	}

}
