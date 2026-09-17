package com.kpabr.DeeperCaves.network;

import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCaves.client.ParticleVibration;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class PacketSculkActivationS2C implements IMessage {

    double xSrc;
    double ySrc;
    double zSrc;
    double xDest;
    double yDest;
    double zDest;
    double speed;

    public PacketSculkActivationS2C() { }

    public PacketSculkActivationS2C(double xSrc, double ySrc, double zSrc, double xDest, double yDest, double zDest, double speed) {
        this.xSrc = xSrc;
        this.ySrc = ySrc;
        this.zSrc = zSrc;
        this.xDest = xDest;
        this.yDest = yDest;
        this.zDest = zDest;
        this.speed = speed;
    }

    public PacketSculkActivationS2C(double xSrc, double ySrc, double zSrc, double xDest, double yDest, double zDest) {
        this(xSrc, ySrc, zSrc, xDest, yDest, zDest, 1.0);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.xSrc = buf.readDouble();
        this.ySrc = buf.readDouble();
        this.zSrc = buf.readDouble();
        this.xDest = buf.readDouble();
        this.yDest = buf.readDouble();
        this.zDest = buf.readDouble();
        this.speed = buf.readDouble();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeDouble(xSrc);
        buf.writeDouble(ySrc);
        buf.writeDouble(zSrc);
        buf.writeDouble(xDest);
        buf.writeDouble(yDest);
        buf.writeDouble(zDest);
        buf.writeDouble(speed);
    }

    public static class Handler implements IMessageHandler<PacketSculkActivationS2C, IMessage> {
        @Override
        public IMessage onMessage(PacketSculkActivationS2C message, MessageContext ctx) {
            //System.out.println("PACKET!!!!: "+message.xSrc+", "+message.ySrc+", "+message.zSrc+" -> "+message.xDest+", "+message.yDest+", "+message.zDest);
            DeeperCaves.proxy.spawnVibrationParticle(message.xSrc, message.ySrc, message.zSrc, message.xDest, message.yDest, message.zDest, message.speed);
            return null;
        }
    }
}
