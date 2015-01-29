package com.kpabr.DeeperCaves;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class DeeperRendering {
    public void setupArmorRenderers()
    {
        /*Setting up armor renderers*/
        RenderingRegistry.addNewArmourRendererPrefix("enderite");
        RenderingRegistry.addNewArmourRendererPrefix("flamerite");
        RenderingRegistry.addNewArmourRendererPrefix("gflamerite");
        RenderingRegistry.addNewArmourRendererPrefix("infusedquartz");
    }
    
}
