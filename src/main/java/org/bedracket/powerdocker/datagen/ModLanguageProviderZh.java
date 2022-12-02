package org.bedracket.powerdocker.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import org.bedracket.powerdocker.PowerdockerMod;
import org.bedracket.powerdocker.init.ModItems;

public class ModLanguageProviderZh extends LanguageProvider {

    public ModLanguageProviderZh(DataGenerator gen) {
        super(gen,  PowerdockerMod.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.BLAZE_BOW.get(), "烈焰弓");
        add("tooltip.powerdocker.mana.weapons", "魔法武器");
    }
}
