package com.kpabr.deepercaves.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class CrystalBlock extends Block {

    //public static final IntProperty COLOR = IntProperty.of("color", 0, 12);

    public CrystalBlock(FabricBlockSettings strength) {
        super(Settings.of(Material.AMETHYST).nonOpaque());
    }

    //@Override
    //protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    //    builder.add(COLOR);
    //}
}
