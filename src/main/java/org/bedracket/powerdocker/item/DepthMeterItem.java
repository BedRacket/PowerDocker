package org.bedracket.powerdocker.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CompassItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class DepthMeterItem extends CompassItem {

    public DepthMeterItem() {
        super(new Settings().maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        int height = user.getBlockPos().getY();
        if (height > 257 && height < 350) {
            user.sendMessage(Text.translatable("info.powerdocker.height")
                    .append(String.valueOf(height)).append(Text.translatable("info.powerdocker.depth.sky_land")), true);
        }
        if (height > 193 && height < 256) {
            user.sendMessage(Text.translatable("info.powerdocker.height")
                    .append(String.valueOf(height)).append(Text.translatable("info.powerdocker.depth.sky")), true);
        }
        if (height > 181 && height < 192) {
            user.sendMessage(Text.translatable("info.powerdocker.height")
                    .append(String.valueOf(height))
                    .append(Text.translatable("info.powerdocker.depth.cloud")), true);
        }
        if (height > 117 && height < 180) {
            user.sendMessage(Text.translatable("info.powerdocker.height")
                    .append(String.valueOf(height))
                    .append(Text.translatable("info.powerdocker.depth.base_cloud")), true);
        }
        if (height == 63) {
            user.sendMessage(Text.translatable("info.powerdocker.height")
                    .append(String.valueOf(height))
                    .append(Text.translatable("info.powerdocker.depth.sea_level")), true);
        }
        if (height > 52 && height < 62 || height > 64 && height < 116) {
            user.sendMessage(Text.translatable("info.powerdocker.height")
                    .append(String.valueOf(height))
                    .append(Text.translatable("info.powerdocker.depth.surface")), true);
        }
        if (height > 4 && height < 51) {
            user.sendMessage(Text.translatable("info.powerdocker.height")
                    .append(String.valueOf(height))
                    .append(Text.translatable("info.powerdocker.depth.underground")), true);
        }
        if (height > -60 && height < 3) {
            user.sendMessage(Text.translatable("info.powerdocker.height")
                    .append(String.valueOf(height))
                    .append(Text.translatable("info.powerdocker.depth.deep_underground")), true);
        }
        if (height > -64 && height < -61) {
            user.sendMessage(Text.translatable("info.powerdocker.height")
                    .append(String.valueOf(height))
                    .append(Text.translatable("info.powerdocker.depth.bedrock")), true);
        }
        if (height > 320 || height < -64) {
            user.sendMessage(Text.translatable("info.powerdocker.height")
                    .append(String.valueOf(height))
                    .append(Text.translatable("info.powerdocker.depth.void")), true);
        }
        return super.use(world, user, hand);
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        return hasLodestone(stack) ? "item.powerdocker.depth_meter" : super.getTranslationKey(stack);
    }
}
