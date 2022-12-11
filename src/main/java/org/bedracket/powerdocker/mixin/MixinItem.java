package org.bedracket.powerdocker.mixin;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import org.bedracket.powerdocker.item.AttachFoods;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class MixinItem {

    @Inject(method = "getFoodComponent", cancellable = true, at = @At("RETURN"))
    private void getFoodPropertiesCC(CallbackInfoReturnable<FoodComponent> cir) {
        if (cir.getReturnValue() == null && AttachFoods.isAttach(((Item) (Object) this))) {
            cir.setReturnValue(AttachFoods.getFood(((Item) (Object) this)));
        }
    }

    @Inject(method = "isFood", cancellable = true, at = @At("RETURN"))
    private void isEdibleCC(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(cir.getReturnValue() || AttachFoods.isAttach(((Item) (Object) this)));
    }
}
