package com.bloomhousemc.terrafabricraft.common.component;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import com.bloomhousemc.terrafabricraft.common.registry.TfcComponents;
import com.bloomhousemc.terrafabricraft.common.registry.TfcDamage;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.Difficulty;

import java.util.Optional;

public class ThirstComponent implements AutoSyncedComponent, ServerTickingComponent {
    public static int MAX_THIRST = 100;
    public int thirst = MAX_THIRST;
    public int thirstTicker = 0;
    public int passiveThirstTicker = 0;

    private final PlayerEntity playerEntity;

    public ThirstComponent(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public int getThirst() {
        return thirst;
    }

    public int getMaxThirst() {
        return MAX_THIRST;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
        TfcComponents.THIRST_COMPONENT.sync(playerEntity);
    }

    public void increaseThirst(int add) {
        if (getThirst() + add <= getMaxThirst()) {
            setThirst(getThirst() + add);
            TfcComponents.THIRST_COMPONENT.sync(playerEntity);
        }
    }

    public void decreaseThirst(int sub){
        if(getThirst() - sub >= 0){

            setThirst(getThirst() - sub);
            TfcComponents.THIRST_COMPONENT.sync(playerEntity);
        }
    }

    //TODO: fix values
    @Override
    public void serverTick() {
        thirstTicker++;
        passiveThirstTicker++;
        Difficulty difficulty = playerEntity.world.getDifficulty();
        HealthComponent healthComponent = HealthComponent.get(playerEntity);
        ThirstComponent thirstComponent = ThirstComponent.get(playerEntity);
        //SLOW KILLER
        if(thirstComponent.getThirst() <= 0 && healthComponent.getHealth() > 0 && thirstTicker % 20 == 0 && !playerEntity.isSpectator() && !playerEntity.isCreative()){
            playerEntity.damage(TfcDamage.DEHYDRATION, 1.0F);
            thirstTicker = 0;
        }

        //TODO: should be faster than hunger
        //IDLE THIRST DECAY
        if (difficulty != Difficulty.PEACEFUL && thirstComponent.getThirst() > 0 && passiveThirstTicker % 25 == 0 && !playerEntity.isSpectator() && !playerEntity.isCreative()) {
            thirstComponent.decreaseThirst(1);
            passiveThirstTicker = 0;
        }
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        setThirst(tag.getInt("Thirst"));
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putInt("Thirst", getThirst());
    }

    public static ThirstComponent get(PlayerEntity obj) {
        return TfcComponents.THIRST_COMPONENT.get(obj);
    }

    public static Optional<ThirstComponent> maybeGet(PlayerEntity obj) {
        return TfcComponents.THIRST_COMPONENT.maybeGet(obj);
    }
}
