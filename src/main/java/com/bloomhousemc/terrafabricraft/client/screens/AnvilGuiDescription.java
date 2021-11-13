package com.bloomhousemc.terrafabricraft.client.screens;

import com.bloomhousemc.terrafabricraft.common.registry.TFCScreens;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;

public class AnvilGuiDescription extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 4;

    public AnvilGuiDescription(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(TFCScreens.ANVIL_GUI_DESCRIPTION, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context, 1));

        WPlainPanel root = new WPlainPanel();
        setRootPanel(root);
        root.setSize(176, 192);
        root.setInsets(Insets.ROOT_PANEL);

        WItemSlot metal1 = WItemSlot.of(blockInventory, 0);
        WItemSlot metal2 = WItemSlot.of(blockInventory, 1);
        WItemSlot hammer = WItemSlot.of(blockInventory, 2);
        WItemSlot rock = WItemSlot.of(blockInventory, 3);
        root.add(metal1, 13, 68);
        root.add(metal2, 31, 68);
        root.add(hammer, 129, 68);
        root.add(rock, 147, 68);

        root.add(this.createPlayerInventoryPanel(false), 0, 110);

        root.validate(this);
    }
}
