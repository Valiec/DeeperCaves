package com.kpabr.DeeperCaves;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class DeeperCavesExtendedPlayerData implements IExtendedEntityProperties {

    public static final String NAME = "DeeperCavesExtendedPlayerData";

    public EntityPlayer player;
    public byte charmState;
    public int shriekerCooldown;
    public int shriekerWarning;
    public int shriekerWarningCooldown;

    public DeeperCavesExtendedPlayerData(EntityPlayer player) {
        this.player = player;
        this.charmState = 0;
        this.shriekerCooldown = 0;
    }

    public boolean voidCharm()
    {
        return (this.charmState & 0x1) != 0;
    }

    public boolean forgottenCharm()
    {
        return (this.charmState & 0x2) != 0;
    }

    public boolean echoCharm()
    {
        return (this.charmState & 0x4) != 0;
    }

    public boolean unblemishedCharm()
    {
        return (this.charmState & 0x8) != 0;
    }

    public void setCharmFlag(boolean state, byte flag) {
        this.charmState =  (byte) (state ? (this.charmState | flag) : (this.charmState & ~flag));
    }

    public void setVoidCharm(boolean state) {
        setCharmFlag(state, (byte) 0x1);
    }

    public void setForgottenCharm(boolean state) {
        setCharmFlag(state, (byte) 0x2);
    }

    public void setEchoCharm(boolean state) {
        setCharmFlag(state, (byte) 0x4);
    }

    public void setUnblemishedCharm(boolean state) {
        setCharmFlag(state, (byte) 0x8);
    }


    @Override
    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound deeperCoreData  = new NBTTagCompound();
        deeperCoreData.setByte("charmState", this.charmState);
        deeperCoreData.setInteger("shriekerCooldown", this.shriekerCooldown);
        deeperCoreData.setInteger("shriekerWarning", this.shriekerWarning);
        deeperCoreData.setInteger("shriekerWarningCooldown", this.shriekerWarningCooldown);
        compound.setTag("deeperCavesData", deeperCoreData);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {
        NBTTagCompound deeperCoreData = compound.getCompoundTag("deeperCavesData");
        this.charmState = deeperCoreData.getByte("charmState");
        this.shriekerCooldown = deeperCoreData.getInteger("shriekerCooldown");
        this.shriekerWarning = deeperCoreData.getInteger("shriekerWarning");
        this.shriekerWarningCooldown = deeperCoreData.getInteger("shriekerWarningCooldown");
    }


    @Override
    public void init(Entity entity, World world) {

    }
}
