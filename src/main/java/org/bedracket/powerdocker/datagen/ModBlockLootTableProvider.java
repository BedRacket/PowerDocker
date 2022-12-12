package org.bedracket.powerdocker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import org.bedracket.powerdocker.init.ModBlocks;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {

    protected ModBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ROSE);
        addDrop(ModBlocks.CACTUS_BALL);
        addPottedPlantDrops(ModBlocks.POTTED_ROSE);
        addPottedPlantDrops(ModBlocks.POTTED_CACTUS_BALL);
        addDrop(ModBlocks.LAND_KELP);
    }
}
