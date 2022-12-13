package org.bedracket.powerdocker.entity.ai.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import org.bedracket.powerdocker.entity.AbstractSharkEntity;

public class SharkAttackGoal extends MeleeAttackGoal {

    public SharkAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
    }

    @Override
    public boolean canStop() {
        return super.canStop() && mob.isTouchingWater();
    }

    @Override
    protected void attack(LivingEntity target, double squaredDistance) {
        double d0 = this.getSquaredMaxAttackDistance(target);
        if (squaredDistance <= d0 && this.getCooldown() <= 0) {
            this.resetCooldown();
            ((AbstractSharkEntity) this.mob).attack(target);
            ((AbstractSharkEntity) this.mob).setHungry(false);
            ((AbstractSharkEntity) this.mob).setTimeTillHungry(mob.getRandom().nextInt(300) + 300);
        }
    }
}
