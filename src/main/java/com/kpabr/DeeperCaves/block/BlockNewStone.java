package com.kpabr.DeeperCaves.block;

import java.util.Random;

import com.kpabr.DeeperCaves.DeeperBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockNewStone extends BlockBase {

	public Block cobble;

	public BlockNewStone(Block cobble) {
		super(Material.rock);
		this.cobble = cobble;
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
        return Item.getItemFromBlock(this.cobble);
    }

}
