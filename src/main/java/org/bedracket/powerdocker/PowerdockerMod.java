package org.bedracket.powerdocker;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import org.bedracket.eventbus.event.BedRacket;
import org.bedracket.powerdocker.event.PlayerEvents;
import org.slf4j.Logger;

public class PowerdockerMod implements ModInitializer {

    public static Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        final BedRacket bus = BedRacket.EVENT_BUS;
        int r = bus.addListener(new PlayerEvents());
        LOGGER.info("Registered '" + r + "' BedRacket events.");
    }
}
