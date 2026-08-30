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
    public int voidCounter;
    public int deepCounter;

    public DeeperCavesExtendedPlayerData(EntityPlayer player) {
        this.player = player;
        this.charmState = 0;
        this.voidCounter = 0;
        this.deepCounter = 0;
    }

    public boolean voidCharm()
    {
        return (this.charmState & 0x1) != 0;
    }

    public boolean forgottenCharm()
    {
        return (this.charmState & 0x2) != 0;
    }

    public int voidCounter()
    {
        return this.voidCounter;
    }

    public int deepCounter()
    {
        return this.deepCounter;
    }

    public void setVoidCounter(int value)
    {
        this.voidCounter = value;
    }

    public void setDeepCounter(int value)
    {
       this.deepCounter = value;
    }


    public void setVoidCharm() {
        this.charmState = (byte) (this.charmState | 0x1);
    }

    public void setForgottenCharm() {
        this.charmState = (byte) (this.charmState | 0x2);
    }

    public void setEchoCharm() {
        this.charmState = (byte) (this.charmState | 0x4);
    }

    public void setUnblemishedCharm() {
        this.charmState = (byte) (this.charmState | 0x8);
    }


    public void unsetVoidCharm() {
        this.charmState = (byte) (this.charmState & ~0x1);
    }

    public void unsetForgottenCharm() {
        this.charmState = (byte) (this.charmState & ~0x2);
    }

    public void unsetEchoCharm() {
        this.charmState = (byte) (this.charmState & ~0x4);
    }

    public void unsetUnblemishedCharm() {
        this.charmState = (byte) (this.charmState & ~0x8);
    }


    @Override
    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound deeperCoreData  = new NBTTagCompound();
        deeperCoreData.setByte("charmState", this.charmState);
        compound.setTag("deeperCavesData", deeperCoreData);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {
        NBTTagCompound deeperCoreData = compound.getCompoundTag("deeperCavesData");
        this.charmState = deeperCoreData.getByte("charmState");

    }


    @Override
    public void init(Entity entity, World world) {

    }
}
