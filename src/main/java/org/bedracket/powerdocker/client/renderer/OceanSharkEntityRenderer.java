package org.bedracket.powerdocker.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import org.bedracket.powerdocker.PowerDockerMod;
import org.bedracket.powerdocker.client.model.OceanSharkEntityModel;
import org.bedracket.powerdocker.entity.OceanSharkEntity;
import org.bedracket.powerdocker.init.ModEntityModelLayers;

public class OceanSharkEntityRenderer<T extends OceanSharkEntity> extends MobEntityRenderer<T, OceanSharkEntityModel<T>> {

    public OceanSharkEntityRenderer(EntityRendererFactory.Context arg) {
        super(arg, new OceanSharkEntityModel<>(arg.getPart(ModEntityModelLayers.OCEAN_SHARK)), 0.2F);
    }

    @Override
    public Identifier getTexture(T entity) {
        return new Identifier(PowerDockerMod.MOD_ID, "textures/entity/ocean_shark.png");
    }
}