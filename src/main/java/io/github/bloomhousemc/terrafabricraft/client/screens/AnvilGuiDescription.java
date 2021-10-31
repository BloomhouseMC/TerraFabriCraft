package io.github.bloomhousemc.terrafabricraft.client.screens;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import io.github.bloomhousemc.terrafabricraft.common.registry.TFCScreens;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;

public class AnvilGuiDescription extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 4;

    public AnvilGuiDescription(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(TFCScreens.ANVIL_GUI_DESCRIPTION, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context, 1));

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(50, 50);
        root.setInsets(Insets.ROOT_PANEL);

        WItemSlot metal1 = WItemSlot.of(blockInventory, 0);
        WItemSlot metal2 = WItemSlot.of(blockInventory, 1);
        WItemSlot hammer = WItemSlot.of(blockInventory, 2);
        WItemSlot rock = WItemSlot.of(blockInventory, 3);
        root.add(metal1, 0, 2);
        root.add(metal2, 1, 2);
        root.add(hammer, 7, 2);
        root.add(rock, 8, 2);

        root.add(this.createPlayerInventoryPanel(), 0, 4);

        root.validate(this);
    }
}
