package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.common.component.HealthComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

public class TFCDamage {

    public static float handleDamage(LivingEntity entity, DamageSource source, float amount) {
        if(entity instanceof PlayerEntity){
            amount = handlePlayerDamage((PlayerEntity) (Object)entity, source, amount);
        }
        return amount;
    }


    public static float handlePlayerDamage(PlayerEntity entity, DamageSource source, float amount) {
        HealthComponent healthComponent = HealthComponent.get(entity);
        while (amount >= 0 && healthComponent.getHealth() > 0 && !entity.isDead()) {
            amount--;
            healthComponent.setHealth(healthComponent.getHealth() - 1);
        }
        return amount;
    }
}
