package com.kpabr.DeeperCaves.network;

import com.kpabr.DeeperCaves.DeeperCaves;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class PacketSculkShriekS2C implements IMessage {

    double xSrc;
    double ySrc;
    double zSrc;

    public PacketSculkShriekS2C() { }

    public PacketSculkShriekS2C(double xSrc, double ySrc, double zSrc) {
        this.xSrc = xSrc;
        this.ySrc = ySrc;
        this.zSrc = zSrc;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.xSrc = buf.readDouble();
        this.ySrc = buf.readDouble();
        this.zSrc = buf.readDouble();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeDouble(xSrc);
        buf.writeDouble(ySrc);
        buf.writeDouble(zSrc);
    }

    public static class Handler implements IMessageHandler<PacketSculkShriekS2C, IMessage> {
        @Override
        public IMessage onMessage(PacketSculkShriekS2C message, MessageContext ctx) {
            //System.out.println("PACKET!!!!: "+message.xSrc+", "+message.ySrc+", "+message.zSrc);
            DeeperCaves.proxy.spawnShriekParticle(message.xSrc, message.ySrc, message.zSrc);
            return null;
        }
    }
}
