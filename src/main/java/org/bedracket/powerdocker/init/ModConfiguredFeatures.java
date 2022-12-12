package org.bedracket.powerdocker.init;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import org.bedracket.powerdocker.PowerDockerMod;

@SuppressWarnings("UnstableApiUsage")
public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> ROSE =
            createRegistryKey("rose");

    public static void populate(FabricDynamicRegistryProvider.Entries entries) {
        entries.add(ROSE, configureFeature(Feature.FLOWER, new RandomPatchFeatureConfig(16, 3, 2,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ROSE))))));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> ConfiguredFeature<FC, ?> configureFeature(F feature, FC config) {
        return new ConfiguredFeature<>(feature, config);
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> createRegistryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(PowerDockerMod.MOD_ID, name));
    }
}
