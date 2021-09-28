package malek.terrafabricraft.common.component;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import malek.terrafabricraft.common.registry.TFCComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import java.util.Optional;

public class HungerComponent implements AutoSyncedComponent, ServerTickingComponent {
    public static int MAX_HUNGER = 100;
    public int hunger = MAX_HUNGER;
    public int hungerTicker = 0;
    public int passiveHungerTicker = 0;

    private final Player playerEntity;

    public HungerComponent(Player playerEntity) {
        this.playerEntity = playerEntity;
    }

    public int getHunger() {
        return hunger;
    }

    public int getMaxHunger() {
        return MAX_HUNGER;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
        TFCComponents.HUNGER_COMPONENT.sync(playerEntity);
    }

    public void increaseHunger(int add) {
        if (getHunger() + add <= getMaxHunger()) {
            setHunger(getHunger() + add);
            TFCComponents.HUNGER_COMPONENT.sync(playerEntity);
        }
    }


    public void decreaseHunger(int sub){
        if(getHunger() - sub >= 0){

            setHunger(getHunger() - sub);
            TFCComponents.HUNGER_COMPONENT.sync(playerEntity);
        }
    }

    //TODO: fix values
    @Override
    public void serverTick() {
        hungerTicker++;
        passiveHungerTicker++;
        Difficulty difficulty = playerEntity.level.getDifficulty();
        HealthComponent healthComponent = HealthComponent.get(playerEntity);
        HungerComponent hungerComponent = HungerComponent.get(playerEntity);
        //HEALING
        if (difficulty != Difficulty.PEACEFUL && passiveHungerTicker >= 10 && healthComponent.getHealth() < healthComponent.getMaxHealth() && hungerComponent.getHunger() > (int) hungerComponent.getMaxHunger() * 0.8) {
            healthComponent.increaseHealth(2);
            hungerComponent.decreaseHunger(1);
            passiveHungerTicker = 0;
        }
        //SLOW KILLER
        if(hungerComponent.getHunger() <= 0 && healthComponent.getHealth() > 0 && hungerTicker % 20 == 0 && !playerEntity.isCreative() && !playerEntity.isSpectator()){
            playerEntity.hurt(DamageSource.STARVE, 1.0F);
            hungerTicker = 0;
        }
        //IDLE HUNGER DECAY
        if (hungerComponent.getHunger() > 0 && passiveHungerTicker % 35 == 0 && difficulty != Difficulty.PEACEFUL && !playerEntity.isSpectator() && !playerEntity.isCreative()) {
            hungerComponent.decreaseHunger(1);
            passiveHungerTicker = 0;
        }
    }

    @Override
    public void readFromNbt(CompoundTag tag) {
        setHunger(tag.getInt("Hunger"));
    }

    @Override
    public void writeToNbt(CompoundTag tag) {
        tag.putInt("Hunger", getHunger());
    }

    public static HungerComponent get(Player obj) {
        return TFCComponents.HUNGER_COMPONENT.get(obj);
    }

    public static Optional<HungerComponent> maybeGet(Player obj) {
        return TFCComponents.HUNGER_COMPONENT.maybeGet(obj);
    }
}
