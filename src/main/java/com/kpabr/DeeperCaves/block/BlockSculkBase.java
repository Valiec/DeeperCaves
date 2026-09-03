package com.kpabr.DeeperCaves.block;

import com.kpabr.DeeperCaves.client.RenderBlockTextureRotation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

public class BlockSculkBase extends Block {

    public boolean rotating = false;

    public BlockSculkBase(Material sponge, boolean rotating) {
        super(sponge);
        this.rotating = rotating;
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

    @Override
    public int getRenderType() {
        return this.rotating ? RenderBlockTextureRotation.renderID : 0;
    }
}
