package org.bedracket.powerdocker.event;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.bedracket.powerdocker.network.SimpleNetworkHandler;

@Mod.EventBusSubscriber
public class CommonSetupEvents {

    @SubscribeEvent
    public void setupCommon(FMLCommonSetupEvent event) {
        SimpleNetworkHandler.init();
    }
}
