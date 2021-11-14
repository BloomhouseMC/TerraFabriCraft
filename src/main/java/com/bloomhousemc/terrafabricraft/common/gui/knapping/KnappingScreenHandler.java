package com.bloomhousemc.terrafabricraft.common.gui.knapping;

import com.bloomhousemc.terrafabricraft.common.registry.TFCScreens;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class KnappingScreenHandler extends ScreenHandler {

    public KnappingScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, buf.readItemStack());
    }

    public KnappingScreenHandler(int syncId, PlayerInventory playerInventory, ItemStack loosePebble) {
        super(TFCScreens.KNAPPING_SCREEN_HANDLER, syncId);

        //TODO: Knapping screen
        int m;
        int l;
        //The player inventory
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }

        //The player Hotbar
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }

    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return false;
    }
}
