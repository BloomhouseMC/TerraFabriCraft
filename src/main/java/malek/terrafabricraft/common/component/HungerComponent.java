package malek.terrafabricraft.common.component;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import malek.terrafabricraft.common.registry.TFCComponents;
import net.minecraft.block.CactusBlock;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.Difficulty;

import java.util.Optional;

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
        this.hunger = hunger;
        TFCComponents.HUNGER_COMPONENT.sync(playerEntity);
    }

    public void increaseHunger(int add){
        if(getHunger() + add <= getMaxHunger()){
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
        Difficulty difficulty = playerEntity.world.getDifficulty();
        HealthComponent healthComponent = HealthComponent.get(playerEntity);
        HungerComponent hungerComponent = HungerComponent.get(playerEntity);
        //HEALING
        if (difficulty != Difficulty.PEACEFUL && passiveHungerTicker >= 10 && healthComponent.getHealth() < healthComponent.getMaxHealth() && hungerComponent.getHunger() > (int)hungerComponent.getMaxHunger()*0.8) {
            healthComponent.increaseHealth(2);
            hungerComponent.decreaseHunger(1);
            passiveHungerTicker = 0;
        }
        //SLOW KILLER
        if(hungerComponent.getHunger() <= 0 && healthComponent.getHealth() > 0 && hungerTicker % 20 == 0){
            playerEntity.damage(DamageSource.STARVE, 1.0F);
            hungerTicker = 0;
        }
        //IDLE HUNGER DECAY
        if(hungerComponent.getHunger() > 0 && passiveHungerTicker % 15 == 0 && difficulty != Difficulty.PEACEFUL && !playerEntity.isSpectator() && !playerEntity.isCreative()){
            hungerComponent.decreaseHunger(1);
            passiveHungerTicker = 0;
        }
        System.out.println(hungerComponent.getHunger());
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        setHunger(tag.getInt("Hunger"));
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putInt("Hunger", getHunger());
    }

    public static HungerComponent get(PlayerEntity obj) {
        return TFCComponents.HUNGER_COMPONENT.get(obj);
    }

    public static Optional<HungerComponent> maybeGet(PlayerEntity obj) {
        return TFCComponents.HUNGER_COMPONENT.maybeGet(obj);
    }
}
