package org.bedracket.powerdocker;

import net.minecraft.item.Items;

public class PowerDockerHooks {

    public static void handleFood() {
        if (Items.DRIED_KELP.getFoodComponent() != null) {
            Items.DRIED_KELP.getFoodComponent().alwaysEdible = true;
            Items.DRIED_KELP.getFoodComponent().hunger = 0;
            Items.DRIED_KELP.getFoodComponent().saturationModifier = 0.0F;
        }
        if (Items.CHORUS_FRUIT.getFoodComponent() != null) {
            Items.CHORUS_FRUIT.getFoodComponent().alwaysEdible = true;
            Items.CHORUS_FRUIT.getFoodComponent().hunger = 0;
            Items.CHORUS_FRUIT.getFoodComponent().saturationModifier = 0.0F;
        }
        if (Items.ROTTEN_FLESH.getFoodComponent() != null) {
            Items.ROTTEN_FLESH.getFoodComponent().alwaysEdible = true;
            Items.ROTTEN_FLESH.getFoodComponent().hunger = 0;
            Items.ROTTEN_FLESH.getFoodComponent().saturationModifier = 0.0F;
        }
    }
}
