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
        new ModItems();
        new ModBlocks();
        new ModItemGroups();
        ModEntities.registerAttributes();
        ModEntitySpawns.addEntitySpawns();
        PowerDockerHooks.handleFood();
    }
}
