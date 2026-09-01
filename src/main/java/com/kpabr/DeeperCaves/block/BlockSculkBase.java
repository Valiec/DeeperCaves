package com.kpabr.DeeperCaves.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockSculkBase extends Block {
    public BlockSculkBase(Material sponge) {
        super(sponge);
    }

    @Override
    public boolean canSilkHarvest()
    {
        return true;
    }

    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return null;
    }
}
