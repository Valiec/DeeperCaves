package com.kpabr.DeeperCore.world;

import com.kpabr.DeeperCore.dimstack.DeeperLayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class WorldProviderDeeperBase extends WorldProvider
{

    public DeeperLayer layer;


    public WorldProviderDeeperBase(DeeperLayer layer) {
        super();
        this.layer = layer;
    }
}
