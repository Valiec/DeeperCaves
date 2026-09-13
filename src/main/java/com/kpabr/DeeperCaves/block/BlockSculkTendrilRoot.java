package com.kpabr.DeeperCaves.block;

import com.kpabr.DeeperCaves.DeeperSculkManager;
import com.kpabr.DeeperCaves.SculkActivation;
import com.kpabr.DeeperCaves.entity.TileEntitySculkShrieker;
import com.kpabr.DeeperCaves.entity.TileEntitySculkTendril;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSculkTendrilRoot extends BlockSculkTendril  implements ITileEntityProvider {

	public BlockSculkTendrilRoot(Material par2Material) {
		super(par2Material);
		DeeperSculkManager.registerTypesForBlockExcept(this, SculkActivation.ActivationType.VIBRATION);
		//DeeperSculkManager.vibrationReceivers.add(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntitySculkTendril();
	}

}
