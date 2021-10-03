package malek.terrafabricraft.mixin.client;

import net.minecraft.client.render.RenderPhase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(RenderPhase.class)
public interface RenderLayerAccessor {
    @Accessor("COLOR_MASK")
    static RenderPhase.WriteMaskState COLOR_MASK() {
        return null;
    }

    @Accessor("GLINT_SHADER")
    static RenderPhase.Shader GLINT_SHADER() {
        return null;
    };


    @Accessor("DISABLE_CULLING")
    static RenderPhase.Cull DISABLE_CULLING() {
        return null;
    }

    @Accessor("EQUAL_DEPTH_TEST")
    static RenderPhase.DepthTest EQUAL_DEPTH_TEST() {
        return null;
    }

    @Accessor("GLINT_TRANSPARENCY")
    static RenderPhase.Transparency GLINT_TRANSPARENCY() {
        return null;
    }

    @Accessor("GLINT_TEXTURING")
    static RenderPhase.Texturing GLINT_TEXTURING() {
        return null;
    }

}
