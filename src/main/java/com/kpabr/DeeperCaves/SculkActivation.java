package com.kpabr.DeeperCaves;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.UUID;
import java.util.function.BiPredicate;

public class SculkActivation {
    private Entity activatingEntity;
    public boolean isPlayer;
    public ActivationType activationType;
    public SculkVibration vibration;
    private UUID entityUUID;

    public SculkActivation(Entity entity, ActivationType type, SculkVibration vibration) {
        this.activatingEntity = entity;
        this.activationType = type;
        this.vibration = vibration;
        this.isPlayer = entity instanceof EntityPlayer;
    }

    public Entity getActivatingEntity(World world) {
        if(this.activatingEntity == null && this.entityUUID != null) {
            for(Object entity : world.loadedEntityList) {
                if(entity instanceof Entity && ((Entity)entity).getUniqueID().equals(this.entityUUID)) {
                    this.activatingEntity = (Entity)entity;
                    return this.activatingEntity;
                }
            }
        }
        return this.activatingEntity;
    }

    public Entity getActivatingEntity() {
        return this.activatingEntity;
    }

    public SculkActivation(UUID entityUUID, ActivationType type, SculkVibration vibration, boolean player) {
        this.entityUUID = entityUUID;
        this.activationType = type;
        this.vibration = vibration;
        this.isPlayer = player;
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
        return new SculkActivation(
                compound.hasKey("entityUUID") ? UUID.fromString(compound.getString("entityUUID")) : null,
                ActivationType.valueOf(compound.getString("type")),
                compound.hasKey("vibration") ? SculkVibration.fromNBT(compound.getCompoundTag("vibration")) : null,
                compound.getBoolean("isPlayer"));
    }

    public NBTTagCompound asNBT()
    {

        NBTTagCompound compound = new NBTTagCompound();
        compound.setBoolean("isPlayer", this.isPlayer);
        compound.setString("type", this.activationType.toString());
        if(this.getActivatingEntity() != null) {
            compound.setString("entityUUID", this.getActivatingEntity().getUniqueID().toString());
        }
        if(this.vibration != null)
        {
        compound.setTag("vibration", this.vibration.asNBT());
        }
        return compound;
    }
}
