package io.github.bloomhousemc.terrafabricraft.mixin.client;

import io.github.bloomhousemc.terrafabricraft.client.CalendarClient;
import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(DebugHud.class)
public class DebugHudMixin {
    @Inject(at = @At("RETURN"), method = "getRightText")
    protected void getRightText(CallbackInfoReturnable<List<String>> info) {
        info.getReturnValue().add("Minute: " + CalendarClient.getMinuteHand());
        info.getReturnValue().add("Day: " + CalendarClient.getDayCounter());
        info.getReturnValue().add("Month: " + CalendarClient.getReadableMonth());
        info.getReturnValue().add("Season: " + CalendarClient.getReadableSeason());
    }
}
