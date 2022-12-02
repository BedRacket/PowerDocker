package org.bedracket.powerdocker.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import org.bedracket.powerdocker.PowerdockerMod;
import org.bedracket.powerdocker.init.ModItems;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(DataGenerator gen) {
        super(gen, PowerdockerMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.BLAZE_BOW.get(), "Blaze Bow");
        add("tooltip.powerdocker.mana.weapons", "Magic Weapon");
    }
}
