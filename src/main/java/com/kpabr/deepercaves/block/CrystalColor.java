package com.kpabr.deepercaves.block;

import net.minecraft.util.StringIdentifiable;

import java.util.Locale;

public enum CrystalColor implements StringIdentifiable {
    white,
    orange,
    magenta,
    lightBlue,
    yellow,
    lime,
    pink,
    gray,
    lightGray,
    cyan,
    purple,
    blue,
    brown,
    green,
    red,
    black;

    @Override
    public String asString() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
