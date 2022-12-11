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
        translationBuilder.add(ModItems.BED_RACKET, "BedRacket");
        translationBuilder.add(ModItems.COPPER_SWORD, "铜剑");
        translationBuilder.add(ModItems.COPPER_AXE, "铜斧");
        translationBuilder.add(ModItems.COPPER_HOE, "铜锄");
        translationBuilder.add(ModItems.COPPER_PICKAXE, "铜镐");
        translationBuilder.add(ModItems.COPPER_SHOVEL, "铜锹");
        translationBuilder.add(ModItems.COPPER_NUGGET, "铜粒");
        translationBuilder.add(ModItems.COPPER_HELMET, "铜制头盔");
        translationBuilder.add(ModItems.COPPER_CHESTPLATE, "铜制胸甲");
        translationBuilder.add(ModItems.COPPER_LEGGINGS, "铜制护腿");
        translationBuilder.add(ModItems.COPPER_BOOTS, "铜制战靴");
        translationBuilder.add(ModItems.TROUT, "鳟鱼");
        translationBuilder.add(ModItems.COOKED_TROUT, "熟鳟鱼");
        translationBuilder.add(ModItems.TROUT_SPAWN_EGG, "鳟鱼刷怪蛋");
        translationBuilder.add(ModItems.TROUT_BUCKET, "鳟鱼桶");
        translationBuilder.add("itemGroup.powerdocker.general", "PowerDocker|通常");
    }
}
