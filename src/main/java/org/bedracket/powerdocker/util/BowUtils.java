package org.bedracket.powerdocker.util;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class BowUtils {

    public static void bowItemOverrides(Item bowItem) {
        ItemProperties.register(bowItem, new ResourceLocation("pulling"), (itemStack, world, livingEntity, num)
                -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);
    }
}
