package org.bedracket.powerdocker.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.bedracket.powerdocker.PowerDockerMod;

public class ModItemGroups {

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(
            new Identifier(PowerDockerMod.MOD_ID, "general"))
            .icon(() -> new ItemStack(ModItems.BED_RACKET))
            .entries((enabledFeatures, entries, operatorEnabled) -> {
                entries.add(ModItems.COPPER_SWORD);
                entries.add(ModItems.COPPER_NUGGET);
                entries.add(ModItems.COPPER_AXE);
                entries.add(ModItems.COPPER_HOE);
                entries.add(ModItems.COPPER_PICKAXE);
                entries.add(ModItems.COPPER_SHOVEL);
                entries.add(ModItems.COPPER_HELMET);
                entries.add(ModItems.COPPER_CHESTPLATE);
                entries.add(ModItems.COPPER_LEGGINGS);
                entries.add(ModItems.COPPER_BOOTS);
                entries.add(ModItems.TROUT);
                entries.add(ModItems.COOKED_TROUT);
                entries.add(ModItems.TROUT_BUCKET);
                entries.add(ModItems.TROUT_SPAWN_EGG);
                entries.add(ModItems.ROSE);
                entries.add(ModItems.CACTUS_BALL);
                entries.add(ModItems.STONE_JAVELIN);
                entries.add(ModItems.COPPER_JAVELIN);
            })
            .build();
}
