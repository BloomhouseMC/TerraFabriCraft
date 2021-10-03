package malek.terrafabricraft.mixin.common;

import malek.terrafabricraft.common.calendar.CalendarManager;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;


@Mixin(ServerWorld.class)
public abstract class CalendarMixin {

    @Inject(method = "tick", at = @At("TAIL"))
    private void tick(BooleanSupplier hasTimeLeft, CallbackInfo ci) {
        CalendarManager.getSingleton().getCalendar().tick();
    }
}