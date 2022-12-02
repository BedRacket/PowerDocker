package org.bedracket.powerdocker.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;
import org.bedracket.powerdocker.api.mana.IManaHandler;
import org.bedracket.powerdocker.api.network.INormalMessage;

import java.util.function.Supplier;

public class PlayerManaMessage implements INormalMessage {

    float mana;
    float maxMana;

    public PlayerManaMessage(float mana, float maxMana) {
        this.mana = mana;
        this.maxMana = maxMana;
    }

    public PlayerManaMessage(FriendlyByteBuf buf) {
        mana = buf.readFloat();
        maxMana = buf.readFloat();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeFloat(mana);
        buf.writeFloat(maxMana);
    }

    @Override
    public void process(Supplier<NetworkEvent.Context> context) {
        if (context.get().getDirection() == NetworkDirection.PLAY_TO_CLIENT) {
            Player player = Minecraft.getInstance().player;
            if (player != null) {
                context.get().enqueueWork(() -> ((IManaHandler) player).setMana(mana));
                context.get().enqueueWork(() -> ((IManaHandler) player).setMaxMana(maxMana));
            }
        }
    }
}