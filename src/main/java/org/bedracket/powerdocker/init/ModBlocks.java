package org.bedracket.powerdocker.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffects;
import org.bedracket.powerdocker.PowerDockerMod;
import org.bedracket.powerdocker.util.Registrar;
import org.bedracket.powerdocker.util.RegistryEntry;

@Registrar(element = Block.class, modid = PowerDockerMod.MOD_ID)
public class ModBlocks {

    @RegistryEntry("rose")
    public static final Block ROSE =
            new FlowerBlock(StatusEffects.SPEED, 8,
            AbstractBlock.Settings.copy(Blocks.DANDELION));

}
