package org.bedracket.powerdocker.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.bedracket.powerdocker.PowerdockerMod;
import org.bedracket.powerdocker.api.mana.IManaHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class MixinPlayer extends LivingEntity implements IManaHandler {

    private static final EntityDataAccessor<Float> MANA =
            SynchedEntityData.defineId(Player.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> MAX_MANA =
            SynchedEntityData.defineId(Player.class, EntityDataSerializers.FLOAT);
    private static final int REGEN_SPEED = 20;
    private static final float REGEN_AMOUNT = 0.05f;

    protected MixinPlayer(EntityType<? extends LivingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public void setMana(float mana) {
        this.entityData.set(MANA, Math.min(getMaxMana(), mana));
    }

    @Override
    public void setMaxMana(float maxMana) {
        this.entityData.set(MANA, Mth.clamp(maxMana, 0.0F, this.getMaxMana()));
    }

    @Override
    public void regenMana(float mana) {
        this.setMana(this.getMana() + mana);
    }

    @Override
    public float getMana() {
        return this.entityData.get(MANA);
    }

    @Override
    public float getMaxMana() {
        return (float) this.getAttributeValue(Attributes.MAX_HEALTH);
    }

    @Override
    public void reduceMana(float mana) {
        this.setMana(this.getMana() - mana);
    }

    @Inject(method = "tick", at = @At("RETURN"))
    private void onPlayerUpdate(CallbackInfo ci) {
        if (this.getMana() < this.getMaxMana() && this.tickCount % REGEN_SPEED == 0) {
            regenMana(REGEN_AMOUNT);
        }
    }

    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    private void manaInit(CallbackInfo ci) {
        this.entityData.define(MAX_MANA, 0.0F);
        this.entityData.define(MANA, 0.0F);
    }

    @Inject(method = "addAdditionalSaveData", at = @At("RETURN"))
    private void writeMana(CompoundTag compound, CallbackInfo ci) {
        compound.putFloat(PowerdockerMod.MOD_ID + ":MaxMana", this.getMaxMana());
        compound.putFloat(PowerdockerMod.MOD_ID + ":Mana", this.getMana());
    }

    @Inject(method = "readAdditionalSaveData", at = @At("RETURN"))
    private void readMana(CompoundTag compound, CallbackInfo ci) {
        this.setMaxMana(compound.getFloat(PowerdockerMod.MOD_ID + ":MaxMana"));
        this.setMana(compound.getFloat(PowerdockerMod.MOD_ID + ":Mana"));
    }
}
