package io.github.bloomhousemc.terrafabricraft.client;

import io.github.bloomhousemc.terrafabricraft.common.component.ProficiencyComponent;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;


//Draw moved to mixin, keeping just in case for a little while
public class UserHud extends DrawableHelper implements HudRenderCallback {
    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        MinecraftClient mc = MinecraftClient.getInstance();
        PlayerEntity player = mc.player;
        TextRenderer textRenderer = mc.textRenderer;
        int height = mc.getWindow().getScaledHeight();
        ProficiencyComponent.maybeGet(player).ifPresent(proficiencyComponent -> {
            int agri_level = proficiencyComponent.getAgriLevel();
            int butch_level = proficiencyComponent.getButchLevel();
            int cook_level = proficiencyComponent.getCookLevel();
            int pros_level = proficiencyComponent.getProsLevel();
            int smith_level = proficiencyComponent.getSmithLevel();
            matrixStack.push();
            renderText(matrixStack, textRenderer, new TranslatableText("hud.terrafabricraft.proficiency.agri", new TranslatableText(String.valueOf(agri_level))), height, 7);
            renderText(matrixStack, textRenderer, new TranslatableText("hud.terrafabricraft.proficiency.butch", new TranslatableText(String.valueOf(butch_level))), height, 6);
            renderText(matrixStack, textRenderer, new TranslatableText("hud.terrafabricraft.proficiency.cook", new TranslatableText(String.valueOf(cook_level))), height, 5);
            renderText(matrixStack, textRenderer, new TranslatableText("hud.terrafabricraft.proficiency.pros", new TranslatableText(String.valueOf(pros_level))), height, 4);
            renderText(matrixStack, textRenderer, new TranslatableText("hud.terrafabricraft.proficiency.smith", new TranslatableText(String.valueOf(smith_level))), height, 3);
            matrixStack.pop();
        });
    }

    void renderText(MatrixStack stack, TextRenderer renderer, Text text, int height, int offset) {
        int textWidth = renderer.getWidth(text);
        drawCenteredText(stack, renderer, text, textWidth/2 + 10, height + 18 - offset*9, 0xffffff);
    }
}
