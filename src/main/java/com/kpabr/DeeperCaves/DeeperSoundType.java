package com.kpabr.DeeperCaves;

import net.minecraft.block.Block;

public class DeeperSoundType extends Block.SoundType {
    public DeeperSoundType(String p_i45393_1_, float p_i45393_2_, float p_i45393_3_) {
        super(p_i45393_1_, p_i45393_2_, p_i45393_3_);
    }

    public String getBreakSound()
    {
        return "deepercaves:dig." + this.soundName;
    }

    public String getStepResourcePath()
    {
        return "deepercaves:step." + this.soundName;
    }

    public String func_150496_b()
    {
        return this.getBreakSound();
    }
}
