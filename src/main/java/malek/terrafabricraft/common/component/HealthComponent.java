package malek.terrafabricraft.common.component;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import malek.terrafabricraft.common.registry.TFCComponents;
import malek.terrafabricraft.mixin.common.PlayerEntityMixin;
import net.fabricmc.fabric.api.event.Event;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;

import java.util.Optional;

import static net.fabricmc.fabric.api.event.EventFactory.createArrayBacked;

public class HealthComponent implements AutoSyncedComponent, ServerTickingComponent {
    public static int MAX_HEALTH = 100;
    public int health = MAX_HEALTH;

    private final LivingEntity livingEntity;
    public HealthComponent(LivingEntity livingEntity) {
        this.livingEntity = livingEntity;
    }

    public int getHealth(){
        return health;
    }

    public int getMaxHealth(){
        return MAX_HEALTH;
    }

    public void setHealth(int health){
        HEALTH_SET.invoker().healthSet(livingEntity, this.health);
        this.health = health;
        TFCComponents.HEALTH_COMPONENT.sync(livingEntity);
    }


    @Override
    public void serverTick() {
        if(livingEntity instanceof PlayerEntity){
            HealthComponent healthComponent = HealthComponent.get(livingEntity);
            HungerComponent hungerComponent = HungerComponent.get((PlayerEntity) (Object) livingEntity);
            if(healthComponent.getHealth() <= 0 && hungerComponent.getHunger() <= 0){
                //TODO: Hunger Hack, could be nicer to deal with death
                livingEntity.damage(DamageSource.STARVE, 1);
            }
        }
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        setHealth(tag.getInt("Health"));

    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putInt("Health", getHealth());
    }

    public interface setHealth {
        void healthSet(LivingEntity entity, int amount);
    }
    public static final Event<setHealth> HEALTH_SET = createArrayBacked(setHealth.class, listeners -> (entity, amount) -> {
        for (setHealth listener : listeners) {
            listener.healthSet(entity, amount);
        }
    });
    public static HealthComponent get(LivingEntity obj) {
        return TFCComponents.HEALTH_COMPONENT.get(obj);
    }
    public static Optional<HealthComponent> maybeGet(LivingEntity obj) {
        return TFCComponents.HEALTH_COMPONENT.maybeGet(obj);
    }
}
