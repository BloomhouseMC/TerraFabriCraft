package com.bloomhousemc.terrafabricraft.client.screens;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class AnvilScreen extends CottonInventoryScreen<AnvilGuiDescription> {
    public AnvilScreen(AnvilGuiDescription gui, PlayerEntity player, Text title) {
        super(gui, player, title);
    }
}
