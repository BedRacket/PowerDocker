package org.bedracket.powerdocker.client.model;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FemaleHumanModel<T extends LivingEntity> extends PlayerModel<T> {

    public FemaleHumanModel(ModelPart pRoot) {
        super(pRoot, true);
    }
}
