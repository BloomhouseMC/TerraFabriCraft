package malek.terrafabricraft.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.component.HealthComponent;
import malek.terrafabricraft.common.component.HungerComponent;
import malek.terrafabricraft.common.component.ThirstComponent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public abstract class InGameHudMixin extends DrawableHelper {
    private static final Identifier TFC_GUI_ICONS_TEXTURE = new Identifier(TerraFabriCraft.MODID, "textures/gui/icons/overlay.png");
    private static final Identifier EMPTY_GUI_ICONS_TEXTURE = new Identifier(TerraFabriCraft.MODID, "textures/gui/icons/empty.png");
    @Shadow
    protected abstract PlayerEntity getCameraPlayer();

    @Shadow
    private int scaledHeight;

    @Shadow
    private int scaledWidth;


    //TODO: Add Thirst and replace statusbars
    @Inject(method = "renderStatusBars", at = @At(value = "INVOKE", shift = At.Shift.AFTER, ordinal = 1, target = "Lnet/minecraft/client/MinecraftClient;getProfiler()Lnet/minecraft/util/profiler/Profiler;"))
    private void renderPre(MatrixStack matrices, CallbackInfo callbackInfo) {
        PlayerEntity player = getCameraPlayer();
        //To use our textures
        RenderSystem.setShaderTexture(0, TFC_GUI_ICONS_TEXTURE);
        drawHunger(matrices, player, scaledWidth / 2 + 1, scaledHeight - 40);
        drawThirst(matrices, player, scaledWidth / 2 + 1, scaledHeight - 35);
        matrices.push();
        drawHealth(matrices, player, scaledWidth / 2 - 91, scaledHeight - 40);
        matrices.pop();

        //To give back minecraft its textures
        RenderSystem.setShaderTexture(0, EMPTY_GUI_ICONS_TEXTURE);
    }
    private void drawHealth(MatrixStack matrices, LivingEntity entity, int x, int y) {
        HealthComponent.maybeGet(entity).ifPresent(healthComponent -> {
            MinecraftClient mc = MinecraftClient.getInstance();
            TextRenderer textRenderer = mc.textRenderer;
            int healthDisp = healthComponent.getHealth();
            int maxDisp = healthComponent.getMaxHealth();
            float health = ((float) healthComponent.getHealth() / HealthComponent.MAX_HEALTH);
            drawTexture(matrices, x, y, 0, 0, 90, 9);
            drawTexture(matrices, x, y, 0, 10, (int)(health*90), 9);
            textRenderer.draw(matrices, new TranslatableText("hud.terrafabricraft.health", new TranslatableText(String.valueOf(healthDisp)),new TranslatableText(String.valueOf(maxDisp))), x+20, y+1, 0xffffff);

        });
    }
    private void drawHunger(MatrixStack matrices, LivingEntity entity, int x, int y) {
        HungerComponent.maybeGet((PlayerEntity) (Object)entity).ifPresent(hungerComponent -> {
            float hunger = ((float) hungerComponent.getHunger() / HungerComponent.MAX_HUNGER);
            drawTexture(matrices, x, y, 0, 20, 90, 5);
            drawTexture(matrices, x, y, 0, 25, (int)(hunger*90), 5);
        });
    }
    private void drawThirst(MatrixStack matrices, LivingEntity entity, int x, int y) {
        ThirstComponent.maybeGet(entity).ifPresent(thirstComponent -> {
            float thirst = ((float) thirstComponent.getThirst() / ThirstComponent.MAX_THIRST);
            drawTexture(matrices, x, y, 90, 20, 90, 5);
            drawTexture(matrices, x, y, 90, 25, (int)(thirst*90), 5);
        });
    }
}
