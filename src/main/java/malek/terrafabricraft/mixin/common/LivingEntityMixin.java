package malek.terrafabricraft.mixin.common;

import malek.terrafabricraft.common.component.HealthComponent;
import malek.terrafabricraft.common.registry.TFCDamage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
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