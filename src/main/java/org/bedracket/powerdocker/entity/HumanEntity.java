package org.bedracket.powerdocker.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HumanEntity extends Animal {

    protected static final EntityDataAccessor<String> FIRST_NAME =
            SynchedEntityData.defineId(HumanEntity.class, EntityDataSerializers.STRING);
    protected static final EntityDataAccessor<String> TRIBE_NAME =
            SynchedEntityData.defineId(HumanEntity.class, EntityDataSerializers.STRING);
    protected static final EntityDataAccessor<Integer> CLOTHES =
            SynchedEntityData.defineId(HumanEntity.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Integer> AGE =
            SynchedEntityData.defineId(HumanEntity.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Float> SIZE =
            SynchedEntityData.defineId(HumanEntity.class, EntityDataSerializers.FLOAT);
    protected static final EntityDataAccessor<Integer> HAIR_COLOR =
            SynchedEntityData.defineId(HumanEntity.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Integer> HAIR_TYPE =
            SynchedEntityData.defineId(HumanEntity.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Integer> EYE_COLOR =
            SynchedEntityData.defineId(HumanEntity.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Integer> SKIN_COLOR =
            SynchedEntityData.defineId(HumanEntity.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Integer> BEARD_TYPE =
            SynchedEntityData.defineId(HumanEntity.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Boolean> HAIR_GRAYS =
            SynchedEntityData.defineId(HumanEntity.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Boolean> HAIR_LOSS =
            SynchedEntityData.defineId(HumanEntity.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Boolean> SLEEPING =
            SynchedEntityData.defineId(HumanEntity.class, EntityDataSerializers.BOOLEAN);

    public Block lastBlockBreak = Blocks.AIR;

    protected double immuneStrength;
    protected double altitudeStrength;
    protected double heatStrength;
    protected double voicePitch;
    protected boolean homosexual;
    protected boolean fertile;
    protected double ageFactor;
    protected double foodLevels;
    protected double sickness;

    protected int blockTicks;

    protected UUID tribe;
    protected SimpleContainer inventory = new SimpleContainer(36);
    protected List<UUID> memories;

    public HumanEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setCanPickUpLoot(true);
        this.memories = new ArrayList<UUID>();
        this.foodLevels = 20;
    }

    @Override
    protected void registerGoals() {
    }

    @Override
    public boolean isNoAi() {
        return false;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }
}
