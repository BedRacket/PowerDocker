package org.bedracket.powerdocker.datagen;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import org.bedracket.powerdocker.init.ModBlocks;
import org.bedracket.powerdocker.init.ModItems;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.ROSE,
                ModBlocks.POTTED_ROSE, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CACTUS_BALL,
                ModBlocks.POTTED_CACTUS_BALL, BlockStateModelGenerator.TintType.TINTED);
        offerCrossCrop(blockStateModelGenerator, ModBlocks.COCA_CROP, Properties.AGE_7, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BED_RACKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.TROUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_TROUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_BOOTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_JAVELIN, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_JAVELIN, Models.HANDHELD);
    }

    public final void offerCrossCrop(BlockStateModelGenerator blockStateModelGenerator, Block crop, Property<Integer> ageProperty, int... ageTextureIndices) {
        if (ageProperty.getValues().size() != ageTextureIndices.length) {
            throw new IllegalArgumentException();
        } else {
            Int2ObjectMap<Identifier> int2ObjectMap = new Int2ObjectOpenHashMap<>();
            BlockStateVariantMap blockStateVariantMap = BlockStateVariantMap.create(ageProperty).register((integer) -> {
                int i = ageTextureIndices[integer];
                Identifier identifier = (Identifier)int2ObjectMap.computeIfAbsent(i, (j) -> {
                    return blockStateModelGenerator.createSubModel(crop, "_stage" + i, Models.TINTED_CROSS, TextureMap::cross);
                });
                return BlockStateVariant.create().put(VariantSettings.MODEL, identifier);
            });
            blockStateModelGenerator.registerItemModel(crop.asItem());
            blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(crop).coordinate(blockStateVariantMap));
        }
    }
}
