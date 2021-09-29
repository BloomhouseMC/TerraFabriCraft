package malek.terrafabricraft.mixin.common;

import malek.terrafabricraft.common.calendar.Calendar;
import malek.terrafabricraft.common.event.TFCEvents;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;
import java.util.function.BooleanSupplier;


@Mixin(ServerWorld.class)
public abstract class CalendarMixin {

    @Inject(method = "tick", at = @At("TAIL"))
    private void tick(BooleanSupplier hasTimeLeft, CallbackInfo ci) {
        TFCEvents.calendarInstantiator.calendar.tick();
    }
}