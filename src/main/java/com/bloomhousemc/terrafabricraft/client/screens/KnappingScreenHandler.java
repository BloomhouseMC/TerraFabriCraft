package com.bloomhousemc.terrafabricraft.client.screens;

import com.bloomhousemc.terrafabricraft.common.registry.TfcScreens;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

import static com.bloomhousemc.terrafabricraft.TerraFabriCraft.MODID;

public class KnappingScreenHandler extends AbstractRecipeScreenHandler {

    public KnappingScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, buf.readItemStack());
    }

    public KnappingScreenHandler(int syncId, PlayerInventory playerInventory, ItemStack loosePebble) {
        super(TfcScreens.KNAPPING_SCREEN_HANDLER, syncId);

        //TODO: Knapping screen

        int l;
        int m;
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
        return true;
    }

    @Override
    public void populateRecipeFinder(RecipeMatcher finder) {

    }

    @Override
    public void clearCraftingSlots() {

    }

    @Override
    public boolean matches(Recipe recipe) {
        return false;
    }

    @Override
    public int getCraftingResultSlotIndex() {
        return 26;
    }

    @Override
    public int getCraftingWidth() {
        return 5;
    }

    @Override
    public int getCraftingHeight() {
        return 5;
    }

    @Override
    public int getCraftingSlotCount() {
        return 25;
    }

    @Override
    public RecipeBookCategory getCategory() {
        return RecipeBookCategory.CRAFTING;
    }

    @Override
    public boolean canInsertIntoSlot(int index) {
        return false;
    }
}
