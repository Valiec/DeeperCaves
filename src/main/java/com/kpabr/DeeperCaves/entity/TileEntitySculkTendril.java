package com.kpabr.DeeperCaves.entity;

import com.kpabr.DeeperCaves.DeeperSculkManager;
import com.kpabr.DeeperCaves.SculkActivation;
import com.kpabr.DeeperCaves.block.BlockSculkTendril;
import net.minecraft.block.Block;

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

        this.worldObj.playSoundEffect(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D, "deepercaves:block.sculk_sensor.clicking", 0.73F, 1.2F + this.worldObj.rand.nextFloat() * 0.3F);
        this.activation.broadcastInRadius(activation.withType(SculkActivation.ActivationType.TENDRIL), this.xCoord, this.yCoord, this.zCoord, 8, this.worldObj, TileEntitySculkTendril::doBroadcastTo);
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
        this.worldObj.playSoundEffect(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D, "deepercaves:block.sculk_sensor.clicking_stop", 0.62F, 1.2F + this.worldObj.rand.nextFloat() * 0.3F);
    }
}
