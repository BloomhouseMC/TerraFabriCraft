package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.component.DecayComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TFCFood extends Item {
    public int weigthCategory;
    public int sizeCategory;
    public TFCFood(String id, Properties settings, int weigthCategory, int sizeCategory) {
        super(settings);
        this.weigthCategory = weigthCategory;
        this.sizeCategory = sizeCategory;


    }
    public int getWeigth(int weigthCategory){
        return weigthCategory == 0 ? 100 : weigthCategory == 1 ? 150 : 200;
    }
    public String getSize(int sizeCategory){
        return sizeCategory == 0 ? "Small" : sizeCategory == 1 ? "Medium" : "Large";
    }


    @Override
    public void onCraftedBy(ItemStack stack, Level world, Player player) {
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        tooltip.add(new TranslatableComponent("tooltip.terrafabricraft.itemprop", new TranslatableComponent(String.valueOf(getWeigth(this.weigthCategory))+"g"), new TranslatableComponent(String.valueOf(getSize(this.sizeCategory)))));
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {

    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        return InteractionResultHolder.fail(user.getItemInHand(hand));
    }
}
