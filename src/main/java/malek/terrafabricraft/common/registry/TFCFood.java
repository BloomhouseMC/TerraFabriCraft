package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.common.component.DecayComponent;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TFCFood extends Item {
    public static IntProperty SIZE = IntProperty.of("size", 0, 2);
    public int weigthCategory;
    public int sizeCategory;
    public TFCFood(Settings settings, int weigthCategory, int sizeCategory) {
        super(settings);
        this.weigthCategory = weigthCategory;
        this.sizeCategory = sizeCategory;

    }
    public long decay;
    //TODO: add proper logic to handle decay percentage and weight interaction
    public int weigth = 100;

    public int getWeigth(int weigthCategory){
        return weigthCategory == 0 ? 100 : weigthCategory == 1 ? 150 : 200;
    }
    public String getSize(int sizeCategory){
        return sizeCategory == 0 ? "Small" : sizeCategory == 1 ? "Medium" : "Large";
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        DecayComponent decayComponent = DecayComponent.get(world);
        stack.getOrCreateNbt().putLong("startTick", decayComponent.getDecay());
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("tooltip.terrafabricraft.decay", new TranslatableText(String.valueOf("Decay: " + (this.decay) + "%"))));
        tooltip.add(new TranslatableText("tooltip.terrafabricraft.itemprop", new TranslatableText(String.valueOf(getWeigth(this.weigthCategory))+"g"), new TranslatableText(getSize(this.sizeCategory))));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient){
            DecayComponent decayComponent = DecayComponent.get(world);
            stack.getOrCreateNbt().putLong("updateTick", decayComponent.getDecay());
            this.decay = stack.getOrCreateNbt().getLong("updateTick") - stack.getOrCreateNbt().getLong("startTick");
        }
        if(this.decay >= 100){
            stack.decrement(1);
        }
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        //Testing
        if(!world.isClient){
            ItemStack itemStack = user.getStackInHand(hand);
            NbtCompound nbt = itemStack.getOrCreateNbt();
            System.out.println("Start: " + nbt.getLong("startTick") + " Update: " + nbt.getLong("updateTick"));
            return TypedActionResult.success(user.getStackInHand(hand));
        }
        return TypedActionResult.fail(user.getStackInHand(hand));
    }
}
