package org.bedracket.powerdocker.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import org.bedracket.powerdocker.api.mana.IManaHandler;

import java.util.List;

public class ManaUtils {

    public static void reducePlayerMana(Player player, float reduceValue) {
        if (!player.isCreative()) {
            ((IManaHandler) player).reduceMana(reduceValue);
        }
    }

    public static void isManaWeapon(List<Component> tooltip) {
        tooltip.add(Component.translatable("tooltip.powerdocker.mana.weapons").withStyle(ChatFormatting.DARK_PURPLE));
    }
}
