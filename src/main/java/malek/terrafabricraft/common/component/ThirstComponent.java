package malek.terrafabricraft.common.component;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import malek.terrafabricraft.common.registry.TFCComponents;
import malek.terrafabricraft.common.registry.TFCDamage;
import net.fabricmc.fabric.api.event.Event;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.Difficulty;

import java.util.Optional;

import static net.fabricmc.fabric.api.event.EventFactory.createArrayBacked;

public class ThirstComponent implements AutoSyncedComponent, ServerTickingComponent {
    public static int MAX_THIRST = 100;
    public int thirst = MAX_THIRST;
    public int thirstTicker = 0;
    public int passiveThirstTicker = 0;

    private final PlayerEntity playerEntity;
    public ThirstComponent(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public int getThirst(){
        return thirst;
    }

    public int getMaxThirst(){
        return MAX_THIRST;
    }

    public void setThirst(int thirst){
        THIRST_SET.invoker().thirstSet(playerEntity, this.thirst);
        this.thirst = thirst;
        TFCComponents.THIRST_COMPONENT.sync(playerEntity);
    }

    @Override
    public void serverTick() {
        thirstTicker++;
        passiveThirstTicker++;
        Difficulty difficulty = playerEntity.world.getDifficulty();
        HealthComponent healthComponent = HealthComponent.get(playerEntity);
        ThirstComponent thirstComponent = ThirstComponent.get(playerEntity);
        //SLOW KILLER
        if(thirstComponent.getThirst() <= 0 && healthComponent.getHealth() > 0 && thirstTicker % 20 == 0){
            healthComponent.setHealth(healthComponent.getHealth() - 10);
            playerEntity.damage(TFCDamage.DROUGHT, 1.0F);
        }

        //TODO: should be faster than hunger
        //IDLE THIRST DECAY
        if(difficulty != Difficulty.PEACEFUL && thirstComponent.getThirst() > 0 && passiveThirstTicker % 20 == 0 && !playerEntity.isSpectator() && !playerEntity.isCreative()){
            thirstComponent.setThirst(thirstComponent.getThirst() - 1);
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

    public interface setThirst {
        void thirstSet(PlayerEntity playerEntity, int amount);
    }
    public static final Event<setThirst> THIRST_SET = createArrayBacked(setThirst.class, listeners -> (entity, amount) -> {
        for (setThirst listener : listeners) {
            listener.thirstSet(entity, amount);
        }
    });
    public static ThirstComponent get(PlayerEntity obj) {
        return TFCComponents.THIRST_COMPONENT.get(obj);
    }
    public static Optional<ThirstComponent> maybeGet(PlayerEntity obj) {
        return TFCComponents.THIRST_COMPONENT.maybeGet(obj);
    }
}
