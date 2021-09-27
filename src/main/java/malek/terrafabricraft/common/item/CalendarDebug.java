package malek.terrafabricraft.common.item;

import malek.terrafabricraft.common.calendar.CalendarWorldData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CalendarDebug extends Item {
    public CalendarDebug(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (world instanceof ServerWorld serverWorld) {
            user.sendMessage(CalendarWorldData.get(serverWorld).getCalendar().getCalendarDayOfYear(), false);
            user.sendMessage(CalendarWorldData.get(serverWorld).getCalendar().getCalendarTimeAndDate(), false);
        }
        return TypedActionResult.success(stack);
    }
}
