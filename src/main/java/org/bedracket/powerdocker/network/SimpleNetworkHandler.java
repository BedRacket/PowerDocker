package org.bedracket.powerdocker.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.bedracket.powerdocker.PowerdockerMod;
import org.bedracket.powerdocker.api.network.INormalMessage;

import java.util.function.Function;

public final class SimpleNetworkHandler {

    public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(PowerdockerMod.MOD_ID, "main"))
            .networkProtocolVersion(() -> PowerdockerMod.NETWORK_VERSION)
            .serverAcceptedVersions(PowerdockerMod.NETWORK_VERSION::equals)
            .clientAcceptedVersions(PowerdockerMod.NETWORK_VERSION::equals).simpleChannel();

    public static void init() {
        int id = 0;
        registerMessage(id++, PlayerManaMessage.class, PlayerManaMessage::new);
        registerMessage(id++, ManaRestoreMessage.class, ManaRestoreMessage::new);
    }

    private static <T extends INormalMessage> void registerMessage(int index, Class<T> messageType, Function<FriendlyByteBuf, T> decoder) {
        CHANNEL.registerMessage(index, messageType, INormalMessage::toBytes, decoder, (message, context) -> {
            message.process(context);
            context.get().setPacketHandled(true);
        });
    }
}