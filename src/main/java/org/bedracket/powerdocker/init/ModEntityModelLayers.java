package org.bedracket.powerdocker.init;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.CodEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import org.bedracket.powerdocker.PowerDockerMod;
import org.bedracket.powerdocker.client.model.JavelinEntityModel;
import org.bedracket.powerdocker.client.model.OceanSharkEntityModel;

public class ModEntityModelLayers {

    public static final EntityModelLayer TROUT = register("trout");
    public static final EntityModelLayer STONE_JAVELIN = register("stone_javelin");
    public static final EntityModelLayer COPPER_JAVELIN = register("copper_javelin");
    public static final EntityModelLayer OCEAN_SHARK  = register("ocean_shark");

    public static void registerEntityModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(TROUT,
                CodEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(STONE_JAVELIN,
                JavelinEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(COPPER_JAVELIN,
                JavelinEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(OCEAN_SHARK,
                OceanSharkEntityModel::create);
    }

    private static EntityModelLayer register(String name) {
        return register(name, "main");
    }

    private static EntityModelLayer register(String name, String text) {
        return new EntityModelLayer(new Identifier(PowerDockerMod.MOD_ID, name), text);
    }
}
