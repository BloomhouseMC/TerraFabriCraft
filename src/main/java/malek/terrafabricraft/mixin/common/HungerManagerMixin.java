package malek.terrafabricraft.mixin.common;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoodData.class)
public abstract class HungerManagerMixin {

    //Effectively disable vanilla hunger system
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void ded(Player player, CallbackInfo ci){
        ci.cancel();
    }
}
