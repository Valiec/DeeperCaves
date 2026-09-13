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
        DeeperSculkManager.broadcastInRadius(this.activation, activation.withType(SculkActivation.ActivationType.SIGNAL), this.xCoord, this.yCoord, this.zCoord, 8, this.worldObj);

        if(DeeperSculkManager.hasNeighbor(this.xCoord, this.yCoord, this.zCoord, worldObj, DeeperBlocks.vesperiteBlock)) {
            DeeperSculkManager.broadcastInRadius(this.activation, activation.withType(SculkActivation.ActivationType.SENSOR_REBROADCAST), this.xCoord, this.yCoord, this.zCoord, 8, this.worldObj);
        }
    }


    @Override
    public void handleDeactivation() {
        this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 0, 2);
    }
}
