package org.bedracket.powerdocker;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import org.bedracket.powerdocker.init.*;
import org.bedracket.powerdocker.util.Matrix;
import org.slf4j.Logger;

public class PowerDockerMod implements ModInitializer {

    public static Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "powerdocker";

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing PowerDocker Mod...");
        new ModItemGroups();
        ModEntities.registerAttributes();
        Matrix.register(ModItems.class, Registries.ITEM);
        Matrix.register(ModBlocks.class, Registries.BLOCK);
        ModEntitySpawns.addEntitySpawns();
        PowerDockerHooks.handleFood();
    }
}
