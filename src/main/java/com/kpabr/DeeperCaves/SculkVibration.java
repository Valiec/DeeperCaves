package com.kpabr.DeeperCaves;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class SculkVibration {
    public enum VibrationEventType
    {
        BLOCK_BREAK,
        BLOCK_PLACE,
        ENTITY_MOVEMENT,
        ENTITY_DAMAGE,
        ENTITY_DEATH,
        PROJECTILE,
        ENTITY_SOUND,
        CHEST,
        EXPLOSION
    }

    public VibrationEventType vibrationType;
    public double x;
    public double y;
    public double z;

    public SculkVibration(VibrationEventType type, double x, double y, double z) {
        this.vibrationType = type;
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public static SculkVibration fromNBT(NBTTagCompound compound)
    {
        return new SculkVibration(VibrationEventType.valueOf(compound.getString("type")),
                compound.getDouble("x"),
                compound.getDouble("y"),
                compound.getDouble("z"));
    }

    public NBTTagCompound asNBT()
    {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setString("type", vibrationType.toString());
        compound.setDouble("x", x);
        compound.setDouble("y", y);
        compound.setDouble("z", z);
        return compound;
    }
}
