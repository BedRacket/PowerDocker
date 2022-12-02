package org.bedracket.powerdocker.client.model;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class MaleHumanModel <T extends LivingEntity> extends PlayerModel<T> {

    public MaleHumanModel(ModelPart pRoot) {
        super(pRoot, false);
    }
}
