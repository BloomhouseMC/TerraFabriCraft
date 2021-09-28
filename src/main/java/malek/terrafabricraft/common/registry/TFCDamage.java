package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.common.component.HealthComponent;
import malek.terrafabricraft.common.component.ProficiencyComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class TFCDamage {
    //New DamageSource for when the player have no water
    public static final DamageSource DROUGHT = new UnblockableDamageSource("drought");

    public static float handleDamage(LivingEntity entity, DamageSource source, float amount) {
        if (entity instanceof Player) {
            amount = handlePlayerDamage((Player) (Object) entity, source, amount);
        }
        return amount;
    }

    public static float handlePlayerDamage(Player entity, DamageSource source, float amount) {
        HealthComponent healthComponent = HealthComponent.get(entity);
        ProficiencyComponent proficiencyComponent = ProficiencyComponent.get(entity);
        //Convert regular damage to TFC damage by subtrackting amount and doing ealthComponent.setHealth
        while (amount > 0 && healthComponent.getHealth() > 0 && !entity.isDeadOrDying()) {
            amount--;
            for(int i = 0; healthComponent.getHealth() > 0 && i < 5; i++){ //TODO: balance the value of i, the value of is is the damage multiplier to be appropriate for the high amount of health compared to vanilla
                healthComponent.decreaseHealth(1);
            }
        }
        return amount;
    }

    private static class UnblockableDamageSource extends DamageSource {
        protected UnblockableDamageSource(String name) {
            super(name);
            bypassArmor();
            bypassMagic();
            bypassInvul();
        }
    }
}
