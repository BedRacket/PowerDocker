package org.bedracket.powerdocker;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import org.bedracket.eventbus.event.BedRacket;
import org.bedracket.powerdocker.event.PlayerEvents;
import org.bedracket.powerdocker.init.ModEntities;
import org.bedracket.powerdocker.init.ModItemGroups;
import org.bedracket.powerdocker.init.ModItems;
import org.bedracket.powerdocker.init.ModSpawnRestrictions;
import org.slf4j.Logger;

public class PowerDockerMod implements ModInitializer {

    public static Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "powerdocker";

    @Override
    public void onInitialize() {
        final BedRacket eventBus = BedRacket.EVENT_BUS;
        new ModItemGroups();
        ModEntities.registerAttributes();
        ModItems.ITEMS.register();
        ModSpawnRestrictions.initSpawnRestrictions();
        PowerDockerHooks.handleFood();
        int r = eventBus.addListener(new PlayerEvents());
        LOGGER.info("Registered " + r + " BedRacket Events!");
    }
}
