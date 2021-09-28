package malek.terrafabricraft.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.component.HealthComponent;
import malek.terrafabricraft.common.component.HungerComponent;
import malek.terrafabricraft.common.component.ThirstComponent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(Gui.class)
public abstract class InGameHudMixin extends GuiComponent {
    private static final ResourceLocation TFC_GUI_ICONS_TEXTURE = new ResourceLocation(TerraFabriCraft.MODID, "textures/gui/icons/overlay.png");
    private static final ResourceLocation EMPTY_GUI_ICONS_TEXTURE = new ResourceLocation(TerraFabriCraft.MODID, "textures/gui/icons/empty.png");
    @Shadow
    protected abstract Player getCameraPlayer();

    @Shadow
    private int screenHeight;

    @Shadow
    private int screenWidth;


    @Inject(method = "renderPlayerHealth", at = @At(value = "INVOKE", shift = At.Shift.AFTER, ordinal = 1, target = "Lnet/minecraft/client/Minecraft;getProfiler()Lnet/minecraft/util/profiling/ProfilerFiller;"))
    private void renderPre(PoseStack matrices, CallbackInfo callbackInfo) {
        Player player = getCameraPlayer();
        RenderSystem.setShaderTexture(0, TFC_GUI_ICONS_TEXTURE);
        drawHunger(matrices, player, screenWidth / 2 + 1, screenHeight - 40);
        drawThirst(matrices, player, screenWidth / 2 + 1, screenHeight - 35);
        drawHealth(matrices, player, screenWidth / 2 - 91, screenHeight - 40);
        RenderSystem.setShaderTexture(0, EMPTY_GUI_ICONS_TEXTURE);
    }
    //Rebind vanilla GUI textures after Health and Hunger has been removed
    @Inject(method = "renderPlayerHealth", at = @At(value = "INVOKE", shift = At.Shift.AFTER, ordinal = 3, target = "Lnet/minecraft/client/Minecraft;getProfiler()Lnet/minecraft/util/profiling/ProfilerFiller;"))
    private void renderPost(PoseStack matrices, CallbackInfo callbackInfo) {
        RenderSystem.setShaderTexture(0, GUI_ICONS_LOCATION);
    }


    private void drawHealth(PoseStack matrices, LivingEntity entity, int x, int y) {
        HealthComponent.maybeGet(entity).ifPresent(healthComponent -> {
            Minecraft mc = Minecraft.getInstance();
            Font textRenderer = mc.font;
            int healthDisp = healthComponent.getHealth();
            int maxDisp = healthComponent.getMaxHealth();
            float health = ((float) healthComponent.getHealth() / HealthComponent.MAX_HEALTH);
            blit(matrices, x, y, 0, 0, 90, 9);
            blit(matrices, x, y, 0, 10, (int)(health*90), 9);
            textRenderer.draw(matrices, new TranslatableComponent("hud.terrafabricraft.health", new TranslatableComponent(String.valueOf(healthDisp)),new TranslatableComponent(String.valueOf(maxDisp))), x+20, y+1, 0xffffff);

        });
    }
    private void drawHunger(PoseStack matrices, LivingEntity entity, int x, int y) {
        HungerComponent.maybeGet((Player) (Object)entity).ifPresent(hungerComponent -> {
            float hunger = ((float) hungerComponent.getHunger() / HungerComponent.MAX_HUNGER);
            blit(matrices, x, y, 0, 20, 90, 5);
            blit(matrices, x, y, 0, 25, (int)(hunger*90), 5);
        });
    }
    private void drawThirst(PoseStack matrices, LivingEntity entity, int x, int y) {
        ThirstComponent.maybeGet((Player) (Object)entity).ifPresent(thirstComponent -> {
            float thirst = ((float) thirstComponent.getThirst() / ThirstComponent.MAX_THIRST);
            blit(matrices, x, y, 90, 20, 90, 5);
            blit(matrices, x, y, 90, 25, (int)(thirst*90), 5);
        });
    }
}
