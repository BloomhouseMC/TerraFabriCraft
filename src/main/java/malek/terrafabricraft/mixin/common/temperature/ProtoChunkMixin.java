package malek.terrafabricraft.mixin.common.temperature;

import malek.terrafabricraft.TerraFabriCraft;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ProtoChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ProtoChunk.class)
public abstract class ProtoChunkMixin implements Chunk {
    @Shadow
    public abstract ChunkPos getPos();

    @Inject(method = "<init>(Lnet/minecraft/util/math/ChunkPos;Lnet/minecraft/world/chunk/UpgradeData;[Lnet/minecraft/world/chunk/ChunkSection;Lnet/minecraft/world/ChunkTickScheduler;Lnet/minecraft/world/ChunkTickScheduler;Lnet/minecraft/world/HeightLimitView;)V", at = @At("RETURN"))
    private void initComponents(CallbackInfo ci) {
        var pos = this.getPos();
        TerraFabriCraft.LOGGER.debug(pos.x + " and, " + pos.z);
    }
}
