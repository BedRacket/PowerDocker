package org.bedracket.powerdocker.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.bedracket.powerdocker.init.ModItems;
import org.bedracket.powerdocker.util.BowUtils;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRegisterEvents {

    @SubscribeEvent
    public static void registerItemModels(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            //BowUtils.bowItemOverrides(ModItems.BLAZE_BOW.get());
            BowUtils.bowItemOverrides(ModItems.vein_sword.get());
        });
    }
}
