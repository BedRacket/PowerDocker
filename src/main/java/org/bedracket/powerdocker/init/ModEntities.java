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
import org.bedracket.powerdocker.client.renderer.CopperJavelinEntityRenderer;
import org.bedracket.powerdocker.client.renderer.OceanSharkEntityRenderer;
import org.bedracket.powerdocker.client.renderer.StoneJavelinEntityRenderer;
import org.bedracket.powerdocker.client.renderer.TroutEntityRenderer;
import org.bedracket.powerdocker.entity.OceanSharkEntity;
import org.bedracket.powerdocker.entity.projectiles.CopperJavelinEntity;
import org.bedracket.powerdocker.entity.projectiles.StoneJavelinEntity;
import org.bedracket.powerdocker.entity.TroutEntity;

public class ModEntities {

    public static final EntityType<TroutEntity> TROUT_ENTITY =
            register("trout", SpawnGroup.WATER_AMBIENT, TroutEntity::new, 0.5F, 0.3F);
    public static final EntityType<StoneJavelinEntity> STONE_JAVELIN_ENTITY =
            register("stone_javelin", SpawnGroup.MISC, StoneJavelinEntity::new, 0.5F, 0.5F);
    public static final EntityType<CopperJavelinEntity> COPPER_JAVELIN_ENTITY =
            register("copper_javelin", SpawnGroup.MISC, CopperJavelinEntity::new, 0.5F, 0.5F);
    public static final EntityType<OceanSharkEntity> OCEAN_SHARK_ENTITY =
            register("ocean_shark", SpawnGroup.WATER_CREATURE, OceanSharkEntity::new, 1.4f,1.1f);

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
        FabricDefaultAttributeRegistry.register(OCEAN_SHARK_ENTITY, OceanSharkEntity.createSharkAttributes());
    }

    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(TROUT_ENTITY, TroutEntityRenderer::new);
        EntityRendererRegistry.register(STONE_JAVELIN_ENTITY, StoneJavelinEntityRenderer::new);
        EntityRendererRegistry.register(COPPER_JAVELIN_ENTITY, CopperJavelinEntityRenderer::new);
        EntityRendererRegistry.register(OCEAN_SHARK_ENTITY, OceanSharkEntityRenderer::new);
    }
}
