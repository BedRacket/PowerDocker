package org.bedracket.powerdocker.init;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.CodEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import org.bedracket.powerdocker.PowerDockerMod;

public class ModEntityModelLayers {

    public static final EntityModelLayer TROUT = register("trout");

    public static void registerEntityModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(TROUT,
                CodEntityModel::getTexturedModelData);
    }

    private static EntityModelLayer register(String name) {
        return register(name, "main");
    }

    private static EntityModelLayer register(String name, String text) {
        return new EntityModelLayer(new Identifier(PowerDockerMod.MOD_ID, name), text);
    }
}
