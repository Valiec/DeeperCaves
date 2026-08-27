package com.kpabr.DeeperCaves;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class DeeperF3Mesages {
    @SubscribeEvent
    public void renderF3(RenderGameOverlayEvent.Text event) {
        Minecraft mc = Minecraft.getMinecraft();
        if(mc.gameSettings.showDebugInfo && mc.theWorld != null && mc.thePlayer != null) {
            double dimY = mc.thePlayer.boundingBox.minY;
            double depth = DeeperCaves.worldgen.getTotalDepth(mc.thePlayer.worldObj.provider.dimensionId, dimY);

            String depthStr = String.format("Depth: %.3f (%s)", depth, mc.thePlayer.worldObj.provider.getDimensionName());
            event.left.add(null);
            event.left.add(depthStr);
        }
    }
}
