package malek.terrafabricraft.mixin.client;

import malek.terrafabricraft.TerraFabriCraft;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
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
    private static final Identifier TFC_GUI_ICONS_TEXTURE = new Identifier(TerraFabriCraft.MODID, "textures/gui/icons.png");
    @Shadow
    protected abstract PlayerEntity getCameraPlayer();

    @Shadow
    private int scaledHeight;

    @Shadow
    private int scaledWidth;

    @Shadow
    @Final
    private MinecraftClient client;

    //TODO: Add Thirst and replace statusbars
    @Inject(method = "renderStatusBars", at = @At(value = "HEAD"))
    private void renderPre(MatrixStack matrices, CallbackInfo callbackInfo) {
        PlayerEntity player = getCameraPlayer();
        //To use our textures
        client.getTextureManager().bindTexture(TFC_GUI_ICONS_TEXTURE);

        //Do stuff

        //To give back minecraft its textures
        client.getTextureManager().bindTexture(GUI_ICONS_TEXTURE);
    }
}
