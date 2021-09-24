package malek.terrafabricraft.common.component;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import malek.terrafabricraft.common.registry.TFCComponents;
import net.fabricmc.fabric.api.event.Event;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.Difficulty;

import java.util.Optional;

import static net.fabricmc.fabric.api.event.EventFactory.createArrayBacked;

public class HungerComponent implements AutoSyncedComponent, ServerTickingComponent {
    public static int MAX_HUNGER = 100;
    public int hunger = MAX_HUNGER;
    public int hungerTicker = 0;
    public int passiveHungerTicker = 0;

    private final PlayerEntity playerEntity;
    public HungerComponent(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public int getHunger(){
        return hunger;
    }

    public int getMaxHunger(){
        return MAX_HUNGER;
    }

    public void setHunger(int hunger){
        HUNGER_SET.invoker().hungerSet(playerEntity, this.hunger);
        this.hunger = hunger;
        TFCComponents.HUNGER_COMPONENT.sync(playerEntity);
    }
    //TODO: fix values
    @Override
    public void serverTick() {
        hungerTicker++;
        passiveHungerTicker++;
        Difficulty difficulty = playerEntity.world.getDifficulty();
        HealthComponent healthComponent = HealthComponent.get(playerEntity);
        HungerComponent hungerComponent = HungerComponent.get(playerEntity);
        //HEALING
        if (difficulty != Difficulty.PEACEFUL && passiveHungerTicker >= 10 && healthComponent.getHealth() < healthComponent.getMaxHealth() && hungerComponent.getHunger() > (int)hungerComponent.getMaxHunger()*0.8) {
            healthComponent.setHealth(healthComponent.getHealth() + 1);
            hungerComponent.setHunger(hungerComponent.getHunger() - 1);
            passiveHungerTicker = 0;
        }
        //SLOW KILLER
        if(hungerComponent.getHunger() <= 0 && healthComponent.getHealth() > 0 && hungerTicker % 20 == 0){
            healthComponent.setHealth(healthComponent.getHealth() - 10);
            playerEntity.damage(DamageSource.STARVE, 1.0F);
        }
        //IDLE HUNGER DECAY
        if(hungerComponent.getHunger() > 0 && passiveHungerTicker % 25 == 0 && difficulty != Difficulty.PEACEFUL && !playerEntity.isSpectator() && !playerEntity.isCreative()){
            hungerComponent.setHunger(hungerComponent.getHunger() - 1);
            passiveHungerTicker = 0;
        }
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        setHunger(tag.getInt("Hunger"));

    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putInt("Hunger", getHunger());
    }

    public interface setHunger {
        void hungerSet(PlayerEntity entity, int amount);
    }
    public static final Event<setHunger> HUNGER_SET = createArrayBacked(setHunger.class, listeners -> (entity, amount) -> {
        for (setHunger listener : listeners) {
            listener.hungerSet(entity, amount);
        }
    });
    public static HungerComponent get(PlayerEntity obj) {
        return TFCComponents.HUNGER_COMPONENT.get(obj);
    }
    public static Optional<HungerComponent> maybeGet(PlayerEntity obj) {
        return TFCComponents.HUNGER_COMPONENT.maybeGet(obj);
    }
}
