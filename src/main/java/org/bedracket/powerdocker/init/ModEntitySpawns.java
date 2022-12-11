package org.bedracket.powerdocker.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.world.Heightmap;

public class ModEntitySpawns {

    public static void addEntitySpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.tag(ModTags.Biomes.IS_WATER), SpawnGroup.CREATURE,
                ModEntities.TROUT_ENTITY, 60, 6, 12);
        SpawnRestriction.register(ModEntities.TROUT_ENTITY, SpawnRestriction.Location.IN_WATER,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WaterCreatureEntity::canSpawn);
    }
}
