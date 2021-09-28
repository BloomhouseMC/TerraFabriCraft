package malek.terrafabricraft.mixin.common;

import malek.terrafabricraft.common.registry.TFCDamage;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Player.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @ModifyVariable(method = "actuallyHurt", at = @At(value = "INVOKE", shift = At.Shift.BEFORE, ordinal = 0, target = "Lnet/minecraft/world/entity/player/Player;getHealth()F"))
    private float modifyDamage(float amount, DamageSource source) {
        if (!level.isClientSide) {
            amount = TFCDamage.handleDamage(this, source, amount);
        }
        return amount;
    }
}
