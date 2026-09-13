package com.kpabr.DeeperCaves.entity;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperSculkManager;
import com.kpabr.DeeperCaves.SculkActivation;
import com.kpabr.DeeperCaves.block.BlockSculkTendril;
import net.minecraft.block.Block;
import org.apache.commons.lang3.tuple.Triple;

import java.util.List;

public class TileEntitySculkTendril extends TileEntitySculkActivatable {

    public TileEntitySculkTendril() {
        this.activatedDuration = 30;
        this.cooldownDuration = 10;
    }

    public static boolean doBroadcastTo(Block block, SculkActivation activation) {
        return activation.activationType != SculkActivation.ActivationType.TENDRIL || !(block instanceof BlockSculkTendril);
    }

    @Override
    public void handleActivation() {
        int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, meta | 2, 2);
        this.worldObj.func_147451_t(this.xCoord, this.yCoord, this.zCoord);
        int i = this.yCoord;

        while(this.worldObj.getBlock(this.xCoord, i, this.zCoord) instanceof BlockSculkTendril)
        {
            meta = this.worldObj.getBlockMetadata(this.xCoord, i, this.zCoord);
            this.worldObj.setBlockMetadataWithNotify(this.xCoord, i, this.zCoord, meta | 2, 2);
            this.worldObj.func_147451_t(this.xCoord, i, this.zCoord);
            i++;
        }

        DeeperSculkManager.broadcastInRadius(this.activation, activation.withType(SculkActivation.ActivationType.TENDRIL), this.xCoord, this.yCoord, this.zCoord, 8, this.worldObj, TileEntitySculkTendril::doBroadcastTo, DeeperSculkManager.signalReceivers.toArray(new Block[0]));
    }


    @Override
    public void handleDeactivation() {
        int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, meta & ~2, 2);
        this.worldObj.func_147451_t(this.xCoord, this.yCoord, this.zCoord);

        int i = this.yCoord;

        while(this.worldObj.getBlock(this.xCoord, i, this.zCoord) instanceof BlockSculkTendril)
        {
            meta = this.worldObj.getBlockMetadata(this.xCoord, i, this.zCoord);
            this.worldObj.setBlockMetadataWithNotify(this.xCoord, i, this.zCoord, meta & ~2, 2);
            this.worldObj.func_147451_t(this.xCoord, i, this.zCoord);
            i++;
        }
    }
}
