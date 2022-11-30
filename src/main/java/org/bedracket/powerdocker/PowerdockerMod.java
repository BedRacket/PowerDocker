package org.bedracket.powerdocker;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.bedracket.powerdocker.init.ModItems;
import org.slf4j.Logger;

@Mod(PowerdockerMod.MOD_ID)
public class PowerdockerMod {

    public static final String MOD_ID = "powerdocker";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PowerdockerMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(modEventBus);
    }

}
