package org.bedracket.powerdocker.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.bedracket.powerdocker.PowerDockerMod;

public class ModItemGroups {

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(
            new Identifier(PowerDockerMod.MOD_ID, "general"))
            .icon(() -> new ItemStack(ModItems.BED_RACKET.get()))
            .entries((enabledFeatures, entries, operatorEnabled) -> {
                entries.add(ModItems.COPPER_SWORD.get());
                entries.add(ModItems.COPPER_NUGGET.get());
                entries.add(ModItems.COPPER_AXE.get());
                entries.add(ModItems.COPPER_HOE.get());
                entries.add(ModItems.COPPER_PICKAXE.get());
                entries.add(ModItems.COPPER_SHOVEL.get());
                entries.add(ModItems.COPPER_HELMET.get());
                entries.add(ModItems.COPPER_CHESTPLATE.get());
                entries.add(ModItems.COPPER_LEGGINGS.get());
                entries.add(ModItems.COPPER_BOOTS.get());
                entries.add(ModItems.TROUT.get());
                entries.add(ModItems.COOKED_TROUT.get());
                entries.add(ModItems.TROUT_BUCKET.get());
                entries.add(ModItems.TROUT_SPAWN_EGG.get());
                entries.add(ModBlocks.ROSE.get());
            })
            .build();
}
