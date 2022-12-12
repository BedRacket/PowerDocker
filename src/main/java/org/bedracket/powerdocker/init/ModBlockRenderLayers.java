package org.bedracket.powerdocker.init;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class ModBlockRenderLayers {

    public static void registerBlockRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_ROSE, RenderLayer.getCutout());
    }
}
