package com.kpabr.deepercaves.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class StoneBlock extends Block {

    //public static final IntProperty COLOR = IntProperty.of("color", 0, 12);

    public StoneBlock(FabricBlockSettings strength) {
        super(Settings.of(Material.STONE).requiresTool());
    }

    //@Override
    //protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    //    builder.add(COLOR);
    //}
}
