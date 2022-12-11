package org.bedracket.powerdocker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import org.bedracket.powerdocker.init.ModItems;

public class ModLanguageProviderZh extends FabricLanguageProvider {

    protected ModLanguageProviderZh(FabricDataOutput dataOutput) {
        super(dataOutput, "zh_cn");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.BED_RACKET.get(), "BedRacket");
        translationBuilder.add(ModItems.COPPER_SWORD.get(), "铜剑");
        translationBuilder.add(ModItems.COPPER_AXE.get(), "铜斧");
        translationBuilder.add(ModItems.COPPER_HOE.get(), "铜锄");
        translationBuilder.add(ModItems.COPPER_PICKAXE.get(), "铜镐");
        translationBuilder.add(ModItems.COPPER_SHOVEL.get(), "铜锹");
        translationBuilder.add(ModItems.COPPER_NUGGET.get(), "铜粒");
        translationBuilder.add(ModItems.COPPER_HELMET.get(), "铜制头盔");
        translationBuilder.add(ModItems.COPPER_CHESTPLATE.get(), "铜制胸甲");
        translationBuilder.add(ModItems.COPPER_LEGGINGS.get(), "铜制护腿");
        translationBuilder.add(ModItems.COPPER_BOOTS.get(), "铜制战靴");
        translationBuilder.add("itemGroup.powerdocker.general", "PowerDocker|通常");
    }
}
