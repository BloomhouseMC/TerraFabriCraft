package com.bloomhousemc.terrafabricraft.mixin.common.temperature;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.chunk.BlendingData;
import net.minecraft.world.tick.SimpleTickScheduler;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ProtoChunk.class)
public abstract class ProtoChunkMixin extends Chunk {

    public ProtoChunkMixin(ChunkPos pos, UpgradeData upgradeData, @Nullable ChunkSection[] sections, SimpleTickScheduler<Block> blockTickScheduler, SimpleTickScheduler<Fluid> fluidTickScheduler, HeightLimitView world, Registry<Biome> biomeRegistry, @Nullable BlendingData blendingData) {
        super(pos, upgradeData, world, biomeRegistry, 0L, sections, blendingData);
    }

    @Inject(method = "<init>(Lnet/minecraft/util/math/ChunkPos;Lnet/minecraft/world/chunk/UpgradeData;[Lnet/minecraft/world/chunk/ChunkSection;Lnet/minecraft/world/tick/SimpleTickScheduler;Lnet/minecraft/world/tick/SimpleTickScheduler;Lnet/minecraft/world/HeightLimitView;Lnet/minecraft/util/registry/Registry;Lnet/minecraft/world/gen/chunk/BlendingData;)V", at = @At("RETURN"))
    private void initComponents(CallbackInfo ci) {
        var pos = this.getPos();
        TerraFabriCraft.LOGGER.debug(pos.x + " and, " + pos.z);
    }
}
