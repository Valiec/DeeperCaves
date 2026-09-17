package com.kpabr.DeeperCaves.client;

import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCaves.DeeperWorldgen;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ClientEventHandler {
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if(Minecraft.getMinecraft().theWorld == null || Minecraft.getMinecraft().thePlayer == null || Minecraft.getMinecraft().isGamePaused()) return;
        if(Minecraft.getMinecraft().theWorld.getWorldTime() % 4 == 0 && Minecraft.getMinecraft().theWorld.provider.dimensionId == DeeperCaves.worldgen.evil.dimID) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            for (int i = 0; i<5; i++) {
                double randX = player.posX + Minecraft.getMinecraft().theWorld.rand.nextDouble() * 8 - 4;
                double randY = player.posY + Minecraft.getMinecraft().theWorld.rand.nextDouble() * 8 - 4;
                double randZ = player.posZ + Minecraft.getMinecraft().theWorld.rand.nextDouble() * 8 - 4;
                //skip particle spawns inside opaque blocks, you'll never see them
                if(!Minecraft.getMinecraft().theWorld.getBlock((int)randX, (int)randY, (int)randZ).isOpaqueCube()) {
                    Minecraft.getMinecraft().effectRenderer.addEffect(new ParticleSpore(Minecraft.getMinecraft().theWorld, randX, randY, randZ));
                }
            }
        }


        if(Minecraft.getMinecraft().theWorld.getWorldTime() % 4 == 0 && Minecraft.getMinecraft().theWorld.provider.dimensionId == DeeperCaves.worldgen.forgotten.dimID && Minecraft.getMinecraft().thePlayer.posY < 16) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            for (int i = 0; i<2; i++) {
                double randX = player.posX + Minecraft.getMinecraft().theWorld.rand.nextDouble() * 8 - 4;
                double randY = player.posY + Minecraft.getMinecraft().theWorld.rand.nextDouble() * 8 - 4;
                double randZ = player.posZ + Minecraft.getMinecraft().theWorld.rand.nextDouble() * 8 - 4;
                //skip particle spawns inside opaque blocks, you'll never see them
                if(!Minecraft.getMinecraft().theWorld.getBlock((int)randX, (int)randY, (int)randZ).isOpaqueCube()) {
                    Minecraft.getMinecraft().effectRenderer.addEffect(new ParticleSpore(Minecraft.getMinecraft().theWorld, randX, randY, randZ));
                }
            }
        }
    }
}
