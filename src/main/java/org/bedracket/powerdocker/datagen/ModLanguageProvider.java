package org.bedracket.powerdocker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import org.bedracket.powerdocker.init.ModBlocks;
import org.bedracket.powerdocker.init.ModItems;

public class ModLanguageProvider extends FabricLanguageProvider {

    protected ModLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.BED_RACKET, "BedRacket");
        translationBuilder.add(ModItems.COPPER_SWORD, "Copper Sword");
        translationBuilder.add(ModItems.COPPER_AXE, "Copper Axe");
        translationBuilder.add(ModItems.COPPER_HOE, "Copper Hoe");
        translationBuilder.add(ModItems.COPPER_PICKAXE, "Copper Pickaxe");
        translationBuilder.add(ModItems.COPPER_SHOVEL, "Copper Shovel");
        translationBuilder.add(ModItems.COPPER_NUGGET, "Copper Nugget");
        translationBuilder.add(ModItems.COPPER_HELMET, "Copper Helmet");
        translationBuilder.add(ModItems.COPPER_CHESTPLATE, "Copper Chestplate");
        translationBuilder.add(ModItems.COPPER_LEGGINGS, "Copper Leggings");
        translationBuilder.add(ModItems.COPPER_BOOTS, "Copper Boots");
        translationBuilder.add(ModItems.TROUT, "Trout");
        translationBuilder.add(ModItems.COOKED_TROUT, "Cooked Trout");
        translationBuilder.add(ModItems.TROUT_SPAWN_EGG, "Trout Spawn Egg");
        translationBuilder.add(ModItems.TROUT_BUCKET, "Trout Bucket");
        translationBuilder.add(ModBlocks.ROSE, "Rose");
        translationBuilder.add(ModBlocks.POTTED_ROSE, "Potted Rose");
        translationBuilder.add(ModBlocks.CACTUS_BALL, "Cactus Ball");
        translationBuilder.add(ModBlocks.POTTED_CACTUS_BALL, "Potted Cactus Ball");
        translationBuilder.add(ModItems.STONE_JAVELIN, "Stone Javelin");
        translationBuilder.add(ModItems.COPPER_JAVELIN, "Copper Javelin");
        translationBuilder.add("itemGroup.powerdocker.general", "PowerDocker|General");
    }
}
