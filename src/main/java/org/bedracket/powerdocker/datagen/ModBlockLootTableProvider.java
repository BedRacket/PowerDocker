package org.bedracket.powerdocker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.item.Item;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import org.bedracket.powerdocker.init.ModBlocks;
import org.bedracket.powerdocker.init.ModItems;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {

    protected ModBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ROSE);
        addDrop(ModBlocks.CACTUS_BALL);
        addDrop(ModBlocks.WILD_COCA);
        addPottedPlantDrops(ModBlocks.POTTED_ROSE);
        addPottedPlantDrops(ModBlocks.POTTED_CACTUS_BALL);
        offerCropDrop(ModBlocks.COCA_CROP, ModItems.COCA, ModItems.COCA, 7);
    }

    protected void offerCropDrop(Block crop, Item product, Item seed, int age) {
        addDrop(crop, cropDrops(crop, product, seed,
                BlockStatePropertyLootCondition.builder(ModBlocks.COCA_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, age))));
    }
}
