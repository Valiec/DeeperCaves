package com.kpabr.DeeperCaves;

import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

@Cancelable
public class VibrationEvent extends Event {

    public Entity entity;
    public World world;
    public boolean hasEntity;
    public SculkVibration vibration;

    public VibrationEvent(SculkVibration vibration, Entity entity, World world)
    {
        this.vibration = vibration;
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
        public Before(SculkVibration vibration, Entity entity, World world) {
            super(vibration, entity, world);
        }
    }
}
