package malek.terrafabricraft.mixin.common;

import malek.terrafabricraft.common.component.HealthComponent;
import malek.terrafabricraft.common.component.HungerComponent;
import malek.terrafabricraft.common.registry.TFCDamage;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    @Shadow protected HungerManager hungerManager;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }
    @ModifyVariable(method = "applyDamage", at = @At(value = "INVOKE", shift = At.Shift.BEFORE, ordinal = 0, target = "Lnet/minecraft/entity/player/PlayerEntity;getHealth()F"))
    private float modifyDamage(float amount, DamageSource source) {
        if (!world.isClient) {
            amount = TFCDamage.handleDamage(this, source, amount);
        }
        return amount;
    }

    @Inject(method = "damage", at = @At(value = "HEAD"))
    private void canDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir){

    }
    @Inject(method = "eatFood", at = @At("HEAD"))
    private void eat(World world, ItemStack stack, CallbackInfoReturnable<ItemStack> callbackInfo) {
        if (!world.isClient) {
            //TODO: Fix a system for food quality
            HungerComponent hungerComponent = HungerComponent.get((PlayerEntity) (Object) this);
            hungerComponent.setHunger(hungerComponent.getHunger() + 10);    //TODO: this value 10 is just for testing
        }
    }
    @Inject(method = "canFoodHeal", at = @At("RETURN"), cancellable = true)
    private void disableNormalFoodHeal(CallbackInfoReturnable<Boolean> callbackInfo) {
        callbackInfo.setReturnValue(false);
    }
}
