package org.bedracket.powerdocker.mixin.entity_events;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.bedracket.entity_events.event.living.MobInitGoalEvent;
import org.bedracket.eventbus.event.BedRacket;
import org.bedracket.eventbus.event.EventException;
import org.bedracket.eventbus.event.EventInfo;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@EventInfo(events = "MobInitGoalEvent")
@Mixin(MobEntity.class)
public abstract class MixinMobEntity {

    @Shadow @Final protected GoalSelector goalSelector;

    @Shadow @Final protected GoalSelector targetSelector;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void callLivingInitGoalEvent(EntityType<?> entityType, World world, CallbackInfo ci) throws EventException {
        if (world != null && !world.isClient) {
            BedRacket.EVENT_BUS.post(MobInitGoalEvent.class, new MobInitGoalEvent(((MobEntity) (Object) this),
                    this.goalSelector,
                    this.targetSelector));
        }
    }
}
