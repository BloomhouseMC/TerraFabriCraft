package malek.terrafabricraft.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LightmapTextureManager.class)
public class LightmapTextureManagerMixin {
    @Shadow
    @Final
    private Identifier textureIdentifier;
    @Shadow
    private MinecraftClient client;

    /**
     * @author
     *
     */
    @Overwrite
    public void enable() {
        RenderSystem.setShaderTexture(2, this.textureIdentifier);
        this.client.getTextureManager().bindTexture(this.textureIdentifier);
        RenderSystem.texParameter(3553, 10241, 9729);
        RenderSystem.texParameter(3553, 10240, 9729);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    //    System.out.println(textureIdentifier);
    }
}
