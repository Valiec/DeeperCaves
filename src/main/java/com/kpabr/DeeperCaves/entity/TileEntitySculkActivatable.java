package com.kpabr.DeeperCaves.entity;

import com.kpabr.DeeperCaves.SculkActivation;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntitySculkActivatable extends TileEntity {

    boolean activated = false;
    int activatedTicks = 0;
    int delayTicks = 0;
    int cooldownTicks = 0;
    SculkActivation activation = null;
    boolean onlyPlayerActivation = false;
    int activatedDuration;
    int cooldownDuration;

    public void activate(int delay, SculkActivation activation)
    {
        this.activation = activation;

        if(!onlyPlayerActivation || this.activation.isPlayer) {
            if (!this.activated && this.cooldownTicks == 0 && this.delayTicks == 0) {
                activatedTicks = activatedDuration;
                if (delay > 0) {
                    delayTicks = delay;
                } else {
                    this.doActivate();
                }
            }
        }
    }

    public abstract void handleActivation();
    public abstract void handleDeactivation();

    public void doActivate() {
        activated = true;
        handleActivation();
    }

    public void doDeactivate() {
        activated = false;
        handleDeactivation();
        this.cooldownTicks = cooldownDuration;
        this.activation = null;
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
        if(compound.hasKey("activation")) {
            this.activation = SculkActivation.fromNBT(compound.getCompoundTag("activation"), this.worldObj);
        }

    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setBoolean("activated", this.activated);
        compound.setInteger("activatedTicks", this.activatedTicks);
        compound.setInteger("delayTicks", this.delayTicks);
        compound.setInteger("cooldownTicks", this.cooldownTicks);
        if(this.activation != null) {
            NBTTagCompound activationCompound = this.activation.asNBT();
            compound.setTag("activation", activationCompound);
        }
    }
}
