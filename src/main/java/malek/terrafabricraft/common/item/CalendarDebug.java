package malek.terrafabricraft.common.item;

import malek.terrafabricraft.common.calendar.CalendarWorldData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CalendarDebug extends Item {
    public CalendarDebug(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack stack = user.getItemInHand(hand);
        if (world instanceof ServerLevel serverWorld) {
            user.displayClientMessage(CalendarWorldData.get(serverWorld).getCalendar().getCalendarDayOfYear(), false);
            user.displayClientMessage(CalendarWorldData.get(serverWorld).getCalendar().getCalendarTimeAndDate(), false);
        }
        return InteractionResultHolder.success(stack);
    }
}
