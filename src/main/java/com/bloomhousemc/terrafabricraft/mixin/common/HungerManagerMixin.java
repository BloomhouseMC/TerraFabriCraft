package com.bloomhousemc.terrafabricraft.mixin.common;

import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HungerManager.class)
public abstract class HungerManagerMixin {

    //Effectively disable vanilla hunger system
    @Inject(method = "update", at = @At("HEAD"), cancellable = true)
    private void ded(PlayerEntity player, CallbackInfo ci){
        ci.cancel();
    }
}
