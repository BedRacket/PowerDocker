package org.bedracket.powerdocker.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ItemModelHandler {

    public static void registerModel(Object obj) {
        if(obj instanceof Item item) {
            Minecraft.getInstance().getItemRenderer().getItemModelShaper().register(item,
                    new ModelResourceLocation(item.getDescriptionId(), "inventory"));
        } else if (obj instanceof Block block) {
            Minecraft.getInstance().getItemRenderer().getItemModelShaper().register(block.asItem(),
                    new ModelResourceLocation(block.getDescriptionId(), "inventory"));
        } else {
            throw new IllegalArgumentException("Item or Block required!");
        }
    }
}
