package org.bedracket.powerdocker.init;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import org.bedracket.powerdocker.PowerDockerMod;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> ROSE_PLACED =
            createRegistryKey("rose_placed");
    public static final RegistryKey<PlacedFeature> CACTUS_BALL_PLACED =
            createRegistryKey("cactus_ball_placed");
    public static final RegistryKey<PlacedFeature> WILD_COCA_PLACED =
            createRegistryKey("wild_coca_placed");

    public static void populate(FabricDynamicRegistryProvider.Entries entries) {
        entries.add(ROSE_PLACED, placeFeature(entries, ModConfiguredFeatures.ROSE,
                CountPlacementModifier.of(3), RarityFilterPlacementModifier.of(2),
                SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,  BiomePlacementModifier.of()));
        entries.add(CACTUS_BALL_PLACED, placeFeature(entries, ModConfiguredFeatures.CACTUS_BALL,
                RarityFilterPlacementModifier.of(16),
                SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,  BiomePlacementModifier.of()));
        entries.add(WILD_COCA_PLACED, placeFeature(entries, ModConfiguredFeatures.WILD_COCA,
                CountPlacementModifier.of(3), RarityFilterPlacementModifier.of(2),
                SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,  BiomePlacementModifier.of()));
    }

    private static PlacedFeature placeFeature(FabricDynamicRegistryProvider.Entries entries, RegistryKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... placementModifiers) {
        List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
        list.add(BiomePlacementModifier.of());
        return placeFeature(entries, feature, list);
    }

    private static PlacedFeature placeFeature(FabricDynamicRegistryProvider.Entries entries, RegistryKey<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> list) {
        return new PlacedFeature(entries.ref(feature), list);
    }

    public static RegistryKey<PlacedFeature> createRegistryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(PowerDockerMod.MOD_ID, name));
    }
}
