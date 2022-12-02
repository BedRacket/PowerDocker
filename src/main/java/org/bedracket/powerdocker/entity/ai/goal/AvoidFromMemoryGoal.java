package org.bedracket.powerdocker.entity.ai.goal;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.pathfinder.Path;
import org.bedracket.powerdocker.entity.HumanEntity;

public class AvoidFromMemoryGoal extends Goal {

    protected HumanEntity human;
    protected Entity target;
    protected float maxDistance;
    protected double speed;
    private Path flightPath;
    protected final PathNavigation pathNav;

    public AvoidFromMemoryGoal(HumanEntity human, float maxDistance, double speed) {
        this.human = human;
        this.maxDistance = maxDistance;
        this.speed = speed;
        this.pathNav = human.getNavigation();
    }

    @Override
    public boolean canUse() {
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        return !this.human.getNavigation().isStuck();
    }

    @Override
    public void start() {
        this.pathNav.moveTo(this.flightPath, this.speed);
    }
}
