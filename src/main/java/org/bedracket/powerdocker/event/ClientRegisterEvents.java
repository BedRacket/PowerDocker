package org.bedracket.powerdocker.event;

import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderItemInFrameEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.bedracket.powerdocker.init.ModItems;
import org.bedracket.powerdocker.util.ItemModelHandler;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRegisterEvents {

    @SubscribeEvent
    public static void registerItemModels(RenderItemInFrameEvent event) {
        ItemModelHandler.registerModel(ModItems.BLAZE_BOW.get());
    }
}
