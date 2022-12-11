package org.bedracket.powerdocker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import org.bedracket.powerdocker.init.ModItems;

public class ModLanguageProvider extends FabricLanguageProvider {

    protected ModLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.BED_RACKET.get(), "BedRacket");
        translationBuilder.add(ModItems.COPPER_SWORD.get(), "Copper Sword");
        translationBuilder.add(ModItems.COPPER_AXE.get(), "Copper Axe");
        translationBuilder.add(ModItems.COPPER_HOE.get(), "Copper Hoe");
        translationBuilder.add(ModItems.COPPER_PICKAXE.get(), "Copper Pickaxe");
        translationBuilder.add(ModItems.COPPER_SHOVEL.get(), "Copper Shovel");
        translationBuilder.add("itemGroup.powerdocker.general", "PowerDocker|General");
    }
}
