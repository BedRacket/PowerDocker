package org.bedracket.powerdocker.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CodEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.bedracket.powerdocker.PowerDockerMod;
import org.bedracket.powerdocker.entity.TroutEntity;
import org.bedracket.powerdocker.init.ModEntityModelLayers;

@Environment(EnvType.CLIENT)
public class TroutRenderer<T extends TroutEntity> extends MobEntityRenderer<TroutEntity, CodEntityModel<TroutEntity>> {

    public TroutRenderer(EntityRendererFactory.Context arg) {
        super(arg, new CodEntityModel<>(arg.getPart(ModEntityModelLayers.TROUT)), 0.3F);
    }


    protected void setupTransforms(TroutEntity arg, MatrixStack arg2, float f, float g, float h) {
        super.setupTransforms(arg, arg2, f, g, h);
        float i = 4.3F * MathHelper.sin(0.6F * f);
        arg2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(i));
        if (!arg.isTouchingWater()) {
            arg2.translate(0.1F, 0.1F, -0.1F);
            arg2.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
        }
    }

    @Override
    public Identifier getTexture(TroutEntity entity) {
        return new Identifier(PowerDockerMod.MOD_ID, "textures/entity/trout.png");
    }
}

