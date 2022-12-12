package org.bedracket.powerdocker.init;

import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.bedracket.powerdocker.PowerDockerMod;

public class ModBlocks {

    public static final Block ROSE = register("rose",
            new FlowerBlock(StatusEffects.SPEED, 8,
                    AbstractBlock.Settings.copy(Blocks.DANDELION)));

    public static final Block POTTED_ROSE = register("potted_rose",
            new FlowerPotBlock(ModBlocks.ROSE,
                    AbstractBlock.Settings.copy(Blocks.POTTED_DANDELION)));

    private static Block register(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(PowerDockerMod.MOD_ID, name), block);
    }
}
