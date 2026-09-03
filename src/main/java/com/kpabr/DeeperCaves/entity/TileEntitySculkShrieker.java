package com.kpabr.DeeperCaves.entity;

import com.kpabr.DeeperCaves.DeeperCavesExtendedPlayerData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.Sys;

public class TileEntitySculkShrieker extends TileEntity {

    boolean activated = false;
    int activatedTicks = 0;
    int delayTicks = 0;
    EntityPlayer player;

    public void activate(int delay, EntityPlayer player)
    {
        this.player = player;
        if(!this.activated && this.delayTicks == 0) {
            activatedTicks = 90;
            if (delay > 0) {
                delayTicks = delay;
            } else {
                this.doActivate();
            }
        }

    }

    public void doActivate() {
        activated = true;
        int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, meta | 1, 2);
        DeeperCavesExtendedPlayerData extData = (DeeperCavesExtendedPlayerData)player.getExtendedProperties(DeeperCavesExtendedPlayerData.NAME);
        if(extData != null && (meta & 2) != 0) {
            extData.shriekerCooldown = 200;
            if(extData.shriekerWarning < 4) {
                extData.shriekerWarning++;
            }
            if(extData.shriekerWarning == 4) {
                //this.player.addChatMessage(new ChatComponentText("Warden!"));
            }
            extData.shriekerWarningCooldown = 12000;
        }
    }

    public void doDeactivate() {
        activated = false;
        int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, meta & ~1, 2);
        this.player =  null;
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
