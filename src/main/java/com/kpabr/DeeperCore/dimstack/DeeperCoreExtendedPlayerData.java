package com.kpabr.DeeperCore.dimstack;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class DeeperCoreExtendedPlayerData implements IExtendedEntityProperties {

    public static final String NAME = "DeeperCoreExtendedPlayerData";

    public EntityPlayer player;
    public boolean tpEnabled;

    public DeeperCoreExtendedPlayerData(EntityPlayer player) {
        this.player = player;
        this.tpEnabled = true;
    }

    public void setTPEnabled(boolean enabled) {
        this.tpEnabled = enabled;
    }

    public boolean toggleTPEnabled() {
        this.tpEnabled = !this.tpEnabled;
        return this.tpEnabled;
    }


    @Override
    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound deeperCoreData  = new NBTTagCompound();
        deeperCoreData.setBoolean("tpEnabled", this.tpEnabled);
        compound.setTag("deeperCoreData", deeperCoreData);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {
        NBTTagCompound deeperCoreData  = compound.getCompoundTag("deeperCoreData");
        this.tpEnabled = deeperCoreData.getBoolean("tpEnabled");

    }

    @Override
    public void init(Entity entity, World world) {

    }
}
