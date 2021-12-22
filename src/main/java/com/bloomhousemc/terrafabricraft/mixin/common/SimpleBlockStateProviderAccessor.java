package com.bloomhousemc.terrafabricraft.mixin.common;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SimpleBlockStateProvider.class)
public interface SimpleBlockStateProviderAccessor {
    @Invoker(value = "<init>")
    static SimpleBlockStateProvider init(BlockState state) {
        throw new UnsupportedOperationException();
    }
}
