package com.kpabr.DeeperCaves.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySculkSensor extends TileEntity {

    boolean activated = false;
    int activatedTicks = 0;
    int delayTicks = 0;
    int cooldownTicks = 0;

    public void activate(int delay)
    {
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
    }

    public void doDeactivate() {
        activated = false;
        this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 0, 2);
        this.cooldownTicks = 10;
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

    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setBoolean("activated", this.activated);
        compound.setInteger("activatedTicks", this.activatedTicks);
        compound.setInteger("delayTicks", this.delayTicks);
    }
}
