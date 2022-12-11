package org.bedracket.powerdocker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import org.bedracket.powerdocker.init.ModItems;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BED_RACKET.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_NUGGET.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_HELMET.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.TROUT.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_TROUT.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_CHESTPLATE.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_LEGGINGS.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_BOOTS.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_SWORD.get(), Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_AXE.get(), Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE.get(), Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE.get(), Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL.get(), Models.HANDHELD);
    }
}
