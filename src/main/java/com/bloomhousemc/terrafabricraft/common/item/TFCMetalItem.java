package com.bloomhousemc.terrafabricraft.common.item;

import com.bloomhousemc.terrafabricraft.common.temperature.ItemTemperature;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.bloomhousemc.terrafabricraft.client.CalendarClient.getMinuteHand;

public class TFCMetalItem extends Item implements MeltableItem {
    private int meltingPoint = 0;
    public TFCMetalItem(Settings settings, int meltingPoint) {
        super(settings);
        this.meltingPoint = meltingPoint;
    }

    @Override
    public int getMeltingPoint() {
        return meltingPoint;
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        //tooltip.add(new TranslatableText("tfc.tooltip.time_delta_hours_minutes", "00", String.format("%02d", stack.getOrCreateNbt().getInt("date_created"))));
        //System.out.println(stack.getOrCreateNbt().getInt("date_created"));
        if (stack.hasNbt()) {
            if(ItemTemperature.getTemperature(stack) != 0) {
                tooltip.add(new TranslatableText("tooltip.terrafabricraft.temperature", new TranslatableText(String.valueOf(ItemTemperature.getTemperature(stack)) + "")));
            }
        }
    }
}
