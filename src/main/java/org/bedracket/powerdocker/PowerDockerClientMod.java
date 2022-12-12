package org.bedracket.powerdocker;

import net.fabricmc.api.ClientModInitializer;
import org.bedracket.powerdocker.init.ModBlockRenderLayers;
import org.bedracket.powerdocker.init.ModEntities;
import org.bedracket.powerdocker.init.ModEntityModelLayers;

public class PowerDockerClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModEntities.registerEntityRenderers();
        ModEntityModelLayers.registerEntityModelLayers();
        ModBlockRenderLayers.registerBlockRenderLayers();
    }
}
