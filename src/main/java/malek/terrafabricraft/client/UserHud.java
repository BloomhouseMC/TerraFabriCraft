package malek.terrafabricraft.client;

import malek.terrafabricraft.common.component.HealthComponent;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class UserHud extends DrawableHelper implements HudRenderCallback {
    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        MinecraftClient mc = MinecraftClient.getInstance();
        PlayerEntity player = mc.player;
        TextRenderer textRenderer = mc.textRenderer;
        int height = mc.getWindow().getScaledHeight();
        HealthComponent.maybeGet(player).ifPresent(healthComponent -> {
            int health = healthComponent.getHealth();
            int max = healthComponent.getMaxHealth();
            matrixStack.push();
            renderText(matrixStack, textRenderer, new TranslatableText("hud.terrafabricraft.health", new TranslatableText(String.valueOf(health)),new TranslatableText(String.valueOf(max))));
            matrixStack.pop();
        });
    }

    void renderText(MatrixStack stack, TextRenderer renderer, Text text) {
        MinecraftClient mc = MinecraftClient.getInstance();
        int textWidth = renderer.getWidth(text);
        int width = mc.getWindow().getScaledWidth();
        int height = mc.getWindow().getScaledHeight();
        stack.scale(0.75F,0.75F,1F);
        //TODO: Scale text pos with windowsize
        drawCenteredText(stack, renderer, text, textWidth/2 + 200, height + 29, 0xffffff);
    }
}
