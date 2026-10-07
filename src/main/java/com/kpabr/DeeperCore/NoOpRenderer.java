package com.kpabr.DeeperCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.client.IRenderHandler;

public class NoOpRenderer extends IRenderHandler {

    public void render(float partialTickTime, WorldClient theWorld, Minecraft mc) {
    }
}
