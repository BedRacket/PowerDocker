package org.bedracket.powerdocker.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawns {

    public static void addEntitySpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                BiomeKeys.OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN,
                BiomeKeys.DEEP_FROZEN_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.FROZEN_OCEAN,
                BiomeKeys.DEEP_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.RIVER, BiomeKeys.FROZEN_RIVER,
                BiomeKeys.PLAINS
                ), SpawnGroup.CREATURE,
                ModEntities.TROUT_ENTITY, 60, 6, 12);
        SpawnRestriction.register(ModEntities.TROUT_ENTITY, SpawnRestriction.Location.IN_WATER,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WaterCreatureEntity::canSpawn);
    }
}
