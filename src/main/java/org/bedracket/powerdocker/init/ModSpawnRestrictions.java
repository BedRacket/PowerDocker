package org.bedracket.powerdocker.init;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.world.Heightmap;

public class ModSpawnRestrictions {

    public static void initSpawnRestrictions() {
        initWaterMobSpawn(ModEntities.TROUT_ENTITY);
    }

    protected static <T extends WaterCreatureEntity> void initWaterMobSpawn(EntityType<T> type) {
        SpawnRestriction.register(type, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WaterCreatureEntity::canSpawn);
    }
}
