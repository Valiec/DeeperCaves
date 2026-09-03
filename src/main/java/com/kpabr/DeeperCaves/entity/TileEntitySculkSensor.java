package com.kpabr.DeeperCaves.entity;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperEventHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import org.apache.commons.lang3.tuple.Triple;

import java.util.List;

public class TileEntitySculkSensor extends TileEntity {

    boolean activated = false;
    int activatedTicks = 0;
    int delayTicks = 0;
    int cooldownTicks = 0;
    EntityPlayer activatingPlayer = null;

    public void activate(int delay)
    {
        activate(delay, null);

    }

    public void activate(int delay, EntityPlayer activatingPlayer)
    {
        if(activatingPlayer != null) {
            this.activatingPlayer = activatingPlayer;
        }

        if(!this.activated && this.cooldownTicks == 0 && this.delayTicks == 0) {
            activatedTicks = 30;
            if (delay > 0) {
                delayTicks = delay;
            } else {
                this.doActivate();
            }
        }

    }

    public void doActivate() {
        activated = true;
        this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 1, 2);
        if(this.activatingPlayer != null) {
            List<Triple<Block, Integer[], Double>> shriekers = DeeperEventHandler.findBlocksWithinRadius(this.xCoord, this.yCoord, this.zCoord, 8, this.worldObj, true, DeeperBlocks.sculkShrieker);

            for(Triple<Block, Integer[], Double> sensor : shriekers) {
                Integer[] coords = sensor.getMiddle();
                double dist = sensor.getRight();
                System.out.println("SHRIEKER!!!");
                ((TileEntitySculkShrieker) this.worldObj.getTileEntity(coords[0], coords[1], coords[2])).activate((int)dist, activatingPlayer);
            }
        }

        boolean amethystCheck = this.worldObj.getBlock(this.xCoord - 1, this.yCoord, this.zCoord) == DeeperBlocks.vesperiteBlock ||
                this.worldObj.getBlock(this.xCoord + 1, this.yCoord, this.zCoord) == DeeperBlocks.vesperiteBlock ||
                this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord) == DeeperBlocks.vesperiteBlock ||
                this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord) == DeeperBlocks.vesperiteBlock ||
                this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord - 1) == DeeperBlocks.vesperiteBlock ||
                this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord + 1) == DeeperBlocks.vesperiteBlock;

        if(amethystCheck) {
            List<Triple<Block, Integer[], Double>> sensors = DeeperEventHandler.findBlocksWithinRadius(this.xCoord, this.yCoord, this.zCoord, 8, this.worldObj, true, DeeperBlocks.sculkSensor);

            for (Triple<Block, Integer[], Double> sensor : sensors) {
                Integer[] coords = sensor.getMiddle();
                double dist = sensor.getRight();
                ((TileEntitySculkSensor) this.worldObj.getTileEntity(coords[0], coords[1], coords[2])).activate((int) dist, activatingPlayer);
            }
        }
    }

    public void doDeactivate() {
        activated = false;
        this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 0, 2);
        this.cooldownTicks = 10;
        this.activatingPlayer = null;
    }

    public void updateEntity() {
        if(delayTicks > 0) {
            delayTicks--;
            if(delayTicks == 0) {
                this.doActivate();
            }
        }
        else if(activatedTicks > 0 && activated) {
            activatedTicks--;
            if(activatedTicks == 0) {
                this.doDeactivate();
            }
        }

        if(cooldownTicks > 0 && !activated) {
            cooldownTicks--;
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.activated = compound.getBoolean("activated");
        this.activatedTicks = compound.getInteger("activatedTicks");
        this.delayTicks = compound.getInteger("delayTicks");
        this.cooldownTicks = compound.getInteger("cooldownTicks");

    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setBoolean("activated", this.activated);
        compound.setInteger("activatedTicks", this.activatedTicks);
        compound.setInteger("delayTicks", this.delayTicks);
        compound.setInteger("cooldownTicks", this.cooldownTicks);
    }
}
