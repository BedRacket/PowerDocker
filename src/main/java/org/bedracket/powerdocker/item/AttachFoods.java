package org.bedracket.powerdocker.item;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.Map;

public class AttachFoods {

    static final Map<Item, FoodComponent> MAP = ImmutableMap.<Item, FoodComponent>builder()
            .put(Items.ROTTEN_FLESH, food(0, 0.0).build())
            .put(Items.SUGAR_CANE, food(2, 1.2).build())
            .put(Items.SUGAR, food(1, 0.6)
                    .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 80, 0), 1).build())
            .put(Items.FERMENTED_SPIDER_EYE, food(4, 6.4)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 80, 0), 1).build())
            .put(Items.EGG, food(2, 0.4).build())
            .put(Items.TURTLE_EGG, food(2, 0.4).build())
            .put(Items.BROWN_MUSHROOM, food(1, 0.2)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 2), 1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 1), 1).build())
            .put(Items.RED_MUSHROOM, food(1, 0.2)
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 1200, 3), 1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 600, 0), 1).build())
            .put(Items.CRIMSON_FUNGUS, food(1, 0.2)
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 1200, 3), 1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 600, 0), 1).build())
            .put(Items.WARPED_FUNGUS, food(1, 0.2)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 2), 1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 1).build())
            .put(Items.GLISTERING_MELON_SLICE, food(4, 4.8).build())
            .put(Items.MELON, food(6, 1.2).build())
            .put(Items.PUMPKIN, food(4, 1.2).build())
            .put(Items.CAKE, food(14, 2.8).build()).build();

    public static boolean isAttach(Item item) {
        return MAP.containsKey(item);
    }

    public static FoodComponent getFood(Item item) {
        return MAP.get(item);
    }

    static FoodComponent.Builder food(int n, double s) {
        return new FoodComponent.Builder().hunger(n).saturationModifier((float) (s / 2 / n));
    }
}
