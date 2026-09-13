package com.kpabr.DeeperCaves.entity;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperSculkManager;
import com.kpabr.DeeperCaves.SculkActivation;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.commons.lang3.tuple.Triple;

import java.util.List;

public class TileEntitySculkSensor extends TileEntitySculkActivatable {

    public TileEntitySculkSensor() {
        this.activatedDuration = 30;
        this.cooldownDuration = 10;
    }

    @Override
    public void handleActivation() {
        this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 1, 2);
        List<Triple<Block, Integer[], Double>> shriekers = DeeperSculkManager.findBlocksWithinRadius(this.xCoord, this.yCoord, this.zCoord, 8, this.worldObj, true, DeeperSculkManager.signalReceivers.toArray(new Block[0]));

        for(Triple<Block, Integer[], Double> sensor : shriekers) {
            Integer[] coords = sensor.getMiddle();
            double dist = sensor.getRight();
            //System.out.println("SHRIEKER!!!");
            if(this.activation != null) {
                ((TileEntitySculkActivatable) this.worldObj.getTileEntity(coords[0], coords[1], coords[2])).activate((int) dist, new SculkActivation(this.activation.activatingEntity, SculkActivation.ActivationType.SIGNAL, null));
            }
        }

        boolean amethystCheck = this.worldObj.getBlock(this.xCoord - 1, this.yCoord, this.zCoord) == DeeperBlocks.vesperiteBlock ||
                this.worldObj.getBlock(this.xCoord + 1, this.yCoord, this.zCoord) == DeeperBlocks.vesperiteBlock ||
                this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord) == DeeperBlocks.vesperiteBlock ||
                this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord) == DeeperBlocks.vesperiteBlock ||
                this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord - 1) == DeeperBlocks.vesperiteBlock ||
                this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord + 1) == DeeperBlocks.vesperiteBlock;

        if(amethystCheck) {
            List<Triple<Block, Integer[], Double>> sensors = DeeperSculkManager.findBlocksWithinRadius(this.xCoord, this.yCoord, this.zCoord, 8, this.worldObj, true, DeeperSculkManager.vibrationReceivers.toArray(new Block[0]));

            for (Triple<Block, Integer[], Double> sensor : sensors) {
                Integer[] coords = sensor.getMiddle();
                double dist = sensor.getRight();
                ((TileEntitySculkActivatable) this.worldObj.getTileEntity(coords[0], coords[1], coords[2])).activate((int) dist, new SculkActivation(this.activation.activatingEntity, SculkActivation.ActivationType.SENSOR_REBROADCAST, null));
            }
        }
    }


    @Override
    public void handleDeactivation() {
        this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 0, 2);
    }
}
