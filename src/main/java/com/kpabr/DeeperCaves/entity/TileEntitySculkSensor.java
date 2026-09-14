package com.kpabr.DeeperCaves.entity;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperSculkManager;
import com.kpabr.DeeperCaves.SculkActivation;
import net.minecraft.block.Block;

public class TileEntitySculkSensor extends TileEntitySculkActivatable {

    public TileEntitySculkSensor() {
        this.activatedDuration = 30;
        this.cooldownDuration = 10;
    }

    @Override
    public void handleActivation() {
        this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 1, 2);
        this.worldObj.playSoundEffect(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D, "deepercaves:block.sculk_sensor.clicking", 0.73F, 0.8F + this.worldObj.rand.nextFloat() * 0.2F);
        this.activation.broadcastInRadius(activation.withType(SculkActivation.ActivationType.SIGNAL), this.xCoord, this.yCoord, this.zCoord, 8, this.worldObj);

        if(DeeperSculkManager.hasNeighbor(this.xCoord, this.yCoord, this.zCoord, worldObj, DeeperBlocks.vesperiteBlock)) {
            this.activation.broadcastInRadius(activation.withType(SculkActivation.ActivationType.SENSOR_REBROADCAST), this.xCoord, this.yCoord, this.zCoord, 8, this.worldObj);
        }
    }


    @Override
    public void handleDeactivation() {
        this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 0, 2);
        this.worldObj.playSoundEffect(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D, "deepercaves:block.sculk_sensor.clicking_stop", 0.62F, 0.8F + this.worldObj.rand.nextFloat() * 0.2F);

    }
}
