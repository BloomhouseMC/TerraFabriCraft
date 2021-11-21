package com.bloomhousemc.terrafabricraft.common.component;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import com.bloomhousemc.terrafabricraft.common.registry.TfcComponents;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class DecayComponent implements AutoSyncedComponent, ServerTickingComponent {

    private long bigTick = 0;
    private final World world;
    public int interval = 0;
    public DecayComponent(World world) {
        this.world = world;
    }

    public long getDecay() {
        return bigTick;
    }

    public void setDecay(long bigTick) {
        this.bigTick = bigTick;
        TfcComponents.DECAY_COMPONENT.sync(world);
    }
    public void increseDecay(long add){
            setDecay(getDecay() + add);
            TfcComponents.DECAY_COMPONENT.sync(world);
    }

    public static <T> DecayComponent get(T provider) {
        return TfcComponents.DECAY_COMPONENT.get(provider);
    }

    @Override
    public void serverTick() {
        interval++;
        if(interval >= 10){
            bigTick++;
            interval=0;
        }
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        setDecay(tag.getLong("Decay"));
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putLong("Decay", getDecay());
    }
}
