package malek.terrafabricraft.mixin.common;

import malek.terrafabricraft.common.registry.TFCDamage;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    /*
    @Inject(method = "shouldCancelInteraction", at = @At("HEAD"), cancellable = true)
    public void allowItMan(CallbackInfoReturnable<Boolean> cir){

        if(this.getActiveItem().getItem() == TFCObjects.CERAMIC_VESSEL){
            cir.setReturnValue(false);
        }
    }

     */
    @ModifyVariable(method = "applyDamage", ordinal = 2, at = @At(value = "INVOKE", shift = At.Shift.BEFORE, ordinal = 0, target = "Lnet/minecraft/entity/player/PlayerEntity;getHealth()F"))
    private float modifyDamage(float amount, DamageSource source) {
        if (!world.isClient) {
            amount = TFCDamage.handleDamage(this, source, amount);
        }
        return amount;
    }
}
