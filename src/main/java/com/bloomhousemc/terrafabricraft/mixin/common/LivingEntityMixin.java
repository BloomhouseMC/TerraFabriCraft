package com.bloomhousemc.terrafabricraft.mixin.common;

import com.bloomhousemc.terrafabricraft.common.registry.TfcDamage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    public abstract StatusEffectInstance getStatusEffect(StatusEffect effect);

    @Inject(method = "computeFallDamage", at = @At("RETURN"), cancellable = true)
    private void computeFallDamage(float fallDistance, float damageMultiplier, CallbackInfoReturnable<Integer> cir) {
        StatusEffectInstance statusEffectInstance = this.getStatusEffect(StatusEffects.JUMP_BOOST);
        float f = statusEffectInstance == null ? 0.0F : (float) (statusEffectInstance.getAmplifier() + 1);
        cir.setReturnValue(MathHelper.ceil((fallDistance - 3.0F - f) * damageMultiplier));
    }

    @ModifyVariable(method = "applyDamage", ordinal = 2, at = @At(value = "INVOKE", shift = At.Shift.BEFORE, ordinal = 0, target = "Lnet/minecraft/entity/LivingEntity;getHealth()F"))
    private float modifyDamage(float amount, DamageSource source) {
        if (!world.isClient) {
            amount = TfcDamage.handleDamage((LivingEntity) (Object) this, source, amount);
        }
        return amount;
    }


    /*
    @Inject(method = "isDead", at = @At("HEAD"), cancellable = true)
    private void ded(CallbackInfoReturnable<Boolean> cir){
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        HealthComponent.maybeGet(livingEntity).ifPresent(healthComponent -> {
        if(healthComponent.getHealth() == 0){
            cir.setReturnValue(true);
        }});
    }

     */
    /*
    @ModifyVariable(method = "applyDamage", at = @At(value = "INVOKE", shift = At.Shift.BEFORE, ordinal = 0, target = "Lnet/minecraft/entity/player/PlayerEntity;getHealth()F"))
    private float modifyDamage(float amount, DamageSource source) {
        if (!world.isClient) {
            amount = TFCDamage.handleDamage((LivingEntity) (Object) this, source, amount);
        }
        return amount;
    }

     */
}