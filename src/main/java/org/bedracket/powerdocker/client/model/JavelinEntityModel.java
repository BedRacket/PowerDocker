package org.bedracket.powerdocker.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class JavelinEntityModel extends Model {

    private final ModelPart root;

    public JavelinEntityModel(ModelPart root) {
        super(RenderLayer::getEntitySolid);
        this.root = root;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();

        ModelPartData bb_main = partdefinition.addChild("bb_main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData cube_r1 = bb_main.addChild("cube_r1", ModelPartBuilder.create().uv(4, 4).cuboid(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -20.0F, 0.0F, 1.5708F, -0.7854F, -3.1416F));

        ModelPartData cube_r2 = bb_main.addChild("cube_r2", ModelPartBuilder.create().uv(0, 4).cuboid(0.5F, -1.0F, -1.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.0F, -1.5F, 0.5F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -23.5F, 1.0F, 0.0F, 1.5708F, 1.5708F));

        ModelPartData stick_r1 = bb_main.addChild("stick_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -0.5F, -16.0F, 1.0F, 1.0F, 32.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));

        return TexturedModelData.of(meshdefinition, 128, 128);
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
