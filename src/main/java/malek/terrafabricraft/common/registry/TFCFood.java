package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.common.component.DecayComponent;
import malek.terrafabricraft.common.component.ServerCalendarComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TFCFood extends Item {

    public TFCFood(Settings settings) {
        super(settings);
    }
    public int bigTicker = 0;

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ServerCalendarComponent serverCalendarComponent = ServerCalendarComponent.CALENDAR_COMPONENT.get(world);



        return super.use(world, user, hand);
    }
}
