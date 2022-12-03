package org.bedracket.powerdocker.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import org.bedracket.powerdocker.api.mana.IManaHandler;
import org.bedracket.powerdocker.api.network.INormalMessage;

import java.util.function.Supplier;

public class ManaRestoreMessage implements INormalMessage {

    public ManaRestoreMessage(FriendlyByteBuf buf) {

    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {

    }

    @Override
    public void process(Supplier<NetworkEvent.Context> context) {
        ServerPlayer player = context.get().getSender();
        if (player != null) {
            SimpleNetworkHandler.CHANNEL.
                    send(PacketDistributor.PLAYER.with(() -> player),
                            new PlayerManaMessage(((IManaHandler) player).getMana(),
                                    ((IManaHandler) player).getMaxMana()));
        }
    }
}