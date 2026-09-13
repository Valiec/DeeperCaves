package com.kpabr.DeeperCaves;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.function.BiPredicate;

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

    public void broadcastInRadius(double xPos, double yPos, double zPos, int radius, World world) {
        broadcastInRadius(this, xPos, yPos, zPos, radius, world, true, null);
    }

    public void broadcastInRadius(double xPos, double yPos, double zPos, int radius, World world, boolean woolCheck) {
        broadcastInRadius(this, xPos, yPos, zPos, radius, world, woolCheck, null);
    }

    public void broadcastInRadius(double xPos, double yPos, double zPos, int radius, World world, BiPredicate<Block, SculkActivation> broadcastCheck) {
        broadcastInRadius(this, xPos, yPos, zPos, radius, world, true, broadcastCheck);
    }

    public void broadcastInRadius(double xPos, double yPos, double zPos, int radius, World world, boolean woolCheck, BiPredicate<Block, SculkActivation> broadcastCheck) {
        broadcastInRadius(this, xPos, yPos, zPos, radius, world, woolCheck, broadcastCheck);
    }

    public void broadcastInRadius(SculkActivation newActivation, double xPos, double yPos, double zPos, int radius, World world) {
        broadcastInRadius(newActivation, xPos, yPos, zPos, radius, world, true, null);
    }

    public void broadcastInRadius(SculkActivation newActivation, double xPos, double yPos, double zPos, int radius, World world, boolean woolCheck) {
        broadcastInRadius(newActivation, xPos, yPos, zPos, radius, world, woolCheck, null);
    }

    public void broadcastInRadius(SculkActivation newActivation, double xPos, double yPos, double zPos, int radius, World world, BiPredicate<Block, SculkActivation> broadcastCheck) {
        broadcastInRadius(newActivation, xPos, yPos, zPos, radius, world, true, broadcastCheck);
    }

    public void broadcastInRadius(SculkActivation newActivation, double xPos, double yPos, double zPos, int radius, World world, boolean woolCheck, BiPredicate<Block, SculkActivation> broadcastCheck) {
        DeeperSculkManager.broadcastInRadius(this, newActivation, xPos, yPos, zPos, radius, world, woolCheck, broadcastCheck);
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
