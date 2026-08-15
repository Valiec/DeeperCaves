package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCaves.DeeperFluids;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperRavine;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.MapGenBase;

import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

public class ChunkProviderCrystal extends ChunkProviderDeeperBase
{
    /** RNG. */
    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault(1.0F, 4.0D);
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 3, 1.5, 1.0, Blocks.stone);
    private NoiseGeneratorOctaves caveFloorNoise;
    private NoiseGeneratorOctaves caveCeilingNoise;
    private NoiseGeneratorPerlin pillarHeightNoise;
    private NoiseGeneratorPerlin wallHeightNoise;
    double[] floorNoise;
    double[] pillarNoise;
    double[] wallNoise;
    double[] ceilingNoise;

    public ChunkProviderCrystal(World par1World, long par2, boolean par4)
    {
    	super(par1World, par2, par4);
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 152;
        this.caveFloorNoise = new NoiseGeneratorOctaves(this.rand, 5);
        this.caveCeilingNoise = new NoiseGeneratorOctaves(this.rand, 5);
        this.pillarHeightNoise = new NoiseGeneratorPerlin(this.rand, 1);
        this.wallHeightNoise = new NoiseGeneratorPerlin(this.rand, 2);
    }

    public void initNoiseTerrain(int p_147422_1_, int p_147422_2_, Block[] p_147422_3_) {

        double d0 = 0.03125D;

        floorNoise = this.caveFloorNoise.generateNoiseOctaves(floorNoise, p_147422_1_ * 16, 0, p_147422_2_ * 16, 16, 1, 16, 0.03125, 0, 0.03125);

        pillarNoise = this.pillarHeightNoise.func_151599_a(pillarNoise, p_147422_1_ * 16, p_147422_2_ * 16, 16, 16, 0.05, 0.05, 1);

        wallNoise = this.wallHeightNoise.func_151600_a(wallNoise, p_147422_1_ * 16, p_147422_2_ * 16, 16, 16, 0.012, 0.012, 1, 2.0);

        ceilingNoise = this.caveCeilingNoise.generateNoiseOctaves(ceilingNoise, p_147422_1_ * 16, 0, p_147422_2_ * 16, 16, 1, 16, 0.03125, 0, 0.03125);


        for (int k = 0; k < 16; ++k) {
            for (int l = 0; l < 16; ++l) {
                //biomegenbase.genTerrainBlocks(this.worldObj, this.rand, p_147422_3_, p_147422_4_, p_147422_1_ * 16 + k, p_147422_2_ * 16 + l, this.stoneNoise[l + k * 16]);
                boolean flag = true;
                Block block = Blocks.grass;
                //byte b0 = (byte)(this.field_150604_aj & 255);
                Block block1 = Blocks.dirt;
                //int l = (int)(this.stoneNoise[l + k * 16] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
                int i1 = p_147422_1_ * 16 + k & 15;
                int j1 = p_147422_2_ * 16 + l & 15;
                int k1 = p_147422_3_.length / 256;

                double floorHeightRaw = 36 + 1.5 * floorNoise[j1 * 16 + i1];
                double wallHeightRaw = 14.0 * (1.18* wallNoise[i1 * 16 + j1] + 0.15);
                double cavernHeightRaw = wallHeightRaw + 1.5 * ceilingNoise[j1 * 16 + i1];

                if (cavernHeightRaw < 0) {
                    cavernHeightRaw = 0;
                }

                int trueFloorHeight   = MathHelper.floor_double(floorHeightRaw - wallHeightRaw);
                int trueCeilingHeight = MathHelper.floor_double(floorHeightRaw + cavernHeightRaw);

                double pillarVal = ((pillarNoise[i1 * 16 + j1]) - 0.3);

                if (pillarVal > 0) {
                    trueFloorHeight += (int) (110 * pillarVal);
                    trueCeilingHeight -= (int) (110 * pillarVal);
                }

                for (int l1 = 255; l1 >= 0; --l1) {
                    int i2 = (j1 * 16 + i1) * k1 + l1;

                    if (l1 >= trueCeilingHeight)
                    {
                        p_147422_3_[i2] = Blocks.stone;
                    }
                    else if (l1 <= trueFloorHeight)
                    {
                        p_147422_3_[i2] = Blocks.stone;
                    }
                    else if (l1 <= 28)
                    {
                        p_147422_3_[i2] = Blocks.water;
                    }
                    else
                    {
                        p_147422_3_[i2] = Blocks.air;
                    }

                }

            }
        }
    }


    @Override
    public void func_147424_a(int p_147424_1_, int p_147424_2_, Block[] p_147424_3_)
    {
        initWorldBlocks(p_147424_1_, p_147424_2_, p_147424_3_);
        initNoiseTerrain(p_147424_1_, p_147424_2_, p_147424_3_);
    }

    /*@Override
    public void finalGenPass(int p_147422_1_, int p_147422_2_, Block[] p_147422_3_, byte[] p_147422_4_, BiomeGenBase[] p_147422_5_)
    {

        for (int k = 0; k < 16; ++k)
        {
            for (int l = 0; l < 16; ++l)
            {

                int i1 = p_147422_1_ * 16 + k & 15;
                int j1 = p_147422_2_ * 16 + l & 15;
                int k1 = p_147422_3_.length / 256;
                for (int l1 = 48; l1 >= 0; --l1)
                {

                    int i2 = (j1 * 16 + i1) * k1 + l1;
                    if (l1 <= 48 && (p_147422_3_[i2] == Blocks.air || p_147422_3_[i2] == null))
                    {
                        p_147422_3_[i2] = Blocks.water;
                    }
                }

            }
        }
    }*/
    
}