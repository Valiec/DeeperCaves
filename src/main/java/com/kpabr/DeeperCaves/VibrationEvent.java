package com.kpabr.DeeperCaves;

import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

@Cancelable
public class VibrationEvent extends Event {
    public enum VibrationEventType
    {
        BLOCK_BREAK,
        BLOCK_PLACE,
        ENTITY_MOVEMENT,
        ENTITY_DAMAGE,
        ENTITY_DEATH,
        PROJECTILE,
        ENTITY_SOUND,
        CHEST
    }

    public VibrationEventType vibrationType;
    public double x;
    public double y;
    public double z;
    public Entity entity;
    public World world;
    public boolean hasEntity;

    public VibrationEvent(VibrationEventType type, double x, double y, double z, Entity entity, World world)
    {
        this.vibrationType = type;
        this.x = x;
        this.y = y;
        this.z = z;
        this.entity = entity;
        this.world = world;
        if(this.entity != null) {
            this.hasEntity = true;
        }
        else {
            this.hasEntity = false;
        }

    }

    public static class Before extends VibrationEvent {
        public Before(VibrationEventType type, double x, double y, double z, Entity entity, World world) {
            super(type, x, y, z, entity, world);
        }
    }
}
