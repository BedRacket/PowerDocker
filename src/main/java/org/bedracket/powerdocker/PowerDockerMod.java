package org.bedracket.powerdocker;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import org.bedracket.powerdocker.init.*;
import org.slf4j.Logger;

public class PowerDockerMod implements ModInitializer {

    public static Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "powerdocker";

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing PowerDocker Mod...");
        new ModItemGroups();
        ModEntities.registerAttributes();
        ModItems.ITEMS.register();
        ModBlocks.BLOCKS.register();
        ModEntitySpawns.addEntitySpawns();
        PowerDockerHooks.handleFood();
    }
}
