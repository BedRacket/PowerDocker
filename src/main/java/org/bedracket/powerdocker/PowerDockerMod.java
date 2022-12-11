package org.bedracket.powerdocker;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import org.bedracket.powerdocker.init.ModItemGroups;
import org.bedracket.powerdocker.init.ModItems;
import org.slf4j.Logger;

public class PowerDockerMod implements ModInitializer {

    public static Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "powerdocker";

    @Override
    public void onInitialize() {
       ModItems.ITEMS.register();
       new ModItemGroups();
    }
}
