package malek.terrafabricraft.common.component;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import malek.terrafabricraft.common.registry.TFCComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;

public class DecayComponent implements AutoSyncedComponent, ServerTickingComponent {

    private long bigTick = 0;
    private final Level world;
    public int interval = 0;
    public DecayComponent(Level world) {
        this.world = world;
    }

    public long getDecay() {
        return bigTick;
    }

    public void setDecay(long bigTick) {
        this.bigTick = bigTick;
        TFCComponents.DECAY_COMPONENT.sync(world);
    }
    public void increseDecay(long add){
            setDecay(getDecay() + add);
            TFCComponents.DECAY_COMPONENT.sync(world);
    }

    public static <T> DecayComponent get(T provider) {
        return TFCComponents.DECAY_COMPONENT.get(provider);
    }


    @Override
    public void readFromNbt(CompoundTag tag) {
        setDecay(tag.getLong("Decay"));
    }

    @Override
    public void writeToNbt(CompoundTag tag) {
        tag.putLong("Decay", getDecay());
    }

    @Override
    public void serverTick() {

    }
}
