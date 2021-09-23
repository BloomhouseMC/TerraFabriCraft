package malek.terrafabricraft.common.component;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import malek.terrafabricraft.common.registry.TFCComponents;
import net.fabricmc.fabric.api.event.Event;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;

import java.util.Optional;

import static net.fabricmc.fabric.api.event.EventFactory.createArrayBacked;

public class ThirstComponent implements AutoSyncedComponent, ServerTickingComponent {
    public static int MAX_THIRST = 1000;
    private int thirst = MAX_THIRST;

    private final LivingEntity livingEntity;
    public ThirstComponent(LivingEntity livingEntity) {
        this.livingEntity = livingEntity;
    }
    public int getThirst(){
        return thirst;
    }
    public void setThirst(int thirst){
        THIRST_SET.invoker().thirstSet(livingEntity, this.thirst);
        this.thirst = thirst;
        TFCComponents.THIRST_COMPONENT.sync(livingEntity);
    }

    @Override
    public void serverTick() {

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
        void thirstSet(LivingEntity entity, int amount);
    }
    public static final Event<setThirst> THIRST_SET = createArrayBacked(setThirst.class, listeners -> (entity, amount) -> {
        for (setThirst listener : listeners) {
            listener.thirstSet(entity, amount);
        }
    });
    public static ThirstComponent get(LivingEntity obj) {
        return TFCComponents.THIRST_COMPONENT.get(obj);
    }
    public static Optional<ThirstComponent> maybeGet(LivingEntity obj) {
        return TFCComponents.THIRST_COMPONENT.maybeGet(obj);
    }
}
