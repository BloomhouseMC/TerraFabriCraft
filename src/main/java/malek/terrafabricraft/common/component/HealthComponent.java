package malek.terrafabricraft.common.component;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import malek.terrafabricraft.common.registry.TFCComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import java.util.Optional;


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
        this.health = health;
        TFCComponents.HEALTH_COMPONENT.sync(livingEntity);
    }

    public void increaseHealth(int add){
        if(getHealth() + add <= getMaxHealth()){
            setHealth(getHealth() + add);
            TFCComponents.HEALTH_COMPONENT.sync(livingEntity);
        }
    }
    public void decreaseHealth(int sub){
        if(getHealth() - sub >= 0){
            setHealth(getHealth() - sub);
            TFCComponents.HEALTH_COMPONENT.sync(livingEntity);
        }
    }

    @Override
    public void serverTick() {
        if(livingEntity instanceof Player){
            HealthComponent healthComponent = HealthComponent.get(livingEntity);
            if(healthComponent.getHealth() <= 0 && livingEntity.isAlive() && !((Player) livingEntity).isCreative() && !livingEntity.isSpectator()){
                if(livingEntity.getLastDamageSource() != null){

                    livingEntity.hurt(livingEntity.getLastDamageSource(), Float.MAX_VALUE);
                }
            }
            Difficulty difficulty = livingEntity.level.getDifficulty();
            if(difficulty == Difficulty.PEACEFUL && healthComponent.getHealth() < healthComponent.getMaxHealth()){
                healthComponent.increaseHealth(1);
            }
        }
    }

    @Override
    public void readFromNbt(CompoundTag tag) {
        setHealth(tag.getInt("Health"));

    }

    @Override
    public void writeToNbt(CompoundTag tag) {
        tag.putInt("Health", getHealth());
    }

    public static HealthComponent get(LivingEntity obj) {
        return TFCComponents.HEALTH_COMPONENT.get(obj);
    }

    public static Optional<HealthComponent> maybeGet(LivingEntity obj) {
        return TFCComponents.HEALTH_COMPONENT.maybeGet(obj);
    }
}
