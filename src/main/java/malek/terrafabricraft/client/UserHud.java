package malek.terrafabricraft.client;

import com.mojang.blaze3d.vertex.PoseStack;
import malek.terrafabricraft.common.component.HealthComponent;
import malek.terrafabricraft.common.component.ProficiencyComponent;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;


//Draw moved to mixin, keeping just in case for a little while
public class UserHud extends GuiComponent implements HudRenderCallback {
    @Override
    public void onHudRender(PoseStack matrixStack, float tickDelta) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        Font textRenderer = mc.font;
        int height = mc.getWindow().getGuiScaledHeight();
        ProficiencyComponent.maybeGet(player).ifPresent(proficiencyComponent -> {
            int agri_level = proficiencyComponent.getAgriLevel();
            int butch_level = proficiencyComponent.getButchLevel();
            int cook_level = proficiencyComponent.getCookLevel();
            int pros_level = proficiencyComponent.getProsLevel();
            int smith_level = proficiencyComponent.getSmithLevel();
            matrixStack.pushPose();
            renderText(matrixStack, textRenderer, new TranslatableComponent("hud.terrafabricraft.proficiency.agri", new TranslatableComponent(String.valueOf(agri_level))), height, 7);
            renderText(matrixStack, textRenderer, new TranslatableComponent("hud.terrafabricraft.proficiency.butch", new TranslatableComponent(String.valueOf(butch_level))), height, 6);
            renderText(matrixStack, textRenderer, new TranslatableComponent("hud.terrafabricraft.proficiency.cook", new TranslatableComponent(String.valueOf(cook_level))), height, 5);
            renderText(matrixStack, textRenderer, new TranslatableComponent("hud.terrafabricraft.proficiency.pros", new TranslatableComponent(String.valueOf(pros_level))), height, 4);
            renderText(matrixStack, textRenderer, new TranslatableComponent("hud.terrafabricraft.proficiency.smith", new TranslatableComponent(String.valueOf(smith_level))), height, 3);
            matrixStack.popPose();
        });
    }

    void renderText(PoseStack stack, Font renderer, Component text, int height, int offset) {
        int textWidth = renderer.width(text);
        drawCenteredString(stack, renderer, text, textWidth/2 + 10, height + 18 - offset*9, 0xffffff);
    }
}
