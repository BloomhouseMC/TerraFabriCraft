package com.bloomhousemc.terrafabricraft.mixin.common.temperature;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructureManager;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ChunkSerializer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ProtoChunk;
import net.minecraft.world.chunk.ReadOnlyChunk;
import net.minecraft.world.poi.PointOfInterestStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChunkSerializer.class)
public abstract class ChunkSerializerMixin {
    @Inject(method = "deserialize", at = @At("RETURN"))
    private static void deserialize(ServerWorld world, PointOfInterestStorage poiStorage, ChunkPos chunkPos, NbtCompound nbt, CallbackInfoReturnable<ProtoChunk> cir) {
        var levelData = nbt.getCompound("Level");
        levelData.getInt("temperature");
        TerraFabriCraft.LOGGER.warn("temp is " + levelData.getInt("temperature") + " degrees celsius.");
    }

    @Inject(method = "serialize", at = @At("RETURN"))
    private static void serialize(ServerWorld world, Chunk chunk, CallbackInfoReturnable<NbtCompound> cir) {
        NbtCompound ret = cir.getReturnValue();
        NbtCompound levelData = ret.getCompound("Level");
        levelData.putInt("temperature", 69);
    }
}