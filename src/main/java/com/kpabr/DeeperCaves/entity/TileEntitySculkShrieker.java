package com.kpabr.DeeperCaves.entity;

import com.kpabr.DeeperCaves.DeeperCavesExtendedPlayerData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntitySculkShrieker extends TileEntitySculkActivatable {

    public TileEntitySculkShrieker()
    {
        this.activatedDuration = 90;
        this.cooldownDuration = 0;
        this.onlyPlayerActivation = true;
    }


    @Override
    public void handleActivation() {
        if(activation.isPlayer) {
            int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
            this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, meta | 1, 2);
            DeeperCavesExtendedPlayerData extData = (DeeperCavesExtendedPlayerData) activation.activatingEntity.getExtendedProperties(DeeperCavesExtendedPlayerData.NAME);
            if (extData != null && (meta & 2) != 0) {
                extData.shriekerCooldown = 200;
                if (extData.shriekerWarning < 4) {
                    extData.shriekerWarning++;
                }
                if (extData.shriekerWarning == 4) {
                    //this.player.addChatMessage(new ChatComponentText("Warden!"));
                }
                extData.shriekerWarningCooldown = 12000;
            }
        }
    }

    @Override
    public void handleDeactivation() {
        int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, meta & ~1, 2);
    }
}
