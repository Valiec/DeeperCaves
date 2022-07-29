package com.kpabr.deepercaves;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class DeeperClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //BlockRenderLayerMap.INSTANCE.putBlock(DeeperCaves.CRYSTAL, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(DeeperCaves.WHITE_CRYSTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DeeperCaves.PURPLE_CRYSTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DeeperCaves.LIGHT_BLUE_CRYSTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DeeperCaves.DARK_BLUE_CRYSTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DeeperCaves.LIGHT_GREEN_CRYSTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DeeperCaves.DARK_GREEN_CRYSTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DeeperCaves.AQUA_CRYSTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DeeperCaves.TURQUOISE_CRYSTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DeeperCaves.YELLOW_CRYSTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DeeperCaves.PINK_CRYSTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DeeperCaves.RED_CRYSTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DeeperCaves.MAGENTA_CRYSTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(DeeperCaves.ORANGE_CRYSTAL, RenderLayer.getTranslucent());
    }
}
