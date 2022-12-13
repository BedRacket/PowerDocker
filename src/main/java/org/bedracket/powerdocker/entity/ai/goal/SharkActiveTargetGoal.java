package org.bedracket.powerdocker.entity.ai.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import org.bedracket.powerdocker.entity.AbstractSharkEntity;

public class SharkActiveTargetGoal<T extends LivingEntity> extends ActiveTargetGoal<T> {

    public SharkActiveTargetGoal(MobEntity mob, Class<T> targetClass, boolean checkVisibility, boolean checkCanNavigate) {
        super(mob, targetClass, checkVisibility, checkCanNavigate);
    }

    @Override
    public boolean shouldContinue() {
        return ((AbstractSharkEntity) this.mob).isHungry() && super.shouldContinue();
    }
}
