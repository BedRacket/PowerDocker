package org.bedracket.powerdocker.init;

import net.minecraft.client.item.CompassAnglePredicateProvider;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import org.bedracket.powerdocker.item.DepthMeterItem;

public class ModModelPredicates {

    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.DEPTH_METER, new Identifier("angle"),
                new CompassAnglePredicateProvider((world, stack, entity) ->
                        DepthMeterItem.hasLodestone(stack) ?
                                DepthMeterItem.createLodestonePos(stack.getOrCreateNbt()) :
                                DepthMeterItem.createSpawnPos(world)));
    }
}
