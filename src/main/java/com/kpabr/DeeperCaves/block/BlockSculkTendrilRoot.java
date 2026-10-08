package com.kpabr.DeeperCaves.block;

import com.kpabr.DeeperCaves.DeeperSculkManager;
import com.kpabr.DeeperCaves.SculkActivation;
import com.kpabr.DeeperCaves.entity.TileEntitySculkTendril;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


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
