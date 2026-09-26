package com.kpabr.DeeperCaves;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class DeeperCavesExtendedPlayerData implements IExtendedEntityProperties {

    public static final String NAME = "DeeperCavesExtendedPlayerData";

    public static final int FEATHER = 0x1;
    public static final int WATER = 0x2;
    public static final int VOID = 0x4;
    public static final int CAVERN = 0x8;
    public static final int AMETRINE = 0x10;
    public static final int FORGOTTEN = 0x20;
    public static final int UNBLEMISHED = 0x40;
    public static final int ECHO = 0x80;

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

    public boolean featherCharm()
    {
        return (this.charmState & FEATHER) != 0;
    }

    public boolean waterCharm()
    {
        return (this.charmState & WATER) != 0;
    }

    public boolean voidCharm()
    {
        return (this.charmState & VOID) != 0;
    }

    public boolean cavernCharm()
    {
        return (this.charmState & CAVERN) != 0;
    }

    public boolean ametrineCharm()
    {
        return (this.charmState & AMETRINE) != 0;
    }

    public boolean forgottenCharm()
    {
        return (this.charmState & FORGOTTEN) != 0;
    }

    public boolean unblemishedCharm()
    {
        return (this.charmState & UNBLEMISHED) != 0;
    }

    public boolean echoCharm()
    {
        return (this.charmState & ECHO) != 0;
    }


    public void setCharmFlag(boolean state, byte flag) {
        this.charmState =  (byte) (state ? (this.charmState | flag) : (this.charmState & ~flag));
    }

    public void setFeatherCharm(boolean state) {
        setCharmFlag(state, (byte) FEATHER);
    }

    public void setWaterCharm(boolean state) {
        setCharmFlag(state, (byte) WATER);
    }

    public void setVoidCharm(boolean state) {
        setCharmFlag(state, (byte) VOID);
    }

    public void setCavernCharm(boolean state) {
        setCharmFlag(state, (byte) CAVERN);
    }

    public void setForgottenCharm(boolean state) {
        setCharmFlag(state, (byte) FORGOTTEN);
    }

    public void setEchoCharm(boolean state) {
        setCharmFlag(state, (byte) ECHO);
    }

    public void setUnblemishedCharm(boolean state) {
        setCharmFlag(state, (byte) UNBLEMISHED);
    }

    public void setAmetrineCharm(boolean state) {
        setCharmFlag(state, (byte) AMETRINE);
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
