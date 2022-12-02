package org.bedracket.powerdocker.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.bedracket.powerdocker.PowerdockerMod;

public class ModCreativeModeTabs {

    public static final CreativeModeTab COMMON = new CreativeModeTab(PowerdockerMod.MOD_ID + ".common") {
        @Override
        public ItemStack makeIcon() {
            return ModItems.WAND.get().getDefaultInstance();
        }
    };
}
