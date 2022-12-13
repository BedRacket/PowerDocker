package org.bedracket.powerdocker.entity.ai.goal;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import org.bedracket.powerdocker.entity.AbstractSharkEntity;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class SharkSwimWithPlayerGoal extends Goal{

    private final AbstractSharkEntity shark;
    private final double speed;
    @Nullable
    private PlayerEntity closestPlayer;

    public SharkSwimWithPlayerGoal(AbstractSharkEntity shark, double speed) {
        this.shark = shark;
        this.speed = speed;
        this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
    }

    public boolean canStart() {
        this.closestPlayer = this.shark.world.getClosestPlayer(AbstractSharkEntity.CLOSE_PLAYER_PREDICATE,
                this.shark);
        if (this.closestPlayer == null) {
            return false;
        } else {
            return this.closestPlayer.isSwimming() && this.shark.getTarget() != this.closestPlayer;
        }
    }

    public boolean shouldContinue() {
        return this.closestPlayer != null && this.closestPlayer.isSwimming() && this.shark.squaredDistanceTo(this.closestPlayer) < 256.0;
    }

    public void start() {
        assert this.closestPlayer != null;
        this.closestPlayer.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 100), this.shark);
    }

    public void stop() {
        this.closestPlayer = null;
        this.shark.getNavigation().stop();
    }

    public void tick() {
        this.shark.getLookControl().lookAt(this.closestPlayer, (float)(this.shark.getMaxHeadRotation() + 20), (float)this.shark.getMaxLookPitchChange());
        if (this.shark.squaredDistanceTo(this.closestPlayer) < 6.25) {
            this.shark.getNavigation().stop();
        } else {
            this.shark.getNavigation().startMovingTo(this.closestPlayer, this.speed);
        }

        assert this.closestPlayer != null;
        if (this.closestPlayer.isSwimming() && this.closestPlayer.world.random.nextInt(6) == 0) {
            this.closestPlayer.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 100), this.shark);
        }

    }
}
