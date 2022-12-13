package org.bedracket.powerdocker.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.control.AquaticMoveControl;
import net.minecraft.entity.ai.control.YawAdjustingLookControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.bedracket.powerdocker.entity.ai.goal.SharkActiveTargetGoal;
import org.bedracket.powerdocker.entity.ai.goal.SharkAttackGoal;
import org.bedracket.powerdocker.entity.ai.goal.SharkJumpGoal;
import org.bedracket.powerdocker.entity.ai.goal.SharkSwimWithPlayerGoal;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractSharkEntity extends SchoolingFishEntity implements Monster {

    private static final TrackedData<Boolean> HAS_FISH =
            DataTracker.registerData(AbstractSharkEntity .class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> MOISTNESS =
            DataTracker.registerData(AbstractSharkEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public static final TargetPredicate CLOSE_PLAYER_PREDICATE =
            TargetPredicate.createNonAttackable().setBaseMaxDistance(10.0).ignoreVisibility();
    private static final TrackedData<Boolean> HUNGRY =
            DataTracker.registerData(AbstractSharkEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> TIME_TILL_HUNGRY =
            DataTracker.registerData(AbstractSharkEntity.class, TrackedDataHandlerRegistry.INTEGER);

    int lastTimeSinceHungry;

    public AbstractSharkEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new AquaticMoveControl(this, 85, 10, 0.02F, 0.1F, true);
        this.lookControl = new YawAdjustingLookControl(this, 10);
        this.setCanPickUpLoot(false);
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.setAir(this.getMaxAir());
        this.setPitch(0.0F);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    @Override
    public boolean canBreatheInWater() {
        return false;
    }

    public boolean hasFish() {
        return this.dataTracker.get(HAS_FISH);
    }

    public void setHasFish(boolean hasFish) {
        this.dataTracker.set(HAS_FISH, hasFish);
    }

    public int getMoistness() {
        return this.dataTracker.get(MOISTNESS);
    }

    public void setMoistness(int moistness) {
        this.dataTracker.set(MOISTNESS, moistness);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(HAS_FISH, false);
        this.dataTracker.startTracking(MOISTNESS, 2400);
        this.dataTracker.startTracking(HUNGRY, true);
        this.dataTracker.startTracking(TIME_TILL_HUNGRY, 0);
    }

    public boolean isHungry() {
        return this.dataTracker.get(HUNGRY);
    }

    public void setHungry(boolean hungry) {
        this.dataTracker.set(HUNGRY, hungry);
    }

    public int getTimeTillHungry() {
        return this.dataTracker.get(TIME_TILL_HUNGRY);
    }

    public void setTimeTillHungry(int ticks) {
        this.dataTracker.set(TIME_TILL_HUNGRY, ticks);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("GotFish", this.hasFish());
        nbt.putInt("Moistness", this.getMoistness());
        nbt.putBoolean("IsHungry", this.isHungry());
        nbt.putInt("TimeTillHungry", this.getTimeTillHungry());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setHasFish(nbt.getBoolean("GotFish"));
        this.setMoistness(nbt.getInt("Moistness"));
        this.setHungry(nbt.getBoolean("IsHungry"));
        this.setTimeTillHungry(nbt.getInt("TimeTillHungry"));
    }

    public static DefaultAttributeContainer.Builder createSharkAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.2000000476837158)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE,  35.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0);
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        return new SwimNavigation(this, world);
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean bl = target.damage(DamageSource.mob(this), (float)((int)this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)));
        if (bl) {
            this.applyDamageEffects(this, target);
            this.playSound(SoundEvents.ENTITY_DOLPHIN_ATTACK, 1.0F, 1.0F);
        }

        return bl;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new BreatheAirGoal(this));
        this.goalSelector.add(0, new MoveIntoWaterGoal(this));
        this.goalSelector.add(2, new SharkSwimWithPlayerGoal(this, 4.0));
        this.goalSelector.add(4, new SwimAroundGoal(this, 1.0, 10));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(5, new SharkJumpGoal(this, 10));
        this.goalSelector.add(5, new SharkAttackGoal(this, 1.2, true));
        this.goalSelector.add(8, new ChaseBoatGoal(this));
        this.goalSelector.add(9, new FleeEntityGoal<>(this, GuardianEntity.class, 8.0F, 1.0, 1.0));
        this.targetSelector.add(1, (new RevengeGoal(this, GuardianEntity.class)).setGroupRevenge());
        this.targetSelector.add(3, new SharkActiveTargetGoal<>(this, TroutEntity.class, true, false));
        this.targetSelector.add(3, new SharkActiveTargetGoal<>(this, PufferfishEntity.class, true, false));
        this.targetSelector.add(3, new SharkActiveTargetGoal<>(this, CodEntity.class, true, false));
        this.targetSelector.add(3, new SharkActiveTargetGoal<>(this, TropicalFishEntity.class, true, false));
        this.targetSelector.add(3, new SharkActiveTargetGoal<>(this, SalmonEntity.class, true, false));
        this.targetSelector.add(3, new SharkActiveTargetGoal<>(this, PlayerEntity.class, true, false));
        this.targetSelector.add(3, new SharkActiveTargetGoal<>(this, PigEntity.class, true, false));
        this.targetSelector.add(1, new SharkActiveTargetGoal<>(this, CowEntity.class, true, false));
        super.initGoals();
    }

    public void attack(LivingEntity entity) {
        if (entity.damage(DamageSource.mob(this), 2.0F) && entity.isTouchingWater()) {
            this.playSound(SoundEvents.ENTITY_PUFFER_FISH_HURT, 1.0F, 1.0F);
            if (entity instanceof PlayerEntity) {
                this.setTarget(entity);
            }
        }
    }

    @Override
    public int getMaxAir() {
        return 4800;
    }

    @Override
    protected int getNextAirOnLand(int air) {
        return this.getMaxAir();
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.3F;
    }

    @Override
    public int getMaxLookPitchChange() {
        return 1;
    }

    @Override
    public int getMaxHeadRotation() {
        return 1;
    }

    @Override
    protected boolean canStartRiding(Entity entity) {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isAiDisabled()) {
            this.setAir(this.getMaxAir());
        } else {
            if (this.isWet()) {
                this.setMoistness(2400);
            } else {
                this.setMoistness(this.getMoistness() - 1);
                if (this.getMoistness() <= 0) {
                    this.damage(DamageSource.DRYOUT, 1.0F);
                }

                if (this.onGround) {
                    this.setVelocity(this.getVelocity().add((double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.2F), 0.5, (double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.2F)));
                    this.setYaw(this.random.nextFloat() * 360.0F);
                    this.onGround = false;
                    this.velocityDirty = true;
                }
            }

            if (this.world.isClient && this.isTouchingWater() && this.getVelocity().lengthSquared() > 0.03) {
                Vec3d vec3d = this.getRotationVec(0.0F);
                float f = MathHelper.cos(this.getYaw() * 0.017453292F) * 0.3F;
                float g = MathHelper.sin(this.getYaw() * 0.017453292F) * 0.3F;
                float h = 1.2F - this.random.nextFloat() * 0.7F;

                for(int i = 0; i < 2; ++i) {
                    this.world.addParticle(ParticleTypes.DOLPHIN, this.getX() - vec3d.x * (double)h + (double)f, this.getY() - vec3d.y, this.getZ() - vec3d.z * (double)h + (double)g, 0.0, 0.0, 0.0);
                    this.world.addParticle(ParticleTypes.DOLPHIN, this.getX() - vec3d.x * (double)h - (double)f, this.getY() - vec3d.y, this.getZ() - vec3d.z * (double)h - (double)g, 0.0, 0.0, 0.0);
                }
            }
            if (!this.isHungry() && lastTimeSinceHungry < this.getTimeTillHungry()) {
                lastTimeSinceHungry++;
            }
            if (lastTimeSinceHungry >= this.getTimeTillHungry()) {
                this.setHungry(true);
                lastTimeSinceHungry = 0;
            }
        }
    }

    @Override
    public ItemStack getBucketItem() {
        return null;
    }

    @Override
    public void travel(Vec3d movementInput) {
        if (this.canMoveVoluntarily() && this.isTouchingWater()) {
            this.updateVelocity(this.getMovementSpeed(), movementInput);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9));
            if (this.getTarget() == null) {
                this.setVelocity(this.getVelocity().add(0.0, -0.005, 0.0));
            }
        } else {
            super.travel(movementInput);
        }

    }

    public boolean canBeLeashedBy(PlayerEntity player) {
        return true;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return null;
    }
}
