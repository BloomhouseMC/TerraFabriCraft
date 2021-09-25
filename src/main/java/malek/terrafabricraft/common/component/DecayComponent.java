package malek.terrafabricraft.common.component;

import dev.onyxstudios.cca.api.v3.item.ItemComponent;
import malek.terrafabricraft.common.registry.TFCComponents;
import net.minecraft.item.ItemStack;

public class DecayComponent extends ItemComponent {

    private final ItemStack stack;
    private int bigTick = 0;
    public DecayComponent(ItemStack stack) {
        super(stack);
        this.stack = stack;
    }
    public int MAX_DECAY = 100;
    public int decay = 0;

    public int getDecay() {
        return decay;
    }
    public int getMaxDecay(){
        return MAX_DECAY;
    }

    public void setDecay(int decay) {
        this.decay = decay;
        TFCComponents.DECAY_COMPONENT.sync(stack);
    }
    public void increseDecay(int add){
        if (getDecay() + add <= getMaxDecay()) {
            setDecay(getDecay() + add);
            TFCComponents.DECAY_COMPONENT.sync(stack);
        }
    }

    public static <T> DecayComponent get(T provider) {
        return TFCComponents.DECAY_COMPONENT.get(provider);
    }
}
