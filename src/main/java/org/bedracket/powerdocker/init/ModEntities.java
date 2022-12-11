package org.bedracket.powerdocker.init;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.bedracket.powerdocker.PowerDockerMod;
import org.bedracket.powerdocker.client.renderer.TroutRenderer;
import org.bedracket.powerdocker.entity.TroutEntity;

public class ModEntities {

    public static final EntityType<TroutEntity> TROUT_ENTITY =
            register("trout", SpawnGroup.WATER_AMBIENT, TroutEntity::new, 0.5F, 0.3F);

    public static <E extends Entity> EntityType<E> register(String name, SpawnGroup spawnGroup, EntityType.EntityFactory<E> factory, float width, float height) {
        return Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(PowerDockerMod.MOD_ID, name),
                FabricEntityTypeBuilder.create(spawnGroup, factory)
                        .dimensions(EntityDimensions.fixed(width, height))
                        .build());
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(TROUT_ENTITY, TroutEntity.registerAttributes());
    }

    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(TROUT_ENTITY, TroutRenderer::new);
    }
}
