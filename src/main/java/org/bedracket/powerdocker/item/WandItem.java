package org.bedracket.powerdocker.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.bedracket.powerdocker.init.ModCreativeModeTabs;
import org.bedracket.powerdocker.util.ManaUtils;
import org.bedracket.powerdocker.util.SkillUtils;

public class WandItem extends Item {

    public WandItem() {
        super(new Item.Properties()
                .tab(ModCreativeModeTabs.COMMON)
                .stacksTo(1)
                .rarity(Rarity.UNCOMMON));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (ManaUtils.checkManaExist()) {
            SkillUtils.callSmallFireBall(pPlayer, pLevel, this);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
