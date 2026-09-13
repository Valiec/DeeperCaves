package com.kpabr.DeeperCaves;

import com.kpabr.DeeperCaves.entity.TileEntitySculkActivatable;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.world.BlockEvent;
import org.apache.commons.lang3.tuple.Triple;

import java.util.*;
import java.util.function.BiPredicate;

public class DeeperSculkManager {

    public static Map<SculkActivation.ActivationType, List<Block>> listeningBlocks =  new HashMap<SculkActivation.ActivationType, List<Block>>();

    public static void registerTypeForBlock(Block block, SculkActivation.ActivationType activationType) {
        registerTypesForBlock(block, activationType);
    }

    public static void registerTypesForBlockExcept(Block block, SculkActivation.ActivationType... exceptTypes) {
        List<SculkActivation.ActivationType> activationTypes = new ArrayList<SculkActivation.ActivationType>(Arrays.asList(SculkActivation.ActivationType.values()));
        activationTypes.removeAll(Arrays.asList(exceptTypes));
        registerTypesForBlock(block, activationTypes.toArray(new SculkActivation.ActivationType[0]));
    }

    public static void registerTypesForBlock(Block block, SculkActivation.ActivationType... activationTypes) {
        for(SculkActivation.ActivationType activationType : activationTypes) {
            if(!listeningBlocks.containsKey(activationType)) {
                listeningBlocks.put(activationType, new ArrayList<Block>());
            }
            listeningBlocks.get(activationType).add(block);
        }
    }

    //exists to avoid array operations for one block
    public static boolean hasNeighbor(int x, int y, int z, World world, Block block) {
        return world.getBlock(x - 1, y, z) == block ||
                world.getBlock(x + 1, y, z) == block ||
                world.getBlock(x, y + 1, z) == block ||
                world.getBlock(x, y + 1, z) == block ||
                world.getBlock(x, y, z - 1) == block ||
                world.getBlock(x, y, z + 1) == block;
    }

    public static boolean hasNeighborMulti(int x, int y, int z, World world, Block... blocks) {
        List<Block> blockList = Arrays.asList(blocks);
        return blockList.contains(world.getBlock(x - 1, y, z)) ||
                blockList.contains(world.getBlock(x + 1, y, z)) ||
                blockList.contains(world.getBlock(x, y + 1, z)) ||
                blockList.contains(world.getBlock(x, y + 1, z)) ||
                blockList.contains(world.getBlock(x, y, z - 1)) ||
                blockList.contains(world.getBlock(x, y, z + 1));
    }

    public static void broadcastInRadiusBlocks(SculkActivation activation, SculkActivation newActivation, double xPos, double yPos, double zPos, int radius, World world, boolean woolCheck, BiPredicate<Block, SculkActivation> broadcastCheck, Block... targetBlocks) {

        List<Triple<Block, Integer[], Double>> targets = DeeperSculkManager.findBlocksWithinRadius(xPos, yPos, zPos, radius, world, woolCheck, targetBlocks);

        if(activation != null) {
            for (Triple<Block, Integer[], Double> target : targets) {
                Integer[] coords = target.getMiddle();
                double dist = target.getRight();
                if (broadcastCheck == null || broadcastCheck.test(target.getLeft(), activation)) {
                    ((TileEntitySculkActivatable) world.getTileEntity(coords[0], coords[1], coords[2])).activate((int) dist, newActivation);
                }
            }
        }
    }

    public static void broadcastInRadius(SculkActivation activation, SculkActivation newActivation, double xPos, double yPos, double zPos, int radius, World world, boolean woolCheck, BiPredicate<Block, SculkActivation> broadcastCheck) {

        Block[] targetBlocks = listeningBlocks.get(newActivation.activationType).toArray(new Block[0]);
        broadcastInRadiusBlocks(activation, newActivation, xPos, yPos, zPos, radius, world, woolCheck, broadcastCheck, targetBlocks);
    }

    public static void postVibrationEvent(SculkVibration vibration, Entity entity, World world) {
        //allow the event to be canceled
        if(!FMLCommonHandler.instance().bus().post(new VibrationEvent.Before(vibration, entity, world)))
        {
            FMLCommonHandler.instance().bus().post(new VibrationEvent(vibration, entity, world));
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
        new SculkActivation(event.hasEntity ? event.entity : null, SculkActivation.ActivationType.VIBRATION, event.vibration).broadcastInRadius(event.vibration.x, event.vibration.y, event.vibration.z, 8, event.world);
    }

    @SubscribeEvent
    public void onPlaySound(PlaySoundAtEntityEvent event) {
        if(!event.entity.worldObj.isRemote) {
            double entityX = event.entity.posX;
            double entityY = event.entity.boundingBox.minY; //feet height
            double entityZ = event.entity.posZ;

            List<String> excludedSounds = Arrays.asList("step.cloth", "dig.cloth", "hit.cloth", "jump.cloth", "land.cloth", "fall.cloth");



            if(!event.entity.isSneaking() && !excludedSounds.contains(event.name)) {
                postVibrationEvent(new SculkVibration(SculkVibration.VibrationEventType.ENTITY_SOUND, entityX, entityY, entityZ), event.entity, event.entity.worldObj);
            }
        }
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        if(event.block != Blocks.wool && event.block != Blocks.carpet) {
            postVibrationEvent(new SculkVibration(SculkVibration.VibrationEventType.BLOCK_BREAK, event.x+0.5D, event.y+0.5D, event.z+0.5D), event.getPlayer(), event.world);
        }
    }

    @SubscribeEvent
    public void onBlockPlace(BlockEvent.PlaceEvent event) {
        if(event.block != Blocks.wool && event.block != Blocks.carpet) {
            postVibrationEvent(new SculkVibration(SculkVibration.VibrationEventType.BLOCK_PLACE, event.x+0.5D, event.y+0.5D, event.z+0.5D), event.player, event.world);
        }
    }
}
