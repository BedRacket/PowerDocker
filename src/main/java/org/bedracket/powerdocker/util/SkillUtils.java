package org.bedracket.powerdocker.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class SkillUtils {

    public static void callSmallFireBall(Player player, Level level, Item wand) {
        ItemStack needItem = player.getOffhandItem().getItem().getDefaultInstance();
        ItemStack itemStack = player.getMainHandItem().getItem().getDefaultInstance();
        if (needItem.is(Items.FLINT_AND_STEEL)
                && itemStack.is(wand)) {
            LargeFireball largefireball = new LargeFireball(level, player, player.getXRot(), player.getYRot(), player.getZ(), 0);
            largefireball.setPos(player.getX() + player.getYRot(), player.getY(), player.getZ());
            level.addFreshEntity(largefireball);
        }
    }
}
