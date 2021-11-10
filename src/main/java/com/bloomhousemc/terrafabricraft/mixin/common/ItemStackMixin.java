package com.bloomhousemc.terrafabricraft.mixin.common;

import com.bloomhousemc.terrafabricraft.common.calendar.CalendarManager;
import com.bloomhousemc.terrafabricraft.common.item.TFCFood;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStack.class)
public class ItemStackMixin {


    @Inject(method = "<init>(Lnet/minecraft/item/ItemConvertible;I)V", at = @At("RETURN"))
    public void ItemStackConstructor(ItemConvertible itemConvertible, int i, CallbackInfo ci) {
        if(CalendarManager.getSingleton() == null) {
            return;
        }
        if(!(itemConvertible.asItem() instanceof TFCFood)) {
            return;
        }
        NbtCompound tag =((ItemStack)(Object)this).getOrCreateNbt();
        tag.putInt("date_created", CalendarManager.getSingleton().getCalendar().getMinuteHand());
    }
}
