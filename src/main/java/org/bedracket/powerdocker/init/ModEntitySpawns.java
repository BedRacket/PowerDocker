package org.bedracket.powerdocker.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.Heightmap;

public class ModEntitySpawns {

    public static void addEntitySpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.tag(ModTags.Biomes.IS_WATER), SpawnGroup.WATER_CREATURE,
                ModEntities.TROUT_ENTITY, 60, 6, 12);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_OCEAN), SpawnGroup.WATER_CREATURE,
                ModEntities.OCEAN_SHARK_ENTITY, 50, 1, 4);
        SpawnRestriction.register(ModEntities.TROUT_ENTITY, SpawnRestriction.Location.IN_WATER,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WaterCreatureEntity::canSpawn);
        SpawnRestriction.register(ModEntities.OCEAN_SHARK_ENTITY, SpawnRestriction.Location.IN_WATER,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WaterCreatureEntity::canSpawn);
    }
}
