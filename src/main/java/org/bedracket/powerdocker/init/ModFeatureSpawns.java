package org.bedracket.powerdocker.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import org.bedracket.powerdocker.PowerDockerMod;

public class ModFeatureSpawns {

    public static void addFeatureSpawns() {
        BiomeModifications.addFeature(
                BiomeSelectors.tag(BiomeTags.IS_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(PowerDockerMod.MOD_ID, "rose_placed"))
        );
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.DESERT),
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(PowerDockerMod.MOD_ID, "cactus_ball_placed"))
        );
    }
}
