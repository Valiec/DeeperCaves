package com.kpabr.DeeperCaves;

import com.kpabr.DeeperCaves.entity.TileEntitySculkSensor;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeeperEventHandler {

    public static void postVibrationEvent(VibrationEvent.VibrationEventType type, double x, double y, double z, Entity entity, World world) {
        //allow the event to be canceled
        if(!FMLCommonHandler.instance().bus().post(new VibrationEvent.Before(type, x, y, z, entity, world)))
        {
            FMLCommonHandler.instance().bus().post(new VibrationEvent(type, x, y, z, entity, world));
        }
    }

    public static int getMaxOf3(double rateX, double rateY, double rateZ) {
        return getMinMaxOf3(rateX, rateY, rateZ, false);
    }

    public static int getMinOf3(double rateX, double rateY, double rateZ) {
        return getMinMaxOf3(rateX, rateY, rateZ, true);
    }

    public static int getMinMaxOf3(double rateX, double rateY, double rateZ, boolean invert) {
        //0=x, 1=y, 2=z
        int maxInd;

        //orderings are greatest -> least (or least -> greatest if invert)
        //ZXY,XZY,XYZ,ZYX,YZX,YXZ
        if((!invert && rateX > rateY) || (invert && rateX < rateY)) {
            //ZXY,XZY,XYZ
            if((!invert && rateX > rateZ) || (invert && rateX < rateZ)) {
                //XZY,XYZ
                maxInd = 0;
            }
            else {
                //ZXY
                maxInd = 2;
            }
        }
        else {
            //ZYX,YZX,YXZ
            if( (!invert && rateZ > rateY) || (invert && rateZ < rateY)) {
                //ZYX
                maxInd = 2;
            }
            else {
                //YZX,YXZ
                maxInd = 1;
            }
        }
        return maxInd;
    }

    public static double[] getNextBlockPos(double rateX, double rateY, double rateZ, double curX, double curY, double curZ) {
        double distToNewBlockX = rateX > 0 ? Math.ceil(curX)-curX : curX-Math.floor(curX);
        double distToNewBlockY = rateY > 0 ? Math.ceil(curY)-curY : curY-Math.floor(curY);
        double distToNewBlockZ = rateZ > 0 ? Math.ceil(curZ)-curZ : curZ-Math.floor(curZ);

        if(distToNewBlockX == 0) {
            distToNewBlockX = 1;
        }

        if(distToNewBlockY == 0) {
            distToNewBlockY = 1;
        }

        if(distToNewBlockZ == 0) {
            distToNewBlockZ = 1;
        }

        //System.out.println("distToNewBlock: ("+distToNewBlockX+", "+distToNewBlockY+", "+distToNewBlockZ+")");
        //System.out.println("rates: ("+rateX+", "+rateY+", "+rateZ+")");

        int closestToNew = getMinOf3(rateX != 0 ? distToNewBlockX/Math.abs(rateX) : Double.POSITIVE_INFINITY, rateY != 0 ? distToNewBlockY/Math.abs(rateY) : Double.POSITIVE_INFINITY, rateZ != 0 ? distToNewBlockZ/Math.abs(rateZ) : Double.POSITIVE_INFINITY);

        //System.out.println("closestToNew: " + closestToNew);

        switch(closestToNew) {
            case 0:
                curX += distToNewBlockX*Math.signum(rateX);
                curY += (distToNewBlockY*(rateY/Math.abs(rateX)));
                curZ += (distToNewBlockZ*(rateZ/Math.abs(rateX)));
                break;
            case 1:
                curX += (distToNewBlockX*(rateX/Math.abs(rateY)));
                curY+= distToNewBlockY*Math.signum(rateY);
                curZ += (distToNewBlockZ*(rateZ/Math.abs(rateY)));
                break;
            case 2:
                curX += (distToNewBlockX*(rateX/Math.abs(rateZ)));
                curY += (distToNewBlockY*(rateY/Math.abs(rateZ)));
                curZ += distToNewBlockZ*Math.signum(rateZ);
                break;
            default:
                //do nothing
        }

        return new double[] {curX, curY, curZ};

    }

    public static boolean woolInPath(double x1, double y1, double z1, double x2, double y2, double z2, World world) {
        double[] curPos = new  double[] {x1, y1, z1};

        double rateX = x2 - x1;
        double rateY = y2 - y1;
        double rateZ = z2 - z1;

        boolean negX = rateX < 0;
        boolean negY = rateY < 0;
        boolean negZ = rateZ < 0;

        //System.out.println("RAYCASTING: ("+x1+", "+y1+", "+z1+") -> ("+x2+", "+y2+", "+z2+")");

        while(((!negX && curPos[0] < x2) || (negX && curPos[0] > x2))
                || ((!negY && curPos[1] < y2) || (negY && curPos[1] > y2))
                || ((!negZ && curPos[2] < z2) || (negZ && curPos[2] > z2))) {
            Block block = world.getBlock((int)Math.floor(curPos[0]), (int)Math.floor(curPos[1]), (int)Math.floor(curPos[2]));
            //System.out.println("block: " + block.getUnlocalizedName());
            if(block == Blocks.wool || block == Blocks.carpet) {
                //System.out.println("WOOL IN PATH");
                return true;
            }
            curPos = getNextBlockPos(rateX, rateY, rateZ, curPos[0], curPos[1], curPos[2]);
            //System.out.println("new pos: ("+curPos[0]+", "+curPos[1]+", "+curPos[2]+")");
        }
        //System.out.println("NO WOOL");
        return false;
    }

    public static List<Triple<Block, Integer[], Double>> findBlocksWithinRadius(double xPos, double yPos, double zPos, int radius, World world, boolean woolCheck, Block... targets) {
        List<Block> targetBlocks = Arrays.asList(targets);

        List<Triple<Block, Integer[], Double>> foundBlocks = new ArrayList<Triple<Block, Integer[], Double>>();

        int x = (int) xPos;
        int y = (int) yPos;
        int z = (int) zPos;

        int isq;
        int jsq;
        int ksq;

        int sqRadius = radius*radius;

        for(int i = -8; i <= radius; ++i) {
            isq = i * i;
            for(int j = -8; j <= radius; ++j) {
                jsq = j * j;
                for(int k = -8; k <= radius; ++k) {
                    ksq = k * k;
                    if(isq+jsq+ksq <= sqRadius) {
                        Block block = world.getBlock(x+i, y+j, z+k);
                        if(targetBlocks.contains(block)) {
                            if(!woolCheck || !woolInPath(xPos, yPos, zPos, x+i+0.5D, y+j+0.5D, z+k+0.5D, world)) {
                                foundBlocks.add(Triple.of(block, new Integer[] {x+i, y+j, z+k}, Math.ceil(Math.sqrt(isq + jsq + ksq))));
                            }
                        }
                    }
                }
            }
        }
        return foundBlocks;
    }

    @SubscribeEvent
    public void onVibration(VibrationEvent event) {
        List<Triple<Block, Integer[], Double>> sensors = findBlocksWithinRadius(event.x, event.y, event.z, 8, event.world, true, DeeperBlocks.sculkSensor);

        for(Triple<Block, Integer[], Double> sensor : sensors) {
            Integer[] coords = sensor.getMiddle();
            double dist = sensor.getRight();
            EntityPlayer activatingPlayer = null;
            if (event.hasEntity && event.entity instanceof EntityPlayer) {
                activatingPlayer = (EntityPlayer)event.entity;
            }
            ((TileEntitySculkSensor) event.world.getTileEntity(coords[0], coords[1], coords[2])).activate((int)dist, activatingPlayer);
        }
    }

    @SubscribeEvent
    public void onPlaySound(PlaySoundAtEntityEvent event) {
        if(!event.entity.worldObj.isRemote) {
            double entityX = event.entity.posX;
            double entityY = event.entity.boundingBox.minY; //feet height
            double entityZ = event.entity.posZ;

            List<String> excludedSounds = Arrays.asList("step.cloth", "dig.cloth", "hit.cloth", "jump.cloth", "land.cloth", "fall.cloth");



            if(!event.entity.isSneaking() && !excludedSounds.contains(event.name)) {
                postVibrationEvent(VibrationEvent.VibrationEventType.ENTITY_SOUND, entityX, entityY, entityZ, event.entity, event.entity.worldObj);
            }
        }
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        if(event.block != Blocks.wool && event.block != Blocks.carpet) {
            postVibrationEvent(VibrationEvent.VibrationEventType.BLOCK_BREAK, event.x+0.5D, event.y+0.5D, event.z+0.5D, event.getPlayer(), event.world);
        }
    }

    @SubscribeEvent
    public void onBlockPlace(BlockEvent.PlaceEvent event) {
        if(event.block != Blocks.wool && event.block != Blocks.carpet) {
            postVibrationEvent(VibrationEvent.VibrationEventType.BLOCK_PLACE, event.x+0.5D, event.y+0.5D, event.z+0.5D, event.player, event.world);
        }
    }


    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if(event.entity instanceof EntityPlayer && (event.entity).getExtendedProperties(DeeperCavesExtendedPlayerData.NAME) == null) {
            EntityPlayer player = (EntityPlayer)event.entity;
            player.registerExtendedProperties(DeeperCavesExtendedPlayerData.NAME, new DeeperCavesExtendedPlayerData(player));
        }
    }

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        event.entity.registerExtendedProperties(DeeperCavesExtendedPlayerData.NAME, event.original.getExtendedProperties(DeeperCavesExtendedPlayerData.NAME));
    }

    public static boolean isPlayerInBlock(EntityLivingBase player, Block block)
    {
        //System.out.println("==============");
        //System.out.println("CHECK: "+(int)player.posX+", "+(int)player.posY+", "+((int)(player.posZ)-1));
        Block block1 = player.worldObj.getBlock((int)player.posX, (int)player.posY, (int)player.posZ-1);
        //System.out.println("BLOCK1: "+block1.getUnlocalizedName());
        if(block1 == block)
        {
            //System.out.println("==============");
            return true;
        }
        Block block2 = player.worldObj.getBlock((int)player.posX, (int)player.posY+1, (int)player.posZ-1);
        //System.out.println("BLOCK2: "+block2.getUnlocalizedName());
        //System.out.println("==============");
        return block2 == block;
        //System.out.println("==============");
    }

    //@SubscribeEvent
    //public void onLivingUpdate(LivingEvent event) {
        //if(event.entityLiving != null) {
            //if (isPlayerInBlock(event.entityLiving, DeeperFluids.veneniumBlock)) {
            //    event.entityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 1));
            //}
        //}
   // }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        try
        {
            EntityPlayerMP player = (EntityPlayerMP)event.player;
            //boolean voidFlag = ((DeeperCaves.instance.voidFlag.get(player.getUniqueID()) != null) ? DeeperCaves.instance.voidFlag.get(player.getUniqueID()) : false);
            //boolean deepFlag = ((DeeperCaves.instance.deepFlag.get(player.getUniqueID()) != null) ? DeeperCaves.instance.deepFlag.get(player.getUniqueID()) : false);

            DeeperCavesExtendedPlayerData extData = (DeeperCavesExtendedPlayerData) player.getExtendedProperties(DeeperCavesExtendedPlayerData.NAME);

            if (extData != null) {

                boolean voidFlag = extData.voidCharm();
                boolean deepFlag = extData.forgottenCharm();

                int voidCounter = extData.voidCounter();
                int deepCounter = extData.deepCounter();

                if (event.player.posY <= 240.0D && player.dimension == DeeperCaves.worldgen.nearVoid.dimID) {
                    if (!voidFlag) {
                        if (voidCounter == 200) {
                            player.attackEntityFrom(DamageSource.outOfWorld, 0.5F);
                            voidCounter = 0;
                            extData.setVoidCounter(voidCounter);
                        } else {
                            voidCounter++;
                            extData.setVoidCounter(voidCounter);
                        }

                    } else if (voidCounter == 0) {
                        extData.setVoidCounter(voidCounter);
                        extData.unsetVoidCharm();
                    } else if (voidCounter == 200) {
                        voidCounter = 0;
                        extData.setVoidCounter(voidCounter);
                    } else {
                        voidCounter++;
                        extData.setVoidCounter(voidCounter);
                    }
                }
                if (event.player.posY <= 240.0D && player.dimension == DeeperCaves.worldgen.farVoid.dimID) {
                    if (!voidFlag) {
                        if (voidCounter >= 9) {
                            player.attackEntityFrom(DamageSource.outOfWorld, 4.0F);
                            voidCounter = 0;
                            extData.setVoidCounter(voidCounter);
                        } else {
                            voidCounter++;
                            extData.setVoidCounter(voidCounter);
                        }

                    } else if (voidCounter == 0) {

                        extData.unsetVoidCharm();
                        voidCounter++;
                        extData.setVoidCounter(voidCounter);
                    } else if (voidCounter >= 9) {
                        voidCounter = 0;
                        extData.setVoidCounter(voidCounter);
                    } else {
                        voidCounter++;
                        extData.setVoidCounter(voidCounter);
                    }
                }
                if (player.dimension == DeeperCaves.worldgen.forgotten.dimID) {
                    if (deepCounter == 0 && deepFlag) {
                        extData.unsetForgottenCharm();
                        deepCounter++;
                        extData.setDeepCounter(deepCounter);
                    } else if (deepCounter >= 1 && deepFlag) {
                        deepCounter = 0;
                        extData.setDeepCounter(deepCounter);
                    } else {
                        deepCounter++;
                        extData.setDeepCounter(deepCounter);
                    }
                }
            }
        }
        catch(ClassCastException e)
        {
            //not a player
        }

    }
}
