package org.bedracket.powerdocker.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.bedracket.powerdocker.PowerDockerMod;
import org.bedracket.powerdocker.client.model.JavelinEntityModel;
import org.bedracket.powerdocker.entity.CopperJavelinEntity;
import org.bedracket.powerdocker.init.ModEntityModelLayers;

@Environment(EnvType.CLIENT)
public class CopperJavelinEntityRenderer extends EntityRenderer<CopperJavelinEntity> {

    private final JavelinEntityModel model;

    public CopperJavelinEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new JavelinEntityModel(ctx.getPart(ModEntityModelLayers.COPPER_JAVELIN));
    }

    @Override
    public void render(CopperJavelinEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw()) - 90.0F));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, this.model.getLayer(this.getTexture(entity)), false, entity.isEnchanted());
        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(CopperJavelinEntity entity) {
        return new Identifier(PowerDockerMod.MOD_ID, "textures/entity/projectiles/copper_javelin.png");
    }

}
