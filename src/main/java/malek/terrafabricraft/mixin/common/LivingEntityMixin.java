package malek.terrafabricraft.mixin.common;

import malek.terrafabricraft.common.component.HealthComponent;
import malek.terrafabricraft.common.registry.TFCDamage;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Shadow
    public abstract MobEffectInstance getEffect(MobEffect effect);

    @Inject(method = "calculateFallDamage", at = @At("RETURN"), cancellable = true)
    private void calculateFallDamage(float fallDistance, float damageMultiplier, CallbackInfoReturnable<Integer> cir){
        MobEffectInstance statusEffectInstance = this.getEffect(MobEffects.JUMP);
        float f = statusEffectInstance == null ? 0.0F : (float)(statusEffectInstance.getAmplifier() + 1);
        cir.setReturnValue(Mth.ceil((fallDistance - 3.0F - f) * damageMultiplier));
    }
    @ModifyVariable(method = "actuallyHurt", at = @At(value = "INVOKE", shift = At.Shift.BEFORE, ordinal = 0, target = "Lnet/minecraft/world/entity/LivingEntity;getHealth()F"))
    private float modifyDamage(float amount, DamageSource source) {
        if (!level.isClientSide) {
            amount = TFCDamage.handleDamage((LivingEntity) (Object)this, source, amount);
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