package com.kpabr.DeeperCaves.entity;

import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCaves.DeeperCavesExtendedPlayerData;
import com.kpabr.DeeperCaves.network.PacketSculkActivationS2C;
import com.kpabr.DeeperCaves.network.PacketSculkShriekS2C;
import cpw.mods.fml.common.network.NetworkRegistry;
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
            int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
            this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, meta | 1, 2);
            this.worldObj.playSoundEffect(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D, "deepercaves:block.sculk_shrieker.shriek", 1.7F, 0.6F + this.worldObj.rand.nextFloat() * 0.4F);
            DeeperCaves.network.sendToAllAround(new PacketSculkShriekS2C(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D), new NetworkRegistry.TargetPoint(this.worldObj.provider.dimensionId, this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D, 32));
            DeeperCavesExtendedPlayerData extData = (DeeperCavesExtendedPlayerData) activation.getActivatingEntity(this.worldObj).getExtendedProperties(DeeperCavesExtendedPlayerData.NAME);
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

    @Override
    public void handleDeactivation() {
        int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, meta & ~1, 2);
    }
}
