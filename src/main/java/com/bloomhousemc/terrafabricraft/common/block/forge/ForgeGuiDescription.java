package com.bloomhousemc.terrafabricraft.common.block.forge;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import io.github.cottonmc.cotton.gui.widget.icon.ItemIcon;
import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import com.bloomhousemc.terrafabricraft.common.registry.TFCScreens;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.Identifier;

public class ForgeGuiDescription extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 14;
    BlockEntity blockEntity;
    WGridPanel root;
    WPlainPanel realRoot;
    int sizeX = 50;
    int sizeY = 100;
    public ForgeGuiDescription(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(TFCScreens.FORGE_GUI_DESCRIPTION, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context, 1));
        root = new WGridPanel();
        setRootPanel(root);
        root.setSize(50, 50);
        root.setInsets(Insets.ROOT_PANEL);
        setTitleAlignment(HorizontalAlignment.CENTER);

        //root.setBackgroundPainter(BackgroundPainter.createNinePatch(new Identifier(TerraFabriCraft.MODID, "textures/gui/charcoal_forge.png")));
        //WTiledSprite sprite = new WTiledSprite(250, 250, new Identifier(TerraFabriCraft.MODID, "textures/gui/charcoal_forge.png"));

        Texture texture = new Texture(new Identifier(TerraFabriCraft.MODID, "textures/gui/heat_indicator.png"));
        //texture = texture.withUv(1, 1, 2, 2);
        WSprite temperatureBar = new WSprite(texture);
        WSprite temperatureIndicator = new WSprite(new Identifier(TerraFabriCraft.MODID, "textures/gui/arrow.png")) {

            @Override
            @Environment(EnvType.CLIENT)
            protected void paintFrame(MatrixStack matrices, int x, int y, Texture texture) {
                matrices.push();
                //matrices.scale(0.25f, 0.25f, 0.25f);
                matrices.translate(0, -((float)propertyDelegate.get(0))/4, 0);
                ScreenDrawing.texturedRect(matrices, x+1, y, 16, 8, texture, tint);

                        matrices.pop();
            }
        };   // temperatureIndicator.setSize(2, 2)

        //temperatureIndicator.setUv(0, 0, 3, 3);
        root.add(temperatureBar, 0, 0, 1, 4);
        root.add(temperatureIndicator, 0, 3, 3, 1);
        //realRoot.add(root, 0,0);
        WItemSlot coalSlot1 = WItemSlot.of(blockInventory, 0);
        WItemSlot coalSlot2 = WItemSlot.of(blockInventory, 1);
        WItemSlot coalSlot3 = WItemSlot.of(blockInventory, 2);
        WItemSlot coalSlot4 = WItemSlot.of(blockInventory, 3);
        WItemSlot coalSlot5 = WItemSlot.of(blockInventory, 4);
        root.add(coalSlot1, 2, 1);
        root.add(coalSlot2, 3, 2);
        root.add(coalSlot3, 4, 3);
        root.add(coalSlot4, 5, 2);
        root.add(coalSlot5, 6, 1);
        ItemIcon coalIcon = new ItemIcon(Items.COAL);
        coalSlot1.setIcon(coalIcon);
        coalSlot2.setIcon(coalIcon);
        coalSlot3.setIcon(coalIcon);
        coalSlot4.setIcon(coalIcon);
        coalSlot5.setIcon(coalIcon);

        WItemSlot forgeSlot1 = WItemSlot.of(blockInventory, 5);
        WItemSlot forgeSlot2 = WItemSlot.of(blockInventory, 6);
        WItemSlot forgeSlot3 = WItemSlot.of(blockInventory, 7);
        WItemSlot forgeSlot4 = WItemSlot.of(blockInventory, 8);
        WItemSlot forgeSlot5 = WItemSlot.of(blockInventory, 9);

        root.add(forgeSlot1, 2, 0);
        root.add(forgeSlot2, 3, 1);
        root.add(forgeSlot3, 4, 2);
        root.add(forgeSlot4, 5, 1);
        root.add(forgeSlot5, 6, 0);

        WItemSlot vesselSlot1 = WItemSlot.of(blockInventory, 10);
        WItemSlot vesselSlot2 = WItemSlot.of(blockInventory, 11);
        WItemSlot vesselSlot3 = WItemSlot.of(blockInventory, 12);
        WItemSlot vesselSlot4 = WItemSlot.of(blockInventory, 13);

        root.add(vesselSlot1, 8, 0);
        root.add(vesselSlot2, 8, 1);
        root.add(vesselSlot3, 8, 2);
        root.add(vesselSlot4, 8, 3);

        root.add(this.createPlayerInventoryPanel(WPlayerInvPanel.createInventoryLabel(playerInventory).setHorizontalAlignment(HorizontalAlignment.CENTER)), 0, 4);

        root.validate(this);
    }
    private BlockEntity getBlockEntity(ScreenHandlerContext ctx) {
        return (BlockEntity) ctx.get((world, pos) -> {
            BlockState state = world.getBlockState(pos);
            Block b = state.getBlock();
            System.out.println(world.getBlockEntity(pos));
            blockEntity = world.getBlockEntity(pos);
            return world.getBlockEntity(pos);

        }).get();
    }

    @Override
    public void setProperty(int id, int value) {
        super.setProperty(id, value);
    }

}
