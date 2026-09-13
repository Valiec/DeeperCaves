package com.kpabr.DeeperCaves;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class SculkActivation {
    public Entity activatingEntity;
    public boolean isPlayer;
    public ActivationType activationType;
    public SculkVibration vibration;

    public SculkActivation(Entity entity, ActivationType type, SculkVibration vibration) {
        this.activatingEntity = entity;
        this.activationType = type;
        this.vibration = vibration;
        this.isPlayer = entity instanceof EntityPlayer;
    }

    public enum ActivationType {
        VIBRATION,
        SENSOR_REBROADCAST,
        TENDRIL,
        SIGNAL,
        CONTACT,

    }

    public SculkActivation withType(ActivationType type) {
        return new SculkActivation(this.activatingEntity, type, vibration);
    }

    public static SculkActivation fromNBT(NBTTagCompound compound, World world)
    {
        return new SculkActivation(world.getEntityByID(compound.getInteger("entityID")), ActivationType.valueOf(compound.getString("type")), compound.hasKey("vibration") ? SculkVibration.fromNBT(compound) : null);
    }

    public NBTTagCompound asNBT()
    {

        NBTTagCompound compound = new NBTTagCompound();
        compound.setBoolean("isPlayer", this.isPlayer);
        compound.setInteger("entityID", this.activatingEntity.getEntityId());
        if(this.vibration != null)
        {
        compound.setTag("vibration", this.vibration.asNBT());
        }
        return compound;
    }
}
