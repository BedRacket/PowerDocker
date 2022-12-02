package org.bedracket.powerdocker.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.FakePlayer;
import org.bedracket.powerdocker.PowerdockerMod;
import org.bedracket.powerdocker.api.mana.IManaHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public abstract class MixinGui extends GuiComponent {

    @Shadow protected abstract Player getCameraPlayer();

    @Shadow protected int screenWidth;

    @Shadow protected int screenHeight;

    @Shadow @Final protected RandomSource random;

    @Inject(method = "renderHotbar", at = @At("RETURN"))
    private void renderManaBar(float pPartialTick, PoseStack pPoseStack, CallbackInfo ci) {
        Player player = this.getCameraPlayer();
        IManaHandler handler = (IManaHandler) player;
        if (player != null
                && !player.isCreative()
                && !player.isSpectator()
                && !(player instanceof FakePlayer)) {
            int mana = Mth.ceil(handler.getMana());
            int barX = this.screenWidth / 2 - 91;
            int barY = this.screenHeight - 39;
            int manaPerStar = (int) handler.getMaxMana() / 10;
            int maxHealth = Mth.ceil((player.getAttributeValue(Attributes.MAX_HEALTH)
                    + player.getAbsorptionAmount()) / 2.0F / 10.0F);
            RenderSystem.setShaderTexture(0, new ResourceLocation(PowerdockerMod.MOD_ID, "textures/gui/icons.png"));
            int x;

            for (x = 9; x >= 0; --x) {
                int drawX = barX + x * 8;
                int drawY = barY - (maxHealth - 1) * Math.max(10 - (maxHealth - 2), 3) - 10;
                if (player.getArmorValue() > 0) {
                    drawY -= 10;
                }
                if (Mth.ceil(mana) <= 2 * manaPerStar) {
                    drawY += this.random.nextInt(2);
                }
                this.blit(pPoseStack, drawX, drawY, 0, 0, 9, 9);
                if (x * manaPerStar + 1 < mana) {
                    this.blit(pPoseStack, drawX, drawY, 9, 0, 9, 9);
                } else if (x * manaPerStar + 1 == mana) {
                    this.blit(pPoseStack, drawX, drawY, 18, 0, 9, 9);
                }
            }
        }
    }
}
